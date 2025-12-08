function formatarTelefone(input) {
    // Salva a posição do cursor
    let cursorPos = input.selectionStart;
    let valorAntigo = input.value;
    
    // Remove tudo que não é número
    let valor = input.value.replace(/\D/g, '');
    
    // Limita a 11 dígitos
    if (valor.length > 11) {
        valor = valor.slice(0, 11);
    }
    
    // Formata conforme o tamanho
    let valorFormatado = '';
    
    if (valor.length === 0) {
        valorFormatado = '';
    } else if (valor.length === 1) {
        valorFormatado = `(${valor}`;
    } else if (valor.length === 2) {
        valorFormatado = `(${valor})`;
    } else if (valor.length === 3) {
        valorFormatado = `(${valor.slice(0, 2)}) ${valor.slice(2)}`;
    } else if (valor.length <= 6) {
        valorFormatado = `(${valor.slice(0, 2)}) ${valor.slice(2)}`;
    } else if (valor.length <= 10) {
        // (16) 3333-4444
        valorFormatado = `(${valor.slice(0, 2)}) ${valor.slice(2, 6)}-${valor.slice(6)}`;
    } else {
        // (16) 99999-9999
        valorFormatado = `(${valor.slice(0, 2)}) ${valor.slice(2, 7)}-${valor.slice(7)}`;
    }
    
    input.value = valorFormatado;
    
    // Ajusta a posição do cursor
    if (valorFormatado.length < valorAntigo.length) {
        // Se está apagando, mantém o cursor onde está
        input.setSelectionRange(cursorPos, cursorPos);
    } else {
        // Se está digitando, move o cursor para o final
        input.setSelectionRange(valorFormatado.length, valorFormatado.length);
    }
}

// Aguarda o DOM carregar
document.addEventListener('DOMContentLoaded', function() {
    
    // Aplica no campo de telefone
    const campoTelefone = document.getElementById('telefone');
    if (campoTelefone) {
        campoTelefone.addEventListener('input', function() {
            formatarTelefone(this);
        });
    }
});