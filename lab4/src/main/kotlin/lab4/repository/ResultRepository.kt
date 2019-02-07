package lab4.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.transaction.annotation.Transactional
import lab4.model.Result
import lab4.model.UserInfo

interface ResultRepository : JpaRepository<Result, Long> {
    @Transactional
    fun deleteAllByUserInfo(user: UserInfo)

    fun findAllByUserInfo(user: UserInfo): List<Result>
}