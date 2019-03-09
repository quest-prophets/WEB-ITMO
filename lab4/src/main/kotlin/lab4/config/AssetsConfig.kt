package lab4.config

import org.springframework.context.annotation.*
import org.springframework.web.servlet.config.annotation.*
import org.springframework.web.servlet.view.InternalResourceViewResolver

@Configuration
class AssetsConfig : WebMvcConfigurer {
    @Bean
    fun getViewResolver() = InternalResourceViewResolver().apply { setSuffix(".html") }

    override fun addViewControllers(registry: ViewControllerRegistry) {
        registry.addViewController("/").setViewName("forward:/index.html")
    }

    override fun addResourceHandlers(registry: ResourceHandlerRegistry) {
        registry.addResourceHandler("/*.js").addResourceLocations("classpath:assets/")
        registry.addResourceHandler("/img/**").addResourceLocations("classpath:assets/img/")
    }
}