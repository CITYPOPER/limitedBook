<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-light shadow">
        <div class="container d-flex justify-content-between align-items-center">

            <a class="navbar-brand text-success logo h1 align-self-center" href="index.jsp">
                limited Book
            </a>

            <button class="navbar-toggler border-0" type="button" data-bs-toggle="collapse" data-bs-target="#templatemo_main_nav" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="align-self-center collapse navbar-collapse flex-fill  d-lg-flex justify-content-lg-between" id="templatemo_main_nav">
                <div class="flex-fill">
                    <ul class="nav navbar-nav d-flex justify-content-between mx-lg-auto">
                        <li class="nav-item">
                            <a class="nav-link" href="index.jsp">온라인 경매</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="about.jsp">인기 경매</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="shop.jsp">신규 경매</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="contact.jsp">서적 등록</a>
                        </li>
                    </ul>
                </div>
                <div class="navbar align-self-center d-flex">
                    <div class="d-lg-none flex-sm-fill mt-3 mb-4 col-7 col-sm-auto pr-3">
                        <div class="input-group">
                            <input type="text" class="form-control" id="inputMobileSearch" placeholder="Search ...">
                            <div class="input-group-text">
                                <i class="fa fa-fw fa-search"></i>
                            </div>
                        </div>
                    </div>
                    <a class="nav-icon d-none d-lg-inline" href="#" data-bs-toggle="modal" data-bs-target="#templatemo_search">
                        <i class="fa fa-fw fa-search text-dark mr-2"></i>
                    </a>
                    <a class="nav-icon position-relative text-decoration-none" href="#">
                        <i class="fa fa-fw fa-cart-arrow-down text-dark mr-1"></i>
                        <span class="position-absolute top-0 left-100 translate-middle badge rounded-pill bg-light text-dark">0</span>
                    </a>
                    <a class="nav-icon position-relative text-decoration-none" href="#">
                        <i class="fa fa-fw fa-user text-dark mr-3"></i>
                        <span class="position-absolute top-0 left-100 translate-middle badge rounded-pill bg-light text-dark">+99</span>
                    </a>
                </div>
                <div class="col-md-3 text-end">
                <%
					if( session.isNew()){
						session.setAttribute("loginState", "logout");
						session.setAttribute("mem_id", null);
						session.setAttribute("mem_passwd", null);
					}
				
				
					if(session.getAttribute("loginState").equals("login")){
				%>
					<%=session.getAttribute("id")%>님 로그인중.
					<form name="logout" method="post" action="./SignController.si">
					  <input type="hidden" name="actionType" value="LOGOUT">
					  <input type="submit" class="btn btn-secondary" value="로그아웃">
					</form> 
				<%
					}
					else{
				%>
                    <button type="button" class="btn btn-outline-primary me-2" onclick="location.href='./login.jsp'">Login</button>
                    <button type="button" class="btn btn-primary" onclick="location.href='./signup.jsp'">Sign-up</button>
                <%  
                    }
                %>
                </div>
            </div>

        </div>
    </nav>
</body>
</html>