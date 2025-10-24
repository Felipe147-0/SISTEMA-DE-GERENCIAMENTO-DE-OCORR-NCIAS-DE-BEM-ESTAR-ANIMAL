function formatarData(campo) {
    campo.value = campo.value
    .replace(/\D/g, "")
    .replace(/(\d{2})(\d)/, "$1/$2")
    .replace(/(\d{2})(\d)/, "$1/$2")
    .slice(0,10);
}

const input = document.getElementById("dataTramite");
input.addEventListener("input", () => formatarData(input));

// TODO inserir verificador de data