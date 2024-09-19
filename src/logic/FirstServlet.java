import somePackage.Cart;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(value = "/logic.FirstServlet")
public class FirstServlet extends HttpServlet {
    /*
    In this example:
The doPost method is overridden from the HttpServlet class, and it handles HTTP POST requests.
The method retrieves the HttpServletRequest and HttpServletResponse objects, which represent the request and response, respectively.
It retrieves parameters from the request using request.getParameter("parameterName").
Performs some processing, in this case, a simple validation of a username and password.
Generates an HTML response using the PrintWriter obtained from the response.
Sends the HTML response back to the client.
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Set the response content type
        response.setContentType("text/html");

        // Get the PrintWriter object to write the HTML response
        PrintWriter out = response.getWriter();

        // Get the parameter values from the request
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Perform some processing with the received data (e.g., validate credentials)
        boolean isValidUser = validateUser(username, password);

        // Send HTML response based on validation result
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Login Result</title>");
        out.println("</head>");
        out.println("<body>");

        if (isValidUser) {
            out.println("<h1>Welcome, " + username + "!</h1>");
        } else {
            out.println("<h1>Invalid credentials. Please try again.</h1>");
        }

        out.println("</body>");
        out.println("</html>");
    }

    private boolean validateUser(String username, String password) {
        // Perform validation logic here (e.g., check against a database)
        // This is a simple example, and you should implement more robust validation.
        return "demo".equals(username) && "password".equals(password);
    }

    protected void doGet (javax.servlet.http.HttpServletRequest request, javax.servlet. http.HttpServletResponse response)
        throws ServletException, IOException {
        HttpSession session = request.getSession();

        String user = (String) session.getAttribute("current_user");

        if (user == null) {
            // response для анонимного пользователя
            // авторизация
            // регистрация
            // session.setAttribute("current_user", ID);
        } else {
            // response для авторизованного пользователя
        }



/////////////////////////////////////////////////////////////////////////////////////
//        Cart cart = (Cart) session.getAttribute("cart");
//
//        String  name = request.getParameter("name");
//        int quantity = Integer.parseInt(request.getParameter("quantity"));
//
//        if (cart == null) {
//            cart = new Cart();
//
//            cart.setName(name);
//            cart.setQuantity(quantity);
//        }
//
//        session.setAttribute("cart", cart);
//
//        getServletContext().getRequestDispatcher("/showCart.jsp").forward(request, response);

 /////////////////////////////////////////////////////////////////////////////////////////////////////


//        Integer count = (Integer) session.getAttribute("cart");
//        if (count == null) {
//            session.setAttribute("count", 1);
//            count = 1;
//        } else {
//            session.setAttribute("count", count + 1);
//        }
//        PrintWriter pw = response.getWriter();
//        pw.println("<html>");
//        pw.println("<h1>Your count is: " + count + " </h1>");
//        pw.println("</html>");
    }
}
