import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class TargetServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String message = (String) request.getAttribute("message");
        out.println("<h2>Received Message: " + message + "</h2>");
    }
}
