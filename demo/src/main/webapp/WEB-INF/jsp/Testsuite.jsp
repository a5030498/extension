<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>TestsuiteView.java</title>
	<script src="/js/jquery-3.6.0.min.js"></script>
	<script src="/js/chart.min.js"></script>
	
	<script>
	var fromval = 1;
    var data = {"id":1,
	        "name": "dada",
	        "cId": 4,
	        "gender": "Female",
	        "nature":"Optimistic"}
	function clickquery(){
    	debugger;
		var userid = $("#userid").val();
		if(userid == ''){
			alert("請輸入ID"); return;
		}
		var name = $("#name").val();
		console.log(userid+"；"+name);
		var user = {
				"userid":userid,
				"name":name}
		$.ajax({
			url:"/testsuite/querysuite",
			type:"POST",
			data:JSON.stringify(user),
			contentType: "application/json;charset=utf-8",
			success:function(data){
				alert("Success data = "+ data);
			},
			error:function(e){
				console.log(e);
			}
			
		})
	}
	function clickadd(){
		var userid = $("#userid").val();
		if(userid == ''){
			alert("請輸入ID"); return;
		}
		var name = $("#name").val();
		var description = $("#description").val();
		console.log(userid + "；"+name + ";" + description);
		var user = {
				"userid":userid,
				"name":name,
				"description":description}
		$.ajax({
			url:"/testsuite/createtestsuite",
			type:"POST",
			data:JSON.stringify(user),
			contentType: "application/json;charset=utf-8",
			success:function(data){
				alert("Success data = "+ data);
			},
			error:function(e){
				console.log(e);
			}
			
		})
	}
	function QueryorCreate(){
		if(fromval == 1){
			$("#Query").css({"display":"none"});
			$("#Create").css({"display":"block"});
			fromval = 2;
		}else{
			$("#Query").css({"display":"block"});
			$("#Create").css({"display":"none"});
			fromval = 1;
		}
	}
	function detailclick(id){
		window.location.href = "/testcase/"+id;
	}
