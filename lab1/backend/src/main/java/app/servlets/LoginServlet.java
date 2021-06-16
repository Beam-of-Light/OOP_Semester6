package app.servlets;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.DAO.UserAccountDAO;
import app.entities.UserAccount;
import com.google.gson.Gson;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        StringBuffer jb = new StringBuffer();
        String line = null;
        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null)
                jb.append(line);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Gson gson = new Gson();
        UserAccount userAccount = gson.fromJson(jb.toString(), UserAccount.class);
        userAccount = UserAccountDAO.getUser(userAccount.getUsername(), userAccount.getPassword());

        if (userAccount == null) {
            String errorMessage = "Invalid username or Password";

            request.setAttribute("errorMessage", errorMessage);
            return;
        }

        AppUtils.storeLoggedInUser(request.getSession(), userAccount);
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        String userJson = new Gson().toJson(userAccount);
        out.println(userJson);
        out.flush();

    }

}
