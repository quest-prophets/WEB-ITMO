package lab4.controller


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import lab4.model.Dot
import lab4.model.Result
import lab4.repository.ResultRepository
import lab4.repository.UserInfoRepository
import org.springframework.web.bind.annotation.RequestMapping
import java.security.Principal
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@RestController
@RequestMapping("/dotCheck")
class LabController {
    @Autowired
    var userInfoRepository: UserInfoRepository? = null

    @Autowired
    var resultRepository: ResultRepository? = null

    data class DotCheckRequest(var x: Double = 0.0, var y: Double = 0.0, var r: Double = 0.0)
    data class ResultsEntry(var x: Double = 0.0, var y: Double = 0.0, var r: Double = 0.0,
                            var isHit: Boolean = false,
                            var time: String = DateTimeFormatter.ofPattern("dd-MM-yyyy'\n'HH:mm:ss").format(LocalDateTime.now()))


    private fun checkDataValidity(x: Double, y: Double, r: Double) = r in (1.0..5.0) && x in (-5.0..3.0) && y in (-3.0..3.0)

    private fun checkAreaHit(x: Double, y: Double, r: Double): Boolean {
        if (x in -r..0.0 && y in 0.0..r / 2) {
            return true
        }
        if (x >= 0 && y >= 0 && x * x + y * y <= r * r / 4) {
            return true
        }
        if (x <= 0 && y <= 0 && y >= -(x + r)/2) {
            return true
        }
        return false
    }

    private fun compute(x: Double, y: Double, r: Double): Dot? {
        if (!checkDataValidity(x, y, r)) return null
        val hit = checkAreaHit(x, y, r)
        return Dot(x, y, hit)
    }

    @PostMapping
    fun addDot(@RequestBody p: DotCheckRequest, principal: Principal): ResultsEntry? {
        val dot = compute(p.x, p.y, p.r) ?: return null
        val user = getUserByName(principal.name)
        val result = Result(p.x, p.y, p.r, dot.isHit)
        user.results?.add(result.apply { this.userInfo = user }) ?: ArrayList<Result>()
        userInfoRepository?.save(user)
        return ResultsEntry(Math.round(result.x*1000.0)/1000.0, Math.round(result.y*1000.0)/1000.0, Math.round(result.r*1000.0)/1000.0,
            result.isHit, result.time)
    }

    @PostMapping("/clear")
    fun clearResults(principal: Principal): Boolean = try {
            val user = getUserByName(principal.name)
            resultRepository?.deleteAllByUserInfo(user)
            true
        } catch (e: Exception) {
            false
        }

    @GetMapping("/update/{r}")
    fun recomputeDotChecks(@PathVariable r: Double, principal: Principal): List<Dot> {
        val user = userInfoRepository?.findByUsername(principal.name)
            ?: throw Exception("User with name \"${principal.name}\" does not exist.")
        val results = resultRepository?.findAllByUserInfo(user)
        val dots = ArrayList<Dot>()
        results?.forEach { dots.add(Dot(it.x, it.y, checkAreaHit(it.x, it.y, r))) }
        return dots
    }

    private fun getUserByName(username: String) = userInfoRepository?.findByUsername(username)
        ?: throw Exception("User with name \"$username\" does not exist.")

    @GetMapping("/fetchResults")
    fun fetchResultsByUser(principal: Principal): List<ResultsEntry> {
        val user = getUserByName(principal.name)
        val results = resultRepository?.findAllByUserInfo(user) ?: emptyList()
        val resultsList = ArrayList<ResultsEntry>()
        results.forEach { resultsList.add(ResultsEntry(it.x, it.y, it.r, it.isHit, it.time)) }
        return resultsList
    }

}