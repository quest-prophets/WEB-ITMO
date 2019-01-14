package lab3;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "groups")
public class Group implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id = null;

    private String username = null;
    private String groupname = null;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    UserInfo user = null;

    public Group(){

    }

    public Group(String groupname, UserInfo user) {
        this.username = user.username;
        this.groupname = groupname;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    public UserInfo getUser() {
        return user;
    }

    public void setUser(UserInfo user) {
        this.user = user;
    }
}
