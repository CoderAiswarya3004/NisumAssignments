import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class PageOneServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        HttpSession session = request.getSession();
        session.setAttribute("name", name);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<form action='PageTwoServlet' method='post'>");
        out.println("Age: <input type='text' name='age'><br/>");
        out.println("<input type='submit' value='Next'>");
        out.println("</form>");
    }
}
