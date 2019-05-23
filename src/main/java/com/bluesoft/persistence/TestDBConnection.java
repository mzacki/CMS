package com.***REMOVED***.persistence;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by Matt on 23.05.2019 at 10:05.
 */

@WebServlet("/TestDBConnection")
public class TestDBConnection extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        String ***REMOVED*** = "postgres";
        String ***REMOVED*** = "***REMOVED***";
        String url = "jdbc:postgresql://localhost:5432/***REMOVED***";
        String driver = "org.postgresql.Driver";

        try {
            PrintWriter out = response.getWriter();
            out.println("Connecting to the database " + url);
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url, ***REMOVED***, ***REMOVED***);
            out.println("Connection works.");
            connection.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}
