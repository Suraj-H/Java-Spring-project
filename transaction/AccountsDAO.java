package com.mikadosolutions.training.spring.transaction;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;

//@Transactional
public class AccountsDAO {
    private SimpleJdbcTemplate simpleJdbcTemplate;
    private AccountsDAO1 accountsDAO1;

    public void setSimpleJdbcTemplate(SimpleJdbcTemplate simpleJdbcTemplate) {
        this.simpleJdbcTemplate = simpleJdbcTemplate;
    }

    public void setAccountsDAO1(AccountsDAO1 accountsDAO1) {
        this.accountsDAO1 = accountsDAO1;
    }

    // @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void performTransaction(Account account1, Account account2, double amount)
            throws InsufficientFundsException {
        accountsDAO1.withdraw(account1.getId(), amount);
        accountsDAO1.deposit(account2.getId(), amount);
    }

    // @Transactional(readOnly = true, propagation = Propagation.MANDATORY)
    public Account getAccount(final int id) {
        Account account = simpleJdbcTemplate.queryForObject("SELECT name, balance FROM accounts WHERE id = ?",
                new ParameterizedRowMapper<Account>() {
                    @Override
                    public Account mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
                        Account account = new Account();
                        try {
                            account.setId(id);
                            account.setName(resultSet.getString("name"));
                            account.setBalance(resultSet.getDouble("balance"));
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }

                        return account;
                    }
                }, id);

        return account;
    }

    // @Transactional(readOnly = false, propagation = Propagation.MANDATORY)
    public void storeAccount(Account account) {
        int i = simpleJdbcTemplate.update("UPDATE accounts SET balance = ? WHERE id = ?", account.getBalance(),
                account.getId());
    }
}