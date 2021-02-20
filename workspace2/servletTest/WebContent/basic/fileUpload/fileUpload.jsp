<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Servlet File Upload / Download연습</title>
</head>
<body>
<h1>File Upload 연습</h1>
<hr>

<!-- 파일을 서버로 전송하기 위해서는 form의 method는 post이여야 하고, 
	 enctype="multipart/form-data" 을 추가해야 한다. -->
	 
<form method="post" enctype="multipart/form-data" 
	action="<%=request.getContextPath()%>/fileUploadServlet.do">
	ID : <input name="memid" type="text"><br><br>
	Upload File1 : <input type="file" name="file1" multiple><br><br>
	Upload File2 : <input type="file" name="file2"><br><br>
	<input type="submit" value="파일 전송">
</form>
<hr>

	<!--  업로드된 전체 파일 목록 보기 -->
<a href="<%=request.getContextPath() %>/uploadFilesServlet.do">전체 파일 업로드 현황</a>
</body>
</html>