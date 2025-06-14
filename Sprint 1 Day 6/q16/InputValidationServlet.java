import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class InputValidationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if (name == null || name.trim().isEmpty() || email == null || email.trim().isEmpty()) {
            out.println("<h2 style='color:red;'>Error: Name and Email are required fields.</h2>");
            out.println("<a href='validationForm.html'>Go Back</a>");
        } else {
            out.println("<h2 style='color:green;'>Success! Your input has been recorded.</h2>");
            out.println("<p>Name: " + name + "</p>");
            out.println("<p>Email: " + email + "</p>");
        }
    }
}
