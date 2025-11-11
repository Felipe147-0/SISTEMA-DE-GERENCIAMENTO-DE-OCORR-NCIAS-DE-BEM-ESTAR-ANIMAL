function exibirCampoObservacao() {
    // Exibe o formulário de exclusão
    document.getElementById('exclusao-form-container').style.display = 'block';

    // Oculta o botão inicial "LISTA DE EXCLUSÃO"
    document.getElementById('ativarExclusao').style.display = 'none';

    // Opcional: Faz a tela rolar para o campo de observação
    document.getElementById('observacaoLista').scrollIntoView({ behavior: 'smooth' });
}

function cancelarExclusao() {
    // Oculta o formulário de exclusão
    document.getElementById('exclusao-form-container').style.display = 'none';

    // Limpa o campo de observação
    document.getElementById('observacaoLista').value = '';

    // Reexibe o botão inicial "LISTA DE EXCLUSÃO"
    document.getElementById('ativarExclusao').style.display = 'block';

    // Opcional: Faz a tela rolar de volta para o topo da seção de botões
    document.querySelector('.botoes.mt-4').scrollIntoView({ behavior: 'smooth' });
}