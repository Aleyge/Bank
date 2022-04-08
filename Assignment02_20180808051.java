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
    private ArrayList<Customer> Customers=new ArrayList<Customer>();
    private ArrayList<Company> Companies=new ArrayList<Company>();
    private ArrayList<Account> Accounts=new ArrayList<Account>();
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
    public Customer getCustomer(int id)throws RuntimeException{
        int i=0;
        for (i = 0; i < Customers.size();i++){ 		      
            if(Customers.get(i).getId()==id){
                break;
            }
            
         }   
         if(Customers.get(i).getId()!=id){
             throw new CustomerNotFoundException(id);
         }
           return Customers.get(i);
    }
    public Customer getCustomer(String name, String surname)throws RuntimeException{
        int i=0;
        for ( i = 0; i < Customers.size();i++){ 		      
            if(Customers.get(i).getName()==name&&Customers.get(i).getSurname()==surname){
               break;
            }
         }
        if(Customers.get(i).getName()!=name||Customers.get(i).getSurname()!=surname){
            throw new CustomerNotFoundException(name,surname);
         }
        return Customers.get(i);
    }
    public Customer getCustomer(int id,String name, String surname){
        int i=0;
        for (i = 0; i < Customers.size();i++){ 		      
               if(Customers.get(i).getId()==id){
                   break;
               }
               
            }   
        if(Customers.get(i).getId()!=id){
                throw new CustomerNotFoundException(id);
        }
        
        for ( i = 0; i < Customers.size();i++){ 		      
            if(Customers.get(i).getName()==name&&Customers.get(i).getSurname()==surname){
               break;
            }
         }
        if(Customers.get(i).getName()!=name||Customers.get(i).getSurname()!=surname){
            throw new CustomerNotFoundException(name,surname);
         }
        return Customers.get(i);
    }
    public Company getCompany(int id){
        int i = 0;
        for (i = 0; i < Companies.size();i++){ 		      
            if(Companies.get(i).getId()==id){
                break;
            }
         }   
         if(Companies.get(i).getId()!=id){
             throw new CompanyNotFoundException(id);
         }
           return Companies.get(i);
    }
    public Company getCompany(String name){
        int i=0;
        for (i = 0; i < Companies.size();i++){ 		      
            if(Companies.get(i).getName()==name){
                break;
            }
         }   
         if(Companies.get(i).getName()!=name){
             throw new CompanyNotFoundException(name);
         }
            return Companies.get(i);
    }
    public Account getAccount(String accountNum){
        int i = 0;
        for (i = 0; i < Companies.size();i++){ 		      
            if(Accounts.get(i).getAcctNum()==accountNum){
                break;
            }
         }   
         if(Accounts.get(i).getAcctNum()!=accountNum){
             throw new CompanyNotFoundException(accountNum);
         }
            return Accounts.get(i);
    }
    public void transferFunds(String accountFrom, String accountTo,double amount){
            int senderIndex=Accounts.indexOf(getAccount(accountFrom));
            int receiverIndex=Accounts.indexOf(getAccount(accountTo));
            if(amount<=0){
                throw new InvalidAmountException(amount);
            }
            double newBalance=(Accounts.get(senderIndex).getBalance()-amount);
            if(newBalance<0){
                throw new BalanceRemainingException(newBalance);
            }
            Accounts.get(senderIndex).setBalance(newBalance);
            Accounts.get(receiverIndex).setBalance(Accounts.get(receiverIndex).getBalance()+amount);
        } 

    public void closeAccount(String accountNum){
         
        if(getAccount(accountNum).getBalance()>0){
            throw new BalanceRemainingException(getAccount(accountNum).getBalance());
        }
        if(getAccount(accountNum).getAcctNum()!=accountNum){
            throw new AccountNotFoundException(accountNum);
        }
        Accounts.remove(Accounts.indexOf(getAccount(accountNum)));
    }

    @Override
    public String toString(){
        StringBuilder bankInfo=new StringBuilder();
        for (int i = 0; i < Companies.size();i++){
        bankInfo.append("\t"+Companies.get(i).getName()+"\n");
            for(int j=0;j<Companies.get(i).getBusinessAccounts().size();j++){
                bankInfo.append("\t\t"+Companies.get(i).getBusinessAccounts().get(j).getAcctNum()+
                "\t"+Companies.get(i).getBusinessAccounts().get(j).getRate()+
                "\t"+Companies.get(i).getBusinessAccounts().get(j).getBalance()+"\n");
            }   
        }
        for (int i = 0; i < Customers.size();i++){
            bankInfo.append("\t"+Customers.get(i).getName()+Customers.get(i).getSurname()+"\n");
                for(int j=0;j<Customers.get(i).getPersonalAccounts().size();j++){
                    bankInfo.append("\t\t"+Customers.get(i).getPersonalAccounts().get(j).getAcctNum()+
                    "\t"+Customers.get(i).getPersonalAccounts().get(j).getBalance()+"\n");
                }   
            }
        return Name+"\t"+Address+"\n"+bankInfo;
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
    private ArrayList<PersonalAccount> personalAccounts= new ArrayList<PersonalAccount>();

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
    public ArrayList<PersonalAccount> getPersonalAccounts(){
        return personalAccounts;
    }
    public void openAccount(String acctNum){
        PersonalAccount pa =new PersonalAccount(acctNum, this.Name, this.Surname);
        personalAccounts.add(pa);
    }
    public PersonalAccount getAccount(String accountNumber){
        int i = 0;
        for (i = 0; i < personalAccounts.size();i++){ 		      
            if(personalAccounts.get(i).getAcctNum()==accountNumber){
                break;
            }
         }   
         if(personalAccounts.get(i).getAcctNum()!=accountNumber){
             throw new AccountNotFoundException(accountNumber);
         }
       return personalAccounts.get(i); 
    }
    public void closeAccount(String accountNumber){
       
        if(getAccount(accountNumber).getAcctNum()!=accountNumber){
            throw new AccountNotFoundException(accountNumber);
        }
        if(getAccount(accountNumber).getBalance()>0){
            throw new BalanceRemainingException(getAccount(accountNumber).getBalance());
        }
        personalAccounts.remove(personalAccounts.indexOf(getAccount(accountNumber)));    
    }
    @Override
    public String toString() {
        return  Name +" "+ Surname;
    }
}
class Company {
    private int id;
    private String Name;
    private ArrayList<BusinessAccount> businessAccounts=new ArrayList<BusinessAccount>();

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
    public ArrayList<BusinessAccount> getBusinessAccounts(){
        return businessAccounts;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
    public void openAccount(String AcctNum,double Rate){
        businessAccounts.add(new BusinessAccount(AcctNum,0,Rate));

        
    }
   
    public BusinessAccount getAccount(String accountNumber){
        int i = 0;
        for (i = 0; i < businessAccounts.size();i++){ 		      
            if(businessAccounts.get(i).getAcctNum()==accountNumber){
                break;
            }
         }   
         if(businessAccounts.get(i).getAcctNum()!=accountNumber){
             throw new AccountNotFoundException(accountNumber);
         }
       return businessAccounts.get(i); 
    }
     public void closeAccount(String accountNumber){
        if(getAccount(accountNumber).getAcctNum()!=accountNumber){
            throw new AccountNotFoundException(accountNumber);
        }
        if(getAccount(accountNumber).getBalance()>0){
            throw new BalanceRemainingException(getAccount(accountNumber).getBalance());
        }
        businessAccounts.remove(businessAccounts.indexOf(getAccount(accountNumber)));    
    }

    @Override
    public String toString() {
        return Name;
    }
}
    
