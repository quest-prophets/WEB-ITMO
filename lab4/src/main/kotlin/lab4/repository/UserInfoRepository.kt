package lab4.repository

import org.springframework.data.jpa.repository.JpaRepository
import lab4.model.UserInfo

interface UserInfoRepository : JpaRepository<UserInfo, Long> {
    fun findByUsername(username: String): UserInfo?
}