<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="limitedBook.model.prod.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>마이쇼핑몰(JHJ77) - 맥주자료삭제(D)</h1>
<hr>
<%
	String imageDir = "/limitedBook/image/";	

	ProdDTO prod;
	ArrayList<ProdDTO> prodList;
	ProdPageInfoVO bpiVO;
	
	bpiVO = (ProdPageInfoVO)session.getAttribute("prodPageInfoVO");
	prodList = (ArrayList<ProdDTO>)request.getAttribute("prodList");
	
	int currentPageNo = bpiVO.getCurrentPageNo();
%>

<h2>현재 DISPLAY RECORDS NUMBER : <%= bpiVO.getLimitCnt() %></h2>
<hr>
<br>
	<table border="1">
		<thead>
			<tr>
				<th>도서순번</th>
				<th>도서이름</th>
				<th>도서사진</th>
				<th>등록날짜</th>
				<th>특이사항</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody>
		
<%
	for(int i = 0; i < prodList.size(); i++){
		prod = prodList.get(i);
%>		
			<tr>
				<td><%=prod.getP_id()%></td>
				<td><%=prod.getP_name()%></td>
				<td><img src="<%=imageDir%><%=prod.getP_img()%>" width="150"/></td>
				<td><%=prod.getP_etc()%></td>
				<td><%=prod.getP_date()%></td>
				<td><a href="./ProdController.pr?actionType=D_ID&P_id=<%=prod.getP_id()%>">DELETE</a>
			</tr>
<%
	}
%>
		</tbody>
		</table>
		
<a href="./ProdController.pr?actionType2=D&currentPageNo=0">[FIRST]</a>
<%
	if( currentPageNo > 0){
%>
	<a href="./ProdController.pr?actionType2=D&currentPageNo=<%=(currentPageNo-1)%>">[PRE]</a>
<%
	}else{
%>
	[PRE]
<%
	}
	
	for(int i = bpiVO.getStartPageNo(); i < bpiVO.getEndPageNo(); i++){
		
		if( i == currentPageNo ){
%>
			[<%=(i+1)%>]
<%
		}else{
%>
			<a href="./ProdController.pr?actionType2=D&currentPageNo=<%=i%>">[<%=(i+1)%>]</a>
<%
		}
	}
%>
<%
	if( currentPageNo < bpiVO.getPageCnt() - 1 ){
%>
	<a href="./ProdController.pr?actionType2=D&currentPageNo=<%=(currentPageNo+1)%>">[NXT]</a>
<%
	}else{
%>
	[NXT]
<%
	}
%>
<a href="./ProdController.be?actionType2=D&currentPageNo=<%=(bpiVO.getPageCnt()-1)%>">[END]</a>

<br><a href="./index.jsp">홈으로 돌아가기</a>
</body>
</html>