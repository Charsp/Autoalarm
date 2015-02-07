<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring4+Mybatis3+FreeMarker</title>
<script type="text/javascript"
	src="resources/js/jquery/jquery-1.11.1.min.js"></script>
</head>
<body>
	<div align="center">
		<h2>基础配置讲解DOC</h2>
		<input type="button" id="test" value="test" />
	</div>
</body>
<script type="text/javascript">
	$(function() {
		$("#test").click(function() {
			$.ajax({
				type : "Post",
				url : "adminlogin",
				headers : {
					"Accept" : "application/xml", 
				},
				data : {
					userName : "carLocation",
					password : "123"
				},
				async : false, 
				error : function() {
					//也返回错误信息，不能更新数据
					latitude = '网络错误，位置信息获取失败';
					longitude = 0;
					Speed = 0;
					Direct = 0;
					Mileage = 0;
					alert('车辆数据错误！');
				},
				success : function(datas) {
					datas = JSON.parse(datas);
					if (datas.errcode == 0) {
						result = true;
					}
				}
			})
		});
	})
</script>
</html>