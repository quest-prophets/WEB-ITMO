package lab4.model

import javax.persistence.*

@Entity
@Table(name = "users")
data class UserInfo(@Column(nullable = false, unique = true) var username: String = "",
                    var password: String = "") {

    @Id
    @GeneratedValue
    var id: Long? = null

    var active: Boolean = true

    @ElementCollection(targetClass = Role::class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = [JoinColumn(name = "user_id")])
    @Enumerated(EnumType.STRING)
    var roles: Set<Role>? = null

    @OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.ALL], mappedBy = "userInfo")
    var results: MutableList<Result>? = null

    var overallDots: Long = 0
    var overallElapsedTime: Long = 0
    var overallGames: Long = 0
    var overallWins: Long = 0
    var score: Long = 0
    var performance: Double = 0.0
}