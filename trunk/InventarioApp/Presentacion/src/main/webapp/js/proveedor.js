$(document).ready(function () {

    $("#modificar-proveedor").hide();

//    $("#nombreProveedorBuscar").autocomplete({
//        source: 'cargar-proveedores',
//        select: function (event, ui) {
//            value: ui.id;
//            label: ui.nombreProveedor;
//        }
//    });


    $.ajax({
        url: 'cargar-proveedores',
        dataType: 'JSON',
        type: 'GET',
        success: function (data) {
            $("#nombreProveedorBuscar").empty();
            $("#nombreProveedorBuscar").autocomplete({
                source: data
            });
        },
        error: function (error) {
            console.log(error);
        }
    });

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
                        bootbox.alert({
                            message: data.Message,
                            buttons: {
                                success: {
                                    label: 'Aceptar',
                                    className: 'btn-success'
                                }
                            }
                        });
                        $("#list").trigger('reloadGrid');
                        $('#agregar-proveedor').each(function () {
                            this.reset();
                        });
                    },
                    error: function (error) {
                        bootbox.dialog({
                            message: error.Message,
                            buttons: {
                                danger: {
                                    label: 'Aceptar',
                                    className: 'btn-danger'
                                }
                            }
                        });
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
        colNames: ['Identificacion', 'Nombre Proveedor', 'Cédula Juridica', 'Telefono', 'Direccion'],
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
