package hello.core.discount;
import hello.core.member.Grade;
import hello.core.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RateDiscountPolicyTest {
    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10프로 할인이 적용되어야 하고, BASIC은 5프로할인이 적용되어야한다.")
    void dc_o(){
        //given
        Member member1 = new Member(1L, "member1", Grade.BASIC);
        Member member2 = new Member(2L, "member2", Grade.VIP);

        //when
        int discount1 = discountPolicy.discount(member1, 10000);
        int discount2 = discountPolicy.discount(member2, 10000);

        //then
        assertThat(discount1).isEqualTo(500);
        assertThat(discount2).isEqualTo(1000);
    }
}
