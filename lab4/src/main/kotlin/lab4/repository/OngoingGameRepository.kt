package lab4.repository

import lab4.model.OngoingGame
import org.springframework.data.jpa.repository.JpaRepository

interface OngoingGameRepository : JpaRepository<OngoingGame, Long> {
    fun findByGameType (gameType: String) : OngoingGame?

}