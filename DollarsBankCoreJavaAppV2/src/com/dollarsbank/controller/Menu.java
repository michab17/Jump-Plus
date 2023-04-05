package com.dollarsbank.controller;

import com.dollarsbank.utility.ConsoleColors;

import java.util.Scanner;

public class Menu {

    public static void menu(Scanner input) {
        String choice;

        System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT + "+------------------------------+\n"
                + "|  DOLLARSBANK Welcomes You!!  |\n"
                + "+------------------------------+\n");
        System.out.println(ConsoleColors.WHITE + "1. Create New Account\n"
                + "2. Log In\n"
                + "3. Exit\n");
        System.out.println(ConsoleColors.GREEN + "Enter Choice (1, 2 or 3)\n");

        choice = input.nextLine();

        switch (choice) {
            case "1" -> AccountManipulation.createAccount(input);
            case "2" -> AccountManipulation.logIn(input);
            case "3" -> {
                System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT + "\nCome back soon!");
                input.close();
                System.exit(0);
            }
            default -> {
                System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "INVALID SELECTION! Please enter 1, 2 or 3!");
                menu(input);
            }
        }
    }

    public static void selection(Scanner input) {
        String choice ="";
        System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT + "+---------------------+\n"
                + "|  WELCOME Customer!  |\n"
                + "+---------------------+\n");

        System.out.println(ConsoleColors.WHITE + "1. Deposit Amount\n"
                + "2. Withdraw Amount\n"
                + "3. Transfer Funds\n"
                + "4. View 5 Recent Transactions\n"
                + "5. Display Customer Information\n"
                + "6. Sign Out\n");
        System.out.println(ConsoleColors.GREEN + "Enter Choice (1, 2, 3, 4, 5 or 6)\n");

        choice = input.nextLine();

        switch (choice) {
            case "1" -> Transactions.deposit(input);
            case "2" -> Transactions.withdraw(input);
            case "3" -> Transactions.transfer(input);
            case "4" -> Information.viewTransactions(input);
            case "5" -> Information.viewCustomerInfo(input);
            case "6" -> {
                System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT + "\nCome back soon!");
                menu(input);
            }
            default -> {
                System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "INVALID SELECTION! Please enter 1, 2, 3, 4, 5 or 6!");
                selection(input);
            }
        }
    }

}
