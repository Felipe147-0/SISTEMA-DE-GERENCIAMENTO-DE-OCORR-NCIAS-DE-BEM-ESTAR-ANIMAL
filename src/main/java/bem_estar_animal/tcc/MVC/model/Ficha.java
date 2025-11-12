package bem_estar_animal.tcc.MVC.model;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
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

    @Column(name = "processo_ouvidoria")
    private String processoOuvidoria;

    private String recebido_por_secretaria;

    private String recebido_por_ouvidoria;

    private String data_ouvidoria;

    private String hora_ouvidoria;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "denunciante_id", referencedColumnName = "id_denunciante")
    private Denunciante denunciante;

    private String desfecho_da_notificacao;

    private String data_secretaria;

    private String hora_secretaria;

    @ManyToOne
    @JoinColumn(name = "funcionario_id", referencedColumnName = "id_funcionario")
    private Funcionario funcionario;

    private String historico;

    @OneToMany(mappedBy = "ficha")
    private List<Animal> animal = new ArrayList<>();

    private String processo_secretaria;

    private String fiscal;

    private String data_tramite;

    private String hora_tramite;

    private String assunto;

    private int interno;

    private String protocolo;

}
