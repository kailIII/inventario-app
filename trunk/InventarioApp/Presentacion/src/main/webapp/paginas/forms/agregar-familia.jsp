<fieldset>
    <legend>Datos de la familia de producto</legend>
    <form:form role="form" id="agregar-familia" modelAttribute="familia">
        <div>
            <table>  
                <tbody>
                    <tr>
                        <td><label for="descripcion">Descripcion Familia de Producto:&nbsp;</label></td>  
                <td><form:input id="descripcion" class="form-control" path="descripcion"></form:input></td>  
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