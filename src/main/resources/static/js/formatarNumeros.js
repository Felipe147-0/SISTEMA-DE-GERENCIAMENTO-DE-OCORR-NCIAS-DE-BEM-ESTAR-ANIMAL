// Script genérico para validação de campos numéricos
// Adicione a classe "apenas-numeros" em qualquer input que deve aceitar somente números

document.addEventListener('DOMContentLoaded', function() {
    // Seleciona todos os inputs com a classe "apenas-numeros"
    const camposNumericos = document.querySelectorAll('.apenas-numeros');
    
    camposNumericos.forEach(function(campo) {
        // Bloqueia a digitação de caracteres não numéricos
        campo.addEventListener('keypress', function(e) {
            // Permite apenas números (0-9)
            const char = String.fromCharCode(e.which);
            if (!/[0-9]/.test(char)) {
                e.preventDefault();
            }
        });
        
        // Remove caracteres não numéricos ao digitar
        campo.addEventListener('input', function(e) {
            // Remove tudo que não for número
            this.value = this.value.replace(/[^0-9]/g, '');
        });
        
        // Previne colar texto com caracteres não numéricos
        campo.addEventListener('paste', function(e) {
            // Pequeno delay para processar após o paste
            setTimeout(() => {
                this.value = this.value.replace(/[^0-9]/g, '');
            }, 10);
        });
    });
});