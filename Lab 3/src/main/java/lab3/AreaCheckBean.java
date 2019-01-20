package lab3;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;

import static java.lang.Math.pow;

public class AreaCheckBean implements Serializable {
    private CheckHistoryBean historyBean = null;
    private List<Dot> dots = new ArrayList<>();
    private double x = 1.0;
    private double y = 0.0;
    private double r = 2.0;

    private int area1 = 5;
    private int area2 = 5;
    private int area3 = 5;
    private int area4 = 5;

    private boolean day = false;


    public void init() {
        List<Result> results = historyBean.user.results;
        if (results.size() >= 1) {
            dots = new ArrayList<>();
            area1 = results.get(results.size() - 1).getArea1();
            area2 = results.get(results.size() - 1).getArea2();
            area3 = results.get(results.size() - 1).getArea3();
            area4 = results.get(results.size() - 1).getArea4();
            for (int i = 1; i < results.size(); i++) {
                dots.add(new Dot(results.get(i).getX(), results.get(i).getY(), results.get(i).getR(), results.get(i).isRes()));
            }
            this.day = historyBean.user.results.get(historyBean.user.results.size() - 1).isDay();
        }
    }

    public boolean checkDataValidity() {
        return ((x >= (-2.0) && x <= 2.0) && (y >= (-5.0) && y < 5.0) && (r >= 2.0 && r <= 5.0) &&
                (area1 >= 1 && area1 <= 9) && (area2 >= 1 && area2 <= 9) && (area3 >= 1 && area3 <= 9) && (area4 >= 1 && area4 <= 9));
    }

    public boolean checkAreaHit(double x, double y, double r, int area1, int area2, int area3, int area4) {
        if ((x >= 0) && (y >= 0)) {
            switch (area1) {
                case 1:
                    return ((pow(x, 2) + pow(y, 2)) <= pow(r, 2));
                case 2:
                    return ((pow(x, 2) + pow(y, 2)) <= pow(r / 2, 2));
                case 3:
                    return (x <= r && y <= r);
                case 4:
                    return (x <= r / 2 && y <= r / 2);
                case 6:
                    return (x <= r && y <= r / 2);
                case 7:
                    return (x <= r / 2 && y <= r);
                case 8:
                    return (y <= ((-1) * x + r));
                case 9:
                    return (y <= (-2*x + r));
                default:
                    return false;
            }
        } else if ((x <= 0) && (y >= 0)) {
            switch (area2) {
                case 1:
                    return ((pow(x, 2) + pow(y, 2)) <= pow(r, 2));
                case 2:
                    return ((pow(x, 2) + pow(y, 2)) <= pow(r / 2, 2));
                case 3:
                    return (x >= -r && y <= r);
                case 4:
                    return (x >= -r / 2 && y <= r / 2);
                case 6:
                    return (x >= -r / 2 && y <= r);
                case 7:
                    return (x >= -r && y <= r / 2);
                case 8:
                    return (y <= (x + r));
                case 9:
                    return (y <= (x + r) / 2);
                default:
                    return false;
            }
        } else if ((x <= 0) && (y <= 0)) {
            switch (area3) {
                case 1:
                    return ((pow(x, 2) + pow(y, 2)) <= pow(r, 2));
                case 2:
                    return ((pow(x, 2) + pow(y, 2)) <= pow(r / 2, 2));
                case 3:
                    return (x >= -r && y >= -r);
                case 4:
                    return ((x >= -r / 2) && (y >= -r / 2));
                case 6:
                    return ((x >= -r) && (y >= -r / 2));
                case 7:
                    return (x >= -r / 2 && y >= -r);
                case 8:
                    return (y >= -(x + r));
                case 9:
                    return (y >= -(2*x + r));
                default:
                    return false;
            }
        } else if ((x >= 0) && (y <= 0)) {
            switch (area4) {
                case 1:
                    return ((pow(x, 2) + pow(y, 2)) <= pow(r, 2));
                case 2:
                    return ((pow(x, 2) + pow(y, 2)) <= pow(r / 2, 2));
                case 3:
                    return (x <= r && y >= -r);
                case 4:
                    return (x <= r / 2 && y >= -r / 2);
                case 6:
                    return (x <= r / 2 && y >= -r);
                case 7:
                    return (x <= r && y >= -r / 2);
                case 8:
                    return (y >= (x - r));
                case 9:
                    return (y >= (x - r) / 2);
                default:
                    return false;
            }
        } else if (area1 == 5 && area2 == 5 && area3 == 5 && area4 == 5)
            return false;
        return true;
    }

    public void compute() {
        if (!checkDataValidity()) return;
        boolean isHit = checkAreaHit(x, y, r, area1, area2, area3, area4);
        historyBean.addResult(new Result(x, y, r, isHit, LocalDateTime.now(), area1, area2, area3, area4, day));
        dots.add(new Dot(x, y, r, isHit));
    }

    public void newRCompute() {
        for (Dot dot: dots) {
            dot.setRes(checkAreaHit(dot.getX(), dot.getY(), r, area1, area2, area3, area4));
        }
    }

    public void newAreaCompute() {

    }

    public void clearResults() {
        historyBean.clearResults();
        dots.clear();
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

    public List<Dot> getDots() {
        return dots;
    }

    public void setDots(List<Dot> dots) {
        this.dots = dots;
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

    public boolean isDay() {
        return day;
    }

    public void setDay(boolean day) {
        this.day = day;
    }
}
