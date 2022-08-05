package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author anant
 */
public class HomeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           HttpSession session = request.getSession();
        
        if(session.getAttribute("username") == null ){
            response.sendRedirect("login");
            return;
        }
        String username = (String) session.getAttribute("username");
        request.setAttribute("user", username);
        getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
        return;

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

   
}
