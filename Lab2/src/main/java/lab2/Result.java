package lab2;

import java.io.Serializable;

public class Result implements Serializable {
    public String x;
    public String y;
    public String r;
    public String res;

    public Result(String x, String y, String r, String res) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.res = res;
    }
}
