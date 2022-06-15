package com.recette.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


import java.io.Serial;
import java.io.Serializable;


@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Recette implements Serializable{
    @Serial
    private static final long serialVersionUID = -2628967119306944612L;
    @Id
    private String id;
    @Field("name")
    private String name;
    @Field("ingredients")
    private String ingredients;
    @Field("address")
    private String larecette;

}
