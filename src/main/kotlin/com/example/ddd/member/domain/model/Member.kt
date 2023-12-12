package com.example.ddd.member.domain.model

import com.example.ddd.common.model.Address
import com.example.ddd.member.domain.exception.PasswordNotMatchException

class Member(
    private val memberId: MemberId,
    private var password: Password,
    private var address: Address
) {
    fun changePassowrd(currentPassword: String, newPassword:String){
        if (!password.match(currentPassword))
            throw PasswordNotMatchException()
        password = Password(newPassword)
    }

    fun changeAddress(address: Address){
        this.address = address
    }
}