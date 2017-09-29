<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h1>List Page</h1>
  <h2>${criteria.page}</h2>
  <h2>${criteria.total}</h2>
  <ul>
	<c:forEach items="${list}" var="todo">
	  <li><span><a class='link' href='${todo.tno}'>${todo.tno}</a></span><span>${todo.title}</span> 
	  <button class='delBtn' data-tno='${todo.tno}'>DEL</button> </li>
	</c:forEach>  
  </ul>
  
  <style>
  .pageArea li{
    list-style: none;
    margin: 1em;
    width:3em;
    text-align:center;
    color:white;
    background-color: green;
    float:left;
    border-radius:5px; 
  }
  </style>
  
  <ul class='pageArea'>
  </ul>
  
  <div>
 
 
 
  </div>
  
  <style>
  .popup {
    position: absolute;
    top:50%;
    left: 25%;
    width:200px;
    height:100px;
    margin-left: -50px;
    background-color: fuchsia;
  }
  
  .hide {
  	display:none;
  }
  
  .show {
  	display:block;
  }
  
  </style>
  
  <div class='popup hide'>
    
  </div>
 
 <form id='form1' action="/todo/view" method='get'>
   <input type='hidden' name='tno' id='tno'>
   <input type='hidden' name='page' value='${criteria.page}'>
 </form>
 
 <script
  src="https://code.jquery.com/jquery-3.2.1.min.js"
  integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
  crossorigin="anonymous"></script>
  
  
  <script type="text/javascript" src="/resources/js/paging.js"></script>
  
  <script>
  $(document).ready(function(){
	  
	  var pageStr = makePage(
		      {
		          total:${criteria.total},
		          current:${criteria.page},
		          pageSize:10
		      });
	  
	  console.log("==================");
	  console.log(pageStr);
	  
	  $(".pageArea").html(pageStr);
	  
	  $(".pageArea").on("click", function(e){
		 
		  e.preventDefault();
		  
		  var target = e.target;
		  
		  console.log(target.innerHTML);
		  
		  $("#form1")
		   .attr("action", "/todo/list")
		   .find("input[name='page']")
		   .val(target.innerHTML);
		  
		  $("#form1").submit();
		  
		  console.log($("#form1").find("input[name='page']") );
		  
	  });
	  
	  
	  $(".delBtn").on("click", function(e){
		 
		  var $this = $(this);
		  var tno = $this.attr("data-tno");
		  
		  
		  $("#tno").val(tno);
		  $("#form1").attr("action","/todo/remove").submit();
		  
	  });
	  
	  $(".link").on("click", function(e){
		 e.preventDefault();
		 console.log("move..........");
		 
		 var $this = $(this);
		 var tno = $this.attr("href");
		 
		 console.log("tno: " + tno);
		 
		 $("#tno").val(tno);
		 $("#form1").submit();
		 
	  });
	  
  });
  
  </script>
  
  
  <script>
  
  var msg = '${result}';
  
  if(msg ==='success'){
	  document.querySelector(".popup").setAttribute("class", "popup show");
  }
  
  
  
  
  </script>
  
</body>
</html>