$.validator.addMethod("validaTelefono", function (value, element) {
    return this.optional(element) || /^\d{4}-\d{4}$/.test(value);
}, "Ingrese un n&uacute;mero de tel&eacute;fono v&aacute;lido.");

$(document).ready(function () {
    $("#cedula").val("");
    $("#usuario").val("");
    $("#modificar-usuario").hide();

    $.cargar_usuarios = function () {
        $.ajax({
            url: 'cargar-usuarios',
            dataType: 'JSON',
            type: 'GET',
            success: function (data) {
                $(data).each(function () {
                    var option = $(document.createElement("option"));
                    option.text(this.username);
                    option.val(this.id);
                    $("#nombreUsuario").append(option);
                });
            },
            error: function (error) {
                alert("Error:" + error);
            }
        });
    };

    $("#nombreUsuario").combobox();

    $.cargar_usuarios();

    $("#btnBuscarUsuario").click(function () {
        $.ajax({
            url: 'buscar-usuario-username',
            dataType: 'json',
            type: 'GET',
            data: {'idUsuario': $("#nombreUsuario").val()},
            success: function (usuario) {
                $("#idAct").val(usuario.id);
                $("#cedulaAct").val(usuario.cedula);
                $("#usuarioAct").val(usuario.usuario);
                $("#correoAct").val(usuario.correo);
                $("#contrasenaAct").val("");
                $("#confirmarContasenaAct").val("");
                $("#telefonoAct").val(usuario.telefono);
                var rolesSelect = $("#rolAct");
                for (i = 0; opt = rolesSelect[0].options[i]; i++) {
                    if (opt.value === usuario.rol) {
                        opt.selected = true;
                    } else {
                        opt.selected = false;
                    }
                }
                if (usuario.enabled) {
                    $("#habilitadoAct").prop("checked", usuario.enabled);
                } else {
                    $("#noHabilitadoAct").prop("checked", !usuario.enabled);
                }
                $("#modificar-usuario").show("slow");
            },
            error: function (error) {
                console.log(JSON.stringify(error));
            }
        });
    });

    $("#btnGuardarUsuario").click(function () {
        $("#agregar-usuario").validate({
            rules: {
                cedula: {
                    required: true,
                    maxlength: 20
                },
                username: {
                    required: true,
                    maxlength: 30,
                    remote: {
                        url: "validar-username",
                        method: "GET",
                        data: {
                            usuario: $("usuario").attr("value")
                        }
                    }
                },
                password: {
                    required: true,
                    maxlength: 15,
                    minlength: 8
                },
                confirmarContrasena: {
                    required: true,
                    maxlength: 15,
                    minlength: 8,
                    equalTo: "#password"
                },
                correo: {
                    required: true,
                    email: true
                },
                rol: {
                    required: true
                },
                telefono: {
                    required: true,
                    validaTelefono: true
                }
            },
            messages: {
                cedula: {
                    required: "Campo obligatorio",
                    maxlength: "Ha excedido el tama&ntilde;o de identificacion"
                },
                username: {
                    required: "Campo obligatorio",
                    maxlength: "Ha excedido el tama&ntilde;o del nombre de usuario",
                    remote: "El nombre de usuario ya se encuentra en uso"
                },
                password: {
                    required: "Campo obligatorio",
                    maxlength: "Ha excedido el tama�o de caracteres",
                    minlength: "La contrase&ntilde;a debe de tener al menos 8 caracteres"
                },
                confirmarContrasena: {
                    required: "Campo obligatorio",
                    maxlength: "Ha excedido el tama&ntilde;o de caracteres",
                    minlength: "La contrase&ntilde;a debe de tener al menos 8 caracteres",
                    equalTo: "Las contrase&ntilde;as no coinciden"
                },
                correo: {
                    required: "Campo obligatorio",
                    email: "Digite un correo v&aacute;lido"
                },
                rol: {
                    required: "Seleccione una opci&oacute;n"
                },
                telefono: {
                    required: "Campo obligatorio"
                }
            },
            submitHandler: function (form) {
                $.ajax({
                    url: 'agregar-usuario',
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
                        $('#agregar-usuario').each(function () {
                            this.reset();
                        });
                        $.cargar_usuarios();
                    },
                    error: function (error) {
                        alert(error.Message);
                        console.log(error.Message);
                    }
                });
            }
        });
    });

    $("#btnActualizar").click(function () {
        $("#form-modificar-usuario").validate({
            rules: {
                contrasenaAct: {
                    required: true,
                    maxlength: 15,
                    minlength: 8
                },
                confirmarContrasenaAct: {
                    required: true,
                    maxlength: 15,
                    minlength: 8,
                    equalTo: "#contrasena"
                },
                correoAct: {
                    required: false,
                    email: true
                },
                rolAct: {
                    required: true
                },
                telefonoAct: {
                    required: true,
                    matches: "[0-9]+",
                    minlength: 8,
                    maxlength: 10
                }
            },
            messages: {
                contrasenaAct: {
                    required: "Campo obligatorio",
                    maxlength: "Ha excedido el tamaño de caracteres",
                    minlength: "La contraseña debe de tener al menos 8 caracteres"
                },
                confirmarContrasenaAct: {
                    required: "Campo obligatorio",
                    maxlength: "Ha excedido el tamaño de caracteres",
                    minlength: "La contraseña debe de tener al menos 8 caracteres",
                    equalTo: "Las contraseñas no coinciden"
                },
                correoAct: {
                    email: "Digite un correo valido"
                },
                rolAct: {
                    required: "Seleccione una opción"
                },
                telefonoAct: {
                    required: "Campo obligatorio",
                    matches: "Digite solo números",
                    minlength: "Digite un telefono valido"
                }
            }
        });
    });

    $("#list").jqGrid({
        url: 'listar-usuarios',
        mtype: 'POST',
        datatype: 'json',
        jsonReader: {
            repeatitems: false,
            root: 'rows'
        },
        colNames: ['Identificaci&oacute;n', 'C&eacute;dula', 'Usuario', 'Correo Electr&oacute;nico', 'Rol', 'Tel&eacute;fono'],
        colModel: [
            {name: 'id', index: 'id', align: 'center', search: false, hidden: true},
            {name: 'cedula', index: 'cedula', align: 'center', search: false},
            {name: 'username', index: 'username', align: 'center', search: false},
            {name: 'correo', index: 'correo', align: 'center', search: false},
            {name: 'rol', index: 'rol', align: 'center', search: false},
            {name: 'telefono', index: 'telefono', align: 'center', search: false}
        ],
        caption: 'Lista de Usuarios',
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

    /*Plugin jqGrid responsive*/
    $(window).on("resize", function () {
        var $grid = $("#list"),
                newWidth = $grid.closest(".ui-jqgrid").parent().width();
        $grid.jqGrid("setGridWidth", newWidth, true);
    });

});