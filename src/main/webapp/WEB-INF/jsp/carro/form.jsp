<%-- 
    Document   : form
    Created on : 30/08/2018, 13:24:01
    Author     : utfpr
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Carro</title>
    </head>
    <body>
        <h1>Carro (cadastro)</h1>
        
        <c:if test="${not empty errors}">       
            <ul>
                <c:forEach items="${errors}" var="err">
                    <li>${err.message}</li>
                </c:forEach>
            </ul>
        </c:if>
        
        <form action="${linkTo[CarroController].save}" method="POST">
            <div>
                <label>Marca</label>
                <input type="text" name="carro.marca"/>
            </div>
            <div>
                <label>Modelo</label>
                <input type="text" name="carro.modelo"/>
            </div>
            <div>
                <input type="submit" name="Gravar"/>
            </div>
        </form>
        
    </body>
</html>
