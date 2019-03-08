package lab4.model

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.persistence.*

@Entity
@Table(name = "hit_results")
data class Result(var x: Double = 0.0,
                  var y: Double = 0.0,
                  var r: Double = 0.0,
                  var isHit: Boolean = false,
                  var time: String = DateTimeFormatter.ofPattern("dd-MM-yyyy'\n'HH:mm:ss").format(LocalDateTime.now()   )) {

    @Id
    @GeneratedValue
    var id: Long? = null

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    var userInfo: UserInfo? = null

}