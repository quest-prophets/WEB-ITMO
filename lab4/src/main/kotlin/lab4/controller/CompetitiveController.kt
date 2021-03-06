package lab4.controller

import lab4.model.*
import lab4.repository.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.lang.Math.pow
import java.security.Principal
import java.time.*
import kotlin.random.Random

@RestController
@RequestMapping("/compCheck")
class CompetitiveController {
    @Autowired
    var userInfoRepository: UserInfoRepository? = null

    @Autowired
    var ongoingGameRepository: OngoingGameRepository? = null

    @Autowired
    var ongoingGameCheckEntryRepository: OngoingGameCheckEntryRepository? = null


    data class DotCheckRequest(var x: Double = 0.0, var y: Double = 0.0)
    data class GameResult(var success: Boolean = false, var clicks: Int = 0, var elapsedTime: Long = 0, var gameScore: Long = 0, var trueGraph: Suspect? = null)


    private fun generateSuspects() : MutableList<Suspect> {
        val area1 = Random.nextInt(1, 9)
        val area2 = Random.nextInt(1, 9)
        val area3 = Random.nextInt(1, 9)
        val area4 = Random.nextInt(1, 9)
        val suspectList = ArrayList<Suspect>()
        suspectList.add(Suspect(area1, area2, area3, area4))
        for (i in 0..2){
            var susArea1 = 5

            if (area1 == 1 || area1 == 3 || area1 == 8)
                susArea1 = listOf(1, 3, 6, 7, 8).random()
            if (area1 == 2 || area1 == 4)
                susArea1 = listOf(2, 4, 6, 7, 9).random()
            if (area1 == 5)
                susArea1 = Random.nextInt(1, 9)
            if (area1 == 6)
                susArea1 = listOf(6, 8).random()
            if (area1 == 7)
                susArea1 = listOf(7, 8, 9).random()
            if (area1 == 9)
                susArea1 = listOf(2, 4, 7, 9).random()

            var susArea2 = 5

            if (area2 == 1 || area2 == 3 || area2 == 8)
                susArea2 = listOf(1, 3, 6, 7, 8).random()
            if (area2 == 2 || area2 == 4)
                susArea2 = listOf(2, 4, 6, 7, 9).random()
            if (area2 == 5)
                susArea2 = Random.nextInt(1, 9)
            if (area2 == 6)
                susArea2 = listOf(6, 8).random()
            if (area2 == 7)
                susArea2 = listOf(7, 8, 9).random()
            if (area2 == 9)
                susArea2 = listOf(2, 4, 7, 9).random()

            var susArea3 = 5

            if (area3 == 1 || area3 == 3 || area3 == 8)
                susArea3 = listOf(1, 3, 6, 7, 8).random()
            if (area3 == 2 || area3 == 4)
                susArea3 = listOf(2, 4, 6, 7, 9).random()
            if (area3 == 5)
                susArea3 = Random.nextInt(1, 9)
            if (area3 == 6)
                susArea3 = listOf(6, 8).random()
            if (area3 == 7)
                susArea3 = listOf(7, 8, 9).random()
            if (area3 == 9)
                susArea3 = listOf(2, 4, 7, 9).random()

            var susArea4 = 5

            if (area4 == 1 || area4 == 3 || area4 == 8)
                susArea4 = listOf(1, 3, 6, 7, 8).random()
            if (area4 == 2 || area4 == 4)
                susArea4 = listOf(2, 4, 6, 7, 9).random()
            if (area4 == 5)
                susArea4 = Random.nextInt(1, 9)
            if (area4 == 6)
                susArea4 = listOf(6, 8).random()
            if (area4 == 7)
                susArea4 = listOf(7, 8, 9).random()
            if (area4 == 9)
                susArea4 = listOf(2, 4, 7, 9).random()

            val newSuspect = Suspect(susArea1, susArea2, susArea3, susArea4)

            suspectList.forEach{
                if (it == newSuspect) {
                    newSuspect.area1 = listOf(1,2,3,4,5,6,7,8,9).minus(it.area1).random()
                    newSuspect.area2 = listOf(1,2,3,4,5,6,7,8,9).minus(it.area2).random()
                    newSuspect.area3 = listOf(1,2,3,4,5,6,7,8,9).minus(it.area3).random()
                    newSuspect.area4 = listOf(1,2,3,4,5,6,7,8,9).minus(it.area4).random()
                }
            }
            suspectList.add(newSuspect)
        }

        for (i in 0..1) {
            val newSuspect = Suspect(Random.nextInt(1, 9), Random.nextInt(1, 9),
                Random.nextInt(1, 9), Random.nextInt(1, 9))
            suspectList.forEach{
                if (it == newSuspect) {
                    newSuspect.area1 = listOf(1,2,3,4,5,6,7,8,9).minus(it.area1).random()
                    newSuspect.area2 = listOf(1,2,3,4,5,6,7,8,9).minus(it.area2).random()
                    newSuspect.area3 = listOf(1,2,3,4,5,6,7,8,9).minus(it.area3).random()
                    newSuspect.area4 = listOf(1,2,3,4,5,6,7,8,9).minus(it.area4).random()
                }
            }
            suspectList.add(newSuspect)
        }
        return suspectList
    }

