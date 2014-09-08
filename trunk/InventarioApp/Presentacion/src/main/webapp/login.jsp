<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6 lt8"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7 lt8"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8 lt8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="es" class="no-js"> <!--<![endif]-->
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <head>
        <meta charset="UTF-8" />
        <!-- <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">  -->
        <title>Inicio de Sesi&oacute;n</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        <meta name="description" content="Login and Registration Form with HTML5 and CSS3" />
        <meta name="keywords" content="html5, css3, form, switch, animation, :target, pseudo-class" />
        <meta name="author" content="Codrops" />
        <link rel="shortcut icon" href="../favicon.ico"> 
        <link rel="stylesheet" type="text/css" href="css/style.css" />
        <style>
            .errorblock {
                color: #ff0000;
                background-color: #ffEEEE;
                border: 3px solid #ff0000;
                padding: 8px;
                margin: 16px;
            }
        </style>
    </head>
    <body onload='document.f.j_username.focus();'>
        <div class="container">
            <section>				
                <div id="container_demo" >
                    <!-- hidden anchor to stop jump http://www.css3create.com/Astuce-Empecher-le-scroll-avec-l-utilisation-de-target#wrap4  -->
                    <a class="hiddenanchor" id="toregister"></a>
                    <a class="hiddenanchor" id="tologin"></a>

                    <div id="wrapper">
                        <div id="login" class="animate form">
                            <c:if test="${not empty param.error}">
                                <div class="errorblock">
                                    Your login attempt was not successful, try again.<br /> Caused :
                                    ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
                                </div>
                            </c:if>
                            <form  name='f' action="<c:url value='j_spring_security_check' />" autocomplete="on" method="post"> 
                                <h1>Iniciar Sesion</h1> 
                                <p> 
                                    <label for="username" class="uname" data-icon="u" > Nombre de Usuario </label>
                                    <input id="username" name="j_username" required="required" type="text" placeholder="usuario"/>
                                </p>
                                <p> 
                                    <label for="password" class="youpasswd" data-icon="p"> Contrase&ntilde;a </label>
                                    <input id="password" name="j_password" required="required" type="password" placeholder="contrase&ntilde;a" /> 
                                </p>
                                <p class="login button"> 
                                    <input type="submit" value="Ingresar" /> 
                                </p>
                            </form>
                        </div>
                    </div>
                </div>  
            </section>
        </div>
    </body>
</html>