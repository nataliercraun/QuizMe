package objects;

public class Card {

	String term;
	String definition;

	public Card(String term, String definition) {
		this.term = term;
		this.definition = definition;
	}

	public Card() {
		// TODO Auto-generated constructor stub
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public String getDefinition() {
		return definition;
	}

	public void setDefinition(String definition) {
		this.definition = definition;
	}
}
