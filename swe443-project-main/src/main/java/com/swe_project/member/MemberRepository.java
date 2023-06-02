package com.swe_project.member;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, Long> {
    // List<Member> findByContent(String content);

    Optional<Member> findById(Long id);

    // void save(Member newGreeting);
}
