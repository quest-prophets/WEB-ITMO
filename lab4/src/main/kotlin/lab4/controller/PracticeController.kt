package lab4.controller

import lab4.model.*
import lab4.repository.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.lang.Math.pow
import java.security.Principal
import kotlin.random.Random

@RestController
@RequestMapping("/pracCheck")
class PracticeController {

    @Autowired
    var userInfoRepository: UserInfoRepository? = null

    @Autowired
    var ongoingGameRepository: OngoingGameRepository? = null

    @Autowired
    var ongoingGameCheckEntryRepository: OngoingGameCheckEntryRepository? = null

    data class DotCheckRequest(var x: Double = 0.0, var y: Double = 0.0)
    data class GameResult(var success: Boolean = false, var clicks: Int = 0)


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
        suspectList.add(Suspect(Random.nextInt(1, 9), Random.nextInt(1, 9),
                                Random.nextInt(1, 9), Random.nextInt(1, 9)))
        suspectList.add(Suspect(Random.nextInt(1, 9), Random.nextInt(1, 9),
                                Random.nextInt(1, 9), Random.nextInt(1, 9)))
        return suspectList
    }

    private fun checkAreaHit(x: Double, y: Double, area1: Int, area2: Int, area3: Int, area4: Int): Boolean {
        if (x >= 0 && y >= 0) {
            when (area1) {
                1 -> return pow(x, 2.0) + pow(y, 2.0) <= pow(1.0, 2.0)
                2 -> return pow(x, 2.0) + pow(y, 2.0) <= pow(1.0 / 2, 2.0)
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
                1 -> return pow(x, 2.0) + pow(y, 2.0) <= pow(1.0, 2.0)
                2 -> return pow(x, 2.0) + pow(y, 2.0) <= pow(1.0 / 2, 2.0)
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
                1 -> return pow(x, 2.0) + pow(y, 2.0) <= pow(1.0, 2.0)
                2 -> return pow(x, 2.0) + pow(y, 2.0) <= pow(1.0 / 2, 2.0)
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
                1 -> return pow(x, 2.0) + pow(y, 2.0) <= pow(1.0, 2.0)
                2 -> return pow(x, 2.0) + pow(y, 2.0) <= pow(1.0 / 2, 2.0)
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

    private fun compute(x: Double, y: Double, trueGraph: Suspect): Dot? {
        val hit = checkAreaHit(x, y, trueGraph.area1, trueGraph.area2, trueGraph.area3, trueGraph.area4)
        return Dot(x, y, hit)
    }



    @PostMapping
    fun createGame (principal: Principal) : OngoingGamePacked {
        val user = getUserByName(principal.name)
        var existingGame = ongoingGameRepository?.findAllByUserInfoAndGameType(user, "practice")
        return if (existingGame != null) {
            val checkResults = ongoingGameCheckEntryRepository?.findAllByOngoingGame(existingGame) ?: emptyList()
            val resultsList = ArrayList<Dot>()
            checkResults.forEach { resultsList.add(Dot(it.x, it.y, it.isHit)) }

            val suspectList = ArrayList<Suspect>()
            existingGame.suspectsTypes?.forEach { suspectList.add(
                Suspect.decode(it))
            }

            val gamePacked = OngoingGamePacked (suspectList, resultsList)
            gamePacked
        } else {
            val suspectList = generateSuspects()
            val trueGraph = suspectList.first()
            suspectList.shuffle()

            existingGame = OngoingGame("practice")
            existingGame.graphType = trueGraph.encode()
            existingGame.suspectsTypes = ArrayList()
            suspectList.forEach {
                existingGame.suspectsTypes?.add(
                    it.encode()
                )
            }
            user.ongoingGames?.add(existingGame.apply { this.userInfo = user }) ?: ArrayList<OngoingGame>()
            userInfoRepository?.save(user)
//            ongoingGameRepository?.save(existingGame)

            val gamePacked = OngoingGamePacked(suspectList, null)
            gamePacked
        }
    }

    @PostMapping("/checkDot")
    fun checkDot(@RequestBody p: DotCheckRequest, principal: Principal): Dot? {
        val user = getUserByName(principal.name)
        val currentGame = ongoingGameRepository?.findAllByUserInfoAndGameType(user, "practice")
        val dot = compute(p.x, p.y, Suspect.decode(currentGame?.graphType!!)) ?: return null

        currentGame.gameCheckEntries?.add(OngoingGameCheckEntry(p.x, p.y, dot.isHit).apply { this.ongoingGame = currentGame })
        ongoingGameRepository?.save(currentGame)
        return dot
    }

    @PostMapping("/getResult")
    fun getGameResult(@RequestBody p: Suspect, principal: Principal): GameResult? {
        val user = getUserByName(principal.name)
        val currentGame = ongoingGameRepository?.findAllByUserInfoAndGameType(user, "practice")!!
        val result = (currentGame.graphType == p.encode())
        val clicks = currentGame.gameCheckEntries?.size

        ongoingGameCheckEntryRepository?.deleteAllByOngoingGame(currentGame)
        ongoingGameRepository?.delete(currentGame)
        return GameResult(result, clicks!!)
    }

    private fun getUserByName(username: String) = userInfoRepository?.findByUsername(username)
        ?: throw Exception("User with name \"$username\" does not exist.")

}