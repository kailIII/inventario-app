$(document).ready(function () {

    $.cargar_proveedores = function () {
        $.ajax({
            url: 'cargar-proveedores',
            dataType: 'html',
            type: 'GET',
            success: function (data) {
                $("#nombreProveedorBuscar").html("");
                $("#nombreProveedorBuscar").html(data);
            },
            error: function (error) {
                alert("Error:" + error);
            }
        });
    };
    
    $.cargar_proveedores();
    
    $("#nombreProveedorBuscar").combobox();

    $("#modificar-proveedor").hide();

    $("#btnBuscarProveedor").click(function () {
        $.ajax({
            url: 'buscar-proveedor-nombre',
            dataType: 'json',
            type: 'GET',
            data: {'nombreProveedor': $("#nombreProveedorBuscar").val()},
            beforeSend: function () {
            },
            success: function (proveedor) {
                $("#idAct").prop("value", proveedor.id);
                $("#nombreProveedorAct").prop("value", proveedor.nombreProveedor);
                $("#cedulaJuridicaAct").prop("value", proveedor.cedulaJuridica);
                $("#direccionAct").prop("value", proveedor.direccion);
                $("#telefonoAct").prop("value", proveedor.telefono);
                $("#modificar-proveedor").show("slow");
            },
            error: function (error) {
                alert(error);
                console.log(error);
            }
        });
    });

    $("#btnGuardar").click(function () {
        $("#agregar-proveedor").validate({
            rules: {
                nombreProveedor: {
                    required: true
                },
                cedulaJuridica: {
                    required: true
                },
                direccion: {
                    required: true
                },
                telefono: {
                    required: true
                }
            },
            messages: {
                nombreProveedor: {
                    required: "Campo obligatorio"
                },
                cedulaJuridica: {
                    required: "Campo obligatorio"
                },
                direccion: {
                    required: "Campo obligatorio"
                },
                telefono: {
                    required: "Campo obligatorio"
                }
            },
            submitHandler: function (form) {
                $.ajax({
                    url: 'agregar-proveedor',
                    data: $(form).serialize(),
                    dataType: 'JSON',
                    type: 'POST',
                    beforeSend: function () {
                        // Codigo para mostrar el spinner
                    },
                    complete: function () {
                        // Codigo para ocultar el spinner
                    },
                    success: function (data) {
                        alert(data.Message);
                        $("#list").trigger('reloadGrid');
                        $("#agregar-proveedor").each(function () {
                            this.reset();
                        });
                        $.cargar_proveedores();
                    },
                    error: function (error) {
                        alert(error.Message);
                        console.log(error.Message);
                    }
                });
                return false;
            }
        });
    });

    $("#list").jqGrid({
        url: 'listar-proveedores',
        mtype: 'POST',
        datatype: 'json',
        //ajaxGridOptions: {Accept: 'application/json'},
        /*xmlReader: {
         repeatitems: false,
         root: 'rows',
         row: 'proveedor',
         page: "rows>page",
         total: "rows>total",
         records: "rows>records"
         },*/
        jsonReader: {
            repeatitems: false,
            root: 'rows'
        },
        colNames: ['Identificaci&oacute;n', 'Nombre Proveedor', 'C&eacute;dula Jur&iacute;dica', 'Tel&eacute;fono', 'Direcci&oacute;n'],
        colModel: [
            {name: 'id', index: 'id', align: 'center', search: false, hidden: true},
            {name: 'nombreProveedor', index: 'nombreProveedor', align: 'center', search: false},
            {name: 'cedulaJuridica', index: 'cedulaJuridica', align: 'center', search: false},
            {name: 'telefono', index: 'telefono', align: 'center', search: false},
            {name: 'direccion', index: 'direccion', align: 'center', search: false}
        ],
        caption: 'Lista de Proveedores',
        pager: '#pager',
        height: 'auto',
        rowNum: 15,
        rowList: [15, 30, 45],
        sortname: 'id',
        sortorder: 'asc',
        viewrecords: true,
        pagination: true,
        pgbuttons: true,
        emptyrecords: "No hay datos disponibles"
    });
});
