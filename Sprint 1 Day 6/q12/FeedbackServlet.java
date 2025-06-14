import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class FeedbackServlet extends HttpServlet {
    private List<String> feedbackList = new ArrayList<>();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String feedback = request.getParameter("feedback");
        if (feedback != null && !feedback.trim().isEmpty()) {
            feedbackList.add(feedback);
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h2>Thank you for your feedback!</h2>");
        out.println("<h3>All Feedback:</h3>");
        for (String fb : feedbackList) {
            out.println("<p>" + fb + "</p>");
        }
    }
}
