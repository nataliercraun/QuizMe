import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import objects.DBmanager;
import objects.User;

/**
 * Servlet implementation class ChooseFile
 */
@WebServlet("/loginServlet")
@MultipartConfig
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DBmanager db = new DBmanager();

		System.out.println("Inside of servlet");
		String type = request.getParameter("type");

		System.out.println(type);

		if (type.equals("signin")) {
			// Get info to make SQL connection
			String email = request.getParameter("email");
			String pass = request.getParameter("password");
			Boolean emailValid = db.checkEmail(email);
			if (emailValid) {
				response.reset();
				Boolean passValid = db.checkPass(email, pass);
				if (passValid) {
					User user = new User(email, pass);
					request.getSession().setAttribute("user", user);
					request.getSession().setAttribute("manager", db);
					response.getWriter().print("other");
				} else {
					response.getWriter().print("pass");
				}
			} else {
				response.reset();
				response.getWriter().print("email");
			}
		} else {
			String email = request.getParameter("email");
			System.out.println(email);
			String pass = request.getParameter("password");
			System.out.println(pass);

			db.addUser(email, pass);
		}
	}
}