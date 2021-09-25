package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "MILES_ACCOUNT", schema = "FATHIMA")
public class MilesAccount implements Serializable {

    private static final long serialVersionUID = -4678420392275548659L;
    private Long accountId;
    private Members memberId;
    private Long miles;


    public MilesAccount(Long accountId, Members memberId, Long miles) {
        this.accountId = accountId;
        this.memberId = memberId;
        this.miles = miles;
    }

    public MilesAccount() {
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

    @Column(name = "Miles")
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
        MilesAccount that = (MilesAccount) o;
        return Objects.equals(accountId, that.accountId) && Objects.equals(memberId, that.memberId) && Objects.equals(miles, that.miles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, memberId, miles);
    }

    @Override
    public String toString() {
        return "MilesAccount{" +
                "accountId=" + accountId +
                ", memberId=" + memberId +
                ", miles=" + miles +
                '}';
    }
}
