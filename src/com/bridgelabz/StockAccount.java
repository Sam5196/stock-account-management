package com.bridgelabz;

import java.util.ArrayList;
import java.util.Scanner;

public class StockAccount{
    ArrayList<String> stockName = new ArrayList<String>();
    ArrayList<Integer> numberOfShares = new ArrayList<Integer>();
    ArrayList<Integer> sharePrice = new ArrayList<Integer>();
    Scanner scanner = new Scanner(System.in);
    int balance = 100000;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            StockAccount obj = new StockAccount();
            while (true) {
                System.out.println(
                        "1-Enter New Stock \n2-Display Stock Report \n3-Withdraw Amount \n4-Exit");
                System.out.println("Enter your choice: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        obj.addStocks();
                        break;
                    case 2:
                        obj.stockReport();
                        break;
                    case 3:
                        obj.debit();
                        break;
                    default:
                        System.out.println("Invalid Input");
                }
            }
        }
    }

    private void addStocks() {

        System.out.print("Enter the stock name: ");
        stockName.add(scanner.next());

        System.out.print("Enter number of shares present: ");
        numberOfShares.add(scanner.nextInt());

        System.out.print("Enter price of each share: ");
        sharePrice.add(scanner.nextInt());

    }

    private void stockReport() {
        int sum = 0;
        for (int i = 0; i < stockName.size(); i++) {
            int total = (numberOfShares.get(i) * sharePrice.get(i));
            balance = balance - total;
            sum = sum + total;
            System.out.println("Stock name= " + stockName.get(i) + "\nValue of each share= " + sharePrice.get(i)
                    + "\nTotal value of share= " + total);
            System.out.println(" Balance remaining : " + balance);

        }
    }

    private void debit() {
        System.out.println("Enter the amount you want to withdraw: ");
        int withdraw = scanner.nextInt();
        if (withdraw < balance) {
            balance = balance - withdraw;
            System.out.println("Total amount left after withdrawal= " + balance);
        } else
            System.out.println("Debit amount account balance");

    }

}
