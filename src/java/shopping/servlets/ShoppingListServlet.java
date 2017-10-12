package shopping.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 642202
 */
public class ShoppingListServlet extends HttpServlet {    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        
        if (action != null && action.equals("logout")){
//            session.removeAttribute("username");
//            session.removeAttribute("shoppingList");
            session.invalidate();
            response.sendRedirect("ShoppingList");
        }
        else if (session.getAttribute("username") == null){
            getServletContext().getRequestDispatcher("/WEB-INF/Register.jsp").forward(request, response);
        }
        else {
            getServletContext().getRequestDispatcher("/WEB-INF/ShoppingList.jsp").forward(request, response);
        }
    } 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        if (action != null){
            if (action.equals("register")){
                String username = request.getParameter("username");
                session.setAttribute("username", username);
            }
            else if (action.equals("add")){
                ArrayList<String> shoppingList = (ArrayList<String>)session.getAttribute("shoppingList");
                String item = request.getParameter("item");
                if (item != null && !item.equals("")){
                    if (shoppingList != null){
                        shoppingList.add(item);
                    }
                    else {
                        shoppingList = new ArrayList<String>();
                        shoppingList.add(item);
                    }
                    session.setAttribute("shoppingList", shoppingList);
                }
            }
            else if (action.equals("delete")){
                ArrayList<String> shoppingList = (ArrayList<String>)session.getAttribute("shoppingList");
                String item = request.getParameter("list");
                if (item != null){
                    shoppingList.remove(Integer.parseInt(item));
                    session.setAttribute("shoppingList", shoppingList);
                }
            }
        }
        else {
            
        }
        response.sendRedirect("ShoppingList");
    }

}
