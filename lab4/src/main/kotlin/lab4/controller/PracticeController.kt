package lab4.controller


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import lab4.model.Dot
import lab4.model.Result
import lab4.repository.ResultRepository
import lab4.repository.UserInfoRepository
import org.springframework.web.bind.annotation.RequestMapping
import java.security.Principal
import javax.servlet.http.HttpServletResponse

@RestController
@RequestMapping("/dotCheck")
class PracticeController {
    @Autowired
    var userInfoRepository: UserInfoRepository? = null

    @Autowired
    var resultRepository: ResultRepository? = null

    data class DotCheckRequest(var x: Double = 0.0, var y: Double = 0.0, var r: Double = 0.0)
    data class ResultsEntry(var x: Double = 0.0, var y: Double = 0.0, var r: Double = 0.0, var isHit: Boolean = false)


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
    fun addDot(@RequestBody p: DotCheckRequest, principal: Principal): Dot? {
        val dot = compute(p.x, p.y, p.r) ?: return null
        val user = getUserByName(principal.name)
        user.results?.add(Result(p.x, p.y, p.r, dot.isHit).apply { this.user = user }) ?: ArrayList<Result>()
        userInfoRepository?.save(user)
        return dot
    }

    @PostMapping("/clear")
    fun clearResults(principal: Principal, response: HttpServletResponse) {
        val user = getUserByName(principal.name)
        resultRepository?.deleteAllByUserEntry(user)
        response.sendRedirect("/graph")
    }

    @GetMapping("/update/{r}")
    fun recomputeDotChecks(@PathVariable r: Double, principal: Principal): List<Dot> {
        val user = userInfoRepository?.findByUsername(principal.name)
            ?: throw Exception("User with name \"${principal.name}\" does not exist.")
        val results = resultRepository?.findAllByUserEntry(user)
        val dots = ArrayList<Dot>()
        results?.forEach { dots.add(Dot(it.x, it.y, checkAreaHit(it.x, it.y, r))) }
        return dots
    }

    private fun getUserByName(username: String) = userInfoRepository?.findByUsername(username)
        ?: throw Exception("User with name \"$username\" does not exist.")

    @GetMapping("/fetchResults")
    fun fetchResultsByUser(principal: Principal): List<ResultsEntry> {
        val user = getUserByName(principal.name)
        val results = resultRepository?.findAllByUserEntry(user) ?: emptyList()
        val resultsList = ArrayList<ResultsEntry>()
        results.forEach { resultsList.add(ResultsEntry(it.x, it.y, it.r, it.isHit)) }
        return resultsList
    }

}