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
    private Integer id = null;

    String username = null;
    String password = null;

    @OneToMany(mappedBy = "user", targetEntity = Result.class, cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    List<Result> results = null;
}
