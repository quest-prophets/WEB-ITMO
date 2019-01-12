package lab3;
import java.io.Serializable;


public class RedirectionController implements Serializable {
    public String gotoMain() {
        return "main?faces-redirect=true";
    }
    public String gotoIndex() {
        return "index?faces-redirect=true";
    }
}
