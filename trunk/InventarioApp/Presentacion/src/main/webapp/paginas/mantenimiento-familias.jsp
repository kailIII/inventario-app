<%-- 
    Document   : otra
    Created on : 17/11/2013, 03:22:05 PM
    Author     : Pruebas
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="utiles/includes.jsp" %>
        <title>Mantenimiento Familias</title>
    </head>
    <body>

        <nav class="navbar">
            <li style="list-style:none"></li>
            <li style="list-style:none"></li>
            <li style="list-style:none"></li>   
            <ul>
                <li></li>
                <li></li>
                <li></li>
            </ul>
        </nav>

        <div class="grid">

            <!-- ===================================== 
                    INSTRUCTIONS 
            ===================================== -->
            <h3></h3>
            <li style="list-style:none"></li>
            <li style="list-style:none"></li>
            <li style="list-style:none"></li>

            <!-- ===================================== 
                    MENUS
            ===================================== -->

            <!-- MENU HORIZONTAL -->
            <div class="col_12">
                <h4></h4>
                <ul class="menu">
                    <sec:authorize ifAnyGranted="ROLE_ADMIN">
                        <li><a href="<c:url value='/mantenimiento-usuario' />">Mantenimiento Usuarios</a></li>
                        <li class="current"><a href="<c:url value='/mantenimiento-familias'/>">Mantimiento Familias</a></li>
                        <li><a href="<c:url value='/mantenimiento-proveedor'/>">Mantimiento Proveedores</a></li>
                        <li><a href="<c:url value='#'/>">Mantimiento Productos</a></li>
                        <li><a href="<c:url value='#'/>">Configuraci&oacute;n</a></li>
                    </sec:authorize>¸
                    <sec:authorize ifAnyGranted="ROLE_USER">
                        <li><a href="<c:url value='#'/>">Punto Venta</a>
                            <ul>
                                <li><a href=""><i class="icon-cog"></i> Sub Item</a></li>
                                <li><a href=""><i class="icon-envelope-alt"></i> Sub Item</a>
                                    <ul>
                                        <li><a href=""><i class="icon-wrench"></i> Sub Item</a></li>
                                        <li><a href=""><i class="icon-camera-retro"></i> Sub Item</a></li>
                                        <li><a href=""><i class="icon-coffee"></i> Sub Item</a></li>
                                        <li><a href=""><i class="icon-twitter"></i> Sub Item</a></li>
                                    </ul>
                                </li>
                                <li class="divider"><a href=""><i class="icon-trash"></i> li.divider</a></li>
                            </ul>
                        </li>
                    </sec:authorize>
                    <li><a href="<c:url value='/logout' />">Cerrar Sesi&oacute;n</a></li>
                </ul>
            </div>


            <div id="tabs">
                <ul>
                    <li><a href="#tabs-1">Agregar</a></li>
                    <li><a href="#tabs-2">Buscar</a></li>
                    <li><a href="#tabs-3">Ver todos</a></li>
                </ul>
                <div id="tabs-1">
                    <%@ include file="forms/agregar-familia.jsp" %>
                </div>
                <div id="tabs-2">
                </div>
                <div id="tabs-3">
                </div>
            </div>

        </div>


        <div id="resultado">

        </div>
        <!-- ===================================== START FOOTER ===================================== -->
        <div class="clear"></div>
        <div id="footer">
            &copy;2014 Desarrollado por Erick P&eacute;rez Ibarra <a target="_blank" href="http://www.facebook.com/erickperez091"><i class="icon-facebook-sign"></i></a>
        </div>
    </body>
</html>
