document.addEventListener('DOMContentLoaded', function() {
    const formulario = document.getElementById('formulario-envio');
    const radioDomicilio = document.getElementById('radio-domicilio');
    const inputDireccion = document.getElementById('domicilio');

    formulario.addEventListener('submit', function (event) {
        if (radioDomicilio.checked && !inputDireccion.value) {
            event.preventDefault();
            alert('Por favor, ingresa una dirección para el envío a domicilio.');
        }
    });
});