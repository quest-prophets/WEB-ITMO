package lab4.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody
import java.security.Principal

@Controller
class PageController {

    @GetMapping("/username")
    @ResponseBody
    fun currentUsername(principal: Principal): String {
        return principal.name
    }

    @GetMapping("/")
    fun home() = "index.html"

    @GetMapping("/mainMenu")
    fun menu() = "mainMenu.html"

    @GetMapping("/practice")
    fun graph() = "practice.html"

}