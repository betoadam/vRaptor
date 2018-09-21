<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<c:import url="/WEB-INF/jsp/inc/cabecalho.jsp"/>


<h1>Lista Carros!</h1>
<table class="table table-striped">
    <tr>
        <th>ID</th>
        <th>Marca</th>
        <th>Modelo</th>
        <th>Ações</th>
    </tr>
    <c:forEach items="${carroList}" var="car">
        <tr>
            <th>${car.id}</th>
            <th>${car.marca}</th>
            <th>${car.modelo}</th>
            <th></th>
        </tr>
    </c:forEach>
</table>
<div>
    ${mensagem}
</div>
<div>
    ${data}
</div>

<jsp:include page="/WEB-INF/jsp/inc/rodape.jsp"/>