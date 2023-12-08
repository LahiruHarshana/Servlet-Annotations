package com.example.helloproject;

import java.io.*;
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
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    }

    public void destroy() {
    }
}