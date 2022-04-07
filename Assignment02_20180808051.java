import java.util.ArrayList;
import java.util.Random;
/**
 * @author Ali Ege Özceylan
 * @since 06.04.2022
 */
public class Assignment02_20180808051 {

    public static void main(String[] args) {
        

    }

   
}
class Bank{
    private String Name;
    private String Address;
    private ArrayList<Customer> Customers;
    private ArrayList<Company> Companies;
    private ArrayList<Account> Accounts;
    public Bank(String Name,String Address){
        this.Name=Name;
        this.Address=Address;
    }
    public String getName(){
        return Name;
    }
    public void setName(String Name){
        this.Name=Name;
    }
    public String getAddress(){
        return Address;
    }
    public void setAddress(String Address){
        this.Address=Address;
    }
    public void addCustomer(int CustomerId, String CustomerName, String CustomerSurname){
        Customers.add(new Customer(CustomerId,CustomerName,CustomerSurname));
    }
    public void addCompany(int CompanyId,String CompanyName){
        Companies.add(new Company(CompanyId,CompanyName));
    }
    public void addAccount(Account account){
        Accounts.add(account);
    }
    public Customer getCustomer(int id){
        int i=0;
        try {
            for (i = 0; i < Customers.size();i++){ 		      
               if(Customers.get(i).getId()==id){
                   break;
               }
               else{
                   int j=0/0;
               }
            }   
           } catch (Exception e) {
               System.out.println("Fail");
           } 
           return Customers.get(i);
    }
    public Customer getCustomer(String name, String surname){
        int i=0;
        try{
        for ( i = 0; i < Customers.size();i++){ 		      
            if(Customers.get(i).getName()==name&&Customers.get(i).getSurname()==surname){
                break;
            }
            else{
                int j=0/0;
            }
         }   
        } catch (Exception e) {
            System.out.println("Fail");
        }
        return Customers.get(i);
    }
    public Company getCompany(int id){
        int i = 0;
        try {
            for (i = 0; i < Companies.size();i++){ 		      
               if(Companies.get(i).getId()==id){
                   break;
               }
               else{
                   int j=0/0;
               }
            }   
           } catch (Exception e) {
               System.out.println("Fail");
           } 
           return Companies.get(i);
    }
    public Company getCompany(String name){
        int i=0;
        try{
            for ( i = 0; i < Companies.size();i++){ 		      
                if(Companies.get(i).getName()==name){
                    break;
                }
                else{
                    int j=0/0;
                }
             }   
            } catch (Exception e) {
                System.out.println("Fail");
            }
            return Companies.get(i);
    }
    public Account getAccount(String accountNum){
        int i = 0;
        try{
            for (i = 0; i < Accounts.size();i++){ 		      
                if(Accounts.get(i).getAcctNum()==accountNum){
                    break;
                }
                else{
                    int j=0/0;
                    
                }
             }   
            } catch (Exception e) {
                System.out.println("Fail");
            }
            return Accounts.get(i);
    }
    public void transferFunds(String accountFrom, String accountTo,double amount){
            int senderIndex=0;
            int receiverIndex=0;
            int i=0;
        try {
            for (i = 0; i < Accounts.size();i++){ 		      
                if(Accounts.get(i).getAcctNum()==accountFrom){
                    senderIndex=i;
                }
                else{
                    int j=0/0;
                    
                }
            }
                for (i = 0; i < Accounts.size();i++){ 		      
                    if(Accounts.get(i).getAcctNum()==accountTo){
                        receiverIndex=i;
                    }
                    else{
                        int j=0/0;
                        
                    }
             }   
            
    } catch (Exception e) {
            //TODO: handle exception
        }
  
        try {
            double newBalance=(Accounts.get(senderIndex).getBalance()-amount);
            Accounts.get(senderIndex).setBalance(newBalance);
            Accounts.get(receiverIndex).setBalance(Accounts.get(receiverIndex).getBalance()+amount);
            
        } catch (Exception e) {
            //TODO: handle exception
        }
       
    }

