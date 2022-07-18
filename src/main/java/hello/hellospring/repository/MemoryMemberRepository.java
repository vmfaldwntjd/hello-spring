package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>(); //파이썬의 사전형 타입이라고 생각하면 될 듯
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); //Optional로 감싸줘야 클라이언트에서의 작업이 편해진다.
    }

    @Override
    public Optional<Member> findByName(String name) {
        return  store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();//필터에서 람다 함수가 적용. member에서 member.getName이 name과 같은지 비교
                            //람다식의 구조는 기본적으로 () -> {} 구조로 되어 있는데 들어오는 매개 변수가 한 개인 경우는
                            // 괄호를 생략할 수가 있다.
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
