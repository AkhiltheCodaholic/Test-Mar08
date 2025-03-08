
abstract class BankAccount {
    protected String accountNumber;
    protected double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited " + amount + ". New balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public abstract void withdraw(double amount);

    public double getBalance() {
        return balance;
    }
}


interface Transaction {
    void transfer(BankAccount toAccount, double amount);
}


class SavingsAccount extends BankAccount implements Transaction {
    private static final double MIN_BALANCE = 500;

    public SavingsAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public void withdraw(double amount) {
        if (balance - amount >= MIN_BALANCE) {
            balance -= amount;
            System.out.println("Withdrawn " + amount + ". New balance: " + balance);
        } else {
            System.out.println("Withdrawal failed! Minimum balance of 500 required.");
        }
    }
    @Override
    public void transfer(BankAccount toAccount, double amount) {
        if (balance - amount >= MIN_BALANCE) {
            balance -= amount;
            toAccount.deposit(amount);
            System.out.println("Transferred " + amount + " to " + toAccount.accountNumber + ". New balance: " + balance);
        } else {
            System.out.println("Transfer failed! Insufficient balance.");
        }
    }
}
class CurrentAccount extends BankAccount implements Transaction {
    private static final double OVERDRAFT_LIMIT = -5000;

    public CurrentAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }
    @Override
    public void withdraw(double amount) {
        if (balance - amount >= OVERDRAFT_LIMIT) {
            balance -= amount;
            System.out.println("Withdrawn " + amount + ". New balance: " + balance);
        } else {
            System.out.println("Withdrawal failed! Overdraft limit exceeded.");
        }
    }
    @Override
    public void transfer(BankAccount toAccount, double amount) {
        if (balance - amount >= OVERDRAFT_LIMIT) {
            balance -= amount;
            toAccount.deposit(amount);
            System.out.println("Transferred " + amount + " to " + toAccount.accountNumber + ". New balance: " + balance);
        } else {
            System.out.println("Transfer failed! Overdraft limit exceeded.");
        }
    }
}
public class BankingSystem {
    public static void main(String[] args) {
        SavingsAccount savings = new SavingsAccount("SAV123", 5000);
        CurrentAccount current = new CurrentAccount("CUR456", 2000);

        savings.deposit(1000);
        current.withdraw(3000); 

        savings.transfer(current, 1500); 
        current.transfer(savings, 6000); 
    }
}