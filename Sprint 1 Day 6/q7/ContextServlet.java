import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ContextServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        ServletContext context = getServletContext();
        String appName = context.getInitParameter("appName");

        out.println("<h2>Context Parameter from ServletContext</h2>");
        out.println("<p>Application Name: " + appName + "</p>");
    }
}