    private fun checkAreaHit(x: Double, y: Double, area1: Int, area2: Int, area3: Int, area4: Int): Boolean {
        if (x >= 0 && y >= 0) {
            when (area1) {
                1 -> return pow(x, 2.0) + pow(y, 2.0) <= pow(1.0, 2.0)
                2 -> return pow(x, 2.0) + pow(y, 2.0) <= pow(1.0 / 2, 2.0)
                3 -> return x <= 1.0 && y <= 1.0
                4 -> return x <= 1.0 / 2 && y <= 1.0 / 2
                6 -> return x <= 1.0 / 2 && y <= 1.0
                7 -> return x <= 1.0 && y <= 1.0 / 2
                8 -> return y <= -1 * x + 1.0
                9 -> return y <= -2 * x + 1.0
                else -> return false
            }
        } else if (x <= 0 && y >= 0) {
            when (area2) {
                1 -> return pow(x, 2.0) + pow(y, 2.0) <= pow(1.0, 2.0)
                2 -> return pow(x, 2.0) + pow(y, 2.0) <= pow(1.0 / 2, 2.0)
                3 -> return x >= -1.0 && y <= 1.0
                4 -> return x >= -1.0 / 2 && y <= 1.0 / 2
                6 -> return x >= -1.0 && y <= 1.0 / 2
                7 -> return x >= -1.0 / 2 && y <= 1.0
                8 -> return y <= x + 1.0
                9 -> return y <= (x + 1.0) / 2
                else -> return false
            }
        } else if (x <= 0 && y <= 0) {
            when (area3) {
                1 -> return pow(x, 2.0) + pow(y, 2.0) <= pow(1.0, 2.0)
                2 -> return pow(x, 2.0) + pow(y, 2.0) <= pow(1.0 / 2, 2.0)
                3 -> return x >= -1.0 && y >= -1.0
                4 -> return x >= -1.0 / 2 && y >= -1.0 / 2
                6 -> return x >= -1.0 / 2 && y >= -1.0
                7 -> return x >= -1.0 && y >= -1.0 / 2
                8 -> return y >= -(x + 1.0)
                9 -> return y >= -(2 * x + 1.0)
                else -> return false
            }
        } else if (x >= 0 && y <= 0) {
            when (area4) {
                1 -> return pow(x, 2.0) + pow(y, 2.0) <= pow(1.0, 2.0)
                2 -> return pow(x, 2.0) + pow(y, 2.0) <= pow(1.0 / 2, 2.0)
                3 -> return x <= 1.0 && y >= -1.0
                4 -> return x <= 1.0 / 2 && y >= -1.0 / 2
                6 -> return x <= 1.0 && y >= -1.0 / 2
                7 -> return x <= 1.0 / 2 && y >= -1.0
                8 -> return y >= x - 1.0
                9 -> return y >= (x - 1.0) / 2
                else -> return false
            }
        }
        return false
    }

