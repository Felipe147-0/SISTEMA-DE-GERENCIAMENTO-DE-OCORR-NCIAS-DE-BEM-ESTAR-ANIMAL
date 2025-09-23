package bem_estar_animal.tcc.model;


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
public class LoginSistema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long login_id;

    private String username;

    private String password;

    @OneToOne
    @JoinColumn(name = "funcionario_id", referencedColumnName = "funcionario_id")
    private Funcionario funcionario;

    @OneToOne(mappedBy = "login")
    private Role role;
}
