
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import objects.Card;
import objects.DBmanager;

@WebServlet("/CardServlet")
public class CardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CardServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DBmanager db = new DBmanager();

		String type = request.getParameter("type");
		System.out.println("TYPE IS: " + type);

		if (type.equals("deck")) {
			String name = request.getParameter("name");
			String desc = request.getParameter("desc");
			Integer userID = Integer.parseInt(request.getParameter("userID"));
			System.out.println(userID);
			db.addDeck(name, desc, userID);
			System.out.println("Deck name is: " + name);
			System.out.println("Deck description is: " + desc);

		} else if (type.equals("card")) {
			String front = request.getParameter("front");
			String back = request.getParameter("back");
			String deck = request.getParameter("deck");
			db.addCard(front, back, deck);
			System.out.println("Front of card says: " + front);
			System.out.println("Back of card says: " + back);
			System.out.println("Deck name is " + deck);
		} else {
			String currDeck = request.getParameter("deck");
			System.out.println(currDeck);
			Integer currID = db.getDeckID(currDeck);
			ArrayList<Card> mycards = db.getCards(currID);
		}
	}
}
