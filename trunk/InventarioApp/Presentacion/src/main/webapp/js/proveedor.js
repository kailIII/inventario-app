$(document).ready(function () {

    $("#modificar-proveedor").hide();


    $.fn.cargar_proveedores = function () {
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
    };
    
    $.cargar_proveedores();
    
    $("#btnBuscarProveedor").click(function () {
        $.ajax({
            url: 'buscar-proveedor-nombre',
            dataType: 'json',
            type: 'GET',
            data: {'nombreProveedor': $("#nombreProveedorBuscar").val()},
            beforeSend: function () {
            },
            success: function (proveedor) {
                $("#nombreProveedorAct").val(proveedor.nombreProveedor);
                $("#cedulaJuridicaAct").val(proveedor.cedulaJuridica);
                $("#direccionAct").val(proveedor.direccion);
                $("#telefonoAct").val(proveedor.telefono);
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
                    success: function (data) {
                        console.log("Agregado correctamente");
                        $("#list").trigger('reloadGrid');
                        $.cargar_proveedores();
                        $('#agregar-proveedor').each(function () {
                            this.reset();
                        });
                    },
                    error: function (error) {
                        alert("Error");
                        console.log(error);
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
        ajaxGridOptions: {Accept: 'application/json'},
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
            {name: 'id', index: 'id', align: 'center', search: false},
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
