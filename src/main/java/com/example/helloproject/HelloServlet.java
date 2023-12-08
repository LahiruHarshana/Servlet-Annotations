package com.example.helloproject;

import java.io.*;
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

    @Override
    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    }

    public void destroy() {
    }
}