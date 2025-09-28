package bem_estar_animal.tcc.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_login;

    private String username;

    private String password;

    @OneToOne
    @JoinColumn(name = "funcionario_id", referencedColumnName = "id_funcionario")
    @JsonManagedReference
    private Funcionario funcionario;

    @OneToOne(mappedBy = "login")
    @JsonManagedReference
    private Role role;
}
