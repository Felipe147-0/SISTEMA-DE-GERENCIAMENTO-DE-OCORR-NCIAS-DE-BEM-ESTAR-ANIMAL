package bem_estar_animal.tcc.record;


public record FichaRecord(
                String processo,
                String recebido_por,
                Long dununcianteId,
                String assunto,
                String desfecho_da_notificacao,
                Long funcionarioId,
                String historico,
                String animal) {
}
