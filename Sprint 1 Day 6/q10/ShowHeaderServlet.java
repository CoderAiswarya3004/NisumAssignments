import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ShowHeaderServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<h2>Request Headers</h2>");
        Enumeration<String> headers = request.getHeaderNames();

        while (headers.hasMoreElements()) {
            String name = headers.nextElement();
            String value = request.getHeader(name);
            out.println("<p>" + name + " : " + value + "</p>");
        }
    }
}
