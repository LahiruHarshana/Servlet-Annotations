package com.example.helloproject;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/helloServlet" , loadOnStartup = 1,initParams = {
        @WebInitParam(name = "username", value = "root"),
        @WebInitParam(name = "password", value = "12345678"),
        @WebInitParam(name = "url", value = "jdbc:mysql://localhost:3306/gdse66_hello")
})
public class HelloServlet extends HttpServlet {
    private String username;
    private String password;
    private String url;

    @Override
    public void init() {
        ServletConfig config = getServletConfig();
        username = config.getInitParameter("username");
        password = config.getInitParameter("password");
        url = config.getInitParameter("url");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Connection connection = null;
        try {
            String id = request.getParameter("id");
            String name = request.getParameter("name");
            String address = request.getParameter("address");

            System.out.println(id + " " + name + " " + address);
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
            PreparedStatement stm = connection.prepareStatement("INSERT INTO customer (id, name, address) VALUES (?, ?, ?)");

            stm.setString(1, id);
            stm.setString(2, name);
            stm.setString(3, address);
            stm.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ignore) {

                }
            }
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection connection = null;
        try {
            String id = req.getParameter("id");
            String name = req.getParameter("name");
            String address = req.getParameter("address");

            System.out.println(id + " " + name + " " + address);
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
            PreparedStatement stm = connection.prepareStatement("UPDATE customer SET name = ?, address = ? WHERE id = ?");

            stm.setString(1, name);
            stm.setString(2, address);
            stm.setString(3, id);
            stm.executeUpdate();


        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ignore) {
                }
            }
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection connection = null;
        try {
            String id = req.getParameter("id");

            System.out.println(id );
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
            PreparedStatement stm = connection.prepareStatement("DELETE FROM customer WHERE id = ?");

            stm.setString(1, id);

            stm.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ignore) {

                }
            }
        }
    }
}