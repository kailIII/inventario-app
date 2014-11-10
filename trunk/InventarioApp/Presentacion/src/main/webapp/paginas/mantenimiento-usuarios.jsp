<%-- 
    Document   : mantenimiento-usuarios
    Created on : 17/11/2013, 03:22:05 PM
    Author     : Erick
--%>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<html>
    <head>
        <meta charset="utf-8" accept="application/json"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Mantenimiento Usuarios</title>
        <link href="css/jquery-ui.css" rel="stylesheet" type="text/css"/>
        <link href="css/jqgridstyle/ui.jqgrid.css" rel="stylesheet" type="text/css"/>
        <script src="js/jquery-1.10.2.js" type="text/javascript"></script>
        <script src="js/jquery-ui.js" type="text/javascript"></script>
        <script src="js/jqgrid/grid.locale-es.js" type="text/javascript"></script>
        <script src="js/jqgrid/jquery.jqGrid.js" type="text/javascript"></script>
        <script src="js/jquery-validate.js" type="text/javascript"></script>
        <script src="js/usuario.js" type="text/javascript"></script>
        <script src="js/bootstrapjs/bootstrap.min.js" type="text/javascript"></script>
        <script src="js/bootstrapjs/custom.js" type="text/javascript"></script>
        <script src="js/bootstrapjs/jquery.metisMenu.js" type="text/javascript"></script>
        <script src="js/bootstrapjs/morris.js" type="text/javascript"></script>
        <script src="js/bootstrapjs/raphael-2.1.0.min.js" type="text/javascript"></script>
        <link href="css/bootstraptemplate/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstraptemplate/custom.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstraptemplate/font-awesome.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstraptemplate/morris-0.4.3.min.css" rel="stylesheet" type="text/css"/>
        <!-- GOOGLE FONTS-->
        <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
    </head>
    <body>
        <div id="wrapper">
            <nav class="navbar navbar-default navbar-cls-top " role="navigation" style="margin-bottom: 0">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="<c:url value='/principal'/>">Inicio</a> 
                </div>
                <div style="color: white;
                     padding: 15px 50px 5px 50px;
                     float: right;
                     font-size: 16px;"><a href="<c:url value='/logout'/>" class="btn btn-danger square-btn-adjust">Salir</a> 
                </div>
            </nav>   
            <!-- /. NAV TOP  -->
            <nav class="navbar-default navbar-side" role="navigation">
                <div class="sidebar-collapse">
                    <ul class="nav" id="main-menu">
                        <li class="text-center">
                            <img src="css/img/find_user.png" class="user-image img-responsive"/>
                        </li>
                        <sec:authorize ifAnyGranted="ROLE_ADMIN">
                            <li><a href="<c:url value='/principal'/>"><i class="fa fa-dashboard fa-3x"></i>Inicio</a></li>
                            <li><a class="active-menu" href="<c:url value='/mantenimiento-usuario'/>"><i class="fa fa-edit fa-3x"></i>Mantenimiento Usuarios</a></li>
                            <li><a href="<c:url value='/mantenimiento-familias'/>"><i class="fa fa-edit fa-3x"></i>Mantenimiento Familias</a></li>
                            <li><a href="<c:url value='/mantenimiento-proveedor'/>"><i class="fa fa-edit fa-3x"></i>Mantenimiento Proveedores</a></li>
                            <li><a href="<c:url value='#'/>"><i class="fa fa-edit fa-3x"></i>Mantenimiento Productos</a></li>
                            <li><a href="<c:url value='#'/>"><i class="fa fa-edit fa-3x"></i>Configuraci&oacute;n</a></li>
                            </sec:authorize>
                    </ul>
                </div>
            </nav>  
            <!-- /. NAV SIDE  -->
            <div id="page-wrapper" >
                <div id="page-inner">
                    <div class="row">
                        <div class="col-md-12">
                            <h2>Mantenimiento Usuarios</h2>   
                        </div>
                    </div>              
                    <!-- /. ROW  -->
                    <hr />
                    <div class="row" >
                        <div class="col-md-9 col-sm-12">
                            <div class="panel-body">
                                <ul class="nav nav-tabs">
                                    <li class="active"><a href="#add" data-toggle="tab">Agregar</a>
                                    </li>
                                    <li class=""><a href="#search" data-toggle="tab">Buscar</a>
                                    </li>
                                    <li class=""><a href="#all" data-toggle="tab">Ver todos</a>
                                    </li>
                                </ul>
                                <div class="tab-content">
                                    <div class="tab-pane fade active in" id="add">
                                        <%@ include file="forms/agregar-usuario.jsp" %>
                                    </div>
                                    <div class="tab-pane fade" id="search">
                                        <%@ include file="forms/buscar-usuario.jsp" %>
                                    </div>
                                    <div class="tab-pane fade" id="all">
                                        <table id="list"></table>
                                        <div id="pager"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /. PAGE INNER  -->
                <!--
                Para poder crear un footer!!
                -->
            </div>
            <!-- /. PAGE WRAPPER  -->
        </div>
        <!-- /. WRAPPER  -->
    </body>
</html>
