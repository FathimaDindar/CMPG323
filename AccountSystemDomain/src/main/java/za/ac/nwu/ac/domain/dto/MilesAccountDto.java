package za.ac.nwu.ac.domain.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.ac.domain.persistence.AccountType;
import za.ac.nwu.ac.domain.persistence.Members;
import za.ac.nwu.ac.domain.persistence.MilesAccount;

import java.io.Serializable;
import java.util.Objects;

@ApiModel(value = "MilesAccount",
        description = "A DTO that represents the MilesAccount")
public class MilesAccountDto implements Serializable {

    private static final long serialVersionUID = 4184713481290456881L;

    private Members memberId;
    private Long miles;

    public MilesAccountDto(Members memberId, Long miles) {
        this.memberId = memberId;
        this.miles = miles;
    }

    public MilesAccountDto() {
    }

    public MilesAccountDto(MilesAccount milesAccount){
        this.setMemberId(milesAccount.getMemberId());
        this.setMiles(milesAccount.getMiles());
    }

    @ApiModelProperty(position = 1,
            value = "Members MemberId",
            name = "MemberId",
            notes = "MemberId to whom MilesAccount belongs",
            dataType = "java.lang.String",
            example = "00000001",
            required = true)
    public Members getMemberId() {
        return memberId;
    }

    public void setMemberId(Members memberId) {
        this.memberId = memberId;
    }

    @ApiModelProperty(position = 2,
            value = "MilesAccount Miles",
            name = "Miles",
            notes = "The amount of miles in the account",
            dataType = "java.lang.String",
            example = "1450",
            required = true)
    public Long getMiles() {
        return miles;
    }

    public void setMiles(Long miles) {
        this.miles = miles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MilesAccountDto that = (MilesAccountDto) o;
        return Objects.equals(memberId, that.memberId) && Objects.equals(miles, that.miles);
    }

    @JsonIgnore
    public MilesAccount getMilesAccount(){
        return new MilesAccount(getMemberId(), getMiles());
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberId, miles);
    }

    @Override
    public String toString() {
        return "MilesAccountDto{" +
                "memberId=" + memberId +
                ", miles=" + miles +
                '}';
    }
}
