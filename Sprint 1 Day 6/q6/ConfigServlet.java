import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ConfigServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        ServletConfig config = getServletConfig();
        String institute = config.getInitParameter("institute");

        out.println("<h2>Init Parameter from ServletConfig</h2>");
        out.println("<p>Institute: " + institute + "</p>");
    }
}
