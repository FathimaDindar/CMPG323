package za.ac.nwu.ac.domain.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.ac.domain.persistence.Members;
import za.ac.nwu.ac.domain.persistence.MilesAccount;

import java.io.Serializable;
import java.util.Objects;

@ApiModel(value = "MilesAccount",
        description = "A DTO that represents the MilesAccount")
public class MilesAccountDto implements Serializable {

    private static final long serialVersionUID = 4184713481290456881L;

    private String username;
    private Long miles;

    public MilesAccountDto(String username, Long miles) {
        this.username = username;
        this.miles = miles;
    }

    public MilesAccountDto() {
    }

    public MilesAccountDto(MilesAccount milesAccount){
        this.setUsername(milesAccount.getUsername());
        this.setMiles(milesAccount.getMiles());
    }

    @ApiModelProperty(position = 1,
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
        return Objects.equals(username, that.username) && Objects.equals(miles, that.miles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, miles);
    }

    @JsonIgnore
    public MilesAccount getMilesAccount(){
        return new MilesAccount(getUsername(), getMiles());
    }

    @Override
    public String toString() {
        return "MilesAccountDto{" +
                "username='" + username + '\'' +
                ", miles=" + miles +
                '}';
    }
}
