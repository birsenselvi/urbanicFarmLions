package utilities;

import java.sql.*;

public class DB_utilities {
    public static Connection connection;
    public static Statement statement;
    public static PreparedStatement preparedStatement;
    public static ResultSet resultSet;


    public static void createConnection() {
        try {
            connection = DriverManager.getConnection(
                    ConfigurationReader.getProperty("url1"),
                    ConfigurationReader.getProperty("username"),
                    ConfigurationReader.getProperty("password1")
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void closeConnection() {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }
    public static void updateQueryStatement(String sql) { // insert update delete
        try {
            statement = connection.createStatement();
            int i = statement.executeUpdate(sql);
            System.out.println(i);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void insertStatement(String sql) {
       try{
        statement = connection.createStatement();
        int i = statement.executeUpdate(sql);
        System.out.println("i = " + i);
       } catch (SQLException e) {
           throw new RuntimeException(e);
       }

    }
    public static void approvedLastProduct(){
        updateQueryStatement("UPDATE `hub_product` SET `product_listing_state` = 'APPROVED' WHERE `product_listing_state` LIKE 'IN_REVIEW' order BY id DESC;");
    }
    public static void approvedLastProductWithLimit(){

        //updateQueryStatement("UPDATE `hub_product` SET `product_listing_state` = 'APPROVED' WHERE `unique_name` LIKE 'IN_REVIEW' order BY id DESC limit 1;");
        updateQueryStatement("UPDATE `hub_product` SET `product_listing_state` = 'APPROVED' WHERE product_id = (SELECT product_id FROM hub_product WHERE product_listing_state = 'IN_REVIEW' ORDER BY product_id DESC limit 1");
//UPDATE hub_product
//SET product_listing_state = 'APPROVE'
//WHERE product_id = (SELECT product_id
//                    FROM hub_product
//                    WHERE product_listing_state = 'IN_REVIEW'
//                    ORDER BY product_id DESC
    //Select * from hub_product where product_listing_state ='IN_REVIEW';
    }
    public static void approvedRequestLastProduct(){
        updateQueryStatement("UPDATE `product_request` SET `product_listing_state` = 'APPROVED' WHERE `product_listing_state` LIKE 'IN_REVIEW' order BY id DESC;");
    }

    public static void deleteUsedPromoCode(){

        updateQueryStatement("DELETE FROM promo_code_user");
    }
    public static void selectQueryStatement(String sql) { // select
        try {
            statement = connection.createStatement();
           resultSet = statement.executeQuery(sql);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void deleteQuery(String query){
        updateQueryStatement(query);
    }

}
