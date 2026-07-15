document.addEventListener("DOMContentLoaded", () => {

    console.log("FoodBridge Loaded");

    const buttons = document.querySelectorAll(".btn");

    buttons.forEach(button => {

        button.addEventListener("mouseenter", () => {

            button.style.transform = "scale(1.05)";
            button.style.transition = "0.3s";

        });

        button.addEventListener("mouseleave", () => {

            button.style.transform = "scale(1)";

        });

    });

});