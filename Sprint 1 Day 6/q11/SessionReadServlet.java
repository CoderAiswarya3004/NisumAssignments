import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SessionReadServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if (session != null) {
            String name = (String) session.getAttribute("username");
            out.println("<h2>Welcome back, " + name + "!</h2>");
        } else {
            out.println("<h2>No session found.</h2>");
        }
    }
}
