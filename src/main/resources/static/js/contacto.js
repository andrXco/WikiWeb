(function () {
    "use strict";

    var form = document.getElementById("form-contacto");
    if (!form) {
        return;
    }

    var status = document.getElementById("form-status");
    var mensajeInput = document.getElementById("mensaje");
    var contador = document.getElementById("contador-mensaje");

    var MENSAJE_MIN = 20;
    var MENSAJE_MAX = 400;
    var TELEFONO_MIN = 7;
    var TELEFONO_MAX = 15;

    var validators = {
        nombre: function (value) {
            var trimmed = value.trim();
            if (trimmed.length === 0) {
                return "El nombre completo es obligatorio.";
            }
            if (trimmed.length < 3) {
                return "El nombre debe tener al menos 3 caracteres.";
            }
            return null;
        },
        correo: function (value) {
            var trimmed = value.trim();
            if (trimmed.length === 0) {
                return "El correo electrónico es obligatorio.";
            }
            var patron = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
            if (!patron.test(trimmed)) {
                return "Ingresa un correo válido, por ejemplo nombre@dominio.com.";
            }
            return null;
        },
        telefono: function (value) {
            var trimmed = value.trim();
            if (trimmed.length === 0) {
                return "El teléfono es obligatorio.";
            }
            if (!/^[0-9]+$/.test(trimmed)) {
                return "El teléfono solo debe contener números.";
            }
            if (trimmed.length < TELEFONO_MIN || trimmed.length > TELEFONO_MAX) {
                return "El teléfono debe tener entre " + TELEFONO_MIN + " y " + TELEFONO_MAX + " dígitos.";
            }
            return null;
        },
        asunto: function (value) {
            if (!value || value.trim().length === 0) {
                return "Selecciona un asunto o motivo de contacto.";
            }
            return null;
        },
        mensaje: function (value) {
            var length = value.trim().length;
            if (length === 0) {
                return "El mensaje es obligatorio.";
            }
            if (length < MENSAJE_MIN) {
                return "El mensaje debe tener al menos " + MENSAJE_MIN + " caracteres (van " + length + ").";
            }
            if (length > MENSAJE_MAX) {
                return "El mensaje no puede superar los " + MENSAJE_MAX + " caracteres.";
            }
            return null;
        }
    };

    function campoEnvoltura(nombreCampo) {
        return form.querySelector('[data-field="' + nombreCampo + '"]');
    }

    function mostrarError(nombreCampo, mensajeError) {
        var envoltura = campoEnvoltura(nombreCampo);
        var errorEl = document.getElementById("error-" + nombreCampo);
        if (mensajeError) {
            envoltura.classList.add("is-invalid");
            errorEl.textContent = mensajeError;
        } else {
            envoltura.classList.remove("is-invalid");
            errorEl.textContent = "";
        }
    }

    function validarCampo(nombreCampo) {
        var input = document.getElementById(nombreCampo);
        var error = validators[nombreCampo](input.value);
        mostrarError(nombreCampo, error);
        return error === null;
    }

    function actualizarContador() {
        var length = mensajeInput.value.trim().length;
        var restantes = MENSAJE_MAX - mensajeInput.value.length;

        if (length < MENSAJE_MIN) {
            contador.textContent = "Van " + length + " de " + MENSAJE_MIN + " caracteres mínimos. Quedan " + restantes + " disponibles.";
        } else {
            contador.textContent = "Quedan " + restantes + " caracteres disponibles.";
        }
    }

    Object.keys(validators).forEach(function (nombreCampo) {
        var input = document.getElementById(nombreCampo);
        input.addEventListener("blur", function () {
            validarCampo(nombreCampo);
        });
        input.addEventListener("input", function () {
            if (campoEnvoltura(nombreCampo).classList.contains("is-invalid")) {
                validarCampo(nombreCampo);
            }
        });
    });

    mensajeInput.addEventListener("input", actualizarContador);
    actualizarContador();

    form.addEventListener("submit", function (evento) {
        var camposValidos = Object.keys(validators).map(validarCampo);
        var formularioValido = camposValidos.every(Boolean);

        if (!formularioValido) {
            evento.preventDefault();
            status.className = "form-status status-error";
            status.textContent = "Revisa los campos marcados en rojo antes de enviar el formulario.";
            status.setAttribute("role", "alert");
            var primerInvalido = form.querySelector(".is-invalid input, .is-invalid select, .is-invalid textarea");
            if (primerInvalido) {
                primerInvalido.focus();
            }
        } else {
            status.className = "form-status status-success";
            status.textContent = "Formulario válido, enviando...";
        }
    });
})();
