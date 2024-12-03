// Configuración del listener para el formulario
document.addEventListener("DOMContentLoaded", () => {
    const form = document.querySelector("form");

    form.addEventListener("submit", async (event) => {
        event.preventDefault(); // Evita el comportamiento predeterminado del formulario

        const email = document.getElementById("email").value;
        const password = document.getElementById("password").value;

        try {
            const response = await fetch("/api/auth/login", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify({ email, password })
            });

            if (response.ok) {
                const data = await response.json();
                // Lógica en caso de login exitoso
                alert("¡Inicio de sesión exitoso!");
                window.location.href = "/dashboard"; // Redirige al dashboard o página principal
            } else {
                // Manejo de errores del backend
                const errorData = await response.json();
                alert(`Error: ${errorData.message || "No se pudo iniciar sesión"}`);
            }
        } catch (error) {
            // Manejo de errores de red u otros problemas
            console.error("Error al intentar iniciar sesión:", error);
            alert("Hubo un problema con el servidor. Inténtalo más tarde.");
        }
    });
});
