package objects;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

	ArrayList<Card> cards;
	String name;
	String description;

	public Deck() {
		cards = new ArrayList<Card>();
	}

	public void addCard(Card newCard) {
		cards.add(newCard);
	}

	public void shuffle() {
		Collections.shuffle(cards);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
