package vamsibanksystem;
import vamsibanksystem.BankSystemDAO;
import vamsibanksystem.BankAccount;
import java.sql.ResultSet;
import java.sql.SQLException;
public class BankSystem 
{
    public static void main( String[] args ) throws SQLException
    {
        BankSystemDAO obj=new  BankSystemDAO();
        ResultSet rs=obj.getUsers();
        while(rs.next()){
            System.out.println(rs.getInt(1) + " "+ rs.getString(2)+ " " +rs.getInt(3));
        }
        // obj.addAccount(new BankAccount(1,"vamsi",1000));
        // System.out.println(obj.getBalance(1));
        // obj.deposit(1,100);
        // obj.withdrawn(1,200);
        // System.out.println(obj.getBalance(1));
        // obj.closeConnection();
    }
}
