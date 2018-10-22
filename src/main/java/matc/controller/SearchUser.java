package matc.controller;


import matc.entity.User;
import matc.persistence.GenericDao;
import matc.persistence.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * A simple servlet to welcome the user.
 * @author pwaite
 */

@WebServlet(
        urlPatterns = {"/searchUser"}
)

public class SearchUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //UserDao userDao = new UserDao();
        GenericDao genericDao = new GenericDao(User.class);
        if (req.getParameter("submit").equals("search")) {
            req.setAttribute("userSearchResults", genericDao.userByLastName(req.getParameter("searchTerm")));

        } else {
            req.setAttribute("userSearchResults", genericDao.getAll());
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("/results.jsp");
        dispatcher.forward(req, resp);
    }


}