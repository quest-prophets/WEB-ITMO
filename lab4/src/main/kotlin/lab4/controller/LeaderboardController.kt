package lab4.controller

import lab4.model.UserInfo
import lab4.repository.UserInfoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageRequest
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.security.Principal

@RestController
@RequestMapping("/leaderboards")
class LeaderboardController {

    @Autowired
    val userInfoRepository: UserInfoRepository? = null

    val usersPerPage = 10

    @GetMapping
    fun getUserInfo(principal: Principal) = getUserByName(principal.name)

    @GetMapping("/getLeaderboard/{page}")
    fun getLeaderboardPage(@PathVariable page: Int) : List<UserInfo> {
        val pageFormat = PageRequest.of(page-1, usersPerPage)
        return userInfoRepository?.findAllByOrderByScoreDesc(pageFormat)!!
    }

    private fun getUserByName(username: String) = userInfoRepository?.findByUsername(username)
        ?: throw Exception("User with name \"$username\" does not exist.")
}