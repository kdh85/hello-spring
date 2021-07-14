package hello.hellospring.service;

import hello.hellospring.repository.MemberBeanRepository;

public class MemberBeanService {

    private final MemberBeanRepository memberBeanRepository;

    public MemberBeanService(MemberBeanRepository memberBeanRepository) {
        this.memberBeanRepository = memberBeanRepository;
    }
}
