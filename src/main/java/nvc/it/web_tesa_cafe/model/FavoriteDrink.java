package nvc.it.web_tesa_cafe.model;

import org.springframework.data.annotation.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class FavoriteDrink {
    @Id
    private String id;
    private String drinkName;
    private String drinkType;
}
