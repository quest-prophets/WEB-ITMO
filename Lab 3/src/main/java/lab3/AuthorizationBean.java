package lab3;

import javassist.bytecode.ByteArray;
import lab3.jpa.UserInfoService;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.ByteArrayInputStream;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class AuthorizationBean {
    private String username = null;
    private String password = null;

    private RedirectionController controller = null;
    private AuthMessageBean messageBean = null;

    public String auth() {
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        HttpServletRequest request = (HttpServletRequest) context.getRequest();
        try {
            request.login(username, password);
            ((HttpSession) context.getSession(true)).setAttribute("username", username);
            messageBean.success();
            return controller.gotoMain();
        } catch (Exception e) {
            messageBean.loginError();
            return null;
        }
    }

    public String register() throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.reset();
        String encPassword = this.hexEncode(md.digest(password.getBytes(Charset.forName("UTF-8"))));

        UserInfo newUser = new UserInfo();
        newUser.username = this.username;
        newUser.password = encPassword;
        newUser.results = new ArrayList<Result>();

        UserInfoService service = new UserInfoService();
        List<UserInfo> userInfos = service.findAllUsers();
        UserInfo existingUser = userInfos.stream()
                .filter(userInfo -> newUser.username.equals(userInfo.username))
                .findAny()
                .orElse(null);

        if (existingUser != null) {
            messageBean.usernameError();
            return null;
        }
        service.saveUser(newUser);

        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        HttpServletRequest request = (HttpServletRequest) context.getRequest();
        try {
            request.login(username, password);
            ((HttpSession) context.getSession(true)).setAttribute("username", username);
            messageBean.success();
            return controller.gotoMain();
        } catch (Exception e) {
            messageBean.databaseError();
            return null;
        }
    }

    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return controller.gotoIndex();
    }

    private String hexEncode(byte[] bytes) {
        char[] hexadecimal = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f'};
        char[] hexChars = new char[bytes.length * 2];
        for ( int j = 0; j < bytes.length; j++ ) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexadecimal[v >>> 4];
            hexChars[j * 2 + 1] = hexadecimal[v & 0x0F];
        }
        return new String(hexChars);
    }

    public RedirectionController getController() {
        return controller;
    }

    public void setController(RedirectionController controller) {
        this.controller = controller;
    }

    public AuthMessageBean getMessageBean() {
        return messageBean;
    }

    public void setMessageBean(AuthMessageBean messageBean) {
        this.messageBean = messageBean;
    }
}
