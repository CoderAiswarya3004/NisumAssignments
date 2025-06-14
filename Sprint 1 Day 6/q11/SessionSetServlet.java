import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SessionSetServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        session.setAttribute("username", "AISWARYA");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h2>Session attribute set successfully.</h2>");
    }
}
