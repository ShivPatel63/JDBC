import java.sql.Connection;
import java.sql.DriverManager;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        try(Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3309/?user=root","root","root")){

            if(conn != null){
                System.out.println("Yuppp , Connection is Successful !!!");
            }
            else {
                System.out.println("Sorry, Could not able to connect !");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}