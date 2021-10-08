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
    private Members member;
    private Integer miles;


    public MilesAccount(Long accountId, Members member,Integer miles) {
        this.accountId = accountId;
        this.member = member;
        this.miles = miles;
    }


    public MilesAccount() {
    }

    public MilesAccount(Integer miles) {
        this.miles = miles;
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
    public Members getMember() {
        return member;
    }

    public void setMember(Members member) {
        this.member = member;
    }


    @Column(name = "Miles")
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
        MilesAccount that = (MilesAccount) o;
        return Objects.equals(accountId, that.accountId) && Objects.equals(member, that.member) && Objects.equals(miles, that.miles) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, member, miles);
    }

    @Override
    public String toString() {
        return "MilesAccount{" +
                "accountId=" + accountId +
                ", member=" + member + '\'' +
                ", miles=" + miles +
                '}';
    }

}
