import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class CookieServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Cookie userCookie = new Cookie("username", "AISWARYA");
        userCookie.setMaxAge(3600); // 1 hour
        response.addCookie(userCookie);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h2>Cookie has been set.</h2>");

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            out.println("<h3>Cookies Found:</h3>");
            for (Cookie c : cookies) {
                out.println("<p>" + c.getName() + " = " + c.getValue() + "</p>");
            }
        }
    }
}
