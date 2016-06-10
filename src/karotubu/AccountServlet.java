package karotubu;


import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AccountServlet extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws IOException {
    UserService userService = UserServiceFactory.getUserService();

    String thisUrl = req.getRequestURI();

    resp.setContentType("text/html");
    if (req.getUserPrincipal() != null) {
      resp.getWriter().println("<p>Hello, "
          + req.getUserPrincipal().getName()
          + "!  You can" +"<a href="
          + userService.createLogoutURL(thisUrl)
          + ">sign out</a>.</p>");
    } else {
      resp.getWriter().println("<p>Please "+"<a href="
            + userService.createLoginURL(thisUrl)
            + ">sign in</a>.</p>");
    }
  }
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
	 // processRequest(request, response);
  }
}