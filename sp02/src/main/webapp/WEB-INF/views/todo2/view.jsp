<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		Tno <input type='text' name='tno' readonly="readonly"
			value="${todo.tno }">
	</div>
	<div>
		Title <input type='text' name='title' readonly="readonly"
			value="${todo.title }">
	</div>
	<div>
		Writer <input type='text' name='title' readonly="readonly"
			value="${todo.writer }">
	</div>
	<div>

		<button class='btn' data-oper='mod'>Modify</button>
		<button class='btn' data-oper='li'>List</button>
	</div>

	<form id='actionForm' method="get">
		<input type='hidden' name='page' value='${cri.page}'> <input
			type='hidden' name='tno' value='${todo.tno}'>
	</form>

	<div>
		<input id='reply' type='reply' name='reply' value='테스트'> <input
			id='replyer' type='replyer' name='replyer' value='tester'>
		<button id="replyBtn">Save</button>
	</div>


	<div class='replyDiv'>
		<ul class='replyUL'>

		</ul>

	</div>

	<style>
	.hide{
	display: none;
}

.popup{
	position: absolute;
	width: 300px;
	height: 300px;
	top: 10px;
	left: 50%;
	background-color: pink;
}
</style>

	<div class='popup hide'>
		<input type='text' name='rno'> <input type='text' name='reply'>
		<input type='text' name='replyer'>
		<button class='popBtn delBtn'>삭제</button>
		<button class='popBtn modBtn'>수정</button>
		<button class='popBtn cloBtn'>닫기</button>
	</div>


	<script src="https://code.jquery.com/jquery-3.2.1.min.js"
		integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
		crossorigin="anonymous"></script>

	<script>
		function getReplies() {

			var str = "";
			$.getJSON("/reply/list/1", function(arr) {

				for (var i = 0; i < arr.length; i++) {
					str += "<li data-rno ='"+arr[i].rno +"'>"+arr[i].rno
							+"  "+ arr[i].reply + "</li>";
				}
				$(".replyUL").html(str);

			});
		}

		$(".cloBtn").click(function(e) {
			$(".popup").hide("slow");
		});

		$(".replyUL").on("click", "li", function(e) {

			var rno = $(this).attr("data-rno");

			$.getJSON("/reply/" + rno, function(replyObj) {

				$(".popup input[name='rno']").val(replyObj.rno);
				$(".popup input[name='reply']").val(replyObj.reply);
				$(".popup input[name='replyer']").val(replyObj.replyer);
				$(".popup").show("slow");
			});

		});
		getReplies();

		$("#replyBtn").click(function(e) {

			console.log("button clicked");

			var data = {
				reply : $("#reply").val(),
				replyer : $("#replyer").val(), tno:95
			};

			$.ajax({
				url : '/reply/new',
				type : 'POST',
				dataType : "application/json; charset=utf-8",//받는 레코드의 타입
				data : JSON.stringify(data),
				success : function(result) {

				alert("success");	
					getReplies();
					$(".popup").hide("hide");
				}
			})
		});
		
		
		
		$(".delBtn").click(function(e){

			console.log("button clicked");

			$.ajax({
				url:"/reply/"+$(".popup input[name='rno']").val(),
				type:"DELETE",
				dataType:"application/json; charset=utf-8",
				
				success:function(result){

					getReplies();
					$(".popup").hide("hide");
	
				}
			})
		});


		
		var msg = '${result}';
		if (msg === 'modsuccess') {

			alert("수정되었습니다.");
		}

		var actionForm = $("#actionForm");

		$(".btn[data-oper='li']").click(function(e) {
			actionForm.attr("action", "/todo2/list").submit();

		});

		$(".btn[data-oper='mod']").click(function(e) {
			actionForm.attr("action", "/todo2/modify").submit();

		});
	</script>
</body>
</html>