<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

    <%@ include file="../layout/header.jsp" %>

        <head>
            <link href="/css/joinForm.css" rel="stylesheet">
        </head>

        <main class="form-signin w-100 m-auto">
            <form>
                <h1 class="h3 mb-3 fw-normal">기본 정보 입력</h1>

                <div class="form-floating">
                    <input type="email" class="form-control" id="floatingInput" placeholder="name@example.com">
                    <label for="floatingInput">Email</label>
                </div>
                <div class="form-floating">
                    <input type="password" class="form-control" id="floatingPassword" placeholder="Password">
                    <label for="floatingPassword">Password</label>
                </div>
                <button class="w-100 btn btn-lg btn-primary btn-join" type="submit">회원 가입 완료</button>
            </form>
        </main>

        <%@ include file="../layout/footer.jsp" %>