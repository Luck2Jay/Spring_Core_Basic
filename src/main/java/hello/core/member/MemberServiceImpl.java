package hello.core.member;

public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository = new MemoryMemberRepository(); // 컨트롤 쉬프트 엔터 하면 세미클론까지 자동 입력

    @Override
    public void join(Member member) {
        memberRepository.save(member); // MemoryMemberRepository의 save
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId); // MemoryMemberRepository의 findById
    }
}
