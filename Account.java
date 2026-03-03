import java.util.ArrayList;

public class Account {

    private double balance;

    public Account(){
        this.balance = 1000;
    }
    public Account(double balance) {
        if (balance > 1000){
            this.balance = balance;
        }else{
            this.balance = 1000.0;
        }
    }

    public double getBalance() {
        return balance;
    }
    
    public boolean deposit(double amt){
        if (amt > 0.0){
            balance += amt;
            return true;
        }
        return false;
    }
    
    public boolean withdraw(double amt){
        if ((amt <= balance) && (amt > 0)){
            balance -= amt;
            return true;
        }
        return false;
    }

    public boolean transfer(Account account, double amt){
      if (account != null && this.balance >= amt && amt > 0){
        this.balance -= amt;
        account.deposit(amt);
        return true;
      } return false;
    }

}
