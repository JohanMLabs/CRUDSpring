<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Formulario de registro Hardware</title>
        <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
        <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
    </head>

    <body>
        <div class="generic-container">
            <%@include file="authheader.jsp" %>

            <div class="well lead">Registrar Hardware</div>
            <form:form method="POST" modelAttribute="hardware" class="form-horizontal">
                <form:input type="hidden" path="id" id="id"/>

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-3 control-lable" for="hardwareId">Hardware Id:</label>
                        <div class="col-md-7">
                            <form:input type="text" path="hardwareId" id="hardwareId" class="form-control input-sm"/>
                            <div class="has-error">
                                <form:errors path="hardwareId" class="help-inline"/>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-3 control-lable" for="descripcion">Descripción:</label>
                        <div class="col-md-7">
                            <form:input type="text" path="descripcion" id="descripcion" class="form-control input-sm" />
                            <div class="has-error">
                                <form:errors path="descripcion" class="help-inline"/>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-3 control-lable" for="observacion">Observación:</label>
                        <div class="col-md-7">
                            <form:input type="text" path="observacion" id="observacion" class="form-control input-sm" />
                            <div class="has-error">
                                <form:errors path="observacion" class="help-inline"/>
                            </div>
                        </div>
                    </div>
                </div>
                

        


<div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-3 control-lable" for="estadoId">Estado Id:</label>
                        <div class="col-md-7">
                            <form:input type="text" path="estadoId" id="estadoId" class="form-control input-sm"/>
                            <div class="has-error">
                                <form:errors path="estadoId" class="help-inline"/>
                            </div>
                        </div>
                    </div>
                </div>
<div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-3 control-lable" for="estadoObjeto">Estado Objeto:</label>
                        <div class="col-md-7">
                            <form:input type="text" path="estadoObjeto" id="estadoObjeto" class="form-control input-sm"/>
                            <div class="has-error">
                                <form:errors path="estadoObjeto" class="help-inline"/>
                            </div>
                        </div>
                    </div>
                </div>
<div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-3 control-lable" for="prestamoId">prestamoId:</label>
                        <div class="col-md-7">
                            <form:input type="text" path="prestamoId" id="prestamoId" class="form-control input-sm"/>
                            <div class="has-error">
                                <form:errors path="prestamoId" class="help-inline"/>
                            </div>
                        </div>
                    </div>
                </div>
<div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-3 control-lable" for="marca">Marca:</label>
                        <div class="col-md-7">
                            <form:input type="text" path="marca" id="marca" class="form-control input-sm"/>
                            <div class="has-error">
                                <form:errors path="marca" class="help-inline"/>
                            </div>
                        </div>
                    </div>
                </div>
<div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-3 control-lable" for="modelo">Modelo:</label>
                        <div class="col-md-7">
                            <form:input type="text" path="modelo" id="modelo" class="form-control input-sm"/>
                            <div class="has-error">
                                <form:errors path="modelo" class="help-inline"/>
                            </div>
                        </div>
                    </div>
                </div>
<div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-3 control-lable" for="asignacionId">AsignacionId:</label>
                        <div class="col-md-7">
                            <form:input type="text" path="asignacionId" id="asignacionId" class="form-control input-sm"/>
                            <div class="has-error">
                                <form:errors path="asignacionId" class="help-inline"/>
                            </div>
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
                    <div class="form-group col-md-12">
                        <label class="col-md-3 control-lable" for="userId">Usuario ID</label>
                        <div class="col-md-7">
                            <c:choose>
                                <c:when test="${editB}">
                                    <form:input type="text" path="userId" id="userId" class="form-control input-sm" disabled="true"/>
                                </c:when>
                                <c:otherwise>
                                    <form:input type="text" path="userId" id="userId" class="form-control input-sm" />
                                    <div class="has-error">
                                        <form:errors path="userId" class="help-inline"/>
                                    </div>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                </div>
        <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-3 control-lable" for="bodegaId">Bodeg ID</label>
                        <div class="col-md-7">
                            <c:choose>
                                <c:when test="${editB}">
                                    <form:input type="text" path="bodegaId" id="bodegaId" class="form-control input-sm" disabled="true"/>
                                </c:when>
                                <c:otherwise>
                                    <form:input type="text" path="bodegaId" id="bodegaId" class="form-control input-sm" />
                                    <div class="has-error">
                                        <form:errors path="bodegaId" class="help-inline"/>
                                    </div>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                </div>
                            
                <div class="row">
                    <div class="form-actions floatRight">
                        <c:choose>
                            <c:when test="${edit}">
                                <input type="submit" value="Actualizar" class="btn btn-primary btn-sm"/>  <a href="<c:url value='/listh' />">Cancelar</a>
                            </c:when>
                            <c:otherwise>
                                <input type="submit" value="Registrar" class="btn btn-primary btn-sm"/> <a href="<c:url value='/listh' />">Cancelar</a>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
            </form:form>
        </div>
    </body>
</html>