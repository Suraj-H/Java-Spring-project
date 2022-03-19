package com.mikadosolutions.training.spring.di;

public class Home {
    static int home;
    int homeNumber;

    public Home() {
        home += 1;
        homeNumber = home;
    }

    public String toString() {
        return String.valueOf(homeNumber);
    }
}