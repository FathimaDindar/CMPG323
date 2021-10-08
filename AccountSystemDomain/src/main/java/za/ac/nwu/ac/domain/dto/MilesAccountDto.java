package za.ac.nwu.ac.domain.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.ac.domain.persistence.AccountTransaction;
import za.ac.nwu.ac.domain.persistence.AccountType;
import za.ac.nwu.ac.domain.persistence.Members;
import za.ac.nwu.ac.domain.persistence.MilesAccount;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@ApiModel(value = "MilesAccount",
        description = "A DTO that represents the MilesAccount")
public class MilesAccountDto implements Serializable {

    private static final long serialVersionUID = 4184713481290456881L;

    private Long accountId;
    private String username;
    private Integer miles;

    public MilesAccountDto(Long accountId, String username, Integer miles) {
        this.accountId = accountId;
        this.username = username;
        this.miles = miles;
    }

    public MilesAccountDto() {
    }

    public MilesAccountDto(MilesAccount milesAccount){
        this.accountId = milesAccount.getAccountId();
        this.username = milesAccount.getMember().getUsername();
        this.miles = milesAccount.getMiles();
    }

    @JsonIgnore
    public MilesAccount buildMilesAccount(Members member){
        return new MilesAccount(this.getAccountId(),member, this.getMiles());
    }

    @ApiModelProperty(position = 1,
            value = "MilesAccount AccountId",
            name = "AccountId",
            notes = "Uniquely identifies miles account",
            dataType = "java.lang.String",
            example = "0",
            required = true)
    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    @ApiModelProperty(position = 2,
            value = "MilesAccount Username",
            name = "Username",
            notes = "Uniquely identifies members",
            dataType = "java.lang.String",
            example = "FDindar",
            required = true)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @ApiModelProperty(position = 3,
            value = "MilesAccount Miles",
            name = "Miles",
            notes = "The amount of miles in the account",
            dataType = "java.lang.String",
            example = "1450",
            required = true)
    public Integer getMiles() {
        return miles;
    }

    public void setMiles(Integer miles) {
        this.miles = miles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MilesAccountDto that = (MilesAccountDto) o;
        return Objects.equals(accountId, that.accountId) && Objects.equals(username, that.username) && Objects.equals(miles, that.miles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, username, miles);
    }

    @Override
    public String toString() {
        return "MilesAccountDto{" +
                "accountId=" + accountId +
                ", username='" + username + '\'' +
                ", miles=" + miles +
                '}';
    }
}
