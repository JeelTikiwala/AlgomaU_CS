/* Author: Johnny Console
 * Student id: 239659420
 * Assignment 1
 * Any and all work in this file is my own.*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BankProgram {
    private static final int MAX_ACCOUNTS = 200;
    private static int[] customerNumbers = new int[MAX_ACCOUNTS];
    private static char[] accountTypes = new char[MAX_ACCOUNTS];
    private static double[] balances = new double[MAX_ACCOUNTS];
    private static int numAccounts = 0;

    public static void main(String[] args) {
        readDataFromFile();
        char command = ' ';
        while (command != 'Q') {
            System.out.println("Enter command to operate: ");         
            System.out.println("Print S to Search for an account:");
            System.out.println("Print P to Print Total Balances:)");
            System.out.println("Print Q to Quit:");
            
            Scanner sc = new Scanner(System.in);
            command = sc.next().charAt(0);
            switch (command) {
                case 'S':
                    search();
                    break;
                case 'P':
                    printTotalBalances();
                    break;
                case 'Q':
                    System.out.println("Assignemt 1 ends, Goodbye, have a great day!");
                    break;
                default:
                    System.out.println("Invalid command. Please try again.");
                    break;
            }
        }
    }

    //This method reads account data from a file specified by its path.
    private static void readDataFromFile() {
        try {
            Scanner sc = new Scanner(new File("/Users/apple/Documents/AlgomaU_CS/SEM2/COSC2006/ASS1/a1data.txt"));
            while (sc.hasNextLine()) {
                customerNumbers[numAccounts] = Integer.parseInt(sc.nextLine());
                accountTypes[numAccounts] = sc.nextLine().charAt(0);
                balances[numAccounts] = Double.parseDouble(sc.nextLine());
                numAccounts++;
            }
            sc.close();
            
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }

    //This method allows the user to search for accounts based on customer number and account type.
    private static void search() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter customer number (0 for don't care): ");
        int customerNumber = sc.nextInt();
        System.out.print("Enter account type (X for don't care): ");
        char accountType = sc.next().charAt(0);
        boolean found = false;
        for (int i = 0; i < numAccounts; i++) {
            if ((customerNumber == 0 || customerNumbers[i] == customerNumber)
                    && (accountType == 'X' || accountTypes[i] == accountType)) {
                System.out.printf("%d\t%c\t%.2f\n", customerNumbers[i], accountTypes[i], balances[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No accounts found.");
        }
    }

    
    //This method prints the total balances for each customer.
    private static void printTotalBalances() {
        selectionSort();
        int currentCustomer = customerNumbers[0];
        double totalBalance = balances[0];
        for (int i = 1; i < numAccounts; i++) {
            if (customerNumbers[i] == currentCustomer) {
                totalBalance += balances[i];
            } else {
                System.out.printf("%d\t%.2f\n", currentCustomer, totalBalance);
                currentCustomer = customerNumbers[i];
                totalBalance = balances[i];
            }
        }
        System.out.printf("%d\t%.2f\n", currentCustomer, totalBalance);
    }

    //This method performs a simple selection sort on the accounts based on customer numbers.
    private static void selectionSort() {
        for (int i = 0; i < numAccounts - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < numAccounts; j++) {
                if (customerNumbers[j] < customerNumbers[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                swap(i, minIndex);
            }
        }
    }

    //This method is a helper method used by selectionSort to swap account data.
    private static void swap(int i, int j) {
        int tempCustomer = customerNumbers[i];
        customerNumbers[i] = customerNumbers[j];
        customerNumbers[j] = tempCustomer;
        char tempType = accountTypes[i];
        accountTypes[i] = accountTypes[j];
        accountTypes[j] = tempType;
        double tempBalance = balances[i];
        balances[i] = balances[j];
        balances[j] = tempBalance;
    }
}