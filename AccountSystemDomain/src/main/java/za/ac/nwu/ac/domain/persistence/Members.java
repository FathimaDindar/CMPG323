package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "MEMBERS", schema = "FATHIMA")
public class Members implements Serializable {

    private static final long serialVersionUID = 5037081944022895091L;
    private Long memberId;
    private String name;
    private String surname;

    private Set<AccountTransaction> accountTransactions;
    private Set<MilesAccount> milesAccounts;

    public Members(Long memberId, String name, String surname) {
        this.memberId = memberId;
        this.name = name;
        this.surname = surname;
    }

    public Members() {
    }

    public Members(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    @Id
    @SequenceGenerator(name = "FATHI_GENERIC_SEQ", sequenceName = "FATHIMA.FATHI_GENERIC_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FATHI_GENERIC_SEQ")
    @Column(name = "Member_ID")
    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    @Column(name = "Member_Fname")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "Member_Lname")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @OneToMany(targetEntity = AccountTransaction.class, fetch = FetchType.LAZY, mappedBy = "memberId", orphanRemoval = true, cascade = CascadeType.PERSIST)
    public Set<AccountTransaction> getAccountTransactions() {
        return accountTransactions;
    }

    public void setAccountTransactions(Set<AccountTransaction> accountTransactions){
        this.accountTransactions = accountTransactions;
    }

    @OneToMany(targetEntity = MilesAccount.class, fetch = FetchType.LAZY, mappedBy = "memberId", orphanRemoval = true, cascade = CascadeType.PERSIST)
    public Set<MilesAccount> getMilesAccounts() {
        return milesAccounts;
    }

    public void setMilesAccounts(Set<MilesAccount> milesAccounts) {
        this.milesAccounts = milesAccounts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Members members = (Members) o;
        return Objects.equals(memberId, members.memberId) && Objects.equals(name, members.name) && Objects.equals(surname, members.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberId, name, surname);
    }

    @Override
    public String toString() {
        return "Members{" +
                "memberId=" + memberId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
