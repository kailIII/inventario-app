<%-- 
    Document   : agregar-usuario
    Created on : 17/11/2013, 03:22:05 PM
    Author     : Erick
--%>

<fieldset>
    <legend>Datos del usuario</legend>
    <form:form role="form" method="post" id="agregar-usuario" modelAttribute="usuario" action="agregar-usuario">  
        <div >
            <table>  
                <tbody>
                    <tr>  
                        <td><form:label path="cedula">C&eacute;dula:</form:label></td>  
                <td><form:input class="form-control" id="cedula" path="cedula"></form:input></td>  
                </tr
                <tr>  
                    <td><form:label path="usuario">Usuario:</form:label></td>  
                <td><form:input class="form-control" id="usuario" path="usuario"></form:input></td>  
                </tr>  
                <tr>
                    <td><form:label path="contrasena">Contrase&ntilde;a:</form:label></td>  
                <td><form:password class="form-control" path="contrasena"></form:password></td>  
                </tr>
                <tr>
                    <td><form:label path="confirmarContrasena">Confirmar Contrase&ntilde;a:</form:label></td>  
                <td><form:password class="form-control" path="confirmarContrasena"></form:password></td>  
                </tr>
                <tr>
                    <td><form:label path="correo">Correo:</form:label></td>  
                <td><form:input class="form-control" path="correo"></form:input></td>  
                </tr>
                <tr>
                    <td><form:label path="telefono">Telefono:</form:label></td>  
                <td><form:input class="form-control" path="telefono"></form:input></td>  
                </tr>
                <tr>
                <div class="form-group">
                    <td><form:label path="rol">Rol:</form:label></td>
                    <td><form:select class="form-control" path="rol">
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
                        <form:radiobutton path="habilitado" value="true" />SI </br>
                    </div>
                    <div class="radio-inline">
                        <form:radiobutton path="habilitado" value="false"/>NO
                    </div>
                </td>  
                </tr>
                <tr>  
                    <td colspan="2">
                        <button id="btnGuardar" type="submit" class="btn btn-primary"><i class="fa fa-floppy-o"></i>Guardar</button>
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