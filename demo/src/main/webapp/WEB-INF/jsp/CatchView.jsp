<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>ServerView.java</title>
	<script src="/js/jquery-3.6.0.min.js"></script>
	<script src="/js/chart.min.js"></script>
	</head>
	<body>
		<h1>測試</h1>
		<form:form id="dataForm" style="width: 96%;margin: auto;" name="dataForm" method="post" action="/event/CatchEvent" modelAttribute="dataForm" enctype="multipart/form-data">
		<div class="div" id="div">
		<div class="block" id="block">
		
		URL:<input type="text"   class="url"name="url"/>
<!-- 		內容:<input type="text"   class="name"name="name"/>  -->
<!-- 		ID:<input type="text"   class="id"name="id"/> -->
		</div>
		</div>
<!-- 		<input type="button" value="新增"onclick="addBlock()"> -->


				<input type="submit" onclick="saveBtn()">
		</form:form>

		<!-- <input type="Button"  onclick="createtext()" value="建立DBtext檔"> -->
	</body>
	<script>
// 	var countBlock=0; 
// 	function deleteBlock(index){
// 		$("#block" + index).remove();
// 		};
// 	function addBlock(){
// 		$("#div").append(	
// 				"<div id='block"+countBlock+"'>"+
// 				"動作:<input type='text'   class='action'name='action'/>"+
// 				"內容:<input type='text'   class='name'name='name'/> "+
// 				"ID:<input type='text'   class='id'name='id'/>"+
// 				"<input type='button' value='刪除'onclick='deleteBlock("+countBlock+")'>"+
// 				"</div>"
// 		);
// 		countBlock++
// 		};
// 	function saveBtn(){		

// 		var count1 = 0;
// 		$(".action").each(function(){
// 			$(this).attr("name", "action[" + count1 + "]");
// 			count1++;
// 		});
		
// 		var count2 = 0;
// 		$(".id").each(function(){
// 			$(this).attr("name", "id[" + count2 + "]");
// 			count2++;
// 		});
// 		var count3 = 0;
// 		$(".name").each(function(){
// 			$(this).attr("name", "name[" + count3 + "]");
// 			count3++;
// 		});
// 		};

	</script>
</html>