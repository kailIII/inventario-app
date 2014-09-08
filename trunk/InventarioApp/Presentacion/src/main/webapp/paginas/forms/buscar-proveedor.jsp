
<fieldset>
    <legend>Datos del Proveedor</legend>
    <form>
        <div>
            <table>
                <tbody>
                    <tr>
                        <td>
                            <label for="nombreProveedorBuscar">Nombre Proveedor:</label>
                            <input type="text" id="nombreProveedorBuscar" />
                            <button id="btnBuscarProveedor" type="button" class="btn btn-default"><i class="fa fa-search"></i>Buscar</button>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
    </form>
</fieldset>

<div id="modificar-proveedor">
    <fieldset class="col_12">
        <legend>Datos del Proveedor</legend>
        <form:form cssClass="vertical" id="form-modifcar-proveedor" method="POST" action="actualizar-proveedor" modelAttribute="proveedor-modificar">  
            <input type="hidden" id="nombreProveedorAct" path="nombreProveedor"/>
            <input type="hidden" id="cedulaJuridicaAct" path="cedulaJuridica"/>
            <div class="col_12">
                <table>  
                    <tbody>
                    <td><form:label path="direccion">Direcci&oacute;n:</form:label></td>  
                    <td><form:input id="direccionAct" class="form-control" path="direccion"></form:input></td>  
                    </tr>
                    <tr>
                        <td><form:label path="telefono">Telefono:</form:label></td>  
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