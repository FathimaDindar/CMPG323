package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "MILES_ACCOUNT", schema = "FATHIMA")
public class MilesAccount implements Serializable {

    private static final long serialVersionUID = -4678420392275548659L;
    
    private Long accountId;
    private Members memberId;
    private String username;
    private Integer miles;
    private LocalDate milesAddedDate;


    public MilesAccount(Long accountId, Members memberId, String username, Integer miles, LocalDate milesAddedDate) {
        this.accountId = accountId;
        this.memberId = memberId;
        this.username = username;
        this.miles = miles;
        this.milesAddedDate = milesAddedDate;
    }


    public MilesAccount() {
    }

    public MilesAccount(String username, Integer miles, LocalDate milesAddedDate) {
        this.username = username;
        this.miles = miles;
        this.milesAddedDate = milesAddedDate;
    }


    @Id
    @SequenceGenerator(name = "FATHI_GENERIC_SEQ", sequenceName = "FATHIMA.FATHI_GENERIC_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FATHI_GENERIC_SEQ")
    @Column(name = "Account_ID")
    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Member_ID")
    public Members getMemberId() {
        return memberId;
    }

    public void setMemberId(Members memberId) {
        this.memberId = memberId;
    }

    @Column(name = "Member_Username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "Miles")
    public Integer getMiles() {
        return miles;
    }

    public void setMiles(Integer miles) {
        this.miles = miles;
    }

    @Column(name = "Date_of_Miles_Added")
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
        MilesAccount that = (MilesAccount) o;
        return Objects.equals(accountId, that.accountId) && Objects.equals(memberId, that.memberId) && Objects.equals(username, that.username) && Objects.equals(miles, that.miles) && Objects.equals(milesAddedDate, that.milesAddedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, memberId, username, miles, milesAddedDate);
    }

    @Override
    public String toString() {
        return "MilesAccount{" +
                "accountId=" + accountId +
                ", memberId=" + memberId +
                ", username='" + username + '\'' +
                ", miles=" + miles +
                ", milesAddedDate=" + milesAddedDate +
                '}';
    }

}
