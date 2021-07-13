package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberReposiotry;
import hello.hellospring.repository.MemberRepositoryImpl;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberReposiotry memberReposiotry;

    public Long join(Member member) {
        validateDuplicateMember(member);

        memberReposiotry.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberReposiotry.findByName(member.getName())
                .ifPresent(
                        member1 -> {
                            throw new IllegalStateException("이미 존재하는 회원입니다.");
                        });
    }

    public List<Member> findMembers(){
        return memberReposiotry.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberReposiotry.findById(memberId);
    }
}
