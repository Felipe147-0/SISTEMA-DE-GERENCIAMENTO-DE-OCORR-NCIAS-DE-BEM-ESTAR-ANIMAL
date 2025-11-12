document.addEventListener("DOMContentLoaded", () => {
    // -------- ELEMENTOS --------
    const editarBtn = document.getElementById("editarBtn");
    const salvarBtn = document.getElementById("salvarBtn");
    const observacao = document.querySelector("textarea[name='observacao']");
    const tipoSelect = document.querySelector("select[name='tipo']");
    const btnGerarChip = document.getElementById("btnGerarChip");
    const btnRemoverChip = document.getElementById("btnRemoverChip");
    const chipInput = document.getElementById("numeroChip");

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

            editarBtn.style.display = "none";
            if (salvarBtn) salvarBtn.style.display = "inline-block";

            // mostrar botões de chip
            if (btnGerarChip) btnGerarChip.classList.remove("d-none");
            if (btnRemoverChip && chipInput.value) btnRemoverChip.classList.remove("d-none");
        });
    }

    // -------- GERAR CHIP --------
    if (btnGerarChip && chipInput) {
        btnGerarChip.addEventListener("click", async () => {
            try {
                btnGerarChip.disabled = true;
                btnGerarChip.innerHTML = '<span class="spinner-border spinner-border-sm me-2"></span> Gerando...';

                const response = await fetch("/animal/animais/gerar-chip");
                if (!response.ok) throw new Error("Erro ao gerar chip");

                const chip = await response.text();
                chipInput.value = chip;
                chipInput.classList.add("border-success");

                btnGerarChip.classList.remove("btn-outline-success");
                btnGerarChip.classList.add("btn-success");
                btnGerarChip.innerHTML = '<i class="bi bi-check-circle"></i> Chip Gerado';

                if (btnRemoverChip) btnRemoverChip.classList.remove("d-none");
            } catch (error) {
                console.error("Erro ao gerar chip:", error);
                btnGerarChip.innerHTML = '<i class="bi bi-exclamation-triangle"></i> Erro';
                btnGerarChip.classList.remove("btn-outline-success");
                btnGerarChip.classList.add("btn-danger");
            }
        });
    }

    // -------- REMOVER CHIP --------
    if (btnRemoverChip && chipInput) {
        btnRemoverChip.addEventListener("click", () => {
            chipInput.value = "";
            chipInput.classList.remove("border-success");

            btnRemoverChip.classList.add("d-none");

            if (btnGerarChip) {
                btnGerarChip.classList.remove("d-none");
                btnGerarChip.disabled = false;
                btnGerarChip.innerHTML = '<i class="bi bi-cpu"></i> Adicionar Chip';
                btnGerarChip.classList.remove("btn-success", "btn-danger");
                btnGerarChip.classList.add("btn-outline-success");
            }
        });
    }
});
