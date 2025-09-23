package bem_estar_animal.tcc.record;

import java.time.Instant;

public record FichaRecord(
        String processo,
        String recebido_por,
        Instant data,
        Instant hora,
        String assunto,
        String desfecho_da_notificacao,
        Instant data_tramite,
        Instant hora_tramite,
        String historico,
        String animal,
        Long denunciante_id,
        Long funcionario_id
) {
}

