package lab4.model

import javax.persistence.*

@Entity
@Table(name = "ongoing_games",
        uniqueConstraints = [UniqueConstraint(columnNames = arrayOf("user_id" , "game_type"))]
)
data class OngoingGame (@Column(nullable = false) var gameType: String = ""){

    @Id
    @GeneratedValue
    var id: Long? = null

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    var userInfo: UserInfo? = null

    @OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.ALL], mappedBy = "ongoingGame")
    var gameResults: MutableList<OngoingGameResult>? = null

    var graphType: Int? = null
    var suspectsTypes: Array<Int>? = null

}