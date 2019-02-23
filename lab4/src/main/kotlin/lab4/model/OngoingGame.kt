package lab4.model

import javax.persistence.*

@Entity
@Table(name = "ongoing_games",
        uniqueConstraints = [UniqueConstraint(columnNames = arrayOf("user_id" , "game_type"))]
)
class OngoingGame {

    @Id
    @GeneratedValue
    var id: Long? = null

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    var userInfo: UserInfo? = null

    var gameType: String? = null

    var graphType: Int? = null
    var suspectsTypes: Array<Int>? = null

}