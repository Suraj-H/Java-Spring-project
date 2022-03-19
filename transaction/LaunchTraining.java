package com.mikadosolutions.training.spring.transaction;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LaunchTraining {
    public static void main(String[] args) throws InsufficientFundsException {
        ApplicationContext context = new ClassPathXmlApplicationContext("TrainingConfig.xml");
        AccountsDAO dao = (AccountsDAO) context.getBean("accountsdao");
        dao.performTransaction(new Account(1, null, 0), new Account(2, null, 0), 1000);
        System.out.println("Transaction completed.");
    }
}