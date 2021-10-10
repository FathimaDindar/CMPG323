package za.ac.nwu.ac.domain.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.ac.domain.persistence.AccountTransaction;
import za.ac.nwu.ac.domain.persistence.AccountType;
import za.ac.nwu.ac.domain.persistence.Members;

import java.io.Serializable;
import java.util.Objects;

@ApiModel(value = "Members",
        description = "A DTO that represents the Member")
public class MembersDto implements Serializable {

    private static final long serialVersionUID = -3675411777951570019L;

    private String mnemonic;
    private String username;
    private String name;
    private String surname;
    private Integer balance;

    public MembersDto(String mnemonic, String username, String name, String surname, Integer balance) {
        this.mnemonic = mnemonic;
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.balance = balance;
    }

    public MembersDto() {
    }

    public MembersDto(Members members){
        this.mnemonic = members.getAccountType().getMnemonic();
        this.username = members.getUsername();
        this.name = members.getName();
        this.surname = members.getSurname();
        this.balance = members.getBalance();
    }

    @JsonIgnore
    public Members buildMember(AccountType accountType){
        return new Members(accountType, this.getUsername(),this.getName(), this.getSurname(), this.getBalance());
    }

    @ApiModelProperty(position = 1,
            value = "AccountType Mnemonic",
            name = "Mnemonic",
            notes = "The intials and surname of the member",
            dataType = "java.lang.String",
            example = "MILES",
            required = true)
    public String getMnemonic() {
        return mnemonic;
    }

    public void setMnemonic(String mnemonic) {
        this.mnemonic = mnemonic;
    }

    @ApiModelProperty(position = 2,
            value = "Members Username",
            name = "Username",
            notes = "The intials and surname of the member",
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
            value = "Members Name",
            name = "Name",
            notes = "The name of the member",
            dataType = "java.lang.String",
            example = "Fathima",
            required = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ApiModelProperty(position = 4,
            value = "Members Surname",
            name = "Surname",
            notes = "The surname of the member",
            dataType = "java.lang.String",
            example = "Dindar",
            required = true)
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @ApiModelProperty(position = 5,
            value = "Members Balance",
            name = "Balance",
            notes = "The balance balance on the specified member",
            dataType = "java.lang.String",
            example = "1450",
            required = true)
    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MembersDto that = (MembersDto) o;
        return Objects.equals(username, that.username) && Objects.equals(name, that.name) && Objects.equals(surname, that.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, name, surname);
    }


    @Override
    public String toString() {
        return "MembersDto{" +
                "username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
