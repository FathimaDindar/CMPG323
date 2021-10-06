package za.ac.nwu.ac.domain.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.ac.domain.persistence.Members;
import za.ac.nwu.ac.domain.persistence.MilesAccount;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@ApiModel(value = "MilesAccount",
        description = "A DTO that represents the MilesAccount")
public class MilesAccountDto implements Serializable {

    private static final long serialVersionUID = 4184713481290456881L;

    private String username;
    private Integer miles;
    private LocalDate milesAddedDate;

    public MilesAccountDto(String username, Integer miles, LocalDate milesAddedDate) {
        this.username = username;
        this.miles = miles;
        this.milesAddedDate = milesAddedDate;
    }

    public MilesAccountDto() {
    }

    public MilesAccountDto(MilesAccount milesAccount){
        this.setUsername(milesAccount.getUsername());
        this.setMiles(milesAccount.getMiles());
        this.setMilesAddedDate(milesAccount.getMilesAddedDate());
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
    public Integer getMiles() {
        return miles;
    }

    public void setMiles(Integer miles) {
        this.miles = miles;
    }

    @ApiModelProperty(position = 3,
            value = "MilesAccount MilesAddedDate",
            name = "MilesAddedDate",
            notes = "The date at which miles were added to the account",
            dataType = "java.lang.String",
            example = "2020-01-03",
            allowEmptyValue = true,
            required = false)
    public LocalDate getMilesAddedDate() {
        return milesAddedDate;
    }

    public void setMilesAddedDate(LocalDate milesAddedDate) {
        this.milesAddedDate = milesAddedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MilesAccountDto that = (MilesAccountDto) o;
        return Objects.equals(username, that.username) && Objects.equals(miles, that.miles) && Objects.equals(milesAddedDate, that.milesAddedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, miles, milesAddedDate);
    }

    @JsonIgnore
    public MilesAccount getMilesAccount(){
        return new MilesAccount(getUsername(), getMiles(), getMilesAddedDate());
    }

    @Override
    public String toString() {
        return "MilesAccountDto{" +
                "username='" + username + '\'' +
                ", miles=" + miles +
                ", milesAddedDate=" + milesAddedDate +
                '}';
    }
}
