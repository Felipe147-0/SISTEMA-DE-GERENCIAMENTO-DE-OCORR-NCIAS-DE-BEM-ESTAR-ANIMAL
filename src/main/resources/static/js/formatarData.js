function formatarData(campo) {
    let valor = campo.value.replace(/\D/g, "");

    // Valida dia (01-31)
    if (valor.length >= 2) {
        let dia = valor.substring(0, 2);
        if (parseInt(dia) > 31) {
            dia = "31";
        } else if (parseInt(dia) === 0) {
            dia = "01";
        }
        valor = dia + valor.substring(2);
    }

    // Valida mês (01-12)
    if (valor.length >= 4) {
        let mes = valor.substring(2, 4);
        if (parseInt(mes) > 12) {
            mes = "12";
        } else if (parseInt(mes) === 0) {
            mes = "01";
        }
        valor = valor.substring(0, 2) + mes + valor.substring(4);
    }

    // Formata com barras
    campo.value = valor
        .replace(/(\d{2})(\d)/, "$1/$2")
        .replace(/(\d{2})(\d)/, "$1/$2")
        .slice(0, 10);
}

const input = document.getElementById("dataTramite");
input.addEventListener("input", () => formatarData(input));

// Validação completa ao sair do campo
/*
input.addEventListener("blur", function() {
    const regex = /^(0[1-9]|[12][0-9]|3[01])\/(0[1-9]|1[0-2])\/\d{4}$/;

    if (this.value && !regex.test(this.value)) {
        alert("Data inválida! Use o formato DD/MM/AAAA");
        this.focus();
    }
});*/
