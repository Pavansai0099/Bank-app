package com.bank;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.Customer;
import com.database.CustomerDAO;

/**
 * Servlet implementation class CustomerServlet
 */
@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CustomerDAO customerDAO;

    public void init() {
        customerDAO = new CustomerDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String fullName = request.getParameter("fullName");
        String address = request.getParameter("address");
        String mobileNo = request.getParameter("mobileNo");
        String email = request.getParameter("email");
        String accountType = request.getParameter("accountType");
        double initialBalance = Double.parseDouble(request.getParameter("initialBalance"));
        Date dob = Date.valueOf(request.getParameter("dob"));
        String idProof = request.getParameter("idProof");
        String accountNo = generateAccountNo();
        String password = generatePassword();
        Customer newCustomer = new Customer(fullName, address, mobileNo, email, accountType, initialBalance, dob, accountNo,password,idProof);
        try {
            customerDAO.insertCustomer(newCustomer);
            response.getWriter().println("Account No:"+ accountNo);
            response.getWriter().println("Password: "+ password);
            
        } catch (SQLException e) {
            throw new ServletException(e);
        }
        response.sendRedirect("AdminDashboard.jsp");
    }
    
    
    public static String generateAccountNo() {
        Random random = new Random();
        StringBuilder accountNo = new StringBuilder();

        // Ensure the first digit is not zero
        accountNo.append(random.nextInt(9) + 1); // 1-9

        // Append the remaining 10 digits
        for (int i = 0; i < 10; i++) {
            accountNo.append(random.nextInt(10)); // 0-9
        }

        return accountNo.toString();
    }

    private String generatePassword() {
        Random random = new Random();
        StringBuilder password = new StringBuilder();

        // Generate a 4-digit password
        for (int i = 0; i < 4; i++) {
            password.append(random.nextInt(10)); // 0-9
        }

        return password.toString();
    }

}

