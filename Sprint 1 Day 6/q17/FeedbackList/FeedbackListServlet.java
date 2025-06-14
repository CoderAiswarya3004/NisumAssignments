import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class FeedbackListServlet extends HttpServlet {
    private List<String> comments = new ArrayList<>();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String comment = request.getParameter("comment");

        if (comment != null && !comment.trim().isEmpty()) {
            comments.add(comment);
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<h2>All Submitted Comments</h2>");
        for (String c : comments) {
            out.println("<p>" + c + "</p>");
        }
        out.println("<a href='commentForm.html'>Submit Another</a>");
    }
}
