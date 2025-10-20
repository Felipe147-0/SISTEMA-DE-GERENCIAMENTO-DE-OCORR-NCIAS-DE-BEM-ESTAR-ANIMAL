package bem_estar_animal.tcc.MVC.model;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonManagedReference;

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
    private Long id_ficha;

    private String processo_ouvidoria;

    private String recebido_por_secretaria;
    
    private String recebido_por_ouvidoria;

    private Instant data_ouvidoria;

    private Instant hora_ouvidoria;

    @OneToOne
    @JoinColumn(name = "denunciante_id", referencedColumnName = "id_denunciante")
    @JsonManagedReference
    private Denunciante denunciante;

    private String desfecho_da_notificacao;

    private Instant data_secretaria;

    private Instant hora_secretaria;

    @ManyToOne
    @JoinColumn(name = "funcionario_id", referencedColumnName = "id_funcionario")
    private Funcionario funcionario;

    private String historico;

    private String animal;

    private String processo_secretaria;

    private String fiscal;

    private Instant data_tramite;

    private Instant hora_tramite;

    private String assunto;

    private int interno;

    private String protocolo;

}
