package lab3;

import lab3.jpa.UserInfoService;
import java.io.Serializable;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

public class CheckHistoryBean implements Serializable {
    UserInfo user = null;

    public void init () {
        UserInfoService service = new UserInfoService();
        String username = (String) ((HttpSession)(FacesContext.getCurrentInstance().getExternalContext().getSession(false))).getAttribute("username");
        List<UserInfo> userInfos = service.findAllUsers();
        user = userInfos.stream()
                .filter(userInfo -> username.equals(userInfo.username))
                .findAny()
                .orElse(null);
    }

    public List<Result> getResults() {
        return user.results;
    }

    public void addResult (Result res) {
        if (user == null && user.results == null) return;
        user.results.add(res);
        res.user = user;
        new UserInfoService().updateUser(user);
    }

}
