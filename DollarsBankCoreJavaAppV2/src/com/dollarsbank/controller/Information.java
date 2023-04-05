package com.dollarsbank.controller;

import com.dollarsbank.DAO.AccountDao;
import com.dollarsbank.DAO.TransactionDao;
import com.dollarsbank.model.Transaction;
import com.dollarsbank.utility.ConsoleColors;

import java.util.ArrayList;
import java.util.Scanner;

public class Information {
    static TransactionDao transDao = new TransactionDao();
    static AccountDao accountDao = new AccountDao();
    static int activeAccount;

    static void viewCustomerInfo(Scanner input) {
        activeAccount = AccountManipulation.activeAccount;
        System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT + "+------------------------+\n"
                + "|  CUSTOMER INFORMATION  |\n"
                + "+------------------------+\n");

        System.out.println(ConsoleColors.WHITE + "Account Id: " + activeAccount + "\n");
        System.out.println(ConsoleColors.WHITE + "Username: " + accountDao.getUsername(activeAccount) + "\n");
        System.out.println(ConsoleColors.WHITE + "Pin: " + accountDao.getPin(activeAccount) + "\n");
        System.out.println(ConsoleColors.WHITE + "Account Balance: " + accountDao.getAvailableFunds(activeAccount) + "\n");

        System.out.println(ConsoleColors.GREEN + "Press any key to go back");

        while(input.nextLine() != null) {
            Menu.selection(input);
        }

    }

    static void viewTransactions(Scanner input) {
        System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT + "+-----------------------+\n"
                + "|  RECENT TRANSACTIONS  |\n"
                + "+-----------------------+\n");

        ArrayList<Transaction> transactions = transDao.getTransactions(AccountManipulation.activeAccount);

        if(transactions.size() == 0) {
            System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT + "There are no transactions yet!\n");
        } else {
            for(Transaction transaction : transactions) {
                System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT + "Transaction # "+ (transactions.indexOf(transaction) + 1) + ":\n" + ConsoleColors.WHITE + transaction.toString() + "\n");
            }
        }

        System.out.println(ConsoleColors.GREEN + "Press any key to go back");

        while(input.nextLine() != null) {
            Menu.selection(input);
        }
    }
}
