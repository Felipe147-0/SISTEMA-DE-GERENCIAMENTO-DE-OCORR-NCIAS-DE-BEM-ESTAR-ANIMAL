document.addEventListener("DOMContentLoaded", () => {
    const editarBtn = document.getElementById("editarBtn");
    const salvarBtn = document.getElementById("salvarBtn");
    const inputs = document.querySelectorAll("input[readonly], textarea[readonly]");

    editarBtn.addEventListener("click", () => {
        inputs.forEach(input => input.removeAttribute("readonly"));
        editarBtn.style.display = "none";
        salvarBtn.style.display = "inline-block";
    });
});
