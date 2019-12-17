<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Listar Asignaciones</title>
        <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
        <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
    </head>

    <body>
        <div class="generic-container">

            <%@include file="authheader.jsp" %>	
            <div class="panel panel-default">
                <!-- Default panel contents -->
            
                <div class="panel-heading"><span class="lead">Lista de Asignaciones</span></div>
                <sec:authorize access="hasRole('ADMIN')">
                    <div class="well">
                        <a class="btn btn-success" href="<c:url value='/newasignacion' />">Agregar Asignacion</a>
                    </div>
                </sec:authorize>
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Asignacion Id:</th>
                            <th>Usuario:</th>
                            <th>Fecha Creado:</th>
                            <th>Fecha Modificado:</th>
                            <th>Hardware:</th>

                                <sec:authorize access="hasRole('ADMIN')">
                                <th width="100"></th>
                                </sec:authorize>
                                <sec:authorize access="hasRole('ADMIN')">
                                <th width="100"></th>
                                </sec:authorize>

                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${asignaciones}" var="asignacion">
                            <tr>
                                <td>${asignacion.id}</td>
                                <td>${asignacion.asignacionId}</td>
                                <td>${asignacion.usuarioFk}</td>
                                <td>${asignacion.fechaCreado}</td>
                                <td>${asignacion.fechaModificado}</td>
                                <td>${asignacion.hardwareFk}</td>
                                
                              <sec:authorize access="hasRole('ADMIN')">
                                    <td><a href="<c:url value='/edit-asignacion-${asignacion.asignacionId}' />" class="btn btn-warning custom-width">Editar</a></td>
                                </sec:authorize>
                                <sec:authorize access="hasRole('ADMIN')">
                                    <td><a href="<c:url value='/delete-asignacion-${asignacion.asignacionId}' />" class="btn btn-danger custom-width">Eliminar</a></td>
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