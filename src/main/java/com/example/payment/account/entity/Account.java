package com.example.payment.account.entity;

import com.example.payment.global.entity.BaseEntity;
import com.example.payment.member.entity.Member;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "accounts")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Account extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(name = "account_number", nullable = false, updatable = false, length = 10)
    private String accountNumber;

    @Column(nullable = false)
    private BigDecimal balance;

    @Column(nullable = false)
    private String password;

    @Builder
    public Account(final Member member, final String accountNumber, final BigDecimal balance, final String password) {
        this.member = member;
        this.accountNumber = accountNumber;
        this.balance = BigDecimal.valueOf(100000);
        this.password = password;
    }

    public void updateBalance(final BigDecimal balance) {
        this.balance = balance;
    }
}
