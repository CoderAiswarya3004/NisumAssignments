import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ForwardingServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("message", "This message was forwarded.");
        RequestDispatcher dispatcher = request.getRequestDispatcher("TargetServlet");
        dispatcher.forward(request, response);
    }
}
