package com.mikadosolutions.training.spring.transaction;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class AccountsDAO1 {
    private AccountsDAO accountsDAO;
    private SimpleJdbcTemplate simpleJdbcTemplate;

    public void setAccountsDAO(AccountsDAO accountsDAO) {
        this.accountsDAO = accountsDAO;
    }

    public void setSimpleJdbcTemplate(SimpleJdbcTemplate simpleJdbcTemplate) {
        this.simpleJdbcTemplate = simpleJdbcTemplate;
    }

//  @Transactional(readOnly = false, propagation = Propagation.MANDATORY)
    public void withdraw(int id, double amount) throws InsufficientFundsException {
        Account account = accountsDAO.getAccount(id);
        double balance = account.getBalance();
        if (balance <= 5000)
            throw new InsufficientFundsException("Funds insufficient.");
        balance -= amount;
        account.setBalance(balance);
        accountsDAO.storeAccount(account);
    }

//  @Transactional(readOnly = false, propagation = Propagation.MANDATORY)
    public void deposit(int id, double amount) {
//      throw new InsufficientFundsException("Funds insufficient");
        Account account = accountsDAO.getAccount(id);
        double balance = account.getBalance();
        account.setBalance(balance + amount);
        accountsDAO.storeAccount(account);
    }
}