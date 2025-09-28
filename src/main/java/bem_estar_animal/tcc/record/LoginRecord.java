package bem_estar_animal.tcc.record;

import bem_estar_animal.tcc.model.Role;

public record LoginRecord(String username, String password, Long funcionarioId, Role role) {

}
