<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="limitedBook.model.prod.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>

<%
	ProdPageInfoVO bpiVO;
	bpiVO = (ProdPageInfoVO)session.getAttribute("prodPageInfoVO");
	int limitCnt;
	
	if( bpiVO == null)
		limitCnt = 10;
	else
		limitCnt = bpiVO.getLimitCnt();
%>

<%-- <h2>현재 DISPLAY RECORDS NUMBER : <%= limitCnt %></h2> --%>
<hr>
<form method="post" action="./ProdController.pr?actionType2=R_DRC">
	페이징수 변경 :
	<select name="displayRecordCnt">
		<option SELECTED value="10">10</option>
		<option value="20">20</option>
		<option value="50">50</option>
		<option value="100">100</option>
	</select>
	<input type="hidden" name="currentPageNo" value="0">
	<input type="submit" value="확인">
</form>

</body>
</html>