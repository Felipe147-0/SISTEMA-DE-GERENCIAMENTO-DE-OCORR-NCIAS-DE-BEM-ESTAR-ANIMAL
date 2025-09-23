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
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long longin_id;

    private String username;

    private String password;

    private Long funcionario_id;
}
