package karotubu;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutServlet extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws IOException {
    UserService userService = UserServiceFactory.getUserService();

    String thisUrl = req.getRequestURI();

    resp.setContentType("text/html;charset=utf-8");
    if (req.getUserPrincipal() != null) {
      resp.getWriter().println("<p>Logout, "
          + req.getUserPrincipal().getName()
          + "横をクリック!" +"<a href="
          + userService.createLogoutURL(thisUrl)
          + ">logout</a>.</p>");
    }else {
        resp.getWriter().println("<p>Please "+"<a href="
                + "index.html"
                + ">トップページへ</a>.</p>");
    }
    
    
  }
  
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
	 // processRequest(request, response);
  }
}