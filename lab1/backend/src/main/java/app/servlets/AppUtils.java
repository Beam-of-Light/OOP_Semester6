package app.servlets;

import app.entities.UserAccount;

import javax.servlet.http.HttpSession;

public class AppUtils {

    public static void storeLoggedInUser(HttpSession session, UserAccount loggedInUser) {
        session.setAttribute("loggedInUser", loggedInUser);
    }

    public static UserAccount getLoggedInUser(HttpSession session) {
        return (UserAccount) session.getAttribute("loggedInUser");
    }

}