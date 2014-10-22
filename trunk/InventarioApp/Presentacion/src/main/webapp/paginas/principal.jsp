<%-- 
    Document   : principal
    Created on : 27/10/2013, 03:07:32 PM
    Author     : Erick
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Principal</title>
        <!-- BOOTSTRAP STYLES-->
        <link href="css/bootstraptemplate/bootstrap.css" rel="stylesheet" type="text/css"/>
        <!-- FONTAWESOME STYLES-->
        <link href="css/bootstraptemplate/font-awesome.css" rel="stylesheet" />
        <!-- MORRIS CHART STYLES-->
        <link href="css/bootstraptemplate/morris-0.4.3.min.css" rel="stylesheet" />
        <!-- CUSTOM STYLES-->
        <link href="css/bootstraptemplate/custom.css" rel="stylesheet" />
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
                            <li><a class="active-menu"  href="<c:url value='/principal'/>"><i class="fa fa-dashboard fa-3x"></i>Inicio</a></li>
                            <li><a href="<c:url value='/mantenimiento-usuario'/>"><i class="fa fa-edit fa-3x"></i>Mantenimiento Usuarios</a></li>
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
                            <h2>Admin Dashboard</h2>   
                            <h5>Welcome ${username} , Love to see you back. </h5>
                        </div>
                    </div>              
                    <!-- /. ROW  -->
                    <hr />
                    
                    <div class="row" >
                        <div class="col-md-9 col-sm-12 col-xs-12">

                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    Responsive Table Example
                                </div>
                                <div class="panel-body">
                                    <div class="table-responsive">
                                        <table class="table table-striped table-bordered table-hover">
                                            <thead>
                                                <tr>
                                                    <th>#</th>
                                                    <th>First Name</th>
                                                    <th>Last Name</th>
                                                    <th>Username</th>
                                                    <th>User No.</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <td>1</td>
                                                    <td>Mark</td>
                                                    <td>Otto</td>
                                                    <td>@mdo</td>
                                                    <td>100090</td>
                                                </tr>
                                                <tr>
                                                    <td>2</td>
                                                    <td>Jacob</td>
                                                    <td>Thornton</td>
                                                    <td>@fat</td>
                                                    <td>100090</td>
                                                </tr>
                                                <tr>
                                                    <td>3</td>
                                                    <td>Larry</td>
                                                    <td>the Bird</td>
                                                    <td>@twitter</td>
                                                    <td>100090</td>
                                                </tr>
                                                <tr>
                                                    <td>1</td>
                                                    <td>Mark</td>
                                                    <td>Otto</td>
                                                    <td>@mdo</td>
                                                    <td>100090</td>
                                                </tr>
                                                <tr>
                                                    <td>2</td>
                                                    <td>Jacob</td>
                                                    <td>Thornton</td>
                                                    <td>@fat</td>
                                                    <td>100090</td>
                                                </tr>
                                                <tr>
                                                    <td>3</td>
                                                    <td>Larry</td>
                                                    <td>the Bird</td>
                                                    <td>@twitter</td>
                                                    <td>100090</td>
                                                </tr>

                                            </tbody>
                                        </table>
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
        <!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
        <!-- JQUERY SCRIPTS -->
        <script src="js/jquery-1.10.2.js" type="text/javascript"></script>
        <!-- BOOTSTRAP SCRIPTS -->
        <script src="js/bootstrapjs/bootstrap.min.js"></script>
        <!-- METISMENU SCRIPTS -->
        <script src="js/bootstrapjs/jquery.metisMenu.js"></script>
        <!-- MORRIS CHART SCRIPTS -->
        <script src="js/bootstrapjs/raphael-2.1.0.min.js"></script>
        <script src="js/bootstrapjs/morris.js" type="text/javascript"></script>
        <!-- CUSTOM SCRIPTS -->
        <script src="js/bootstrapjs/custom.js"></script>


    </body>
</html>
