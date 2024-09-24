import java.util.Scanner;
class Account 
{
    String accountNumber;
    String accountHolderName;
    double balance;
    public Account(String accountNumber, String accountHolderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit successful for " + accountHolderName + ". Current balance: " + balance);
    }
    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds for " + accountHolderName + ".");
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful for " + accountHolderName + ". Current balance: " + balance);
        }
    }
    public void transfer(Account toAccount, double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds for transfer from " + accountHolderName + ".");
        } else {
            balance -= amount;
            toAccount.balance += amount;
            System.out.println("Transfer successful from " + accountHolderName + " to " + toAccount.accountHolderName + ".");
            System.out.println(accountHolderName + "'s new balance is: " + balance);
        }
    }
}
public class BankY
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        Account account1 = new Account("25490A67", "Hardhik", 7000);
        Account account2 = new Account("45667D78", "Mahesh", 5000);
        int choice;
        Account selectedAccount = null;  

        do 
        {
            System.out.println("\n--- BankY Menu ---");
            System.out.println("1. Select Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) 
            {
                case 1:
                    System.out.println("Select an account:");
                    System.out.println("1. Hardhik's account");
                    System.out.println("2. Mahesh's account");
                    int accountChoice = scanner.nextInt();
                    if (accountChoice == 1) 
                    {
                        selectedAccount = account1;
                        System.out.println("You selected Hardhik's account.");
                    } else if (accountChoice == 2) 
                    {
                        selectedAccount = account2;
                        System.out.println("You selected Mahesh's account.");
                    } 
                    else {
                        System.out.println("Invalid account selection.");
                    }
                    break;

                case 2:
                    if (selectedAccount != null)
                    {
                        System.out.print("Enter amount to deposit: ");
                        double depositAmount = scanner.nextDouble();
                        selectedAccount.deposit(depositAmount);
                    } 
                    else 
                    {
                        System.out.println("No account selected. Please select an account first.");
                    }
                    break;

                case 3:
                    if (selectedAccount != null) 
                    {
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = scanner.nextDouble();
                        selectedAccount.withdraw(withdrawAmount);
                    } 
                    else 
                    {
                        System.out.println("No account selected. Please select an account first.");
                    }
                    break;

                case 4:
                    if (selectedAccount != null) 
                    {
                        System.out.print("Enter amount to transfer: ");
                        double transferAmount = scanner.nextDouble();
                        Account toAccount = (selectedAccount == account1) ? account2 : account1;
                        selectedAccount.transfer(toAccount, transferAmount);
                    }
                    else 
                    {
                        System.out.println("No account selected. Please select an account first.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting the system.");
                    break;

                default:
                    System.out.println("Invalid option! Please choose again.");
            }

        } while (choice != 5);

        scanner.close();
    }
}
