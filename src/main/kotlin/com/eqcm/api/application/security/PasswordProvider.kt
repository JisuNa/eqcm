package com.eqcm.api.application.security

import org.mindrot.jbcrypt.BCrypt
import org.springframework.stereotype.Component

@Component
class PasswordProvider {
    fun hash(password: String): String {
        return BCrypt.hashpw(password, BCrypt.gensalt())
    }

    fun matches(password: String, hashed: String): Boolean {
        return BCrypt.checkpw(password, hashed)
    }
}
