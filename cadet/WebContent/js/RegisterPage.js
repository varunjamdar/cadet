var RecaptchaOptions = {
		    theme : 'clean'
		 };

$(document).ready(function(e) {
	populateUserCategories();	
});
	function populateUserCategories(){
	$.ajax({
		url:"GetUserCategories",
		type: 'POST',
		async:false,
		success:function(result){
			$("#usercategory").html(result);
		}
	});
}


  function validate() {
	  
	  var username = document.getElementById("Username").value;
	  var password = document.getElementById("Password");
	  var password2 = document.getElementById("Password2");
	  
	  var username_error = document.getElementById("username_error");
	  var password_error = document.getElementById("password_error");
	  var name_error = document.getElementById("name_error");
	  var contact_error = document.getElementById("contact_error");
	  
	  username_error.innerHTML="";
	  
	  if(!$("#regform").valid()){
		  return false;
	  }
	  
	  if(Ajax_username("isUserNameAvailable?username="+username, "username_error")==false){
		  return false;
	  }
	  
	  var challenge=document.getElementById("recaptcha_challenge_field").value;
	  var response=document.getElementById("recaptcha_response_field").value;
	  var message = "recaptcha_challenge_field="+challenge+"&recaptcha_response_field="+response;
	if( Ajax("VerifyCaptcha?"+message,"captchaerror")==false){
		return false;
	}
	
	password.value = hashmap(password.value);
	password2.value = hashmap(password2.value);
}
  
  function hashmap(input){
		var shaobj = new jsSHA(input,"ASCII");
		var hash = shaobj.getHash("SHA-512", "HEX");
		return hash;
	}
  
  function Ajax(url,div)
  {
  var xmlhttp;
  if (window.XMLHttpRequest)
    {// code for IE7+, Firefox, Chrome, Opera, Safari
    xmlhttp=new XMLHttpRequest();
    }
  else
    {// code for IE6, IE5
    xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
  xmlhttp.open("GET",url,false);
  xmlhttp.send();
  if(xmlhttp.status==200){
	  if(xmlhttp.responseText.substring(0,4)=="true"){
		  return true;
	  }else{
		  document.getElementById(div).innerHTML="Invalid Captcha";
		  return false;
	  }
  }else{
	  document.getElementById(div).innerHTML="Invalid Captcha";
	  return false;
  }
  }
  
  function Ajax_username(url,div)
  {
  var xmlhttp;
  if (window.XMLHttpRequest)
    {// code for IE7+, Firefox, Chrome, Opera, Safari
    xmlhttp=new XMLHttpRequest();
    }
  else
    {// code for IE6, IE5
    xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
  xmlhttp.open("GET",url,false);
  xmlhttp.send();
  if(xmlhttp.status==200){
		  return true;
  }else{
	  document.getElementById(div).innerHTML="UserName not Available";
	  return false;
  }
  }