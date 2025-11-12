document.addEventListener("DOMContentLoaded", () => {
    const editarBtn = document.getElementById("editarBtn");
    const salvarBtn = document.getElementById("salvarBtn");
    const observacao = document.querySelector("textarea[name='observacao']");

    editarBtn.addEventListener("click", () => {
        if (observacao) {
            observacao.removeAttribute("readonly");
            observacao.focus();
            observacao.style.border = "2px solid #ffc107"; // destaque visual opcional
        }

        editarBtn.style.display = "none";
        salvarBtn.style.display = "inline-block";
    });
});
