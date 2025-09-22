package bem_estar_animal.tcc.model;

import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Ficha {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;

    private String processo;

    private String recebido_por;

    private Instant data;

    private Instant hora;

    private String denunciante_id;

    private String assunto;

    private String desfecho_da_notificacao;

    private String data_tramite;

    private String hora_tramite;

    private String funcionario_id;

    private String historico;

    private String animal;

}
