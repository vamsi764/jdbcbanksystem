package vamsibanksystem;
public class BankAccount 
{
    int accountId;
    String name;
    int amount;
    BankAccount(int accountId,String name,int amount){
        this.accountId=accountId;
        this.name=name;
        this.amount=amount;
    }
}