    private fun compute(x: Double, y: Double, trueGraph: Suspect): Dot? {
        val hit = checkAreaHit(x, y, trueGraph.area1, trueGraph.area2, trueGraph.area3, trueGraph.area4)
        return Dot(x, y, hit)
    }

    @PostMapping
    fun createGame (principal: Principal) : OngoingGamePacked {
        val user = getUserByName(principal.name)
        var existingGame = ongoingGameRepository?.findAllByUserInfoAndGameType(user, "competitive")
        return if (existingGame != null) {
            val passedTime = Duration.between(existingGame.startTime, LocalDateTime.now()).toMillis()
            val checkResults = ongoingGameCheckEntryRepository?.findAllByOngoingGame(existingGame) ?: emptyList()
            val resultsList = ArrayList<Dot>()
            checkResults.forEach { resultsList.add(Dot(it.x, it.y, it.isHit)) }

            val suspectList = ArrayList<Suspect>()
            existingGame.suspectsTypes?.forEach { suspectList.add(
                Suspect.decode(it))
            }

            val gamePacked = OngoingGamePacked (suspectList, resultsList, passedTime)
            gamePacked
        } else {
            val suspectList = generateSuspects()
            val trueGraph = suspectList.first()
            suspectList.shuffle()

            existingGame = OngoingGame("competitive", LocalDateTime.now())
            existingGame.graphType = trueGraph.encode()
            existingGame.suspectsTypes = ArrayList()
            suspectList.forEach {
                existingGame.suspectsTypes?.add(
                    it.encode()
                )
            }
            user.ongoingGames?.add(existingGame.apply { this.userInfo = user }) ?: ArrayList<OngoingGame>()
            userInfoRepository?.save(user)

            val gamePacked = OngoingGamePacked(suspectList, null, 0)
            gamePacked
        }
    }

    @PostMapping("/checkDot")
    fun checkDot(@RequestBody p: DotCheckRequest, principal: Principal): Dot? {
        val user = getUserByName(principal.name)
        val currentGame = ongoingGameRepository?.findAllByUserInfoAndGameType(user, "competitive")
        val dot = compute(p.x, p.y, Suspect.decode(currentGame?.graphType!!)) ?: return null

        currentGame.gameCheckEntries?.add(OngoingGameCheckEntry(p.x, p.y, dot.isHit).apply { this.ongoingGame = currentGame })
        ongoingGameRepository?.save(currentGame)
        return dot
    }

    @PostMapping("/getResult")
    fun getGameResult(@RequestBody p: Suspect, principal: Principal): GameResult? {
        val user = getUserByName(principal.name)
        val currentGame = ongoingGameRepository?.findAllByUserInfoAndGameType(user, "competitive")!!
        val result = (currentGame.graphType == p.encode())
        val clicks = currentGame.gameCheckEntries?.size
        val elapsedTime = Duration.between(currentGame.startTime, LocalDateTime.now()).toMillis()

        user.overallDots += clicks!!
        user.overallElapsedTime += elapsedTime
        user.overallGames++
        user.overallWins += if (result) 1 else 0

        val gameScore = if (result) (10+100/(clicks+1)+100000/elapsedTime) else (-50)
        user.score += gameScore
        user.performance = (user.overallWins/(user.overallDots+0.001*user.overallElapsedTime))*100

        userInfoRepository?.save(user)

        ongoingGameCheckEntryRepository?.deleteAllByOngoingGame(currentGame)
        ongoingGameRepository?.delete(currentGame)
        return GameResult(result, clicks, elapsedTime, gameScore, Suspect.decode(currentGame.graphType!!))
    }

    private fun getUserByName(username: String) = userInfoRepository?.findByUsername(username)
        ?: throw Exception("User with name \"$username\" does not exist.")


}