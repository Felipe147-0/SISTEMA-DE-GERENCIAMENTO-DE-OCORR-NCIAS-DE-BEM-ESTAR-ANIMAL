function formatarData(campo) {
    let valor = campo.value.replace(/\D/g, "");

    if (valor.length >= 2) {
        let dia = valor.substring(0, 2);
        if (parseInt(dia) > 31) {
            dia = "";
        } else if (parseInt(dia) === 0) {
            dia = "01";
        }
        valor = dia + valor.substring(2);
    }

    if (valor.length >= 4) {
        let mes = valor.substring(2, 4);
        if (parseInt(mes) > 12) {
            mes = "";
        } else if (parseInt(mes) === 0) {
            mes = "01";
        }
        valor = valor.substring(0, 2) + mes + valor.substring(4);
    }

    campo.value = valor
        .replace(/(\d{2})(\d)/, "$1/$2")
        .replace(/(\d{2})(\d)/, "$1/$2")
        .slice(0, 10);
}

const todosInput = document.querySelectorAll(".data-format");

todosInput.forEach((input) => {
    input.addEventListener("input", () => formatarData(input));
});
