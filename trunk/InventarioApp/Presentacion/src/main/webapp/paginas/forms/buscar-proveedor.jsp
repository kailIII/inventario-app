<%-- 
    Document   : buscar-proveedor
    Created on : 17/11/2013, 03:22:05 PM
    Author     : Erick
--%>

<fieldset>
    <legend>Datos del Proveedor</legend>
    <div>
        <table>
            <tbody>
                <tr>
                    <td>
                        <div class="ui-widget">
                            <label for="nombreProveedorBuscar">Nombre Proveedor:&nbsp;</label>
                            <select id="nombreProveedorBuscar"></select>
                        </div>
                        <button id="btnBuscarProveedor" type="button" class="btn btn-default"><i class="fa fa-search"></i>Buscar</button>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>
</fieldset>

<div id="modificar-proveedor">
    <fieldset>
        <legend>Datos del Proveedor</legend>
        <form:form role="form" id="form-modifcar-proveedor" method="POST" action="actualizar-proveedor" modelAttribute="proveedor-modificar">
            <form:hidden id="idAct" path="id"/>
            <form:hidden id="nombreProveedorAct" path="nombreProveedor"/>
            <form:hidden id="cedulaJuridicaAct" path="cedulaJuridica"/>
            <div class="col_12">
                <table>  
                    <tbody>
                    <td><label for="direccionAct">Direcci&oacute;n:&nbsp;</label></td>  
                    <td><form:input id="direccionAct" class="form-control" path="direccion"></form:input></td>  
                    </tr>
                    <tr>
                        <td><label for="telefonoAct">Telefono:&nbsp;</label></td>  
                    <td><form:input id="telefonoAct" class="form-control" path="telefono"></form:input></td>  
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