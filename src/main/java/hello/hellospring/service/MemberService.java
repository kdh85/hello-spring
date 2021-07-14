package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberJpaRepository;
import hello.hellospring.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    private final MemberJpaRepository memberJpaRepository;

    public Long join(Member member) {
        validateDuplicateMember(member);

        //memberRepository.save(member);
        memberJpaRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        /*
        memberRepository.findByName(member.getName())
                .ifPresent(
                        member1 -> {
                            throw new IllegalStateException("이미 존재하는 회원입니다.");
                        });
        */
        memberJpaRepository.findByName(member.getName())
                .ifPresent(
                        member1 -> {
                            throw new IllegalStateException("이미 존재하는 회원입니다.");
                        });
    }

    public List<Member> findMembers(){
        //return memberRepository.findAll();
        return memberJpaRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        //return memberRepository.findById(memberId);
        return memberJpaRepository.findById(memberId);
    }
}
