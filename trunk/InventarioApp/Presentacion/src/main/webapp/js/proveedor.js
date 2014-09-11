$(document).ready(function () {

    $("#modificar-proveedor").hide();

    $.ajax({
        url: 'cargar-proveedores',
        dataType: 'JSON',
        type: 'GET',
        success: function (data) {
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
            }
        });
    });

    $("#list").jqGrid({
        url: 'listar-proveedores',
        mtype: 'POST',
        dataType: 'xml',
        xmlReader: {
            repeatitems: false,
            root: 'rows',
            row: 'proveedor',
            page: "rows>page",
            total: "rows>total",
            records: "rows>records"
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