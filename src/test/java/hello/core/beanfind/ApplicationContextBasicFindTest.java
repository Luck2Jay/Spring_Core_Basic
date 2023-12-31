package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName(){
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        System.out.println("memberService = " + memberService);
        System.out.println("memberService.getCLass() = " + memberService.getClass());
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class); // win alt enter
    }

    @Test
    @DisplayName("구체 타입으로 조회")
    void findBeanByName2(){
        MemberService memberService = ac.getBean("memberService",MemberServiceImpl.class);
        System.out.println("memberService = " + memberService);
        System.out.println("memberService.getCLass() = " + memberService.getClass());
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class); // win alt enter
    }
    @Test
    @DisplayName("이름없이 타입으로만 조회")
    void findBeanByType(){
        MemberService memberService = ac.getBean(MemberService.class);
        System.out.println("memberService = " + memberService);
        System.out.println("memberService.getCLass() = " + memberService.getClass());
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class); // win alt enter
    }

    @Test
    @DisplayName("빈 이름으로 조회 x")
    void findBeanByNameX(){
//        ac.getBean("xxxxx",MemberService.class);
//        MemberService xxxxx = ac.getBean("xxxxx", MemberService.class);
//        MemberService memberService = ac.getBean(MemberService.class);
//        System.out.println("memberService = " + memberService);
//        System.out.println("memberService.getCLass() = " + memberService.getClass());
//        assertThat(memberService).isInstanceOf(MemberServiceImpl.class); // win alt enter
        assertThrows(NoSuchBeanDefinitionException.class,() -> //에러가 나야 테스트가 성공
                ac.getBean("xxxxx", MemberService.class));
    }





}
