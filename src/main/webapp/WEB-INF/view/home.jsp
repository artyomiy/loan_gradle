<!DOCTYPE HTML>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>	
  	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
		
	<c:url value="/css/simple-slider.css" var="cssURL1" />  
    <link rel="stylesheet" type="text/css" media="screen" href="${cssURL1}" />  
    <c:url value="/css/simple-slider-volume.css" var="cssURL2" />  
    <link rel="stylesheet" type="text/css" media="screen" href="${cssURL2}" /> 
    <c:url value="js/simple-slider.js" var="cssURL3" />   
 	<script src="${cssURL3}"></script>
  	<style>
	  body { font-family: "Helvetica Neue", Helvetica, Arial, sans-serif; }
	  [class^=slider] { display: inline-block; margin-bottom: 30px; }
	  .output { color: #888; font-size: 14px; padding-top: 1px; margin-left: 5px; vertical-align: top;}
	  h1 { font-size: 20px; }
	  h2 { clear: both; margin: 0; margin-bottom: 5px; font-size: 16px; }
	  p { font-size: 15px; margin-bottom: 30px; }
	  h2:first-of-type { margin-top: 0; }
  	</style>

    <title>Sample Application</title>
  </head>
  <body>
    <h1>Hello, ${name}!</h1>
    
		<form id="loanForm" action='/loanForm' method="post" >
		  	<h3>Loan amount</h3>
		  	<input type="text" name="amount" data-slider="true" data-slider-range="100,500" data-slider-step="100" data-slider-snap="true">
		  	<h3>For month:</h3>
	  		<input type="text" name="termMonth" data-slider="true" data-slider-range="1,12" data-slider-step="1" data-slider-snap="true">
	  		<BR/>
		  	<input type="submit" value="Get loan">
  		</form>
  	<script>
	  $("[data-slider]")
	    .each(function () {
	      var input = $(this);
	      $("<span>")
	        .addClass("output")
	        .insertAfter($(this));
	    })
	    .bind("slider:ready slider:changed", function (event, data) {
	      $(this)
	        .nextAll(".output:first")
	          .html(data.value.toFixed(0));
	    });
	  
  	</script>
  </body>
</html>