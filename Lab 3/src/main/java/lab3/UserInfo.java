package lab3;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "users")
public class UserInfo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "client_id")
    Integer id = null;

    String username = null;
    String password = null;

    @OneToMany(mappedBy = "user", targetEntity = Result.class, cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    List<Result> results = null;

    @OneToMany(mappedBy = "user", targetEntity = Group.class, cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    List<Group> groups = null;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }
}
