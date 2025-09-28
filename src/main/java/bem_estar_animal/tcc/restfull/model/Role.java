package bem_estar_animal.tcc.restfull.model;

import com.fasterxml.jackson.annotation.JsonCreator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum Role {
    ADMIN("Administrador"),
    USER("Usuário"),
    VETERINARIO("Veterinário"),
    FUNCIONARIO("Funcionário"),
    SUPERVISOR("Supervisor");

    private String descricao;

   @JsonCreator
    public static Role ConvertFromString(String value) {
        for (Role role : Role.values()) {
            if (role.name().equalsIgnoreCase(value)) {
                return role;
            }
        }
        throw new IllegalArgumentException("Role inválida: " + value);
    }
}
