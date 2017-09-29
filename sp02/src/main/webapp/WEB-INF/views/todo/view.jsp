<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  ${cri.page}
  
  <span>${todo.title }</span>
  <span>${todo.title }</span>
  <span>${todo.title }</span>
  
  <span><fmt:formatDate value="${todo.regdate }" pattern="yyyy-MM-dd"/></span>
  
  <button class='btn' data-oper='md'>Mod OR Del</button>
  <button class='btn' data-oper='li'>Go List</button>
  
  <form class='f1' method="get" >
    <input type='hidden' name='page' value='${cri.page}'>
    
  </form>
  
   <script
  src="https://code.jquery.com/jquery-3.2.1.min.js"
  integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
  crossorigin="anonymous"></script>
  
  <script>
  $(document).ready(function(){
	  
	  var formObj = $(".f1")
	  
	  $(".btn").click(function(e){
		 
		  var $this = $(this);
		  var oper = $this.attr("data-oper");
		  
		  if(oper  === 'li'){
			 formObj.attr("action","/todo/list");
		  }else if(oper === 'md'){
			 formObj.append("<input type='hidden' name='tno' value='${todo.tno}'>"); 
			 formObj.attr("action","/todo/modify"); 
		  }
		  
		  formObj.submit();
	  });
	  
  });
  </script>
  
</body>
</html>