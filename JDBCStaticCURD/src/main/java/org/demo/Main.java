package org.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Main {

    private static String creatTable = "create table if not exists person(id serial,city varchar(30));";

    private static String insertTable = "insert into person values(101,'Lubbock'),(102,'Dallas');";

    private static String updateTable = "update person set city = 'New Jersey' where id = 102;";

    private static String selectTable = "select * from person";

    public static void main(String[] args) {
        try(Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3309/JavaPractice","root","root")){

            if(conn != null){
                System.out.println("Yup , Connection is Successful !!!");
            }
            else {
                System.out.println("Sorry, Could not able to connect !");
            }

            assert conn != null;
            Statement state = conn.createStatement();
            state.execute(creatTable);
            System.out.println("Table Created");

//            state.execute(insertTable);
//            System.out.println("Rows Inserted");

//            state.execute(updateTable);
//            System.out.println("Row Updated");

            ResultSet rs = state.executeQuery(selectTable);

            while(rs.next()){
                System.out.println("ID: " + rs.getInt(1));
                System.out.println("City: " + rs.getString("city"));
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}