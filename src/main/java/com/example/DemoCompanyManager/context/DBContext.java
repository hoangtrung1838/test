package com.example.DemoCompanyManager.context;

import java.sql.*;

public class DBContext {

    private static final String url = "jdbc:postgresql://localhost:5432/Company";
    private static final String user ="postgres";
    private static final String password ="123456789";

    public static Connection getConnection(){
        Connection connection = null;

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url,user,password);
            return connection;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }


        return connection;
    }

    public static void main(String[] args) {
        Connection connection = DBContext.getConnection();
        String sql = "select * from public.company";
        try {
            PreparedStatement pStatement = connection.prepareStatement(sql);
            ResultSet rs = pStatement.executeQuery();
            int i =1;
            while (rs.next()){
                System.out.println(rs.getString(i));
                System.out.println(rs.getString(2));
                System.out.println(rs.getString(3));
                System.out.println(rs.getString(4));
                System.out.println(rs.getString(5));
                System.out.println(rs.getString(6));
                System.out.println(rs.getString(7));
                System.out.println(rs.getString(8));
            }
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
