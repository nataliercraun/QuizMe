// Validating Empty Field
	function check_empty() {
		if (document.getElementById('cardFront').value == "" || document.getElementById('cardBack').value == ""
			|| document.getElementById('selectedDeck').value == "") {
			alert("Fill All Fields !");
		} else {
			console.log("submitting new user");
			document.getElementById('form').submit();
			var front = document.getElementById('cardFront').value;
			var back = document.getElementById('cardBack').value;
			var decks = document.getElementById('pickDeck'); 
			var deck = decks.options[decks.selectedIndex].value;
			alert(deck);
			var type = "card";
			var xhttp = new XMLHttpRequest();
	        xhttp.open("POST", "CardServlet?front=" + front + "&back=" + back + "&type=" + type + "&deck=" + deck, false);
	        xhttp.send();
		}
}
	
// Validating Empty Field
	function check_empty_deck() {
		if (document.getElementById('deckName').value == "" || document.getElementById('deckDesc').value == "" 
			|| document.getElementById('userID').innerHTML == "") {
			alert("Fill All Fields !");
		} else {
			console.log("submitting new user");
			document.getElementById('form').submit();
			var name = document.getElementById('deckName').value;
			var desc = document.getElementById('deckDesc').value;
			var userid = document.getElementById('userID').innerHTML;
			var type = "deck";
			var xhttp = new XMLHttpRequest();
	        xhttp.open("POST", "CardServlet?name=" + name + "&userID=" + userid + "&desc=" + desc + "&type=" + type, false);
	        xhttp.send();
		}
}
	
// Pop-up to flip through deck 
	function div_learn() {
		if (decks.options[decks.selectedIndex].value == "") {
			alert("Please select a deck");
		} else {
			var userid = document.getElementById('userID').innerHTML;
			var deck = decks.options[decks.selectedIndex].value;
			var type = "learn";
			var xhttp = new XMLHttpRequest();
			xhttp.open("POST", "CardServlet?deck=" + deck + "&userID=" + userid + "&type=" + type, false);
	        xhttp.send();
	       // This should set the session's ArrayList<Card> to the selected 
	        // decks cards 
		}
	}

// Move to next card in deck 
	function nextCard() {
		
	}
	
// Function To Display Card Popup
	function div_show() {
		document.getElementById('abc').style.display = "block";
	}
	
// Function to Hide Card Popup
	function div_hide(){
		document.getElementById('abc').style.display = "none";
	}
	
// Function To Display Deck Popup
	function div_show_deck() {
		document.getElementById('def').style.display = "block";
	}
	
// Function to Hide Deck Popup
	function div_hide_deck(){
		document.getElementById('def').style.display = "none";
	}
	
// Function To Display Learn Popup
	function div_show_learn() {
		if (document.getElementById('selectedDeck').value == "") {
			alert("Fill All Fields !");
		} else {
			var decks = document.getElementById('pickDeck').selectedIndex; 
			alert(decks);
			var deck = decks.options[decks].value;
			var type = "learn";
			var xhttp = new XMLHttpRequest();
			xhttp.open("POST", "CardServlet?deck=" + deck + "&type=" + type, false);
	        xhttp.send();
	       // This should set the session's ArrayList<Card> to the selected 
	        // decks cards 
		}
		document.getElementById('ghi').style.display = "block";
	}
	
// Function to Hide Learn Popup
	function div_hide_learn() {
		document.getElementById('ghi').style.display = "none";
	}

// change dropdown select
	function someFunc(){
		   alert("called");
		   //var myindex  = dropdown.selectedIndex;// This prints correctly
		   alert("Index : "+document.getElementById("pickDeck").selectedIndex);// This is always 0 no metter what selects        
		}
