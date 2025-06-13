import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if ("admin".equals(username) && "pass123".equals(password)) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);

            out.println("<h2>Login successful. Session started for " + username + ".</h2>");
            out.println("<a href='LogoutServlet'>Logout</a>");
        } else {
            out.println("<h2>Invalid credentials. Please try again.</h2>");
            out.println("<a href='login.html'>Back to Login</a>");
        }
    }
}
