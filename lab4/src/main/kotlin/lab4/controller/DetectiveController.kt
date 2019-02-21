package lab4.controller

import lab4.model.Suspect
import lab4.repository.UserInfoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import kotlin.random.Random

@RestController
@RequestMapping("/detectiveCheck")
class DetectiveController {
    @Autowired
    var userInfoRepository: UserInfoRepository? = null

    data class DotCheckRequest(var x: Double = 0.0, var y: Double = 0.0)

    private fun generateGraph () {
        val area1 = Random.nextInt(1, 9)
        val area2 = Random.nextInt(1, 9)
        val area3 = Random.nextInt(1, 9)
        val area4 = Random.nextInt(1, 9)
        generateSuspects(area1, area2, area3, area4)
    }

    private fun generateSuspects(area1: Int, area2: Int, area3: Int, area4: Int) {
        val suspectList = ArrayList<Suspect>()
        suspectList.add(Suspect(area1, area2, area3, area4))
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

            suspectList.add(Suspect(susArea1, susArea2, susArea3, susArea4))
        }
        suspectList.add(Suspect(Random.nextInt(1, 9), Random.nextInt(1, 9),
                                Random.nextInt(1, 9), Random.nextInt(1, 9)))
        suspectList.add(Suspect(Random.nextInt(1, 9), Random.nextInt(1, 9),
                                Random.nextInt(1, 9), Random.nextInt(1, 9)))
        suspectList.shuffle()
    }

}