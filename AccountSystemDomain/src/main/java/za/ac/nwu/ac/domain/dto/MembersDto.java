package za.ac.nwu.ac.domain.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.ac.domain.persistence.AccountType;
import za.ac.nwu.ac.domain.persistence.Members;

import java.io.Serializable;
import java.util.Objects;

@ApiModel(value = "Members",
        description = "A DTO that represents the Member")
public class MembersDto implements Serializable {

    private static final long serialVersionUID = -3675411777951570019L;

    private String name;
    private String surname;

    public MembersDto(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public MembersDto() {
    }

    public MembersDto(Members member){
        this.setName(member.getName());
        this.setSurname(member.getSurname());
    }

    @ApiModelProperty(position = 1,
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

    @ApiModelProperty(position = 2,
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MembersDto memberDto = (MembersDto) o;
        return Objects.equals(name, memberDto.name) && Objects.equals(surname, memberDto.surname);
    }

    @JsonIgnore
    public Members getMembers(){
        return new Members(getName(), getSurname());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }

    @Override
    public String toString() {
        return "MemberDto{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
