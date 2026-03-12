package vamsibanksystem;
import vamsibanksystem.BankSystemDAO;
import vamsibanksystem.BankAccount;;
public class BankSystem 
{
    public static void main( String[] args )
    {
        BankSystemDAO obj=new  BankSystemDAO();
        obj.addAccount(new BankAccount(1,"vamsi",1000));
        System.out.println(obj.getBalance(1));
        obj.deposit(1,100);
        obj.withdrawn(1,200);
        System.out.println(obj.getBalance(1));
        obj.closeConnection();
    }
}
