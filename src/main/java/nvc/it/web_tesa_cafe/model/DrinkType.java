package nvc.it.web_tesa_cafe.model;

import org.springframework.data.annotation.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class DrinkType {
    @Id
    private String _id;
    private String drinkTy;
    private Integer drinkPrice;
}
