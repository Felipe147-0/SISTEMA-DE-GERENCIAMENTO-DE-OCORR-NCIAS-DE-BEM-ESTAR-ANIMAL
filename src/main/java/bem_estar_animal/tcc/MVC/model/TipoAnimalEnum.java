package bem_estar_animal.tcc.MVC.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum TipoAnimalEnum {

    GATO("GATO"),
    CACHORRO("CACHORRO"),
    CAVALO("CAVALO"),
    AVE("AVE");

    private String descricao;
}
