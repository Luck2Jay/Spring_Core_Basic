package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository ; // 컨트롤 쉬프트 엔터 하면 세미클론까지 자동 입력

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member); // MemoryMemberRepository의 save
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId); // MemoryMemberRepository의 findById
    }

    //테스트 용도
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }

}
