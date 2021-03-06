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

    private static final long serialVersionUID = 4800890815057444633L;

    private Long transactionId;
    private String accountTypeMnemonic;
    private String username;
    private Integer amount;
    private LocalDate transactionDate;
    private String details;


    public AccountTransactionDto(Long transactionId, String accountTypeMnemonic, String username, Integer amount, LocalDate transactionDate, String details) {
        this.transactionId = transactionId;
        this.accountTypeMnemonic = accountTypeMnemonic;
        this.username = username;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.details = details;
    }

    public AccountTransactionDto() {
    }

    public AccountTransactionDto(AccountTransaction accountTransaction){
        this.accountTypeMnemonic = accountTransaction.getAccountType().getMnemonic();
        this.username = accountTransaction.getMember().getUsername();
        this.amount = accountTransaction.getAmount();
        this.transactionDate = LocalDate.now();
        this.details = accountTransaction.getDetails();
    }

    @JsonIgnore
    public AccountTransaction buildAccountTransaction(AccountType accountType, Members member){
        return new AccountTransaction(accountType, member, this.getAmount(), this.transactionDate, details);
    }

    @ApiModelProperty(position = 1,
            dataType = "java.lang.String",
            example = "1",
            required = true)
    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    @ApiModelProperty(position = 2,
            dataType = "java.lang.String",
            example = "MILES",
            required = true)
    public String getAccountTypeMnemonic() {
        return accountTypeMnemonic;
    }

    @ApiModelProperty(position = 3,
            dataType = "java.lang.String",
            example = "FDindar",
            required = true)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @ApiModelProperty(position = 4,
            dataType = "java.lang.String",
            example = "200",
            required = true)
    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @ApiModelProperty(position = 5,
            dataType = "java.lang.String",
            example = "2020-02-03")
    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    @ApiModelProperty(position = 6,
            dataType = "java.lang.String",
            example = "add/subtract",
            required = true)
    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTransactionDto that = (AccountTransactionDto) o;
        return Objects.equals(transactionId, that.transactionId) && Objects.equals(accountTypeMnemonic, that.accountTypeMnemonic) && Objects.equals(username, that.username) && Objects.equals(amount, that.amount) && Objects.equals(transactionDate, that.transactionDate) && Objects.equals(details, that.details);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionId, accountTypeMnemonic, username, amount, transactionDate, details);
    }

    @Override
    public String toString() {
        return "AccountTransactionDto{" +
                "transactionId=" + transactionId +
                ", accountTypeMnemonic='" + accountTypeMnemonic + '\'' +
                ", username='" + username + '\'' +
                ", amount=" + amount +
                ", transactionDate=" + transactionDate +
                ", details='" + details + '\'' +
                '}';
    }
}
