document.getElementById("pedidoForm").addEventListener("submit", function(event) {
    event.preventDefault(); // Evita el envío del formulario
    // Obtén el valor del primer input por su identificador
    // Asigna el valor al campo oculto del formulario
    document.getElementById("cantidad").value = document.getElementById("cantidadAComprar").value;
    // Envía el formulario
    event.target.submit();
});