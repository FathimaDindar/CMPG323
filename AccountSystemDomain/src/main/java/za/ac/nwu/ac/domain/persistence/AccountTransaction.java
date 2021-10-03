package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "ACCOUNT_TRANSACTION", schema = "FATHIMA")
public class AccountTransaction implements Serializable {

    private static final long serialVersionUID = 1636276203670716488L;

    private Long transactionId;
    private AccountType accountTypeId;
    private Members memberId;
    private Long amount;
    private LocalDate transactionDate;

    public AccountTransaction(Long transactionId, AccountType accountTypeId, Members memberId, Long amount, LocalDate transactionDate) {
        this.transactionId = transactionId;
        this.accountTypeId = accountTypeId;
        this.memberId = memberId;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    public AccountTransaction() {
    }

    public AccountTransaction(AccountType accountTypeId, Members memberId, Long amount, LocalDate transactionDate) {

        this.accountTypeId = accountTypeId;
        this.memberId = memberId;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    @Id
    @SequenceGenerator(name = "FATHI_GENERIC_SEQ", sequenceName = "FATHIMA.FATHI_GENERIC_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FATHI_GENERIC_SEQ")
    @Column(name = "Account_TX_ID")
    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Account_Type_ID")
    public AccountType getAccountTypeId() {
        return accountTypeId;
    }

    public void setAccountTypeId(AccountType accountTypeId) {
        this.accountTypeId = accountTypeId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Member_ID")
    public Members getMemberId() {
        return memberId;
    }

    public void setMemberId(Members memberId) {
        this.memberId = memberId;
    }

    @Column(name = "Amount")
    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    @Column(name = "Transaction_Date")
    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTransaction that = (AccountTransaction) o;
        return Objects.equals(transactionId, that.transactionId) && Objects.equals(accountTypeId, that.accountTypeId) && Objects.equals(memberId, that.memberId) && Objects.equals(amount, that.amount) && Objects.equals(transactionDate, that.transactionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionId, accountTypeId, memberId, amount, transactionDate);
    }

    @Override
    public String toString() {
        return "AccountTransaction{" +
                "transactionId=" + transactionId +
                ", accountType=" + accountTypeId +
                ", memberId=" + memberId +
                ", amount=" + amount +
                ", transactionDate=" + transactionDate +
                '}';
    }
}
