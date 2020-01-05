package com.retail.DB1.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "account")
public class Account implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "account_id")
    private int accountId;

    @Column( name= "location")
    private String location;

    @Column( name = "accountType")
    private boolean accountType;

    @Column( name = "login")
    private String login;

    public Account(){

    }
    public Account(String login, String location, boolean accountType)
    {
        this.accountId = 0;
        this.login = login;
        this.location = location;
        this.accountType= accountType;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isAccountType() {
        return accountType;
    }

    public void setAccountType(boolean accountType) {
        this.accountType = accountType;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return getAccountId() == account.getAccountId() &&
                isAccountType() == account.isAccountType() &&
                Objects.equals(getLocation(), account.getLocation()) &&
                Objects.equals(getLogin(), account.getLogin());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAccountId(), getLocation(), isAccountType(), getLogin());
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", location='" + location + '\'' +
                ", accountType=" + accountType +
                ", login='" + login + '\'' +
                '}';
    }
}