/**------------------------圖表js------------------------------------------------------------------------------------------------------**/
	var alldata = ${count};
	var errordata = ${errorcount};
	//var namedata = ${namedata};
	
	var lineChartData = {
			labels: ${namedata},//["name1","name2","name3"], //顯示區間名稱
		    datasets: [{
				label: 'suite數量',
		        lineTension: 0,
		        fill: true,
		        backgroundColor: "rgba(68,190,190,.3)",
		        borderColor: "#29b288",
		        borderWidth: 1,
		        data: alldata,
		    	},{
		        label: '錯誤', // tootip 出現的名稱
		        lineTension: 0, // 曲線的彎度，設0 表示直線
		        backgroundColor:"rgba(250,150,30,.3)",
		        borderColor:"#ea464d",
		        borderWidth: 1,
		        data: errordata, // 資料
		        fill: true // 是否填滿色彩
				},/*,{
				label: '一半使用一半未使用',
		        lineTension: 0,
		        fill: true,
		        backgroundColor: "rgba(33,40,53,.3)",
		        borderColor: "#6e6273",
		        borderWidth: 1,
		        data: [180,150,166,41,39,192,99,73,20],
		    	}*/
		]
	};
	var data = {"id":1,
	        "name": "dada",
	        "cId": 4,
	        "gender": "Female",
	        "nature":"Optimistic"}
	
	function drawLineCanvas(ctx,data) {
	    var myLine = new Chart(ctx,{//先建立一個 chart
	        type: 'bar', //型態
	        data: data,
	        options:{
				plugins:{
	        		title:{
						display: true,
						text:'Custom Chart Title',
						color:'blue'
			        },
			        legend:{//是否要顯示圖示
						display: true,
						labels: {
							boxWidth: 40,
							fontColor: 'rgb(60, 180, 100)'
						}
					}/*,
					tooltips:{
						caretSize:50,
					},*/
				},
				responsive:false,
				animations:{
					tension:{
					  duration:1000,
					  easing:'linear',
					  from:1,
					  to:0,
					  loop:true
					}
				},
				scales:{//是否要顯示 x、y 軸
					x:{
						grid: {
							tickColor:'red'
						},
						ticks: {
							color:'blue'
						},/*
						title{
							text:"天數"
						}*/
					},
					y:{
						grid: {
							tickColor: 'Blue'
						},
						ticks: {
							color: 'Red'
						}/*,
						title:{
							text:"使用次數"
						}*/
					}
                    /*,xAxes: [{
                        display: true
                    }],
                    yAxes: [{
                        display: true
                    }]*/
				}
			}
	    });
	};

	window.onload = function () {
		//找到canvas元素，並宣告圖表為2D
		var ctx = document.getElementById("canvas").getContext("2d");
	    drawLineCanvas(ctx,lineChartData);
	};
	</script>
	</head>
	<body style="background-color:#f1f1f1">
		<input type="hidden" value="${count}" />
		<input type="hidden" value="${errorcount}" />
		<input type="hidden" value="${Name}" />
		<h1>Welcome</h1>
		<div id="changefrom">
			<input type="hidden" value="Query or Create" onclick="QueryorCreate()"/>
		</div>
		<%--<div id = "Query" style="display:block;padding-top:30px;padding-left:50px;width:1000px;height:100px;margin-top:50px;background-color:green;">
			<p>Query</p>
			UserName：
			<input type="text" id="username" value="kazma">
			UserE-Mail：
			<input type="text" id="useremail" value="kazmali@gmail.com">
			UserPassword：
			<input type="text" id="userpwd" value="1234567">
			<input type="button" value="queryUser" onclick="clickquery()"/>
			<input type="hidden" value="createUser" onclick="clickadd()">
		</div>
		<div id = "Create" style="display:none;padding-top:30px;padding-left:50px;width:1000px;height:100px;margin-top:50px;background-color:orange;">
			<p>Create</p>
			userid：
			<input type="text" id="userid" value="">
			name：
			<input type="text" id="name" value="">
			description：
			<input type="text" id="description" value="">
			<input type="hidden" value="querytestSuite" onclick="clickquery()" />
			<input type="button" value="createtestSuite" onclick="clickadd()">
		</div> --%>
		<div id="topflow" style="display:flex;width:100%;height:450px; background-color:bisque;margin-bottom:20px;">
			<canvas id="canvas" width="950px" height="450px" style="margin-left:50px;" ></canvas>
			<div style="flex:1;width:50px;">
				<table border='1' style="width: 20%;border:3px #FFD382 dashed;margin-left:100px;">
					<p style="margin-left:150px;margin-top:150px;">日期區間為：${rightnow}</p>
					<c:forEach var="checkStatusItem2" items="${Data}" varStatus="loop">
						<tr>
							<td style="background-color:#bfa145">Userid</td>
							<td style="width:1%;background-color: bisque" class="boxTitle">${checkStatusItem2.id}</td>
						</tr>
						<tr>
							<td style="background-color:#bfa145">Username</td>
							<td style="width:10%;background-color: bisque" class="boxTitle">${checkStatusItem2.name}</td>
						</tr>
						<tr>
							<td style="background-color:#bfa145">Useremail</td>
							<td style="width:10%;background-color: bisque" class="boxTitle">${checkStatusItem2.email}</td>
						</tr>
						<tr>
							<td style="background-color:#bfa145">Userpassword</td>
							<td style="width:10%;background-color: bisque" class="boxTitle">${checkStatusItem2.password}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
		
		<div style="width:100%;height:5px;background-color:#FF7F50;margin-bottom:20px;"></div>
		<table border='1' style="width:50%;border:3px #FFD382 dashed;margin-left:50px;">
			<th>Users</th>
			<tr>
				<td style="background-color:#bfa145">ID</td>
				<td style="background-color:#bfa145" align="center">使用者Id</td>
				<td style="background-color:#bfa145" align="center">套件名稱</td>
				<td style="background-color:#bfa145">新增日期</td>
				<td style="background-color:#bfa145">描述</td>
				<td align="center" style="background-color:#bfa145">詳細內容</td>
			</tr>
			<c:forEach var="checkStatusItem" items="${Datasuite}" varStatus="loop">
				<tr>
					<td style="width:1%;background-color: bisque" class="boxTitle">${checkStatusItem.id}</td>
					<td align="center" style="width:6%;background-color: bisque" class="boxTitle">${checkStatusItem.usersid}</td>
					<td align="center" style="width:20%;background-color: bisque" class="boxTitle">${checkStatusItem.name}</td>
					<td style="width:20%;background-color: bisque" class="boxTitle">${checkStatusItem.createdate}</td>
					<td style="width:25%;background-color: bisque" class="boxTitle">${checkStatusItem.description}</td>
					<td align="center" style="width:25%;background-color: bisque" class="boxTitle">
						<input type="button" style="align:center" value="Detail" onclick="detailclick(${checkStatusItem.id})">
					</td>
					<td align="center" style="width:0.4%;border:none;" class="boxTitle">
						<c:if test="${checkStatusItem.status=='y'}">
							<img src="img/索引1.jpg" height="20px" weight="20px;" /></c:if>
						<c:if test="${checkStatusItem.status=='n'}">
							<img src="img/索引.jpg" height="20px" weight="20px;" /></c:if>
					</td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>