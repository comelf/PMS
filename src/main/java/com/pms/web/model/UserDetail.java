package com.pms.web.model;

import com.pms.web.entity.Account;
import com.pms.web.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

public class UserDetail extends User {

    private static final long serialVersionUID = -75164108800286047L;

    @Autowired
    AccountRepository accountRepo;

    public int accountId;

    private Account account;

    public UserDetail(Account account) {
        super(account.getLoginId(), account.getPassword(), AuthorityUtils.createAuthorityList(account.isAdmin() ? "ADMIN" : "USER"));
        this.accountId = account.getId();
        this.account = account;
    }

    public int getAccountId() {
        return accountId;
    }

    public Account getAccount() {
        return account;
    }
}
