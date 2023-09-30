package Task_3;

import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. \nNew total balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. \nRemaining total balance: $" + balance);
        }
        else if(amount>balance){
            System.out.println("Insufficient funds.");
        } 
        else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    public void checkBalance() {
        System.out.println("Current balance: $" + balance);
    }
}

public class ATM_Interface {
    public static void main(String[] args) {
        
        double initialBalance = 100.0; // Initial balance for the bank account
        BankAccount account = new BankAccount(initialBalance);

        System.out.print("\nWelcome to ATM");
        while (true) {
            try (Scanner sc = new Scanner(System.in)) {
                System.out.println("\nChoose a number for corresponding task.");
                System.out.println("1. Deposit");
                System.out.println("2. Withdraw");
                System.out.println("3. Check Balance");
                System.out.println("4. Exit");
                System.out.print("Please select an option: ");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter deposit amount: $");
                        double depositAmount = sc.nextDouble();
                        account.deposit(depositAmount);
                        break;
                    case 2:
                        System.out.print("Enter withdrawal amount: $");
                        double withdrawalAmount = sc.nextDouble();
                        account.withdraw(withdrawalAmount);
                        break;
                    case 3:
                        account.checkBalance();
                        break;
                    case 4:
                        System.out.println("Thank you for using the ATM. Namaste..!");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please select a valid option.");
                }
            }
        }
    }
}

