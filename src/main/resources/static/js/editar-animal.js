document.addEventListener("DOMContentLoaded", () => {
    const editarBtn = document.getElementById("editarBtn");
    const salvarBtn = document.getElementById("salvarBtn");
    const observacao = document.querySelector("textarea[name='observacao']");
    const tipoSelect = document.querySelector("select[name='tipo']");
    const btnGerarChip = document.getElementById("btnGerarChip");
    const btnRemoverChip = document.getElementById("btnRemoverChip");
    const chipInput = document.getElementById("numeroChip");

    const idAnimal = document.querySelector("form").dataset.animalId;

    // -------- EDITAR / SALVAR --------
    if (editarBtn) {
        editarBtn.addEventListener("click", () => {
            if (observacao) {
                observacao.removeAttribute("readonly");
                observacao.focus();
                observacao.style.border = "2px solid #ff0707ff";
            }

            if (tipoSelect) {
                tipoSelect.removeAttribute("disabled");
                tipoSelect.style.border = "2px solid #ff0707ff";
            }

            // Mostrar botão correto de chip
            if (chipInput.value) {
                // Já possui chip: mostrar botão de remover
                btnRemoverChip.classList.remove("d-none");
                btnGerarChip.classList.add("d-none");
            } else {
                // Não possui chip: mostrar botão de gerar
                btnGerarChip.classList.remove("d-none");
                btnRemoverChip.classList.add("d-none");
            }

            editarBtn.style.display = "none";
            if (salvarBtn) salvarBtn.style.display = "inline-block";
        });
    }

    // -------- GERAR CHIP --------
    if (btnGerarChip) {
        btnGerarChip.addEventListener("click", async () => {
            try {
                btnGerarChip.disabled = true;
                btnGerarChip.innerHTML = '<span class="spinner-border spinner-border-sm me-2"></span> Gerando...';

                const response = await fetch(`/animal/animais/gerar-chip?idAnimal=${idAnimal}`);
                if (!response.ok) throw new Error("Erro ao gerar chip");

                const chip = await response.text();
                chipInput.value = chip;
                chipInput.classList.add("border-success");

                // Esconde botão de gerar e mostra remover
                btnGerarChip.classList.add("d-none");
                btnRemoverChip.classList.remove("d-none");
            } catch (error) {
                console.error("Erro ao gerar chip:", error);
                btnGerarChip.innerHTML = '<i class="bi bi-exclamation-triangle"></i> Erro';
                btnGerarChip.className = "btn btn-danger btn-custom"; // resetar classes
            }
        });
    }

    // -------- REMOVER CHIP --------
    if (btnRemoverChip) {
        btnRemoverChip.addEventListener("click", async () => {
            const response = await fetch(`/animal/animais/remover-chip?idAnimal=${idAnimal}`, { method: "POST" });
            if (response.ok) {
                chipInput.value = "";
                chipInput.classList.remove("border-success");

                // Esconde botão de remover
                btnRemoverChip.classList.add("d-none");

                // Mostra botão de gerar e reseta totalmente seu estado
                btnGerarChip.className = "btn btn-outline-success btn-custom"; // reseta classes
                btnGerarChip.disabled = false;
                btnGerarChip.innerHTML = '<i class="bi bi-cpu"></i> Adicionar Chip';
                btnGerarChip.classList.remove("d-none");
            }
        });
    }
});
