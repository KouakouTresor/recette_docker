package com.recette.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recette {
    @Id
    private String id;
    @Field("name")
    private String name;
    @Field("ingredients")
    private String ingredients;
    @Field("larecette")
    private String larecette;


}
