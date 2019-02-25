package lab4.controller

import lab4.model.*
import lab4.repository.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.security.Principal
import java.time.*
import kotlin.random.Random

@RestController
@RequestMapping("/timeAttackCheck")
class CompetitiveController {
    @Autowired
    var userInfoRepository: UserInfoRepository? = null

    @Autowired
    var ongoingGameRepository: OngoingGameRepository? = null

    @Autowired
    var ongoingGameCheckEntryRepository: OngoingGameCheckEntryRepository? = null

    var trueGraph: Suspect? = null

    data class DotCheckRequest(var x: Double = 0.0, var y: Double = 0.0)
    data class GameResult(var success: Boolean = false, var elapsedTime: Long = 0, var gameScore: Long = 0)


    private fun generateSuspects() : List<Suspect> {
        val area1 = Random.nextInt(1, 9)
        val area2 = Random.nextInt(1, 9)
        val area3 = Random.nextInt(1, 9)
        val area4 = Random.nextInt(1, 9)
        trueGraph = Suspect(area1, area2, area3, area4)
        val suspectList = ArrayList<Suspect>()
        suspectList.add(Suspect(area1, area2, area3, area4))
        for (i in 0..2){
            var susArea1 = 5

            if (area1 == 1 || area1 == 3 || area1 == 8)
                susArea1 = listOf(1, 3, 6, 7, 8).random()
            if (area1 == 2 || area1 == 4)
                susArea1 = listOf(2, 4, 6, 7, 9).random()
            if (area1 == 6)
                susArea1 = listOf(6, 8).random()
            if (area1 == 7)
                susArea1 = listOf(7, 8, 9).random()
            if (area1 == 9)
                susArea1 = listOf(2, 4, 7, 9).random()

            var susArea2 = 5

            if (area1 == 1 || area1 == 3 || area1 == 8)
                susArea2 = listOf(1, 3, 6, 7, 8).random()
            if (area1 == 2 || area1 == 4)
                susArea2 = listOf(2, 4, 6, 7, 9).random()
            if (area1 == 6)
                susArea2 = listOf(6, 8).random()
            if (area1 == 7)
                susArea2 = listOf(7, 8, 9).random()
            if (area1 == 9)
                susArea2 = listOf(2, 4, 7, 9).random()

            var susArea3 = 5

            if (area1 == 1 || area1 == 3 || area1 == 8)
                susArea3 = listOf(1, 3, 6, 7, 8).random()
            if (area1 == 2 || area1 == 4)
                susArea3 = listOf(2, 4, 6, 7, 9).random()
            if (area1 == 6)
                susArea3 = listOf(6, 8).random()
            if (area1 == 7)
                susArea3 = listOf(7, 8, 9).random()
            if (area1 == 9)
                susArea3 = listOf(2, 4, 7, 9).random()

            var susArea4 = 5

            if (area1 == 1 || area1 == 3 || area1 == 8)
                susArea4 = listOf(1, 3, 6, 7, 8).random()
            if (area1 == 2 || area1 == 4)
                susArea4 = listOf(2, 4, 6, 7, 9).random()
            if (area1 == 6)
                susArea4 = listOf(6, 8).random()
            if (area1 == 7)
                susArea4 = listOf(7, 8, 9).random()
            if (area1 == 9)
                susArea4 = listOf(2, 4, 7, 9).random()

            suspectList.add(Suspect(susArea1, susArea2, susArea3, susArea4))
        }
        suspectList.add(
            Suspect(
                Random.nextInt(1, 9), Random.nextInt(1, 9),
                Random.nextInt(1, 9), Random.nextInt(1, 9))
        )
        suspectList.add(
            Suspect(
                Random.nextInt(1, 9), Random.nextInt(1, 9),
                Random.nextInt(1, 9), Random.nextInt(1, 9))
        )
        suspectList.shuffle()
        return suspectList
    }

