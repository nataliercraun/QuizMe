// Checking email and password
	function checkForm() {	
		var access = false; 
		document.getElementById("wrongEmail").innerHTML = "";
		document.getElementById("wrongPass").innerHTML = "";
        var xhttp = new XMLHttpRequest();
        var email = document.myForm.email.value;
        var pass = document.myForm2.password.value;
        xhttp.open("POST", "loginServlet?email=" + document.myForm.email.value + "&password=" + document.myForm2.password.value + "&type=signin", false);
        xhttp.send();

        var resp = xhttp.response;
        console.log(resp);
        if (resp == "email") {
            document.getElementById("wrongEmail").innerHTML = "Please enter a valid email";
        } else if (resp == "pass") {
            document.getElementById("wrongPass").innerHTML = "Please enter a valid password";
        } else {
        		access = true; 
        }
        return access; 
    }

// Validating Empty Field
	function check_empty() {
		if (document.getElementById('emailinput').value == "" || document.getElementById('passinput').value == "") {
			alert("Fill All Fields !");
		} else {
			console.log("submitting new user");
			document.getElementById('form').submit();
			var email = document.getElementById('emailinput').value;
			var pass = document.getElementById('passinput').value;
			var xhttp = new XMLHttpRequest();
	        xhttp.open("POST", "loginServlet?email=" + email + "&password=" + pass + "&type=signup", false);
	        xhttp.send();
		}
}
	
// Function To Display Popup
	function div_show() {
		document.getElementById('abc').style.display = "block";
	}
	
// Function to Hide Popup
	function div_hide(){
		document.getElementById('abc').style.display = "none";
	}

// Function to clear text areas 
	function cleartext() {
		document.getElementById('exampleInputEmail1').value = '';
		document.getElementById('exampleInputPassword1').value = '';
	}
	