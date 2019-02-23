package lab4.model

import javax.persistence.*

data class OngoingGameResult (var x: Double = 0.0,
                              var y: Double = 0.0,
                              var isHit: Boolean = false) {
    @Id
    @GeneratedValue
    var id: Long? = null

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "game_id", referencedColumnName = "id", nullable = false)
    var ongoingGame: OngoingGame? = null

}