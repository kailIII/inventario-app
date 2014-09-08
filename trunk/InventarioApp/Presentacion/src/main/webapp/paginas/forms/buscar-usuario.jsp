<%-- 
    Document   : buscar-usuario
    Created on : 17/11/2013, 03:22:05 PM
    Author     : Erick
--%>

<fieldset>
    <legend>Datos del usuario</legend>
    <form>
        <div>
            <table>
                <tbody>
                    <tr>
                        <td>
                            <label for="nombreUsuario">Nombre de usuario:&nbsp;</label>
                            <input type="text" class="form-control" id="nombreUsuario" />
                            <button type="button" id="btnBuscarUsuario" class="btn btn-default"><i class="fa fa-search"></i>Buscar</button>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
    </form>
</fieldset>

<div id="modificar-usuario">
    <fieldset>
        <legend>Datos del usuario</legend>
        <form:form role="form" method="POST" id="form-modificar-usuario" modelAttribute="usuario-modificar" action="actualizar-usuario">  
            <div>
                <form:input type="hidden" id="idAct" path="id"></form:input>
                <form:input type="hidden" id="cedulaAct" path="cedula"></form:input>
                <form:input type="hidden" id="usuarioAct" path="usuario"></form:input>
                <table>  
                    <tbody>
                        <tr>
                            <td><form:label path="contrasena">Contrase&ntilde;a:</form:label></td>  
                    <td><form:password id="contrasenaAct" class="form-control" path="contrasena"></form:password></td>  
                    </tr>
                    <tr>
                        <td><form:label path="confirmarContrasena">Confirmar Contrase&ntilde;a:</form:label></td>  
                    <td><form:password id="confirmarContrasenaAct" class="form-control" path="confirmarContrasena"></form:password></td>  
                    </tr>
                    <tr>
                        <td><form:label path="correo">Correo:</form:label></td>  
                    <td><form:input id="correoAct" class="form-control" path="correo"></form:input></td>  
                    </tr>
                    <tr>
                        <td><form:label path="telefono">Telefono:</form:label></td>  
                    <td><form:input id="telefonoAct" class="form-control" path="telefono"></form:input></td>  
                    </tr>
                    <tr>
                    <div class="form-group">
                        <td><form:label path="rol">Rol:</form:label></td>
                        <td><form:select id="rolAct" class="form-control" path="rol">
                            <form:option value="">Seleccione...</form:option>
                            <form:option value="ROLE_ADMIN">ADMINISTRADOR</form:option>
                            <form:option value="ROLE_USER">VENDEDOR</form:option>
                        </form:select>
                        </td>
                    </div>
                    </tr>
                    <tr>

                        <td><form:label path="habilitado">Habilitado:</form:label></td>
                    <td>
                        <div class="radio-inline">
                            <form:radiobutton id="habilitadoAct" path="habilitado" value="true" />SI </br>
                        </div>
                        <div class="radio-inline">
                            <form:radiobutton id="noHabilitadoAct" path="habilitado" value="false"/>NO
                        </div>
                    </td>  
                    </tr>
                    <tr>  
                        <td colspan="2">
                            <button type="submit" class="btn btn-primary"><i class="fa fa-refresh"></i>Actualizar</button>
                            <button type="reset" class="btn btn-danger"><i class="fa fa-warning"></i>Cancelar</button>
                        </td>  
                        <td></td>  
                        <td></td>  
                    </tr>  
                    </tbody>
                </table>
            </div>    
        </form:form>  
    </fieldset>
</div>