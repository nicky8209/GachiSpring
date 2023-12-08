<%@ page pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<html>
	<head>
		<title>물건 등록하기</title>
	</head>
	<body>
		<h1>물건 등록하기</h1>
		<form method="POST">
			<p>제목 : <input type="text" name="title" /></p>
			<p>카테고리 : <input type="text" name="category" /></p>
			<p>가격 : <input type="text" name="price" /></p>
			<p>사진 : <input type="file" id="formFile" /></p>
			<p><input type="submit" value="저장" />
		</form>
	</body>
</html>