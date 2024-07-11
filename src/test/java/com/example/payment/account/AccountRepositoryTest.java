package com.example.payment.account;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.payment.account.entity.Account;
import com.example.payment.member.MemberRepository;
import com.example.payment.member.entity.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.math.BigDecimal;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@DataJpaTest
public class AccountRepositoryTest {

    @PersistenceContext
    EntityManager em;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    MemberRepository memberRepository;

    @Test
    @DisplayName("계좌를 생성한 후, 생성한 계좌를 확인한다.")
    void 계좌를_생성한후_생성한_계좌를_확인한다() throws Exception {
        //given
        final Member member = Member.builder().email("abc@abc.com").nickName("abc").password("abc123").build();
        final Account account = Account.builder()
                .member(member)
                .accountNumber("1234567891")
                .password("1234")
                .balance(BigDecimal.ZERO)
                .build();

        //when
        final Account savedAccount = accountRepository.save(account);

        //then
        SoftAssertions.assertSoftly(softAssertions -> {
            softAssertions.assertThat(savedAccount.getMember()).isEqualTo(account.getMember());
            softAssertions.assertThat(savedAccount.getBalance()).isEqualTo(account.getBalance());
            softAssertions.assertThat(savedAccount.getAccountNumber()).isEqualTo(account.getAccountNumber());
        });
    }

    @Test
    @DisplayName("계좌를 생성한 후, 계좌의 존재 여부를 확인한다.")
    void 계좌를_생성한후_계좌의_존재_여부를_확인한다() throws Exception {
        //given
        final Member member = Member.builder().email("abc@abc.com").nickName("abc").password("abc123").build();
        final Account account = Account.builder()
                .member(member)
                .accountNumber("1234567891")
                .password("1234")
                .balance(BigDecimal.ZERO)
                .build();

        //when
        memberRepository.save(member);
        final Account savedAccount = accountRepository.save(account);

        //then
        Boolean check = accountRepository.existsByAccountNumber(savedAccount.getAccountNumber());

        assertThat(check).isTrue();
    }

    @Test
    @DisplayName("존재하지 않는 계좌의 존재 여부를 확인한다.")
    void 존재하지_않는_계좌의_존재_여부를_확인한다() throws Exception {
        //given
        final Member member = Member.builder().email("abc@abc.com").nickName("abc").password("abc123").build();
        final Account account = Account.builder()
                .member(member)
                .accountNumber("1234567891")
                .password("1234")
                .balance(BigDecimal.ZERO)
                .build();

        //when
        memberRepository.save(member);

        //then
        Boolean check = accountRepository.existsByAccountNumber(account.getAccountNumber());

        assertThat(check).isFalse();
    }
}
