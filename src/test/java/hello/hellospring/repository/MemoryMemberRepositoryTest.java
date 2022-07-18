package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member(); //테스트를 위해 세로운 멤버 객체를 만들고
        member.setName("spring"); //그 멤버의 이름을 "spring"으로 정했다.

        repository.save(member); //이것을 레포지토리 객체의 save기능을 통해서 저장하였다.

        //그리고 레퍼지토리에서 멤버의 id를 추출해서 그 id가 member와 같은지 확인
        Member result = repository.findById(member.getId()).get();
        assertThat(member).isEqualTo(result);
    }

    //멤버 이름 찾기 메서드에 대한 테스트 코드
    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        //멤버를 추가적으로 더 만들어보았다.
        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }
}
