package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "ACCOUNT_TRANSACTION_DETAILS")
public class AccountTransactionDetails implements Serializable {

    private static final long serialVersionUID = 4562890339977033624L;

    private Long accountTransactionDetailsId;
    private AccountTransaction accountTransactionId;
    private String partnerName;
    private Long noOfItems;

    public AccountTransactionDetails(Long accountTransactionDetailsId, AccountTransaction accountTransactionId, String partnerName, Long noOfItems) {
        this.accountTransactionDetailsId = accountTransactionDetailsId;
        this.accountTransactionId = accountTransactionId;
        this.partnerName = partnerName;
        this.noOfItems = noOfItems;
    }

    public AccountTransactionDetails() {
    }

    public AccountTransactionDetails(AccountTransaction accountTransactionId, String partnerName, Long noOfItems) {
        this.accountTransactionId= accountTransactionId;
        this.partnerName = partnerName;
        this.noOfItems = noOfItems;

    }

    public AccountTransactionDetails(String partnerName, Long noOfItems) {
        this.partnerName = partnerName;
        this.noOfItems = noOfItems;
    }

    @Id
    @SequenceGenerator(name = "FATHI_GENERIC_SEQ", sequenceName = "FATHIMA.FATHI_GENERIC_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FATHI_GENERIC_SEQ")
    @Column(name = "Account_Transaction_Details_ID")
    public Long getAccountTransactionDetailsId() {
        return accountTransactionDetailsId;
    }

    public void setAccountTransactionDetailsId(Long accountTransactionDetailsId) {
        this.accountTransactionDetailsId = accountTransactionDetailsId;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACCOUNT_TRANSACTION_ID")
    public AccountTransaction getAccountTransactionId() {
        return accountTransactionId;
    }

    public void setAccountTransactionId(AccountTransaction accountTransactionId) {
        this.accountTransactionId = accountTransactionId;
    }

    @Column(name = "Partner_Name")
    public String getPartnerName() {
        return partnerName;
    }

    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }

    @Column(name = "No_of_Items")
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
        AccountTransactionDetails that = (AccountTransactionDetails) o;
        return Objects.equals(accountTransactionDetailsId, that.accountTransactionDetailsId) && Objects.equals(accountTransactionId, that.accountTransactionId) && Objects.equals(partnerName, that.partnerName) && Objects.equals(noOfItems, that.noOfItems);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountTransactionDetailsId, accountTransactionId, partnerName, noOfItems);
    }

    @Override
    public String toString() {
        return "AccountTransactionDetails{" +
                "accountTransactionDetailsId=" + accountTransactionDetailsId +
                ", accountTransactionId=" + accountTransactionId +
                ", partnerName='" + partnerName + '\'' +
                ", noOfItems=" + noOfItems +
                '}';
    }
}
