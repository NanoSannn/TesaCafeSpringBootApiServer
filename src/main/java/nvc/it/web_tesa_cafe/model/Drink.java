package nvc.it.web_tesa_cafe.model;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document("drink")
@Getter @Setter @NoArgsConstructor
public class Drink {
    @Id
    private String _id;
    private String name;
    private String drinkTy;
    private Integer drinkPrice;
    private Number Price;
    private String img;

    @CreatedDate
    private Date createdAt;

    @LastModifiedDate
    private Date updataDate;
}
