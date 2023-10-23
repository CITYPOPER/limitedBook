<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<div class="col-6 mx-auto">
		<form class="form-control" action="login" method="post">
			<label for="userId" class="form-label">아이디</label>
			<input type="text" name="user_id" id="userId" class="form-control">
			<label for="password" class="form-label">비밀번호</label>
			<input type="text" name="user_pw" id="password" class="form-control">
			<div class="d-grid">
				<button class="btn btn-primary btn-block my-3">로그인</button>
			</div>
				<button type="reset" class="btn btn-secondary ">다시입력</button>
		</form>
	</div>
</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>