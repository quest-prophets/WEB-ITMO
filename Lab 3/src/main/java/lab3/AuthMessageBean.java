package lab3;

import java.io.Serializable;

public class AuthMessageBean implements Serializable {
    private String msg = "";

    public void success() {
        msg = "Success!";
    }

    public void usernameError() {
        msg = "User with such name already exists. Try again.";
    }

    public void loginError() {
        msg = "Incorrect login/password. Try again.";
    }

    public void databaseError(String stacktrace) {
        msg = stacktrace;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
