package com.example.ddd.member.domain.repository

import com.example.ddd.member.domain.model.Member
import com.example.ddd.member.domain.model.MemberId
import org.springframework.data.jpa.repository.JpaRepository

interface MemberRepository: JpaRepository<Member, MemberId> {
}