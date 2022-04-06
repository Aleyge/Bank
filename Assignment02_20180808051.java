import java.util.ArrayList;

/**
 * @author Ali Ege Özceylan
 * @since 06.04.2022
 */
public class Assignment2_20180808051 {

    public static void main(String[] args) {
        

    }

   
}
public class Bank{
    private String Name;
    private String Address;
    private ArrayList<Customer> Customers;
    private ArrayList<Company> Companies;
    private ArrayList<Account> Accounts;

}
class Account {
    private String AcctNum;
    private double balance;

    public Account(String AcctNum){
        this.AcctNum = AcctNum;
        balance=0;
    }

    public Account(String AcctNum, double balance) {
        this.AcctNum = AcctNum;
        this.balance = balance;
        if(balance<0){
            this.balance=0;
        }
    }

    public String getAcctNum() {
        return AcctNum;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount){
        if(amount>0)
            balance+=amount;
    }
    public void withdrawal(double amount){
        if(amount>0&&balance-amount>0)
            balance-=amount;
    }

    @Override
    public String toString() {
        return "Account " + AcctNum +" has "+ balance ;
    }
}
class PersonalAccount extends Account{
    private String Name;
    private String Surname;
    private String PIN;

    Random rnd = new Random();
    int number = rnd.nextInt(9999);

    public PersonalAccount(String AcctNum, String name, String surname) {
        super(AcctNum);
        Name = name;
        Surname = surname;
        this.PIN = String.format("%04d", number);
    }

    public PersonalAccount(String AcctNum, double balance, String name, String surname) {
        super(AcctNum, balance);
        Name = name;
        Surname = surname;
        this.PIN = String.format("%04d", number);
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname.toUpperCase();
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getPIN() {
        return PIN;
    }

    public void setPIN(String PIN) {
        this.PIN = PIN;
    }

    @Override
    public String toString() {
        return "Account " +getAcctNum()+
                " belonging to "+getName() +" "+getSurname()+" has "+ getBalance();
    }
}
class BusinessAccount extends Account {
    private double Rate;

    public BusinessAccount(String AcctNum,  double interestRate) {
        super(AcctNum);
        Rate = interestRate;
    }

    public BusinessAccount(String AcctNum, double balance, double interestRate) {
        super(AcctNum, balance);
        Rate = interestRate;
    }

    public double getRate() {
        return Rate;
    }

    public void setRate(double interestRate) {
        Rate = interestRate;
    }

    public double calculateInterest(){
        return getBalance()*Rate;
    }
}
public class Customer{

}
public class Company{

}