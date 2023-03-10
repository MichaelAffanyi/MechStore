package com.mech_store.mech_store.collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Products {
    private String name;
    private String image;
    private String description;
    private String price;
}
