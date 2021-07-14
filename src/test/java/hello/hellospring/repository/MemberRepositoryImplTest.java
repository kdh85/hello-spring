package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryImplTest {

    MemberRepository memberRepository = new MemberRepositoryImpl();

    @AfterEach
    public void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void saveTest() {
        Member member = getMember("spring");

        Member findMember = memberRepository.findById(member.getId()).get();

        assertThat(findMember.getName()).isEqualTo("spring");
    }

    @Test
    void findByNameTest() {
        Member member = getMember("spring1");

        Member member2 = getMember("spring2");

        Member findMember = memberRepository.findByName("spring1").get();
        assertThat(findMember).isEqualTo(member);
    }

    private Member getMember(String spring1) {
        Member member = new Member();
        member.setName(spring1);

        memberRepository.save(member);
        return member;
    }

    @Test
    void findAllTest() {
        craeteMembers();

        List<Member> all = memberRepository.findAll();
        assertThat(all.size()).isEqualTo(2);
    }

    private void craeteMembers() {
        Member member = getMember("spring1");

        Member member2 = getMember("spring2");
    }
}