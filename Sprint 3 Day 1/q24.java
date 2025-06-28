import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Account {
    private final int id;
    private int balance;
    private final Lock lock = new ReentrantLock();

    public Account(int id, int balance) {
        this.id = id;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public Lock getLock() {
        return lock;
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        balance += amount;
    }

    public void withdraw(int amount) {
        balance -= amount;
    }

    @Override
    public String toString() {
        return "Account{" + id + ", balance=" + balance + '}';
    }
}

class TransferTask extends Thread {
    private final Account from;
    private final Account to;
    private final int amount;

    public TransferTask(Account from, Account to, int amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    public void run() {
        transferMoney(from, to, amount);
    }

    private void transferMoney(Account from, Account to, int amount) {
        Account first = from.getId() < to.getId() ? from : to;
        Account second = from.getId() < to.getId() ? to : from;

        first.getLock().lock();
        second.getLock().lock();
        try {
            if (from.getBalance() >= amount) {
                from.withdraw(amount);
                to.deposit(amount);
                System.out.println("Transferred ₹" + amount + " from A" + from.getId() + " to A" + to.getId());
            } else {
                System.out.println("Transfer failed: insufficient balance in A" + from.getId());
            }
        } finally {
            second.getLock().unlock();
            first.getLock().unlock();
        }
    }
}

public class MultiAccountTransfer {
    public static void main(String[] args) throws InterruptedException {
        List<Account> accounts = new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
            accounts.add(new Account(i, 1000));
        }

        List<Thread> threads = new ArrayList<>();
        Random rand = new Random();

        for (int i = 0; i < 6; i++) {  
            Account from = accounts.get(rand.nextInt(accounts.size()));
            Account to = accounts.get(rand.nextInt(accounts.size()));
            while (from == to) {
                to = accounts.get(rand.nextInt(accounts.size())); 
            }
            int amount = 100 + rand.nextInt(400); 
            threads.add(new TransferTask(from, to, amount));
        }

        for (Thread t : threads) t.start();
        for (Thread t : threads) t.join();

        System.out.println("\nFinal Balances:");
        for (Account acc : accounts) {
            System.out.println(acc);
        }
    }
}
