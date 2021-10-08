package za.ac.nwu.ac.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import za.ac.nwu.ac.domain.persistence.AccountTransaction;
import za.ac.nwu.ac.domain.persistence.AccountTransactionDetails;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@ApiModel(value = "AccountTransactionDetails",
        description = "A DTO that represents the AccountTransactionDetails")
public class AccountTransactionDetailsDto  {

    String partnerName;
    Long noOfItems;

    public AccountTransactionDetailsDto(String partnerName, Long noOfItems) {
        this.partnerName = partnerName;
        this.noOfItems = noOfItems;
    }

    public AccountTransactionDetailsDto() {
    }

    public AccountTransactionDetailsDto(AccountTransactionDetails details){
        this.partnerName = details.getPartnerName();
        this.noOfItems = details.getNoOfItems();
    }

    @JsonIgnore
    public AccountTransactionDetails buildAccountTransactionDetails(AccountTransaction accountTransaction){
       return new AccountTransactionDetails(accountTransaction, this.partnerName, this.noOfItems);
    }

    @JsonIgnore
    public AccountTransactionDetails buildAccountTransactionDetails(){
        return new AccountTransactionDetails(this.partnerName, this.noOfItems);
    }

    public String getPartnerName() {
        return partnerName;
    }

    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }

    public Long getNoOfItems() {
        return noOfItems;
    }

    public void setNoOfItems(Long noOfItems) {
        this.noOfItems = noOfItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTransactionDetailsDto that = (AccountTransactionDetailsDto) o;
        return Objects.equals(partnerName, that.partnerName) && Objects.equals(noOfItems, that.noOfItems);
    }

    @Override
    public int hashCode() {
        return Objects.hash(partnerName, noOfItems);
    }

    @Override
    public String toString() {
        return "AccountTransactionDetailsDto{" +
                "partnerName='" + partnerName + '\'' +
                ", noOfItems=" + noOfItems +
                '}';
    }
}
