<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
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

    <!-- My stylesheet -->
    <link rel="stylesheet" href="login.css">
    
    <!-- My JavaScript -->
    <script type="text/javascript" src="login.js"></script>
    
    <title>Login</title>
</head>
<body>
<div class="container-fluid">
    <div class="row" id="ltblue">
        <section class="col-md-7" id="colorStrip">
            <h1 id="title"> QuizMe. </h1>
        </section>
        <section class="col-md-2" id="emailForm"> 
	        <form id="myform" name="myForm">
                <div class="form-group">
                    <label for="exampleInputEmail1">Email address</label>
                    <input type="text" name="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email"> 
                </div>
            </form>
        </section>
        <section class="col-md-2" id="passForm">
        		<form id="myform" name="myForm2" action="home.jsp" onsubmit="return checkForm()">
                <div class="form-group">
                    <label for="exampleInputPassword1">Password</label>   
                    <input type="text" name="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
                    <br> 
                    <br> 
                    	<button id="loginButton" type="submit" class="btn btn-lg">Login</button>   
                </div>
           </form>
        </section>
         <section class="col-md-1" id="btnz">
         	<div id="clrbutton">
         		<button onclick="cleartext()" class="btn btn-lg"> Clear </button>
         	</div>
         	<br> 
         	<br> 
         	<!-- Display Popup Button -->
			<button onclick="div_show()" class="btn btn-lg">Sign Up </button>
        </section>
    </div>
    <div class="row">
    		<section class="col-md-7"></section>
    		<section class="col-md-2" style="padding-top: 10px">
    			<div id="wrongEmail" style="font-family: Futura; color: red; font-size: 15px"></div>
    		</section>
    		<section class="col-md-2" style="padding-top: 10px">
    			<div id="wrongPass" style="font-family: Futura; color: red; font-size: 15px"></div>
    		</section>
     </div>
    <div class="row" style="padding-bottom: 125px">
    </div>
    <div class="row">
        <section class="col-md-5">
            <table>
                <tr>
                    <td id="siteDescription"> Simple tools for learning anything. </td>
                </tr>
                <tr>
                    <td id="siteDescriptionSml"> Create your own study sets to improve your grades and limit paper waste. </td>
                </tr>
            </table>
        </section>
        <section class="col-md-2">            
        </section>
        <section class="col-md-5"></section>
    </div>
    <div id="abc">
		<!-- Popup Div Starts Here -->
		<div id="popupContact">
			<!-- Contact Us Form -->
			<form action="#" id="form" method="post" name="form">
				<img id="close" src="https://openclipart.org/image/800px/svg_to_png/183568/close-button.png" onclick ="div_hide()">
				<h2> Create Account </h2>
				<hr>
				<input id="emailinput" name="email" placeholder="Email" type="text">
				<input id="passinput" name="pass" placeholder="Password" type="text"> 
				<br> 
				<br> 
				<a onclick="check_empty()" id="submit">Submit</a>
			</form>
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
