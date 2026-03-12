package vamsibanksystem;

import vamsibanksystem.BankAccount;
import java.sql.*;
public  class BankSystemDAO 
{
    Connection con;
    PreparedStatement stmt;
    ResultSet rs;
    BankSystemDAO(){
        try{
           con =DriverManager.getConnection("jdbc:mysql://localhost:3306/vamsi", "root","1221");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public void addAccount(BankAccount account){
        try{
            if(!getDetails(account.accountId)){
            stmt=con.prepareStatement("insert into Bank values(?,?,?)");
            stmt.setInt(1, account.accountId);
            stmt.setString(2, account.name);
            stmt.setInt(3,account.amount);
            int result=stmt.executeUpdate();
            System.out.println("added the bank account of user"+account.name);
            stmt.close();}
            else{
                System.out.println("already there");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
    }
    public void withdrawn(int id,int amount){
        try{
            if(getDetails(id) && getBalance(id)>=amount){
            stmt=con.prepareStatement("update Bank set balance=balance-? where id=?");
            stmt.setInt(1,amount);
            stmt.setInt(2,id);
            stmt.executeUpdate();
            System.out.println(amount+ " deposited from the bank account of user id "+ id);
            stmt.close();
            }
            else{
                System.out.println("failed");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public void deposit(int id, int amount){
        try{
            if(getDetails(id)){
            stmt=con.prepareStatement("update Bank set balance=balance + ? where id=?");
            stmt.setInt(1,amount);
            stmt.setInt(2,id);
            stmt.executeUpdate();
            System.out.println(amount+ " credited to the bank account of user id "+id);
            stmt.close();
            }
            else{
            System.out.println("falied");
        }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public int getBalance(int id){
        try{
            if(getDetails(id)){
            
            stmt=con.prepareStatement("select balance from Bank where id=?");
            stmt.setInt(1,id);
            rs=stmt.executeQuery();
            if(rs.next()){
            int result= rs.getInt("balance");
            rs.close();
            stmt.close();
            return result;
            }
        }
        else{

            System.out.println("failed");
        }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return -1;
    }
    public boolean getDetails(int id){
        try{
            stmt=con.prepareStatement("select * from bank where id=?");
            stmt.setInt(1,id);
            ResultSet rs=stmt.executeQuery();
            if(rs.next()){
                return true;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public void closeConnection(){
        try{
            con.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}