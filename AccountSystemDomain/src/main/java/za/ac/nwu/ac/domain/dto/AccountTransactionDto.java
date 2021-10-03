package za.ac.nwu.ac.domain.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.ac.domain.persistence.AccountTransaction;
import za.ac.nwu.ac.domain.persistence.AccountType;
import za.ac.nwu.ac.domain.persistence.Members;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@ApiModel(value = "AccountTransaction",
        description = "A DTO that represents the AccountTransaction")
public class AccountTransactionDto implements Serializable {

    private static final long serialVersionUID = -7819344808062462808L;

    private AccountType accountTypeId;
    private Members memberId;
    private Long amount;
    private LocalDate transactionDate;

    public AccountTransactionDto(AccountType accountTypeId, Members memberId, Long amount, LocalDate transactionDate) {
        this.accountTypeId = accountTypeId;
        this.memberId = memberId;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    public AccountTransactionDto() {
    }

    public AccountTransactionDto(AccountTransaction accountTransaction){
        this.setAccountTypeId(accountTransaction.getAccountTypeId());
        this.setMemberId(accountTransaction.getMemberId());
        this.setAmount(accountTransaction.getAmount());
        this.setTransactionDate(accountTransaction.getTransactionDate());

    }

    @ApiModelProperty(position = 1,
            value = "AccountType AccountTypeId",
            name = "AccountType",
            notes = "Account type of the transaction",
            dataType = "java.lang.String",
            example = "000000000000001",
            required = true)
    public AccountType getAccountTypeId() {
        return accountTypeId;
    }

    public void setAccountTypeId(AccountType accountTypeId) {
        this.accountTypeId = accountTypeId;
    }

    @ApiModelProperty(position = 2,
            value = "Members MemberId",
            name = "Member",
            notes = "Member Id linked to the transaction",
            dataType = "java.lang.String",
            example = "000000000000001",
            required = true)
    public Members getMemberId() {
        return memberId;
    }

    public void setMemberId(Members memberId) {
        this.memberId = memberId;
    }

    @ApiModelProperty(position = 3,
            value = "AccountTransaction Amount",
            name = "Amount",
            notes = "The amount of the transaction ",
            dataType = "java.lang.String",
            example = "",
            required = true)
    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    @ApiModelProperty(position = 4,
            value = "MemberId",
            name = "Member",
            notes = "The date of the transaction",
            dataType = "java.lang.String",
            example = "00000001",
            allowEmptyValue = true,
            required = false)
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
        AccountTransactionDto that = (AccountTransactionDto) o;
        return Objects.equals(accountTypeId, that.accountTypeId) && Objects.equals(memberId, that.memberId) && Objects.equals(amount, that.amount) && Objects.equals(transactionDate, that.transactionDate);
    }

    @JsonIgnore
    public AccountTransaction getAccountTransaction(){
        return new AccountTransaction(getAccountTypeId(), getMemberId(), getAmount(), getTransactionDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountTypeId, memberId, amount, transactionDate);
    }

    @Override
    public String toString() {
        return "AccountTransactionDto{" +
                "accountTypeId=" + accountTypeId +
                ", memberId=" + memberId +
                ", amount=" + amount +
                ", transactionDate=" + transactionDate +
                '}';
    }
}
