

<fieldset class="col_12">
    <legend>Datos de la familia</legend>
    <form:form cssClass="vertical" method="POST" id="frmFamilia" modelAttribute="familia" action="#">  
        <div class="col_12">
            <table>  
                <tbody>
                    <tr>  
                        <td><form:label path="descripcion">Descripci&oacute;n:</form:label></td>  
                <td><form:input id="descripcion" path="descripcion"></form:input></td>  
                </tr
                <tr>  
                    <td colspan="2">
                        <button type="submit" class="inset"><i class="icon-save"></i>Guardar</button>
                        <button type="reset" class="inset"><i class="icon-remove"></i>Cancelar</button>
                    </td>  
                    <td></td>  
                    <td></td>  
                </tr>  
                </tbody>
            </table>
        </div>    
    </form:form>  
</fieldset>