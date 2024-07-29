package org.junbeom.member.repositories;

import org.junbeom.member.entities.Authorities;
import org.junbeom.member.entities.AuthoritiesId;
import org.junbeom.member.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface AuthoritiesRepository extends JpaRepository<Authorities, AuthoritiesId>,
        QuerydslPredicateExecutor<Authorities> {

    List<Authorities> findByMember(Member member);
}
