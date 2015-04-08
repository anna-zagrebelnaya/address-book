package com.anka.servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Anka on 08.04.2015.
 */
public class AddressBookServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String user = request.getParameter("user");
        //TODO: check if user is in db
        response.sendRedirect("address-book.jsp");
    }
}
