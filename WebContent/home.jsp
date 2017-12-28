<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="objects.User"%>
<%@ page import="objects.DBmanager"%>
<%@ page import="objects.Deck"%>
<%@ page import="objects.Card"%>
<%@ page import="java.util.ArrayList"%>
<html>
<% 
	if ((session.getId() == null)){
		request.getRequestDispatcher("index.jsp").forward(request, response);
		return;
	}
	User user = (User) session.getAttribute("user");
	DBmanager db = (DBmanager) session.getAttribute("manager");
%>
<head>
    <meta charset="UTF-8">
    <!-- BOOTSTRAP HEAD SECTION -->
    <!-- IE Edge Meta Tag -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <!-- Viewport -->
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

    <!-- Optional Theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
    
     <!-- Home page JavaScript -->
    <script type="text/javascript" src="home.js"></script>
    
    <!-- Home page stylesheet -->
    <link rel="stylesheet" href="home.css">
    
    <title>Home Page</title>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <section class="col-md-12" id="colorStrip">
            <h1 id="title"> QuizMe </h1>
            
        </section>
    </div>
    <div class="row"> 
    		<section class="col-md-12" id="currUserSection"> 
    			<h2 id="currUser"> <%=user.getEmail() %></h2>
    			<div id="userID" style="color: white"><%=user.getID()%></div>
    			<div id="logout" > 
    				<a href="index.jsp"> Logout </a>
    			</div>
    			<script> console.log(document.getElementById('userID').innerHTML)</script>
    		</section>
    </div>
    <div class="row" style="padding-bottom: 125px">
    </div>
    <div class="row"> 
	    <section class="col-md-6" id="btnz">
	        	<!-- Display Popup Button -->
	        	<h2 style="text-align: center; background-color: white"> Create </h2>
	        	<br> 
			<button id="newcardBtn" onclick="div_show()" class="btn btn-warning btn-lg"> New Card </button>
			<br> 
			<br> 
	    		<button id="newdeckBtn" onclick="div_show_deck()" class="btn btn-warning btn-lg"> New Deck </button>
	    </section>
	    <section class="col-md-6">
	    		<h2 style="text-align: left;background-color: white"> Select Deck </h2>
	    		<br> 
	    		<select id="deckDrop">
				<% ArrayList<Deck> mydecks = db.getDecks(user.getID()); %>
				<% for (int i=0; i<mydecks.size();i++) { %>
					 <option id="selectedDeck" value="<%=mydecks.get(i).getName()%>"><%=mydecks.get(i).getName()%></option>
				<%} %>
			</select>
			<br> 
			<br> 
			<button id="learnBtn" onclick="div_show_learn()" class="btn btn-success btn-lg"> Learn </button>
	    </section>
    	</div>
     <div id="abc">
		<!-- Popup Div Starts Here -->
		<div id="popupContact">
			<!-- Contact Us Form -->
			<form action="#" id="form" method="post" name="form">
				<img id="close" src="https://openclipart.org/image/800px/svg_to_png/183568/close-button.png" onclick ="div_hide()">
				<h2> Create Card </h2>
				<hr>
				<input id="cardFront" name="cardFront" placeholder="Term" type="text">
				<textarea id="cardBack" name="cardBack" placeholder="Definition"></textarea> 
				<h2 style="text-align: left; font-size: 20px; padding-left: 50px"> Choose Deck </h2>
				<select id="pickDeck" onchange='someFunc();'>
					<% for (int i=0; i<mydecks.size();i++) { %>
						 <option id="selectedDeck" value="<%=mydecks.get(i).getName()%>"><%=mydecks.get(i).getName()%></option>
					<%} %>
				</select>
				<br> 
				<br> 
				<a onclick="check_empty()" id="submit">Add</a>
			</form>
		</div>
		<!-- Popup Div Ends Here -->
	</div>
	 <div id="def">
		<!-- Popup Div Starts Here -->
		<div id="popupContact">
			<!-- Contact Us Form -->
			<form action="#" id="form" method="post" name="form">
				<img id="close" src="https://openclipart.org/image/800px/svg_to_png/183568/close-button.png" onclick ="div_hide_deck()">
				<h2> Create Deck </h2>
				<hr>
				<input id="deckName" name="deckName" placeholder="Name" type="text">
				<textarea id="deckDesc" name="deckDesc" placeholder="Description"></textarea> 
				<br> 
				<a onclick="check_empty_deck()" id="submit">Add</a>
			</form>
		</div>
		<!-- Popup Div Ends Here -->
	</div>
	 <div id="ghi" style="display: none">
		<!-- Popup Div Starts Here -->
		<div id="popupContact">
			<img id="close" src="https://openclipart.org/image/800px/svg_to_png/183568/close-button.png" onclick ="div_hide_learn()">
			<h2> Blah blah blah </h2>
			<hr>
		</div>
		<!-- Popup Div Ends Here -->
	</div>
</div>

<!-- FOOTER SECTION - Before closing </body> tag -->

<!-- jQuery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

<!-- Minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>
