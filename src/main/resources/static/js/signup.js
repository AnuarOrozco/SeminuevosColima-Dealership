document.addEventListener("DOMContentLoaded", () => {
    const form = document.querySelector("form");
    const messageContainer = document.createElement("div"); // Contenedor para mensajes
    messageContainer.id = "message-container";
    form.parentNode.insertBefore(messageContainer, form); // Lo colocamos antes del formulario

    form.addEventListener("submit", async (event) => {
        event.preventDefault();

        const nombre = document.getElementById("nombre").value.trim();
        const email = document.getElementById("email").value.trim();
        const password = document.getElementById("password").value.trim();
        const confirmPassword = document.getElementById("confirm-password").value.trim();

        // Validación básica de contraseñas
        if (password !== confirmPassword) {
            displayMessage("Las contraseñas no coinciden", "danger");
            return;
        }

        const payload = {
            name: nombre,
            email: email,
            password: password
        };

        try {
            const response = await fetch("/api/auth/register", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(payload)
            });

            if (response.ok) {
                displayMessage("Registro exitoso. Ahora puedes iniciar sesión.", "success");
                setTimeout(() => {
                    window.location.href = "login.html";
                }, 3000); // Redirección tras 3 segundos
            } else {
                const errorData = await response.json();
                displayMessage(errorData.message || "Ocurrió un problema en el registro", "danger");
            }
        } catch (error) {
            console.error("Error:", error);
            displayMessage("Error al conectar con el servidor.", "danger");
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
