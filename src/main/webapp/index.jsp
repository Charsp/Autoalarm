<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<div align="center">
		<h2>基础配置讲解DOC</h2>
		<form action="UploadFile" method="post" enctype="multipart/form-data">
			<table>
				<tbody>
					<tr>
						<th><span>请选择上传文件:</span></th>
						<td><input type="file" name="file"></td>
					</tr>
					<tr>
						<th><span>声音文件:</span></th>
						<td><input type="text" value="用户名" name="sound_name"></td>
					</tr>
					<tr>
						<th><span>备注填写:</span></th>
						<td><input type="text" value="用户名" name="remark"></td>
					</tr>
				</tbody>
				<caption>
					<input type="submit" value="提交文件">
				</caption>
			</table>
		</form>
	</div>
</body>
</html>
