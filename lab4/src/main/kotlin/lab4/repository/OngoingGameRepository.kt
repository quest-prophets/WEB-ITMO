package lab4.repository

import lab4.model.OngoingGame
import lab4.model.UserInfo
import org.springframework.data.jpa.repository.JpaRepository

interface OngoingGameRepository : JpaRepository<OngoingGame, Long> {
    fun findAllByUserInfoAndGameType (userInfo: UserInfo, gameType: String): OngoingGame

}