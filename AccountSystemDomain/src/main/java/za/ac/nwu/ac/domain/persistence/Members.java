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
    private String username;
    private String name;
    private String surname;
    private Integer miles;

    private Set<MilesAccount> milesAccounts;
    private Set<AccountTransaction> accountTransactions;

    public Members(Long memberId, String username, String name, String surname, Integer miles) {
        this.memberId = memberId;
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.miles = miles;
    }

    public Members() {
    }

    public Members(String username, String name, String surname, Integer miles) {
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.miles = miles;
    }

    @Id
    @SequenceGenerator(name = "FATHI_GENERIC_SEQ", sequenceName = "FATHIMA.FATHI_GENERIC_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FATHI_GENERIC_SEQ")
    @Column(name = "MEMBER_ID")
    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    @Column(name = "MEMBER_USERNAME")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "MEMBER_FNAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "MEMBER_LNAME")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Column(name = "MILES")
    public Integer getMiles() {
        return miles;
    }

    public void setMiles(Integer miles) {
        this.miles = miles;
    }

    @OneToMany(targetEntity = MilesAccount.class, fetch = FetchType.LAZY, mappedBy = "member", orphanRemoval = true)
    public Set<MilesAccount> getMilesAccounts() {
        return milesAccounts;
    }

    public void setMilesAccounts(Set<MilesAccount> milesAccounts) {
        this.milesAccounts = milesAccounts;
    }

    @OneToMany(targetEntity = AccountTransaction.class, fetch = FetchType.LAZY, mappedBy = "member")
    public Set<AccountTransaction> getAccountTransactions() {
        return accountTransactions;
    }

    public void setAccountTransactions(Set<AccountTransaction> accountTransactions) {
        this.accountTransactions = accountTransactions;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Members members = (Members) o;
        return Objects.equals(memberId, members.memberId) && Objects.equals(username, members.username) && Objects.equals(name, members.name) && Objects.equals(surname, members.surname) && Objects.equals(miles, members.miles) && Objects.equals(milesAccounts, members.milesAccounts) && Objects.equals(accountTransactions, members.accountTransactions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberId, username, name, surname, miles, milesAccounts, accountTransactions);
    }

    @Override
    public String toString() {
        return "Members{" +
                "memberId=" + memberId +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", miles=" + miles +
                ", milesAccounts=" + milesAccounts +
                ", accountTransactions=" + accountTransactions +
                '}';
    }
}
