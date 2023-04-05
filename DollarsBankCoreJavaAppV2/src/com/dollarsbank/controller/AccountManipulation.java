package com.dollarsbank.controller;

import com.dollarsbank.DAO.AccountDao;
import com.dollarsbank.DAO.TransactionDao;
import com.dollarsbank.model.Account;
import com.dollarsbank.model.Transaction;
import com.dollarsbank.utility.ConsoleColors;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class AccountManipulation {
    static AccountDao accountDao = new AccountDao();
    static TransactionDao transDao = new TransactionDao();
    static int activeAccount;
    public static void createAccount(Scanner input) {
        String username;
        String pin;
        Double availableFunds = null;

        System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT + "+--------------------+\n"
                + "|  Account Creation  |\n"
                + "+--------------------+\n");

        System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT + "Please enter the following information\n");


        System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT + "Username:");
        username = input.nextLine();


        System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT + "pin:");

        pin = input.nextLine();
        while(availableFunds == null) {
            System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT + "Please enter the amount you would like to make for your initial deposit");
            try {
                availableFunds = Double.parseDouble(input.nextLine());
            } catch(Exception e) {
                System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "You must enter a number!!!\n");
            }
        }
        if(accountDao.createAccount(username, pin, availableFunds)) {

            transDao.createTransaction("Initial Deposit", "$" + availableFunds + " was deposited into your account", accountDao.getAccountId(username));

        } else {
            System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "Username is taken!!!\n");
        }

        transDao.createTransaction("Initial Deposit", "$" + availableFunds + " was deposited into your account", accountDao.getAccountId(username));

        Menu.menu(input);
    }

    public static void logIn(Scanner input) {
        String username;
        String pin;

        System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT + "+----------+\n"
                + "|  Log In  |\n"
                + "+----------+\n");
        System.out.println(ConsoleColors.WHITE + "Enter your username:");

        username = input.nextLine();

        System.out.println(ConsoleColors.WHITE + "Enter your pin:");

        pin = input.nextLine();

        if(accountDao.checkCredentials(username, pin)) {
            activeAccount = 0;
            activeAccount = accountDao.getAccountId(username);
            System.out.println(activeAccount);
            System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT + "Log in successful!");
            Menu.selection(input);
        } else {
            System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "Username or pin were incorrect, Please try again.");
            logIn(input);
        }

    }

}

