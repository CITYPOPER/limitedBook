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

<%
	ProdDTO prod;
	ArrayList<ProdDTO> prodList;
	ProdPageInfoVO bpiVO;	
	
	bpiVO = (ProdPageInfoVO)session.getAttribute("prodPageInfoVO");
	prodList = (ArrayList<ProdDTO>)request.getAttribute("prodList");
	
	int currentPageNo = bpiVO.getCurrentPageNo();
%>

	<table border="1">
		<thead>
			<tr>
				<th>도서순번</th>							
				<th>도서코드</th>							
				<th>도서이름</th>				
				<th>도서사진</th>				
				<th>등록날짜</th>				
				<th>특이사항</th>				
				<th>수정</th>				
				<th>삭제</th>				
			</tr>
		</thead>
		<tbody>
		
<%
		String imageDir = "/limitedBook/image/";

 	for(int i = 0; i < prodList.size(); i++){
		prod = prodList.get(i); 		
		
%>
			<tr>
				<td><%=prod.getP_id()%></td>
				<td><%=prod.getP_code()%></td>
				<td><%=prod.getP_name()%></td>
				<td><img src="<%=imageDir%><%=prod.getP_img()%>" width="150"/></td>
				<td><%=prod.getP_etc()%></td>
				<td><%=prod.getP_date()%></td>
				<td><a href="./ProdController.pr?actionType2=U2&p_id=<%=prod.getP_id()%>">UPDATE</a>
				<td><a href="./ProdController.pr?actionType2=D_ID&p_id=<%=prod.getP_id()%>">DELETE</a>
			</tr>
<%
	}
%>		
		
		</tbody>
	</table>
	
	<a href="./ProdController.pr?actionType2=R4&currentPageNo=0">[FIRST]</a>
<%
	if( currentPageNo > 0){
%>
	<a href="./ProdController.pr?actionType2=R4&currentPageNo=<%=(currentPageNo-1)%>">[PRE]</a>
<%
	}else{
%>
	[PRE]
<%
	}

	for(int i = bpiVO.getStartPageNo(); i < bpiVO.getEndPageNo(); i++ ){
		
		if( i == currentPageNo){
%>
			[<%=(i+1)%>]
<%
		}else{
%>
			<a href="./ProdController.pr?actionType2=R4&currentPageNo=<%=i%>">[<%=(i+1)%>]</a>
<%
		}
	}
%>
<%
	if( currentPageNo < bpiVO.getPageCnt() - 1){
%>
	<a href="./ProdController.pr?actionType2=R4&currentPageNo=<%=(currentPageNo+1)%>">[NXT]</a>
<%
	}else{
%>
	[NXT]
<%
	}
%>
<a href="./ProdController.pr?actionType2=R4&currentPageNo=<%=(bpiVO.getPageCnt()-1)%>">[END]</a>

</body>
</html>