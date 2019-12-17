<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Listar Prestamos</title>
        <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
        <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
    </head>

    <body>
        <div class="generic-container">

            <%@include file="authheader.jsp" %>	
            <div class="panel panel-default">
                <!-- Default panel contents -->

                <div class="panel-heading"><span class="lead">Lista de Prestamos</span></div>
                <sec:authorize access="hasRole('ADMIN')">
                    <div class="well">
                        <a class="btn btn-success" href="<c:url value='/newprestamo' />">Agregar Prestamo</a>
                    </div>
                </sec:authorize>
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>Id:</th>
                            <th>Usuario:</th>
                            <th>Estado:</th>
                            <th>Fecha Creado:</th>
                            <th>Fecha Modificado:</th>
                            <th>Prestamo ID:</th>
                                <sec:authorize access="hasRole('ADMIN')">
                                <th width="100"></th>
                                </sec:authorize>
                                <sec:authorize access="hasRole('ADMIN')">
                                <th width="100"></th>
                                </sec:authorize>

                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${prestamos}" var="prestamo">
                            <tr>
                                <td>${prestamo.id}</td>
                                <td>${prestamo.usuario}</td>
                                <td>${prestamo.estado}</td>
                                <td>${prestamo.fechaCreado}</td>
                                <td>${prestamo.fechaModificado}</td>
                                <td>${prestamo.prestamoId}</td>
                                <sec:authorize access="hasRole('ADMIN')">
                                    <td><a href="<c:url value='/edit-prestamo-${prestamo.prestamoId}' />" class="btn btn-warning custom-width">Editar</a></td>
                                </sec:authorize>
                                <sec:authorize access="hasRole('ADMIN')">
                                    <td><a href="<c:url value='/delete-prestamo-${prestamo.prestamoId}' />" class="btn btn-danger custom-width">Eliminar</a></td>
                                </sec:authorize>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <span class="well floatRight">
                Ir a <a href="<c:url value='/menu' />">Volver al Menu</a>
            </span>
        </div>

    </body>
</html>