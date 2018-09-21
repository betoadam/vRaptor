<%-- 
    Document   : login
    Created on : 06/09/2018, 14:37:33
    Author     : utfpr
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:import url="/WEB-INF/jsp/inc/cabecalho.jsp"/>

<form action="${linkTo[AuthController].autenticar}" method="POST">
    <input type="text" class="form-control" name="p.login" placeholder="Login"/>
    <input type="password" class="form-control" name="p.senha" placeholder="Senha"/>
    <button type="submit" class="btn btn-primary">Login</button>
</form>

<jsp:include page="/WEB-INF/jsp/inc/rodape.jsp"/>