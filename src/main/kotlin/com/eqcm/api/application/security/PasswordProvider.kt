package com.eqcm.api.application.security

import org.mindrot.jbcrypt.BCrypt
import org.springframework.stereotype.Component

@Component
class PasswordProvider {
    fun hash(password: String): String = BCrypt.hashpw(password, BCrypt.gensalt())


    fun matches(password: String, hashed: String) = BCrypt.checkpw(password, hashed)
}
