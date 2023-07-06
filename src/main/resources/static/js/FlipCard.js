// Agregar evento de clic al botón "+ info" para controlar el volteo
const flipButtons = document.querySelectorAll('.card-flip .card-front .btn-info');
flipButtons.forEach((button) => {
    button.addEventListener('click', (event) => {
        const card = event.target.closest('.card');
        card.classList.toggle('flipped');
    });
});

// Agregar evento de clic al botón "Cerrar" en la parte posterior de la tarjeta
const closeButtons = document.querySelectorAll('.card-flip .card-back .btn-close');
closeButtons.forEach((button) => {
    button.addEventListener('click', (event) => {
        const card = event.target.closest('.card');
        card.classList.toggle('flipped');
    });
});