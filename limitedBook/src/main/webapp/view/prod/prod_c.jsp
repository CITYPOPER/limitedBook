<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id=title>
	<h3>쇼핑몰 상품 등록</h3>
</div>
<div align="center">
<form name=f1 action="./ProdController.pr"
	  method=post enctype="multipart/form-data">
	  <table border=1 id=tabel4>
	  	<tr><td>도서코드</td><td><input type=text name=p_code size=6></td></tr>
	  	<tr><td>도서이름</td><td><input type=text name=p_name size=20></td></tr>
	  	<tr><td>도서사진</td><td><input type=file name=p_img></td></tr>
	  	<tr><td>특이사항</td><td><textarea rows="5" cols="30" name=p_etc></textarea></td></tr>
	  	<tr><td>등록날짜</td><td><input type=text name=p_date></td></tr>
	  	<tr><td colspan=2 align="center"><input type=submit value=등록> &emsp;
	  	<input type="hidden" name="actionType" value="C">
	  </table>
</form>
</div>
</body>
</html>