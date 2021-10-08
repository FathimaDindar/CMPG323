package za.ac.nwu.ac.domain.persistence;

import za.ac.nwu.ac.domain.dto.AccountTransactionDetailsDto;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "ACCOUNT_TRANSACTION", schema = "FATHIMA")
public class AccountTransaction implements Serializable {

    private static final long serialVersionUID = 8898610430083916190L;

    private Long accountTransactionId;
    private AccountType accountType;
    private Members member;
    private Integer amount;
    private LocalDate transactionDate;

    AccountTransactionDetails details;

    public AccountTransaction(Long accountTransactionId, AccountType accountType, Members member, Integer amount, LocalDate transactionDate) {
        this.accountTransactionId = accountTransactionId;
        this.accountType = accountType;
        this.member = member;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    public AccountTransaction() {
    }

    public AccountTransaction(Integer amount, LocalDate transactionDate) {
        this.amount = amount;
        this.transactionDate = transactionDate;
    }


    @Id
    @SequenceGenerator(name = "FATHI_GENERIC_SEQ", sequenceName = "FATHIMA.FATHI_GENERIC_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FATHI_GENERIC_SEQ")
    @Column(name = "Account_Transaction_ID")
    public Long getAccountTransactionId() {
        return accountTransactionId;
    }

    public void setAccountTransactionId(Long accountTransactionId) {
        this.accountTransactionId = accountTransactionId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACCOUNT_TYPE_ID")
    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID")
    public Members getMember() {
        return member;
    }

    public void setMember(Members member) {
        this.member = member;
    }


    @Column(name = "AMOUNT")
    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Column(name = "TRANSACTION_DATE")
    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    @OneToOne(targetEntity = AccountTransactionDetails.class, fetch = FetchType.LAZY, mappedBy = "accountTransactionId")
    public AccountTransactionDetails getDetails() {
        return details;
    }

    public void setDetails(AccountTransactionDetails details)
    {
        this.details = details;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTransaction that = (AccountTransaction) o;
        return Objects.equals(accountTransactionId, that.accountTransactionId) && Objects.equals(accountType, that.accountType) && Objects.equals(member, that.member) && Objects.equals(amount, that.amount) && Objects.equals(transactionDate, that.transactionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountTransactionId, accountType, member, amount, transactionDate);
    }

    @Override
    public String toString() {
        return "AccountTransaction{" +
                "accountTransactionId=" + accountTransactionId +
                ", accountType=" + accountType +
                ", member=" + member +
                ", amount=" + amount +
                ", transactionDate=" + transactionDate +
                '}';
    }


}
