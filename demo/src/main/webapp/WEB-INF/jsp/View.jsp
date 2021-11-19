<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>ServerView.java</title>
	<script src="/js/jquery-3.6.0.min.js"></script>
	<script src="/js/chart.min.js"></script>
	<script>
	//給死資料把Chart.js實例化，建立圖表資料
	var lineChartData = {
		    labels: ["3", "6", "9", "12", "15", "18", "21", "24", "27"], //顯示區間名稱
		    datasets: [{
		        label: '未曾使用', // tootip 出現的名稱
		        lineTension: 0, // 曲線的彎度，設0 表示直線
		        backgroundColor:"rgba(250,150,30,.3)",
		        borderColor:"#ea464d",
		        borderWidth: 1,
		        data: [10,12,147,111,50,33,150,60,130], // 資料
		        fill: true // 是否填滿色彩
				},{
				label: '罹癌後開始使用',
		        lineTension: 0,
		        fill: true,
		        backgroundColor: "rgba(68,190,190,.3)",
		        borderColor: "#29b288",
		        borderWidth: 1,
		        data: [12,14,33,133,167,34,80,80,200],
		    	}/*,{
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
	//畫圖表
	function drawLineCanvas(ctx,data) {
	    var myLine = new Chart(ctx,{//先建立一個 chart
	        type: 'line', //型態
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
	//呼叫圖表
	window.onload = function () {
		//找到canvas元素，並宣告圖表為2D
		var ctx = document.getElementById("canvas").getContext("2d");
	    drawLineCanvas(ctx,lineChartData);
	};
/*	function createtext(){
		alert("OK ! ");
		window.location.href="text/create";
		
		$.ajax({
	        type: "GET",
	        url: "text/create",
	        contentType:"application/json; charset=utf-8",
	        success: function (html) {
	            if(html==1) {alert("success ! ");}
	        },
	        error: function (error) {
	            alert(error.responseJSON.message);
	        }
	    });
	    
	}*/
    var data = {"id":1,
	        "name": "dada",
	        "cId": 4,
	        "gender": "Female",
	        "nature":"Optimistic"}
	function clickno(){
		$.ajax({
			url:"/view/getalert",
			type:"POST",
			data:JSON.stringify(data),
			contentType: "application/json;charset=utf-8",
	        dataType: "json",
			success:function(data){
				alert("Success data = "+JSON.stringify(data));
			},
			error:function(XMLHttpRequest, status, error){
				console.log(errror);
			}
			
		})
	}
	</script>
	</head>
	<body>
		<h1>Welcome</h1>
		<input type="button" value="按我顯示Alert後端值" onclick="clickno()" />
		<div>
			<canvas id="canvas" width="1900" height="850"></canvas>
		</div>
		<!-- <input type="Button"  onclick="createtext()" value="建立DBtext檔"> -->
	</body>
</html>