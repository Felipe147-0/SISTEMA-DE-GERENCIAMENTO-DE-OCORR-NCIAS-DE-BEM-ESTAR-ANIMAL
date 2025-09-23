package bem_estar_animal.tcc.model;

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
public class Endereco {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long endereco_id;

    private String logradouro;
    
    private String bairro;

    private String ponto_de_referencia;
}
