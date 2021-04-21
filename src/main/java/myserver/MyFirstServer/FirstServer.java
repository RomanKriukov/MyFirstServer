package myserver.MyFirstServer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class FirstServer extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        String user = (String) session.getAttribute("current_user");
        if(user == null){

        }else{

        }

//        Cart cart = (Cart)session.getAttribute("cart");
//
//        String name = req.getParameter("name");
//        int quantity = Integer.parseInt(req.getParameter("quantity"));
//
//        if(cart == null){
//            cart = new Cart();
//        }
//        cart.setName(name);
//        cart.setQuantity(quantity);
//
//        session.setAttribute("cart", cart);
//
//        getServletContext().getRequestDispatcher("/showCart.jsp").forward(req, resp);

//        Integer count = (Integer) session.getAttribute("cart");
//        if(count == null){
//            session.setAttribute("count", 1);
//            count = 1;
//        }else {
//            session.setAttribute("count", count + 1);
//        }

//        String name = req.getParameter("name");
//        String surname = req.getParameter("surname");

        PrintWriter pw = resp.getWriter();
        String str = "Test";
        pw.println("{\"");
        //pw.println("<html>");
        //pw.println("<h1>Your count is: " + count + "</h1>");
        //pw.println("<h1>Hello " + name + " " + surname + "!</h1>");
        //pw.println("</html>");

        //resp.sendRedirect("");
        //resp.sendRedirect("/firstJsp.jsp");

        //RequestDispatcher dispatcher = req.getRequestDispatcher("/firstJsp.jsp");
        //dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
