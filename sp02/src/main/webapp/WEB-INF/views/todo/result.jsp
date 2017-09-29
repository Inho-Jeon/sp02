<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${todoDTO }</h1>
	<h2>${result }</h2>
	<form method="get">

<button>Register</button>
</form>
	<script type="text/javascript">
	
	setTimeout(function() { window.location="/todo/list" },500);
	//0.5초 간격으로 결과창 띄우고 list페이지로 이동하는 것을 의미한다.
	
	</script>
</body>
</html>