    private fun checkAreaHit(x: Double, y: Double, area1: Int, area2: Int, area3: Int, area4: Int): Boolean {
        if (x >= 0 && y >= 0) {
            when (area1) {
                1 -> return Math.pow(x, 2.0) + Math.pow(y, 2.0) <= Math.pow(1.0, 2.0)
                2 -> return Math.pow(x, 2.0) + Math.pow(y, 2.0) <= Math.pow(1.0 / 2, 2.0)
                3 -> return x <= 1.0 && y <= 1.0
                4 -> return x <= 1.0 / 2 && y <= 1.0 / 2
                6 -> return x <= 1.0 && y <= 1.0 / 2
                7 -> return x <= 1.0 / 2 && y <= 1.0
                8 -> return y <= -1 * x + 1.0
                9 -> return y <= -2 * x + 1.0
                else -> return false
            }
        } else if (x <= 0 && y >= 0) {
            when (area2) {
                1 -> return Math.pow(x, 2.0) + Math.pow(y, 2.0) <= Math.pow(1.0, 2.0)
                2 -> return Math.pow(x, 2.0) + Math.pow(y, 2.0) <= Math.pow(1.0 / 2, 2.0)
                3 -> return x >= -1.0 && y <= 1.0
                4 -> return x >= -1.0 / 2 && y <= 1.0 / 2
                6 -> return x >= -1.0 / 2 && y <= 1.0
                7 -> return x >= -1.0 && y <= 1.0 / 2
                8 -> return y <= x + 1.0
                9 -> return y <= (x + 1.0) / 2
                else -> return false
            }
        } else if (x <= 0 && y <= 0) {
            when (area3) {
                1 -> return Math.pow(x, 2.0) + Math.pow(y, 2.0) <= Math.pow(1.0, 2.0)
                2 -> return Math.pow(x, 2.0) + Math.pow(y, 2.0) <= Math.pow(1.0 / 2, 2.0)
                3 -> return x >= -1.0 && y >= -1.0
                4 -> return x >= -1.0 / 2 && y >= -1.0 / 2
                6 -> return x >= -1.0 && y >= -1.0 / 2
                7 -> return x >= -1.0 / 2 && y >= -1.0
                8 -> return y >= -(x + 1.0)
                9 -> return y >= -(2 * x + 1.0)
                else -> return false
            }
        } else if (x >= 0 && y <= 0) {
            when (area4) {
                1 -> return Math.pow(x, 2.0) + Math.pow(y, 2.0) <= Math.pow(1.0, 2.0)
                2 -> return Math.pow(x, 2.0) + Math.pow(y, 2.0) <= Math.pow(1.0 / 2, 2.0)
                3 -> return x <= 1.0 && y >= -1.0
                4 -> return x <= 1.0 / 2 && y >= -1.0 / 2
                6 -> return x <= 1.0 / 2 && y >= -1.0
                7 -> return x <= 1.0 && y >= -1.0 / 2
                8 -> return y >= x - 1.0
                9 -> return y >= (x - 1.0) / 2
                else -> return false
            }
        }
        return false
    }

    private fun compute(x: Double, y: Double): Dot? {
        val hit = checkAreaHit(x, y, trueGraph?.area1!!, trueGraph?.area2!!, trueGraph?.area3!!, trueGraph?.area4!!)
        return Dot(x, y, hit)
    }

    private fun getAnswer (area1: Int, area2: Int, area3: Int, area4: Int): Boolean =
        (area1 == trueGraph?.area1!! && area2 == trueGraph?.area2!! && area3 == trueGraph?.area3!! && area4 == trueGraph?.area4!!)


    @PostMapping
    fun createGame (principal: Principal) : OngoingGamePacked {
        val user = getUserByName(principal.name)
        var existingGame = ongoingGameRepository?.findAllByUserInfoAndGameType(user, "detective")
        return if (existingGame != null) {
            val checkResults = ongoingGameCheckEntryRepository?.findAllByOngoingGame(existingGame) ?: emptyList()
            val resultsList = ArrayList<Dot>()
            checkResults.forEach { resultsList.add(Dot(it.x, it.y, it.isHit)) }

            val suspectList = ArrayList<Suspect>()
            existingGame.suspectsTypes?.forEach { suspectList.add(
                Suspect(it and 255,
                    (it shr 8) and 255,
                    (it shr 16) and 255,
                    (it shr 24) and 255)
            )
            }

            val gamePacked = OngoingGamePacked (suspectList, resultsList)
            gamePacked
        } else {
            val suspectList = generateSuspects()
            existingGame = OngoingGame("time", LocalDateTime.now())
            existingGame.graphType = (trueGraph!!.area4 shl 24) or (trueGraph!!.area3 shl 16) or (trueGraph!!.area2 shl 8) or trueGraph!!.area1
            existingGame.suspectsTypes = ArrayList()
            suspectList.forEach {
                existingGame.suspectsTypes?.add(
                    (it.area4 shl 24) or (it.area3 shl 16) or (it.area2 shl 8) or it.area1)
            }
            ongoingGameRepository?.save(existingGame)

            val gamePacked = OngoingGamePacked(suspectList, null)
            gamePacked
        }
    }

    @PostMapping("/checkDot")
    fun checkDot(@RequestBody p: DotCheckRequest, principal: Principal): Dot? {
        val dot = compute(p.x, p.y) ?: return null
        val user = getUserByName(principal.name)
        val currentGame = ongoingGameRepository?.findAllByUserInfoAndGameType(user, "time")
        currentGame?.gameCheckEntries?.add(OngoingGameCheckEntry(p.x, p.y, dot.isHit).apply { this.ongoingGame = currentGame })
        ongoingGameRepository?.save(currentGame!!)
        return dot
    }

    @PostMapping("/getResult")
    fun getGameResult(@RequestBody p: Suspect, principal: Principal): GameResult? {
        val user = getUserByName(principal.name)
        val currentGame = ongoingGameRepository?.findAllByUserInfoAndGameType(user, "time")
        val result = getAnswer(p.area1, p.area2, p.area3, p.area4)
        val clicks = currentGame?.gameCheckEntries?.size
        val elapsedTime = Duration.between(currentGame?.startTime, LocalDateTime.now()).toMillis()

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
        return GameResult(result, elapsedTime, gameScore)
    }

    private fun getUserByName(username: String) = userInfoRepository?.findByUsername(username)
        ?: throw Exception("User with name \"$username\" does not exist.")


}