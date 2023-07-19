package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 설정 정보
public class AppConfig {

    // @Bean memberService() -> MemberServiceImpl() -> memberRepository() -> MemoryMemberRepository()
    // @Bean orderService -> OrderServiceImpl() -> memberRepository(), discountPolicy() -> MemoryMemberRepository(),RateDiscountPolicy()

    //예상
    //call AppConfig.memberService
    //call AppConfig.memberRepository
    //call AppConfig.memberRepository
    //call AppConfig.orderService
    //call AppConfig.memberRepository

    //실제
    //call AppConfig.memberService
    //call AppConfig.memberRepository
    //call AppConfig.orderService

    @Bean
    public MemberService memberService(){
        //soutm
        System.out.println("call AppConfig.memberService");

        //ctrl alt m
        return new MemberServiceImpl(memberRepository()); // 생성자 주입, 생성자를 통해 MemberServiceImpl이 배우를 정하지 않도록 주입
    }

    @Bean // 스프링 컨테이너에 등록
    public MemberRepository memberRepository() { // 역할

        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();

    }

    @Bean
    public OrderService orderService(){
        System.out.println("call AppConfig.orderService");

        return new OrderServiceImpl(memberRepository(), discountPolicy());
//        return null;

    }

}
