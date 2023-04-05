package com.dollarsbank.controller;

import com.dollarsbank.DAO.AccountDao;
import com.dollarsbank.DAO.TransactionDao;

import com.dollarsbank.utility.ConsoleColors;

import java.util.Scanner;

public class Transactions {
    static AccountDao accountDao = new AccountDao();
    static TransactionDao transDao = new TransactionDao();
    static int activeUser;
    public static void transfer(Scanner input) {
        String transferAccount = null;
        String choice;
        boolean transferBool = true;
        activeUser = AccountManipulation.activeAccount;

        if(transferBool) {
            System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT + "+------------+\n"
                    + "|  TRANSFER  |\n"
                    + "+------------+\n");
            System.out.println(ConsoleColors.GREEN + "Please enter the User Id of the account you would like to transfer money to.");

            choice = input.nextLine();

            for(String username : accountDao.getUsernames()) {
                if (username.equalsIgnoreCase(choice)) {
                    transferAccount = choice;
                    break;
                }
            }

            if (transferAccount == null) {
                System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "Account with the give User Id does not exist, Please try again.");
                transfer(input);
            }

            System.out.println(ConsoleColors.GREEN + "Please enter the amount of money you would like to transfer.");

            try {
                double amount = Double.parseDouble(input.nextLine());
                if(amount > 0 && amount < accountDao.getAvailableFunds(activeUser)) {

                    if(accountDao.deposit(accountDao.getAccountId(choice), amount) && accountDao.withdraw(activeUser, amount)) {
                        transDao.createTransaction("Transfer Out", "$" + amount + " was withdrawn from your account via transfer", activeUser);

                        transDao.createTransaction("Transfer In", "$" + amount + " was deposited into your account via transfer", accountDao.getAccountId(choice));

                        System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT + "Transfer Successful!\n");
                        System.out.println(ConsoleColors.GREEN + "Your account now contains $" + accountDao.getAvailableFunds(activeUser) + ".");

                    } else {
                        System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "Transaction Failed");
                    }

                } else {
                    System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "Please enter a number greater than zero");
                }

            } catch(Exception e) {
                System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "Invalid Input! Please enter an amount of money!");
                transfer(input);
            }
        }
        System.out.println(ConsoleColors.GREEN + "Would you like to:\n"
                + "1. Make another transfer\n"
                + "2. Go back to selection screen\n"
                + "3. Log out");

        choice = input.nextLine();

        switch (choice) {
            case "1" -> transfer(input);
            case "2" -> Menu.selection(input);
            case "3" -> {
                System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT + "\nCome back soon!");
                Menu.menu(input);
            }
            default -> {
                System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "INVALID SELECTION! Please enter 1, 2, or 3!");
                transferBool = false;
                transfer(input);
            }
        }
    }

    public static void withdraw(Scanner input) {
        String choice;
        boolean withdrawBool = true;
        activeUser = AccountManipulation.activeAccount;

        if(withdrawBool) {
            System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT + "+------------+\n"
                    + "|  WITHDRAW  |\n"
                    + "+------------+\n");
            System.out.println(ConsoleColors.GREEN + "How much would you like to withdraw from your account today?");

            try {
                double transactionAmount = Double.parseDouble(input.nextLine());

                if(transactionAmount > 0 && transactionAmount < accountDao.getAvailableFunds(activeUser)) {

                    if(accountDao.withdraw(activeUser, transactionAmount)) {

                        transDao.createTransaction("Withdraw", "$" + transactionAmount + " was withdrawn from your account", activeUser);

                        System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT + "Withdrawal Successful!\n");
                        System.out.println(ConsoleColors.GREEN + "Your account now contains $" + accountDao.getAvailableFunds(activeUser) + ".");
                    } else {
                        System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "Transaction Failed");
                    }

                } else {
                    System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "Please enter a number greater than zero and less than your account balance!");
                    withdraw(input);
                }

            } catch(Exception e) {
                System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "Invalid Input! Please enter an amount of money!");
                withdraw(input);
            }
        }

        System.out.println(ConsoleColors.GREEN + "Would you like to:\n"
                + "1. Make another withdrawal\n"
                + "2. Go back to selection screen\n"
                + "3. Log out");

        choice = input.nextLine();

        switch (choice) {
            case "1" -> withdraw(input);
            case "2" -> Menu.selection(input);
            case "3" -> {
                System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT + "\nCome back soon!");
                Menu.menu(input);
            }
            default -> {
                System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "INVALID SELECTION! Please enter 1, 2, or 3!");
                withdrawBool = false;
                withdraw(input);
            }
        }
    }

    public static void deposit(Scanner input) {
        String choice;
        boolean depositBool = true;
        activeUser = AccountManipulation.activeAccount;

        if(depositBool) {
            System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT + "+-----------+\n"
                    + "|  DEPOSIT  |\n"
                    + "+-----------+\n");

            System.out.println(ConsoleColors.GREEN + "How much would you like to deposit into your account today?");

            try{
                double transactionAmount = Double.parseDouble(input.nextLine());
                if(transactionAmount > 0) {

                    if(accountDao.deposit(activeUser, transactionAmount)) {
                        transDao.createTransaction("Deposit", "$" + transactionAmount + " was deposited into your account", activeUser);

                        System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT + "Deposit Successful!\n");
                        System.out.println(ConsoleColors.GREEN + "Your account now contains $" + accountDao.getAvailableFunds(activeUser) + ".");
                    } else {
                        System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "Transaction Failed");
                    }

                } else {
                    System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "Please enter a number greater than zero!");
                }

            } catch(Exception e) {
                System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "Invalid Input! Please enter an amount of money!");
                deposit(input);
            }

        }

        System.out.println(ConsoleColors.GREEN + "Would you like to:\n"
                + "1. Make another deposit\n"
                + "2. Go back to selection screen\n"
                + "3. Log out");

        choice = input.nextLine();

        switch (choice) {
            case "1" -> deposit(input);
            case "2" -> Menu.selection(input);
            case "3" -> {
                System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT + "\nCome back soon!");
                Menu.menu(input);
            }
            default -> {
                System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "INVALID SELECTION! Please enter 1, 2, or 3!");
                depositBool = false;
                deposit(input);
            }
        }
    }
}
