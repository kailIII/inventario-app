$(document).ready(function() {
    $("#cedula").val("");
    $("#usuario").val("");
    $("#modificar-usuario").hide();
    $.ajax({
        url: 'cargar-usuarios',
        dataType: 'JSON',
        type: 'GET',
        success: function(data) {
            $("#nombreUsuario").autocomplete({
                source: data
            });
        },
        error: function(error) {
            console.log(error);
        }
    });

    $("#btnBuscarUsuario").click(function() {
        $.ajax({
            url: 'buscar-usuario-username',
            dataType: 'json',
            type: 'GET',
            data: {'nombreUsuario': $("#nombreUsuario").val()},
            success: function(usuario) {
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
                if (usuario.habilitado) {
                    $("#habilitadoAct").prop("checked", usuario.habilitado);
                } else {
                    $("#noHabilitadoAct").prop("checked", !usuario.habilitado);
                }
                $("#modificar-usuario").show("slow");
            },
            error: function(error) {
                console.log(JSON.stringify(error));
            }
        });
    });

    $("#btnGuardar").click(function() {
        $("#agregar-usuario").validate({
            rules: {
                cedula: {
                    required: true,
                    maxlength: 20
                },
                usuario: {
                    required: true,
                    maxlength: 30,
                    remote: {
                        url: "validar-username",
                        method: "POST",
                        data: {
                            usuario: $("usuario").attr("value")
                        }
                    }
                },
                contrasena: {
                    required: true,
                    maxlength: 15,
                    minlength: 8
                },
                confirmarContrasena: {
                    required: true,
                    maxlength: 15,
                    minlength: 8,
                    equalTo: "#contrasena"
                },
                correo: {
                    required: false,
                    email: true
                },
                rol: {
                    required: true
                },
                telefono: {
                    required: true,
                    matches: "[0-9]+",
                    minlength: 8,
                    maxlength: 10
                }
            },
            messages: {
                cedula: {
                    required: "Campo obligatorio",
                    maxlength: "Ha excedido el tamaño de identificacion"
                },
                usuario: {
                    required: "Campo obligatorio",
                    maxlength: "Ha excedido el tamaño del nombre de usuario",
                    remote: "El nombre de usuario ya se encuentra en uso"
                },
                contrasena: {
                    required: "Campo obligatorio",
                    maxlength: "Ha excedido el tamaño de caracteres",
                    minlength: "La contraseña debe de tener al menos 8 caracteres"
                },
                confirmarContrasena: {
                    required: "Campo obligatorio",
                    maxlength: "Ha excedido el tamaño de caracteres",
                    minlength: "La contraseña debe de tener al menos 8 caracteres",
                    equalTo: "Las contraseñas no coinciden"
                },
                correo: {
                    email: "Digite un correo valido"
                },
                rol: {
                    required: "Seleccione una opción"
                },
                telefono: {
                    required: "Campo obligatorio",
                    matches: "Digite solo números",
                    minlength: "Digite un telefono valido"
                }
            }
        });
    });

    $("#btnActualizar").click(function() {
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
});