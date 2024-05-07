package org.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;

public class Main {

    private static String createTable = "Create table if not exists  example(id serial, name varchar(30))";
    private static String insertQuery = "insert into Example values(?,?)";
    private static String updateQuery = "update example set name =? where id =? ";


    public static void main(String[] args) {

        try(Connection conn = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3309/JavaPractice","root","root");
            PreparedStatement ps_create = conn.prepareStatement(createTable);
            PreparedStatement ps_insert = conn.prepareStatement(insertQuery);
            PreparedStatement ps_update = conn.prepareStatement(updateQuery)){

            ps_create.execute();
            System.out.println("Table created");


            ps_insert.setLong(1, 1001);
            ps_insert.setString(2, "ABC");
            ps_insert.addBatch();

            ps_insert.setLong(1, 1002);
            ps_insert.setString(2, "XYZ");
            ps_insert.addBatch();

            ps_insert.setLong(1, 1003);
            ps_insert.setString(2, "MNO");
            ps_insert.addBatch();

            int[] updateCount = ps_insert.executeBatch();
            System.out.println(Arrays.toString(updateCount));

            ps_update.setString(1, "PQR");
            ps_update.setInt(2,1003);
            ps_update.executeUpdate();

            System.out.println("RowUPDATED ");
            ;

        }catch(SQLException e) {
            System.err.format("SQL State : %s \n %s", e.getSQLState(),e.getMessage());
        }catch(Exception e) {
            e.printStackTrace();
        }

    }

}
