<%-- 
    Document   : agregar-proveedor
    Created on : 17/11/2013, 03:22:05 PM
    Author     : Erick
--%>

<fieldset>
    <legend>Datos del Proveedor</legend>
    <form:form role="form" id="agregar-proveedor" modelAttribute="proveedor">
        <div>
            <table>  
                <tbody>
                    <tr>
                        <td><label for="nombreProveedor">Nombre Proveedor:&nbsp;</label></td>  
                <td><form:input id="nombreProveedor" class="form-control" path="nombreProveedor"></form:input></td>  
                </tr>
                <tr>  
                    <td><label for="cedulaJuridica">C&eacute;dula Jur&iacute;dica:&nbsp;</label></td>  
                <td><form:input id="cedulaJuridica" class="form-control" path="cedulaJuridica"></form:input></td>  
                </tr>  
                <tr>
                    <td><label for="direccion">Direcci&oacute;n:&nbsp;</label></td>  
                <td><form:input id="direccion" class="form-control" path="direccion"></form:input></td>  
                </tr>
                <tr>
                    <td><label for="telefono">Telefono:&nbsp;</label></td>  
                <td><form:input id="telefono" class="form-control" path="telefono"></form:input></td>  
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