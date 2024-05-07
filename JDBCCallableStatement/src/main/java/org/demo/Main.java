package org.demo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

    private static String callSP =  "CALL new_procedure();";

    public static void main(String[] args) {
        try(Connection conn = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3309/JavaPractice","root","root");
            CallableStatement cstatement = conn.prepareCall(callSP)){

            ResultSet rs = cstatement.executeQuery();
            while(rs.next()) {
                System.out.println("ID :: " +rs.getInt(1));
                System.out.println("Name :: " +rs.getString("name"));
            }

        }catch(SQLException e) {
            System.err.format("SQL State : %s \n %s", e.getSQLState(),e.getMessage());
        }catch(Exception e) {
            e.printStackTrace();
        }

    }

}