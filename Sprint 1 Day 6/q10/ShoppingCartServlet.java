import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ShoppingCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String item = request.getParameter("item");
        HttpSession session = request.getSession();

        List<String> cart = (List<String>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
        }

        if (item != null && !item.trim().isEmpty()) {
            cart.add(item);
        }

        session.setAttribute("cart", cart);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<h2>Items in Your Cart:</h2>");
        for (String cartItem : cart) {
            out.println("<p>" + cartItem + "</p>");
        }

        out.println("<br/><a href='cart.html'>Add More Items</a>");
    }
}
