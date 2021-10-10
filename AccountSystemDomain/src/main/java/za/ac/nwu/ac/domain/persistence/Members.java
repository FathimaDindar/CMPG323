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
    private AccountType accountType;
    private String username;
    private String name;
    private String surname;
    private Integer balance;

    private Set<AccountTransaction> accountTransactions;

    public Members(Long memberId, AccountType accountType, String username, String name, String surname, Integer balance) {
        this.memberId = memberId;
        this.accountType = accountType;
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.balance = balance;
    }

    public Members() {
        
    }

    public Members(AccountType accountType, String username, String name, String surname, Integer balance) {
        this.accountType = accountType;
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.balance = balance;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACCOUNT_TYPE_ID")
    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
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

    @Column(name = "BALANCE")
    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
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
        return Objects.equals(memberId, members.memberId) && Objects.equals(accountType, members.accountType) && Objects.equals(username, members.username) && Objects.equals(name, members.name) && Objects.equals(surname, members.surname) && Objects.equals(balance, members.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberId, accountType, username, name, surname, balance);
    }

    @Override
    public String toString() {
        return "Members{" +
                "memberId=" + memberId +
                ", accountType=" + accountType +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", balance=" + balance +
                ", accountTransactions=" + accountTransactions +
                '}';
    }
}
