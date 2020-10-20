package com.kotsoft.persistence;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author Created by Matt on 23.05.2019 at 10:05.
 * Class testing database connection.
 * Attention! Login credentials and database details to be completed by the user
 */

@WebServlet("/TestDBConnection")
public class TestDBConnection extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        String user = "";
        // Login credentials and database details to be completed by the user
        String pass = "";
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String driver = "org.postgresql.Driver";

        try {
            PrintWriter out = response.getWriter();
            out.println("Connecting to the database " + url);
            Class.forName(driver);
            try (Connection connection = DriverManager.getConnection(url, user, pass)) {
                out.println("Connection works.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
