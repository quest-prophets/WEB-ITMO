package lab3;

public class Dot {
    private double x;
    private double y;
    private double r;
    private boolean res;

    public Dot() {

    }

    public Dot(double x, double y, boolean res) {
        this.x = x;
        this.y = y;
        this.res = res;
    }

    public Dot(double x, double y, double r, boolean res) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.res = res;
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

    public boolean isRes() {
        return res;
    }

    public void setRes(boolean res) {
        this.res = res;
    }
}
