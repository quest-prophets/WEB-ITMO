package lab3;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;

import static java.lang.Math.pow;

public class AreaCheckBean implements Serializable {
    private CheckHistoryBean historyBean = null;
    private List<Dot> dots = new ArrayList<>();
    private double x = 0.0;
    private double y = 0.0;
    private double r = 2.0;

    private int area1 = 1;
    private int area2 = 1;
    private int area3 = 1;
    private int area4 = 1;


    private  boolean checkDataValidity() {
        return ((x>=(-2.0) && x<=2.0) && (y>=(-5.0) && y<5.0) && (r>=2.0 && r<=5.0) &&
                (area1>=1 && area1<=9) && (area2>=1 && area2<=9) && (area3>=1 && area3<=9) && (area4>=1 && area4<=9));
    }

    private boolean checkAreaHit(double x, double y, double r, int area1, int area2, int area3, int area4) {
        if ((x > 0) && (y > 0)) {
            switch (area1) {
                case 1:
                    if ((pow(x, 2) + pow(y, 2)) <= pow(r, 2)) return true;
                case 2:
                    if ((pow(x, 2) + pow(y, 2)) <= pow(r/2, 2)) return true;
                case 3:
                    if (x <= r && y <= r) return true;
                case 4:
                    if (x <= r/2 && y <= r/2) return true;
                case 6:
                    if (x <= r/2 && y <= r) return true;
                case 7:
                    if (x <= r && y <= r/2) return true;
                case 8:
                    if (y <= ((-1)*x + r)) return true;
                case 9:
                    if (y <= (x/(-2) + r/2)) return true;
                default:
                    return false;
            }
        }
        else if ((x < 0) && (y > 0)) {
            switch (area2) {
                case 1:
                    if ((pow(x, 2) + pow(y, 2)) <= pow(r, 2)) return true;
                case 2:
                    if ((pow(x, 2) + pow(y, 2)) <= pow(r/2, 2)) return true;
                case 3:
                    if (x >= -r && y <= r) return true;
                case 4:
                    if (x >= -r/2 && y <= r/2) return true;
                case 6:
                    if (x >= -r/2 && y <= r) return true;
                case 7:
                    if (x >= -r && y <= r/2) return true;
                case 8:
                    if (y <= (x + r)) return true;
                case 9:
                    if (y <= (x + r)/2) return true;
                default:
                    return false;
            }
        }

        else if ((x < 0) && (y < 0)) {
            switch (area3) {
                case 1:
                    if ((pow(x, 2) + pow(y, 2)) <= pow(r, 2)) return true;
                case 2:
                    if ((pow(x, 2) + pow(y, 2)) <= pow(r/2, 2)) return true;
                case 3:
                    if (x >= -r && y >= -r) return true;
                case 4:
                    if (x >= -r/2 && y >= -r/2) return true;
                case 6:
                    if (x >= -r/2 && y >= -r) return true;
                case 7:
                    if (x >= -r && y >= -r/2) return true;
                case 8:
                    if (y <= -(x + r)) return true;
                case 9:
                    if (y <= -(x + r)/2) return true;
                default:
                    return false;
            }
        }

        else if ((x > 0) && (y < 0)) {
            switch (area4) {
                case 1:
                    if ((pow(x, 2) + pow(y, 2)) <= pow(r, 2)) return true;
                case 2:
                    if ((pow(x, 2) + pow(y, 2)) <= pow(r/2, 2)) return true;
                case 3:
                    if (x <= r && y >= -r) return true;
                case 4:
                    if (x <= r/2 && y >= -r/2) return true;
                case 6:
                    if (x <= r/2 && y >= -r) return true;
                case 7:
                    if (x <= r && y >= -r/2) return true;
                case 8:
                    if (y <= (x - r)) return true;
                case 9:
                    if (y <= (x - r)/2) return true;
                default:
                    return false;
            }
        }
        else if (area1 == 5 && area2 == 5 && area3 == 5 && area4 == 5)
            return false;
        else
            return true;
    }

    public void dataCheck() {
        if(!checkDataValidity()) return;
        boolean isHit = checkAreaHit(x,y,r,area1,area2,area3,area4);
        historyBean.addResult(new Result(x,y,r,isHit,LocalDateTime.now()));
        dots.add(new Dot(x,y,isHit));
    }

    public CheckHistoryBean getHistoryBean() {
        return historyBean;
    }

    public void setHistoryBean(CheckHistoryBean historyBean) {
        this.historyBean = historyBean;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public int getArea1() {
        return area1;
    }

    public void setArea1(int area1) {
        this.area1 = area1;
    }

    public int getArea2() {
        return area2;
    }

    public void setArea2(int area2) {
        this.area2 = area2;
    }

    public int getArea3() {
        return area3;
    }

    public void setArea3(int area3) {
        this.area3 = area3;
    }

    public int getArea4() {
        return area4;
    }

    public void setArea4(int area4) {
        this.area4 = area4;
    }
}