    class AccountNotFoundException extends RuntimeException{
        private String acctNum;
        public AccountNotFoundException(String acctNum){
            this.acctNum=acctNum;
        }
        @Override
        public String toString() {
            return "AccountNotFoundException: " + acctNum;
        }
    }
   
    class BalanceRemainingException extends RuntimeException{
        private double balance;
        public BalanceRemainingException(double balance){
            this.balance=balance;
        }
        @Override
        public String toString() {
            return "BalanceRemainingException: " + balance;
        }
    
        public double getBalance() {
            return balance;
        }
    }

    class CompanyNotFoundException extends RuntimeException{
        private int id;
        private String name;
    
        public CompanyNotFoundException(int id){
            this.id = id;
            this.name = null;
        }
    
        public CompanyNotFoundException(String name){
            this.name = name;
    
            Random rndm = new Random();
            this.id = rndm.nextInt(10000);
        }
    
        @Override
        public String toString() {
            if(name != null){
                return "CompanyNotFoundException: name-" + name;
            }else{
                return "CompanyNotFoundException: id-" + id;
            }
        }
    }

    class CustomerNotFoundException extends RuntimeException{
        private int id;
        private String name;
        private String surname;
    
        public CustomerNotFoundException(int id){
            this.id = id;
            this.name = null;
            this.surname = null;
        }
    
        public CustomerNotFoundException(String name, String surname){
            this.name = name;
            this.surname = surname;
    
            Random rndm = new Random();
            this.id = rndm.nextInt(10000);
        }
    
        @Override
        public String toString() {
            if(name != null && surname != null){
                return "CustomerNotFoundException: name-" + name + ""
                        + surname;
            }else{
                return "CustomerNotFoundException: id-" + id;
            }
        }
    }

    class InvalidAmountException extends RuntimeException{
        private double amount;

        public InvalidAmountException(double amount){
            this.amount=amount;
        }
        @Override
        public String toString() {
            return "InvalidAmountException: " + amount ;
        }
    }
    
