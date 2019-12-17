<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Formulario de registro Prestamo</title>
        <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
        <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
    </head>

    <body>
        <div class="generic-container">
            <%@include file="authheader.jsp" %>

            <div class="well lead">Registrar Prestamo</div>
            <form:form method="POST" modelAttribute="prestamo" class="form-horizontal">
                <form:input type="hidden" path="id" id="id"/>

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-3 control-lable" for="usuario">Usuario:</label>
                        <div class="col-md-7">
                            <form:input type="text" path="usuario" id="usuario" class="form-control input-sm"/>
                            <div class="has-error">
                                <form:errors path="usuario" class="help-inline"/>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-3 control-lable" for="estado">Estado:</label>
                        <div class="col-md-7">
                            <form:input type="text" path="estado" id="estado" class="form-control input-sm" />
                            <div class="has-error">
                                <form:errors path="estado" class="help-inline"/>
                            </div>
                        </div>
                    </div>
                </div>
                

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-3 control-lable" for="prestamoId">Prestamo ID</label>
                        <div class="col-md-7">
                            <c:choose>
                                <c:when test="${editP}">
                                    <form:input type="text" path="prestamoIdId" id="prestamoId" class="form-control input-sm" disabled="true"/>
                                </c:when>
                                <c:otherwise>
                                    <form:input type="text" path="prestamoId" id="prestamoId" class="form-control input-sm" />
                                    <div class="has-error">
                                        <form:errors path="prestamoId" class="help-inline"/>
                                    </div>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                </div>


<div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-3 control-lable" for="fechaCreado">Fecha de Creado:</label>
                        <div class="col-md-7">
                            <form:input type="date" path="fechaCreado" id="fechaCreado" class="form-control input-sm"/>
                            <div class="has-error">
                                <form:errors path="fechaCreado" class="help-inline"/>
                            </div>
                        </div>
                    </div>
                </div>
<div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-3 control-lable" for="fechaModificado">Fecha de Modificado:</label>
                        <div class="col-md-7">
                            <form:input type="date" path="fechaModificado" id="fechaModificado" class="form-control input-sm"/>
                            <div class="has-error">
                                <form:errors path="fechaModificado" class="help-inline"/>
                            </div>
                        </div>
                    </div>
                </div>


                <div class="row">
                    <div class="form-actions floatRight">
                        <c:choose>
                            <c:when test="${edit}">
                                <input type="submit" value="Actualizar" class="btn btn-primary btn-sm"/>  <a href="<c:url value='/listb' />">Cancelar</a>
                            </c:when>
                            <c:otherwise>
                                <input type="submit" value="Registrar" class="btn btn-primary btn-sm"/> <a href="<c:url value='/listb' />">Cancelar</a>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
            </form:form>
        </div>
    </body>
</html>