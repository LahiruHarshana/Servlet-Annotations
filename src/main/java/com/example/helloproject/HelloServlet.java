package com.example.helloproject;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletConfig;
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

            System.out.println(id+" "+name+" "+address);
            Class.forName("com.mysqljdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
//            PreparedStatement stm = connection.prepareStatement("Insert into customer values (id,name,address) VALUES (?,?,?)");
//
//



            System.out.println();
//
//            stm.setString(1, id);
//            stm.setString(2, name);
//            stm.setString(3, address);
//
//
//            stm.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void destroy() {
    }
}