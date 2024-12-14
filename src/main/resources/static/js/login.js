document.addEventListener("DOMContentLoaded", () => {
    const form = document.querySelector("form");
    const messageContainer = document.getElementById("message-container");

    // Mostrar mensaje de error si la URL contiene el parámetro 'error'
    if (window.location.search.includes("error")) {
        displayMessage("Credenciales incorrectas. Inténtalo de nuevo.", "danger");
    }

    // Función para mostrar mensajes dinámicos
    function displayMessage(message, type) {
        messageContainer.innerHTML = `
            <div class="alert alert-${type} alert-dismissible fade show" role="alert">
                ${message}
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
        `;
    }
});
