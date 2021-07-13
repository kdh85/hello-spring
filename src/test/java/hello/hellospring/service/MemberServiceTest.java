package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberReposiotry;
import hello.hellospring.repository.MemberRepositoryImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    MemberReposiotry memberReposiotry;

    @BeforeEach
    public void beforeEach(){
        memberReposiotry = new MemberRepositoryImpl();
        memberService = new MemberService(memberReposiotry);
    }

    @AfterEach
    public void afterEach(){
        memberReposiotry.clearStore();
    }

    @Test
    void join() {
        //given
        Member member = getMember("hello");

        //when
        Long saveId = memberService.join(member);
        //then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    private Member getMember(String name) {
        Member member = new Member();
        member.setName(name);
        return member;
    }

    @Test
    void duplicateMemberTest() {
        //given
        Member member1 = getMember("member1");
        Member member2 = getMember("member1");

        //when
        memberService.join(member1);

        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        //then
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}