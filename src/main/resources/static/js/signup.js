// signup.js

document.addEventListener("DOMContentLoaded", () => {
    const form = document.querySelector("form");

    form.addEventListener("submit", async (event) => {
        event.preventDefault();

        const nombre = document.getElementById("nombre").value.trim();
        const email = document.getElementById("email").value.trim();
        const password = document.getElementById("password").value.trim();
        const confirmPassword = document.getElementById("confirm-password").value.trim();

        if (password !== confirmPassword) {
            alert("Las contraseñas no coinciden");
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
                alert("Registro exitoso. Ahora puedes iniciar sesión.");
                window.location.href = "login.html";
            } else {
                const errorData = await response.json();
                alert(`Error: ${errorData.message || "Ocurrió un problema en el registro"}`);
            }
        } catch (error) {
            console.error("Error:", error);
            alert("Error al conectar con el servidor.");
        }
    });
});
