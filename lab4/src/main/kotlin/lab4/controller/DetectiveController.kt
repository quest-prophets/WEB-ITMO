package lab4.controller

import lab4.model.Dot
import lab4.model.Suspect
import lab4.repository.OngoingGameRepository
import lab4.repository.OngoingGameResultRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.lang.Math.pow
import kotlin.random.Random

@RestController
@RequestMapping("/detectiveCheck")
class DetectiveController {

    @Autowired
    var ongoingGameRepository: OngoingGameRepository? = null

    @Autowired
    var ongoingGameResultRepository: OngoingGameResultRepository? = null

    var trueGraph: Suspect? = null
    var suspectList: ArrayList<Suspect>? = ArrayList()

    data class DotCheckRequest(var x: Double = 0.0, var y: Double = 0.0)
    data class ResultsEntry(var x: Double = 0.0, var y: Double = 0.0, var isHit: Boolean = false)


    private fun generateSuspects() {
        val area1 = Random.nextInt(1, 9)
        val area2 = Random.nextInt(1, 9)
        val area3 = Random.nextInt(1, 9)
        val area4 = Random.nextInt(1, 9)
        trueGraph = Suspect(area1, area2, area3, area4)
        suspectList?.add(Suspect(area1, area2, area3, area4))
        for (i in 0..2){
            var susArea1 = 5

            if (area1 == 1 || area1 == 3 || area1 == 8)
                susArea1 = listOf(1, 3, 6, 7, 8).random()
            if (area1 == 2 || area1 == 4)
                susArea1 = listOf(2, 4, 6, 7, 9).random()
            if (area1 == 5) susArea1 = 5
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
            if (area1 == 5) susArea2 = 5
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
            if (area1 == 5) susArea3 = 5
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

            suspectList?.add(Suspect(susArea1, susArea2, susArea3, susArea4))
        }
        suspectList?.add(Suspect(Random.nextInt(1, 9), Random.nextInt(1, 9),
                                Random.nextInt(1, 9), Random.nextInt(1, 9)))
        suspectList?.add(Suspect(Random.nextInt(1, 9), Random.nextInt(1, 9),
                                Random.nextInt(1, 9), Random.nextInt(1, 9)))
        suspectList?.shuffle()
    }

    private fun checkAreaHit(x: Double, y: Double,  area1: Int, area2: Int, area3: Int, area4: Int): Boolean {
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

    private fun compute(x: Double, y: Double): Dot? {
        val hit = checkAreaHit(x, y, trueGraph?.area1!!, trueGraph?.area2!!, trueGraph?.area3!!, trueGraph?.area4!!)
        return Dot(x, y, hit)
    }

}