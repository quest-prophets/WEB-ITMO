package lab4.controller

import org.springframework.stereotype.Controller
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import lab4.model.Role
import lab4.model.UserInfo
import lab4.repository.UserInfoRepository
import java.util.*
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder



@Controller
@RequestMapping("/auth")
class AuthorizationController {

    @Autowired
    private val userInfoRepository: UserInfoRepository? = null

    @GetMapping("/login")
    fun login() = "/index.html"

    @GetMapping("/register")
    fun register(): String {
        return "/index.html"
    }

    @PostMapping("/register")
    @ResponseBody
    fun addUser(@RequestBody user: UserInfo): AuthResponse {
        val passwordEncoder = BCryptPasswordEncoder()
        val encodedPassword = passwordEncoder.encode(user.password)
        user.password = encodedPassword

        val existingUser = userInfoRepository?.findByUsername(user.username)
        val authResponse = AuthResponse(user.username, AuthType.REGISTER)
        return if (existingUser != null) {
            authResponse.success = false
            authResponse.message = "Username '${user.username}' is already taken. Please try again."
            authResponse
        } else {
            user.active = true
            user.roles = Collections.singleton(Role.USER)
            userInfoRepository?.save(user)

            authResponse.success = true
            authResponse.message = "Successfully registered. You can sign in with your username and password."
            authResponse
        }
    }

    enum class AuthType { LOGIN, REGISTER }

    data class AuthResponse(var username: String = "", var type: AuthType = AuthType.LOGIN,
                            var success: Boolean = false, var message: String = "")

}