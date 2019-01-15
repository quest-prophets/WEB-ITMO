package lab3;

import java.io.Serializable;

public class CheckMessageBean implements Serializable {
    private String msg = "";

    public void rNullError() {
        msg = "Enter R.";
    }

    public void rOutOfBoundsError() {
        msg = "R must be from 2 to 5.";
    }

    public void rNaNError() {
        msg = "R is NaN!";
    }

    public void yNullError() {
        msg = "Enter Y.";
    }

    public void yOutOfBoundsError() {
        msg = "Y must be from -5 to 5.";
    }

    public void yNaNError() {
        msg = "Y is NaN!";
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
