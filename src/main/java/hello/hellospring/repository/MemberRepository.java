package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository   {
    Member save(Member member);
    Optional<Member> findById(Long id); //찾았는데 값이 없으면 null을 반환하게 되는데 Null 대신에 Optional 방식을 사용을 한다.
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
