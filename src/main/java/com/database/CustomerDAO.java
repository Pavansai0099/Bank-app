package com.database;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;



import com.control.Customer;

public class CustomerDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/mydb2";
    private String jdbcUsername = "root";
    private String jdbcPassword = "Kishore@10";
    
    private static final String INSERT_CUSTOMERS_SQL = "INSERT INTO customers" +
            "  (full_name, address, mobile_no, email, account_type, initial_balance, dob, id_proof, account_no, password) VALUES " +
            " (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void insertCustomer(Customer customer) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMERS_SQL)) {
            
            preparedStatement.setString(1, customer.getFullName());
            preparedStatement.setString(2, customer.getAddress());
            preparedStatement.setString(3, customer.getMobileNo());
            preparedStatement.setString(4, customer.getEmail());
            preparedStatement.setString(5, customer.getAccountType());
            preparedStatement.setDouble(6, customer.getInitialBalance());
            preparedStatement.setDate(7, customer.getDob());
            preparedStatement.setString(8, customer.getIdProof());
            
//            String accountNo = generateAccountNo(); // Generate unique account number
            preparedStatement.setString(9, customer.getAccountNo());
            preparedStatement.setString(10, customer.getPassword());
            
            preparedStatement.executeUpdate();
            
        
        } catch (SQLException e) {
            printSQLException(e);
        }
    }



    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}


