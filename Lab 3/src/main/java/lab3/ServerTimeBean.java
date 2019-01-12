package lab3;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ServerTimeBean {
    private String time;

    public String getTime() {
        return time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.uuuu - HH:mm:ss"));
    }

    public void setTime(String time) {
        this.time = time;
    }
}
