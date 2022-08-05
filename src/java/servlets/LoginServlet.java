package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.User;
import services.AccountService;

/**
 *
 * @author anant
 */
public class LoginServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         HttpSession session = request.getSession();
        String logout = request.getParameter("logout");
        if(logout != null) {
            request.setAttribute("message", "You have successfully logged out.");
            session.invalidate();
            
        } else if(session.getAttribute("username") != null ){
            response.sendRedirect("home");
            return;
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        return;

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      String user = request.getParameter("user");
        String password = request.getParameter("password");
        
        if (user.equals("") || password.equals("")) {
                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
                return;
            }
        
        HttpSession session = request.getSession();
        
        AccountService service = new AccountService();
        User login = service.login(user, password);
        
        if (login != null) {
            session.setAttribute("username", user); 
            response.sendRedirect("home");
            return;
        } else {
            request.setAttribute("message", "Please type the right login information!");
            request.setAttribute("user", user);
            request.setAttribute("password", password);
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
        }
        

      
    }

   
}
