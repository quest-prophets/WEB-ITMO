package lab4.repository

import org.springframework.data.jpa.repository.JpaRepository
import lab4.model.UserInfo
import org.springframework.data.domain.Pageable


interface UserInfoRepository : JpaRepository<UserInfo, Long> {
    fun findByUsername(username: String): UserInfo?

    fun findAllByOrderByScoreDesc(pageable: Pageable): List<UserInfo>
}