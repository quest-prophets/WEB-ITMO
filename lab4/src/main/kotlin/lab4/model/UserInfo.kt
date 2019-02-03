package lab4.model

import javax.persistence.*

@Entity
@Table(name = "users")
data class UserInfo(@Column(nullable = false, unique = true) var username: String = "",
                    var password: String = "") {

    @Id
    @GeneratedValue
    var id: Int? = null

    var active: Boolean = true

    @ElementCollection(targetClass = Role::class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = [JoinColumn(name = "user_id")])
    @Enumerated(EnumType.STRING)
    var roles: Set<Role>? = null

    @OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.ALL], mappedBy = "user")
    var results: MutableList<Result>? = null

}