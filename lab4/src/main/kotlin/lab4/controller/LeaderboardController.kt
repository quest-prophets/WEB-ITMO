package lab4.controller

import lab4.model.LeaderboardStatsPacked
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
    fun getLeaderboardPage(@PathVariable page: Int) : List<LeaderboardStatsPacked> {
        val pageFormat = PageRequest.of(page-1, usersPerPage)
        val userPage = userInfoRepository?.findAllByOrderByScoreDesc(pageFormat)!!
        val statsPacked = ArrayList<LeaderboardStatsPacked>()
        userPage.forEachIndexed { index, element ->
            statsPacked.add(LeaderboardStatsPacked((page-1)*10+index+1, element.username, element.overallWins, element.overallGames,
                element.overallDots, element.overallElapsedTime, element.score, Math.round(element.performance*1000.0)/1000.0))
        }
        return statsPacked
    }

    @GetMapping("/getPageCount")
    fun getPages() : Int {
        val pageFormat = PageRequest.of(0, Int.MAX_VALUE)
        val users = userInfoRepository?.findAllByOrderByScoreDesc(pageFormat)!!
        return (users.size%usersPerPage)+1
    }

    private fun getUserByName(username: String) = userInfoRepository?.findByUsername(username)
        ?: throw Exception("User with name \"$username\" does not exist.")
}