package lab3;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name="results")
public class Result implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "result_id")
    private int id;
    private double x;
    private double y;
    private double r;
    private boolean res;
    private LocalDateTime time;
    private int area1;
    private int area2;
    private int area3;
    private int area4;
    private boolean isDay;

    @Transient
    private String formattedLDT;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    UserInfo user = null;

    public Result() {

    }

    public Result(double x, double y, double r, boolean res, LocalDateTime time) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.res = res;
        this.time = time;
        formattedLDT = DateTimeFormatter.ofPattern("dd-MM-yyyy'\n'HH:mm:ss").format(time);
    }

    public Result(double x, double y, double r, boolean res, LocalDateTime time, UserInfo user) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.res = res;
        this.time = time;
        this.user = user;
        formattedLDT = DateTimeFormatter.ofPattern("dd-MM-yyyy'\n'HH:mm:ss").format(time);
    }

    public Result(double x, double y, double r, boolean res, LocalDateTime time, boolean isDay) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.res = res;
        this.time = time;
        this.isDay = isDay;
        formattedLDT = DateTimeFormatter.ofPattern("dd-MM-yyyy'\n'HH:mm:ss").format(time);
    }

    public Result(double x, double y, double r, boolean res, LocalDateTime time, int area1, int area2, int area3, int area4, boolean isDay) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.res = res;
        this.time = time;
        this.area1 = area1;
        this.area2 = area2;
        this.area3 = area3;
        this.area4 = area4;
        this.isDay = isDay;
        formattedLDT = DateTimeFormatter.ofPattern("dd-MM-yyyy'\n'HH:mm:ss").format(time);
    }

    public double getX() {
        return x;
    }

    public void setX(double kx) {
        this.x = kx;
    }

    public double getY() {
        return y;
    }

    public void setY(double ky) {
        this.y = ky;
    }

    public double getR() {
        return r;
    }

    public void setR(double rad) {
        this.r = rad;
    }

    public boolean isRes() {
        return res;
    }

    public void setTime(LocalDateTime curTime){
        this.time = curTime;
    }

    public UserInfo getUser() {
        return user;
    }

    public void setUser(UserInfo user) {
        this.user = user;
    }


    public void setRes(boolean res) {
        this.res = res;
    }

    public LocalDateTime getTime() {
        return time;
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
        return isDay;
    }

    public void setDay(boolean day) {
        isDay = day;
    }

    public String getFormattedLDT() {
        return formattedLDT;
    }

    public void setFormattedLDT(String formattedLDT) {
        this.formattedLDT = formattedLDT;
    }
}
