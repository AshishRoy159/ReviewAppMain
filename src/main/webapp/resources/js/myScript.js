/**
 * 
 */


function validate(){
	var pass1 = document.getElementById("pass1").value;
	var pass2 = document.getElementById("pass2").value;
	if(pass1 != pass2){
		alert("Passwords do not match!!"+$(".asd"));
		return false;
	}
}

//$(".asd").click(function() {
//  alert( "Handler for .click() called." );
//});

function clicktest(){
	alert("Hello");
}


var active = document.getElementById('and')
if(active != null){
	$(function(){
		$('.and').addClass('active');
	});
}
var active2 = document.getElementById('ios')
if(active2 != null){
	$(function(){
		$('.ios').addClass('active');
	});
}
var active3 = document.getElementById('win')
if(active3 != null){
	$(function(){
		$('.win').addClass('active');
	});
}
var active4 = document.getElementById('home')
if(active4 != null){
	$(function(){
		$('.home').addClass('active');
	});
}

