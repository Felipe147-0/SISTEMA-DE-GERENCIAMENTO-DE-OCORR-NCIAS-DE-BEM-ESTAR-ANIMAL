const inputCpf = document.getElementById("cpf");
const botao = document.getElementById("enviar");

inputCpf.addEventListener("input", function () {
    if (inputCpf.value.length > 11) {
        inputCpf.value = inputCpf.value.slice(0, 11);
    }

    const cpf = inputCpf.value.trim();

    if (cpf != null && cpf.match(/\d{11}/)) {
        botao.disabled = false;
    } else {
        botao.disabled = true;
    }
});