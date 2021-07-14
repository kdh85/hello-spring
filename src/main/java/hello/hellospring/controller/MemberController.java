package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class MemberController {
    //lombok이 생서자를 만들어주는 방식으로 사용.
    private final MemberService memberService;
    /*
    //의존관계 필드 주입 방식
    @Autowired
    MemberService memberService;

    //의존관계 생성자 주입 방식
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    //의존관계 setter 주입 방식
    @Autowired
    public void setMemberService(MemberService memberService) {
        this.memberService = memberService;
    }
    */
}
