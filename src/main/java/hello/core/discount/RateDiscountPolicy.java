package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class RateDiscountPolicy implements DiscountPolicy{

    private double VIPdiscoutnPer = 0.1;
    private double BASICdiscoutnPer = 0.05;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade()== Grade.VIP)
            return (int)(price*VIPdiscoutnPer);
        else
            return (int)(price*BASICdiscoutnPer);
    }
}
