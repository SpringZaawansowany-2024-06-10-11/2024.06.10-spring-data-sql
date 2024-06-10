package com.comarch.szkolenia.spring.data.sql.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("stuff")
public class Stuff {
    @Id
    private String id;
    private String name;
    private int quantity;
}
