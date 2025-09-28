package bem_estar_animal.tcc.restfull.record;

import bem_estar_animal.tcc.restfull.model.Role;

public record LoginRecord(String username, String password, Long funcionarioId, Role role) {

}
