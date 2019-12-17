<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Listar Hardware</title>
        <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
        <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
    </head>

    <body>
        <div class="generic-container">

            <%@include file="authheader.jsp" %>	
            <div class="panel panel-default">
                <!-- Default panel contents -->
            
                <div class="panel-heading"><span class="lead">Lista de Hardware</span></div>
                <sec:authorize access="hasRole('ADMIN')">
                    <div class="well">
                        <a class="btn btn-success" href="<c:url value='/newhardware' />">Agregar Hardware</a>
                    </div>
                </sec:authorize>
                <table class="table table-hover">
                    <thead>
                        <tr>
                               <th>Id</th>
                            <th>Hardware Id:</th>
                            
                            <th>Descripción:</th>
                            <th>Observación:</th>
                            <th>Estado Id:</th>
                            <th>Estado Objeto:</th>
                            <th>Prestamo Id:</th>
                            <th>Marca:</th>
                            <th>Modelo:</th>
                            <th>Asignacion Id:</th>
                            <th>Fecha Creado:</th>
                            <th>Fecha Modificado:</th>
                            <th>User Id:</th>
                            <th>Bodega Id:</th>
                            
                                <sec:authorize access="hasRole('ADMIN')">
                                <th width="100"></th>
                                </sec:authorize>
                                <sec:authorize access="hasRole('ADMIN')">
                                <th width="100"></th>
                                </sec:authorize>

                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${hardwares}" var="hardware">
                            <tr>
                                 <td>${hardware.id}</td>
                                <td>${hardware.hardwareId}</td>
                                <td>${hardware.descripcion}</td>
                                <td>${hardware.observacion}</td>
                                <td>${hardware.estadoId}</td>
                                <td>${hardware.estadoObjeto}</td>
                                <td>${hardware.prestamoId}</td>
                                <td>${hardware.marca}</td>
                                <td>${hardware.modelo}</td>
                                <td>${hardware.asignacionId}</td>
                                <td>${hardware.fechaCreado}</td>
                                <td>${hardware.fechaModificado}</td>
                                <td>${hardware.userId}</td>
                                <td>${hardware.bodegaId}</td>
                                
                                
                              <sec:authorize access="hasRole('ADMIN')">
                                    <td><a href="<c:url value='/edit-hardware-${hardware.hardwareId}' />" class="btn btn-warning custom-width">Editar</a></td>
                                </sec:authorize>
                                <sec:authorize access="hasRole('ADMIN')">
                                    <td><a href="<c:url value='/delete-hardware-${hardware.hardwareId}' />" class="btn btn-danger custom-width">Eliminar</a></td>
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