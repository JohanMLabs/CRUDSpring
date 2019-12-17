<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Listar Usuarios</title>
        <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
        <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
    </head>

    <body>
        <div class="generic-container">

            <%@include file="authheader.jsp" %>	

  <div>
            <sec:authorize access="hasRole('ADMIN')">
                

                    <a class="btn btn-success" href="<c:url value='/list' />"> Usuarios</a>
             
                    <a class="btn btn-success" href="<c:url value='/listb' />"> Bodegas</a>
             
                    <a class="btn btn-success" href="<c:url value='/listc' />"> Compras</a>
                
                    <a class="btn btn-success" href="<c:url value='/lista' />"> Asignaciones</a>
                    
                    <a class="btn btn-success" href="<c:url value='/listp' />"> Prestamos</a>
                    
                    <a class="btn btn-success" href="<c:url value='/liste' />"> Estados</a>
                    
                    <a class="btn btn-success" href="<c:url value='/listh' />"> Hardware</a>
                </div>
            </sec:authorize>
        </div>

        </div>
      

    </body>
</html>