    public void closeAccount(String accountNum){
        try {
            for (int i = 0; i < Accounts.size();i++){ 		      
               if(Accounts.get(i).getAcctNum()==accountNum&&
               Accounts.get(i).getBalance()>0){
                
               }
               else{
                   int j=0/0;
               }
            }   
           } catch (Exception e) {
               System.out.println("Fail");
           } 

        try {
            for (int i = 0; i < Accounts.size();i++){ 		      
               if(Accounts.get(i).getAcctNum()==accountNum){
                   Accounts.remove(i);
               }
               else{
                   int j=0/0;
               }
            }   
           } catch (Exception e) {
               System.out.println("Fail");
           } 
    }
    @Override
    public String toString(){
        StringBuilder companyInfo=new StringBuilder();
        StringBuilder customerInfo=new StringBuilder();
        for (int i = 0; i < Companies.size();i++){
        companyInfo.append("\t"+Companies.get(i)+"");
        }
        return Name+"\t"+Address+
        "\n";
    }
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
    public void setBalance(double balance){
        this.balance=balance;
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

    public PersonalAccount(String AcctNum, String Name, String Surname) {
        super(AcctNum);
        this.Name = Name;
        this.Surname = Name;
        this.PIN = String.format("%04d", number);
    }

    public PersonalAccount(String AcctNum, double balance, String Name, String Surname) {
        super(AcctNum, balance);
        this.Name = Name;
        this.Surname = Surname;
        this.PIN = String.format("%04d", number);
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getSurname() {
        return Surname.toUpperCase();
    }

    public void setSurname(String Surname) {
        this.Surname = Surname;
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
class Customer{
    private int id;
    private String Name;
    private String Surname;
    private ArrayList<PersonalAccount> personalAccounts;

    public Customer(int id,String Name, String Surname) {
        this.Name = Name;
        this.Surname = Surname;
        this.id=id;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
    public String getName() {
        return Name;
    }
    public void setName(String Name) {
        this.Name = Name;
    }
    public String getSurname() {
        return Surname.toUpperCase();
    }
    public void setSurname(String Surname) {
        this.Surname = Surname;
    }
    public void openAccount(String acctNum){
        PersonalAccount pa =new PersonalAccount(acctNum, this.Name, this.Surname);
        personalAccounts.add(pa);
    }
    public PersonalAccount getAccount(String accountNumber){
        int i = 0;
       try {
        for (i = 0; i < personalAccounts.size();i++){ 		      
           if(personalAccounts.get(i).getAcctNum()==accountNumber){
               break;
           }
           else{
               int j=0/0;
           }
        }   
       } catch (Exception e) {
           System.out.println("Fail");
       }
       return personalAccounts.get(i); 
    }
    public void closeAccount(String accountNum){
        try {
            for (int i = 0; i < personalAccounts.size();i++){ 		      
               if(personalAccounts.get(i).getAcctNum()==accountNum){
                   personalAccounts.remove(i);
               }
               else{
                   int j=0/0;
               }
            }   
           } catch (Exception e) {
               System.out.println("Fail");
           } 
    }
    @Override
    public String toString() {
        return  Name +" "+ Surname;
    }
}
class Company {
    private int id;
    private String Name;
    private ArrayList<BusinessAccount> businessAccounts;

    public Company(int id,String Name) {
        this.Name = Name;
        this.id=id;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;

    }
    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
    public void openAccount(String AcctNum,double Rate){
        businessAccounts.add(new BusinessAccount(AcctNum,0,Rate));

    }
   
    public BusinessAccount getAccout(String accountNumber){
        int i = 0;
        try {
         for ( i = 0; i < businessAccounts.size();i++){ 		      
            if(businessAccounts.get(i).getAcctNum()==accountNumber){
                break;
            }
            else{
                int j=0/0;
            }
         }   
        } catch (Exception e) {
            System.out.println("Fail");
        } 
        return businessAccounts.get(i);
     }
     public void closeAccount(String accountNum){
         try {
             for (int i = 0; i < businessAccounts.size();i++){ 		      
                if(businessAccounts.get(i).getAcctNum()==accountNum){
                    businessAccounts.remove(i);
                }
                else{
                    int j=0/0;
                }
             }   
            } catch (Exception e) {
                System.out.println("Fail");
            } 
     }


    @Override
    public String toString() {
        return Name;
    }
}