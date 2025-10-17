package bem_estar_animal.tcc.MVC.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum TipoUsuarioEnum {
    
    ADMIN("Administrador"),
    USER("Usuário"),
    VETERINARIO("Veterinário"),
    FUNCIONARIO("Funcionário"),
    SUPERVISOR("Supervisor");

    private String descricao;

//    @JsonCreator
//     public static TipoUsuario ConvertFromString(String value) {
//         for (TipoUsuario role : TipoUsuario.values()) {
//             if (role.name().equalsIgnoreCase(value)) {
//                 return role;
//             }
//         }
//         throw new IllegalArgumentException("tipo inválido: " + value);
//     }
}
