package org.demo;


import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        try(Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3309/?user=root","root","root")){

            if(conn != null){
                System.out.println("Yuppp , Connection is Successful !!!");
            }
            else {
                System.out.println("Sorry, Could not able to connect !");
            }

            Statement state = conn.createStatement();

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}