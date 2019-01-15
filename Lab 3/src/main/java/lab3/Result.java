package lab3;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

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
    }

    public Result(double x, double y, double r, boolean res, LocalDateTime time, UserInfo user) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.res = res;
        this.time = time;
        this.user = user;
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
        // DateTimeFormatter df = DateTimeFormatter.ofPattern("HH:mm:ss");
        // this.time = curTime.format(df);
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

    public String getColor(){
        if(res){
            return "green";
        } else {
            return "red";
        }
    }
}
