package bem_estar_animal.tcc.restfull.record;

import bem_estar_animal.tcc.MVC.model.TipoUsuarioEnum;

public record LoginRecord(String username, String password, Long funcionarioId, TipoUsuarioEnum role) {

}
