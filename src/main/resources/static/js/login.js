document.addEventListener("DOMContentLoaded", () => {
    const form = document.querySelector("form");
    const messageContainer = document.createElement("div"); // Contenedor para mensajes
    messageContainer.id = "message-container";
    form.parentNode.insertBefore(messageContainer, form); // Colocar antes del formulario

    form.addEventListener("submit", async (event) => {
        event.preventDefault();

        const email = document.getElementById("email").value.trim();
        const password = document.getElementById("password").value.trim();

        try {
            const response = await fetch("/api/auth/login", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify({ email, password })
            });

            if (response.ok) {
                displayMessage("¡Inicio de sesión exitoso! Redirigiendo...", "success");
                setTimeout(() => {
                    window.location.href = "/dashboard"; // Redirige tras 2 segundos
                }, 2000);
            } else {
                const errorData = await response.json();
                displayMessage(errorData.message || "No se pudo iniciar sesión. Verifica tus credenciales.", "danger");
            }
        } catch (error) {
            console.error("Error al intentar iniciar sesión:", error);
            displayMessage("Hubo un problema con el servidor. Inténtalo más tarde.", "danger");
        }
    });

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
