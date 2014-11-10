<%-- 
    Document   : agregar-usuario
    Created on : Nov 10, 2014, 10:01:20 AM
    Author     : erick
--%>

<fieldset>
    <legend>Datos del Usuario</legend>
    <form:form role="form" id="agregar-usuario" modelAttribute="usuario">
        <div>
            <table>
                <tbody>
                    <tr>
                        <td><label for="cedula">C&eacute;dula:&nbsp;</label></td>
                        <td><form:input class="form-control" type="text" id="cedula" path="cedula"></form:input></td>
                    </tr>
                    <tr>
                        <td><label for="usuario">Usuario:&nbsp;</label></td>
                        <td><form:input class="form-control" type="text" id="usuario" path="usuario"></form:input></td>
                    </tr>
                    <tr>
                        <td><label for="contrasena">Contrase&ntilde;a:&nbsp;</label></td>
                        <td><form:password class="form-control" id="contrasena" path="contrasena"></form:password></td>
                    </tr>
                    <tr>
                        <td><label for="confirmarContrasena">Confirmar Contrase&ntilde;a:&nbsp;</label></td>
                        <td><form:password class="form-control" id="confirmarContrasena" path="confirmarContrasena"></form:password></td>
                    </tr>
                    <tr>
                        <td><label for="correo">Correo:&nbsp;</label></td>
                        <td><form:input class="form-control" type="text" id="correo" path="correo"></form:input></td>
                    </tr>
                    <tr>
                        <td><label for="telefono">Tel&eacute;fono:&nbsp;</label></td>
                        <td><form:input class="form-control" id="telefono" path="telefono"></form:input></td>
                    </tr>
                    <tr>
                    <div class="form-group">
                        <td><label for="rol">Rol:&nbsp;</label></td>
                        <td><form:select class="form-control" id="rol" path="rol">
                            <form:option value="">Seleccione...</form:option>
                            <form:option value="ROLE_ADMIN">ADMINISTRADOR</form:option>
                            <form:option value="ROLE_USER">USUARIO NORMAL</form:option>
                        </form:select></td>
                    </div>
                    </tr>
                    <tr>
                        <td><label for="habilitado">Habilitado:&nbsp;</label></td>
                        <td><div class="radio-inline"><form:radiobutton path="habilitado" id="habilitado" value="true"/>SI </div>
                        <div class="radio-inline"><form:radiobutton path="habilitado" id="habilitado" value="false"/>NO </div></td>
                    </tr>
                    <tr>  
                        <td colspan="2">
                            <button id="btnGuardarUsuario" type="submit" class="btn btn-primary"><i class="fa fa-floppy-o"></i>Guardar</button>
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