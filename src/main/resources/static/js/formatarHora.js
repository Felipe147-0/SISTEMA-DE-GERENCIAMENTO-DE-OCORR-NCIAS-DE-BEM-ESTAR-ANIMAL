function formatarHora(input) {
    // Salva a posição do cursor
    let cursorPos = input.selectionStart;

    // Remove tudo que não é número
    let valor = input.value.replace(/\D/g, '');

    // Limita a 4 dígitos
    if (valor.length > 4) {
        valor = valor.slice(0, 4);
    }

    // Valida e formata
    if (valor.length >= 3) {
        let horas = parseInt(valor.slice(0, 2));
        let minutos = valor.slice(2, 4);

        // Limita horas a 23
        if (horas > 23) {
            horas = 23;
            valor = '23' + minutos;
        }

        // Limita minutos a 59
        if (minutos.length === 2 && parseInt(minutos) > 59) {
            minutos = '59';
        }

        input.value = `${String(horas).padStart(2, '0')}:${minutos}`;
    } else if (valor.length === 2) {
        let horas = parseInt(valor);
        if (horas > 23) {
            horas = 23;
        }
        input.value = String(horas).padStart(2, '0');
    } else {
        input.value = valor;
    }

    // Move cursor para o final
    input.setSelectionRange(input.value.length, input.value.length);
}

// Aplica no campo de hora tramite
const campoHoraTramite = document.getElementById('horaTramite');
if (campoHoraTramite) {
    campoHoraTramite.addEventListener('input', function () {
        formatarHora(this);
    });
}