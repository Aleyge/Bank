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
    public void addCompany(int CompanyId,int CompanyName){
        Companies.add(new Company(CompanyId,CompanyName));
    }
    public void addAccount(Account account){
        Accounts.add(account);
    }
    public Customer getCustomer(int id){
        try {
            for (int i = 0; i < Customers.size();i++){ 		      
               if(Customers.get(i).getId()==id){
                   return Customers.get(i);
               }
               else{
                   int j=0/0;
               }
            }   
           } catch (Exception e) {
               System.out.println("Fail");
           } 
        
    }
    public Customer getCustomer(String name, String surname){
        try{
        for (int i = 0; i < Customers.size();i++){ 		      
            if(Customers.get(i).getName()==name&&Customers.get(i).getSurname()==surname){
                return Customers.get(i);
            }
            else{
                int j=0/0;
            }
         }   
        } catch (Exception e) {
            System.out.println("Fail");
        }
    }
    public Company getCompany(int id){
        try {
            for (int i = 0; i < Companies.size();i++){ 		      
               if(Companies.get(i).getId()==id){
                   return Companies.get(i);
               }
               else{
                   int j=0/0;
               }
            }   
           } catch (Exception e) {
               System.out.println("Fail");
           } 
    }
    public Company getCompany(String name){
        try{
            for (int i = 0; i < Companies.size();i++){ 		      
                if(Companies.get(i).getName()==name){
                    return Companies.get(i);
                }
                else{
                    int j=0/0;
                }
             }   
            } catch (Exception e) {
                System.out.println("Fail");
            }
    }
    public Account getAccount(String accountNum){
        try{
            for (int i = 0; i < Accounts.size();i++){ 		      
                if(Accounts.get(i).getName()==name){
                    return Accounts.get(i);
                }
                else{
                    int j=0/0;
                }
             }   
            } catch (Exception e) {
                System.out.println("Fail");
            }
    }
    public void transferFunds(String accountFrom, String accountTo,double amount){
        try {
            int senderIndex=Accounts.indexOf(accountFrom);
            int receiverIndex=Accounts.indexOf(accountTo);
            
        } catch (Exception e) {
            //TODO: handle exception
        }
  
        try {
            int balance=Accounts.get(senderIndex).getBalance()-amount;
            Accounts.get(senderIndex).setBalance(balance);
            Accounts.get(receiverIndex).setBalance(Accounts.get(receiverIndex).getBalance()+amount);
            
        } catch (Exception e) {
            //TODO: handle exception
        }
       
    }
    public void closeAccount(String accountNum){
        try {
            for (int i = 0; i < Accounts.size();i++){ 		      
               if(Accounts.get(i).getAcctNum()==accountNumber&&
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
               if(Accounts.get(i).getAcctNum()==accountNumber){
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
        return "/t"+Name+"/t"+Address;
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
public class Customer{
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
    public PersonalAccount getAccout(String accountNumber){
       try {
        for (int i = 0; i < personalAccounts.size();i++){ 		      
           if(personalAccounts.get(i).getAcctNum()==accountNumber){
               return personalAccounts.get(i);
           }
           else{
               int j=0/0;
           }
        }   
       } catch (Exception e) {
           System.out.println("Fail");
       } 
    }
    public void closeAccount(String accountNum){
        try {
            for (int i = 0; i < personalAccounts.size();i++){ 		      
               if(personalAccounts.get(i).getAcctNum()==accountNumber){
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
    private BusinessAccounts<> businessAccounts;

    public Company(String Name,int id) {
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
        ba=new BusinessAccount(AcctNum,0,Rate);

    }
    public BusinessAccount getAccount(){
        return ba;
    }
    public PersonalAccount getAccout(String accountNumber){
        try {
         for (int i = 0; i < businessAccounts.size();i++){ 		      
            if(businessAccounts.get(i).getAcctNum()==accountNumber){
                return businessAccounts.get(i);
            }
            else{
                int j=0/0;
            }
         }   
        } catch (Exception e) {
            System.out.println("Fail");
        } 
     }
     public void closeAccount(String accountNum){
         try {
             for (int i = 0; i < businessAccounts.size();i++){ 		      
                if(businessAccounts.get(i).getAcctNum==accountNumber){
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