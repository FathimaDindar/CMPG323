package za.ac.nwu.ac.domain.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.ac.domain.persistence.Members;

import java.io.Serializable;
import java.util.Objects;

@ApiModel(value = "Members",
        description = "A DTO that represents the Member")
public class MembersDto implements Serializable {

    private static final long serialVersionUID = -3675411777951570019L;

    private String username;
    private String name;
    private String surname;
    private Integer miles;

    public MembersDto(String username, String name, String surname, Integer miles) {
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.miles = miles;
    }

    public MembersDto() {
    }

    public MembersDto(Members members){
        this.setUsername(members.getUsername());
        this.setName(members.getName());
        this.setSurname(members.getSurname());
        this.setMiles(members.getMiles());
    }

    @ApiModelProperty(position = 1,
            value = "Members Initials and Surname",
            name = "Initials and Surname",
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

    @ApiModelProperty(position = 2,
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

    @ApiModelProperty(position = 3,
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

    @ApiModelProperty(position = 4,
            value = "Members Miles",
            name = "Miles",
            notes = "The miles balance on the specified member",
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
        MembersDto that = (MembersDto) o;
        return Objects.equals(username, that.username) && Objects.equals(name, that.name) && Objects.equals(surname, that.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, name, surname);
    }

    @JsonIgnore
    public Members getMembers(){
        return new Members(username, name, surname,miles);
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
