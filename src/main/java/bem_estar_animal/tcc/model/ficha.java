package bem_estar_animal.tcc.model;

import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ficha_id;

    private String processo;

    private String recebido_por;

    private Instant data;

    private Instant hora;

    @OneToOne
    @JoinColumn(name = "denunciante_id", referencedColumnName = "denunciante_id")
    private Denunciante denunciante;

    private String assunto;

    private String desfecho_da_notificacao;

    private Instant data_tramite;

    private Instant hora_tramite;

    @ManyToOne
    @JoinColumn(name = "funcionario_id", referencedColumnName = "funcionario_id")
    private Funcionario funcionario;

    private String historico;

    private String animal;

}
