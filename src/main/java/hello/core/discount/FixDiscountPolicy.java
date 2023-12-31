package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component // 조회 빈이 2개 이상 확인 위해 추가
//@Qualifier("fixDiscountPolicy")
public class  FixDiscountPolicy implements DiscountPolicy {

    private int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int price) {

        if(member.getGrade()== Grade.VIP){
            return discountFixAmount;
        }else{
            return 0;
        }

    }
}
