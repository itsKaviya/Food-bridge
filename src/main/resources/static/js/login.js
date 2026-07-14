async function login() {

    const email = document.getElementById("email").value.trim();

    const password = document.getElementById("password").value.trim();

    if (email === "" || password === "") {

        alert("Please enter email and password.");

        return;

    }

    const response = await fetch("/api/auth/login", {

        method: "POST",

        headers: {

            "Content-Type": "application/json"

        },

        body: JSON.stringify({

            email,

            password

        })

    });

    if (response.ok) {

        const data = await response.json();

        localStorage.setItem("token", data.token);

        window.location = "/dashboard";

    } else {

        alert("Invalid email or password.");

    }

}