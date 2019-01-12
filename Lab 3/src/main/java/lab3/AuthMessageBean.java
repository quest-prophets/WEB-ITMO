package lab3;

import java.io.Serializable;

public class AuthMessageBean implements Serializable {
    private String msg = "";

    public void success() {
        msg = "Успешно!";
    }

    public void usernameError() {
        msg = "Пользователь с таким именем уже существует. Попробуйте еще раз.";
    }

    public void loginError() {
        msg = "Неправильный логин/пароль. Попробуйте еще раз.";
    }

    public void databaseError() {
        msg = "Проблема с подключением к базе данных.";
    }
}
