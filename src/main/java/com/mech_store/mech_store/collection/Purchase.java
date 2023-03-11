package com.mech_store.mech_store.collection;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Purchase {
    @NotNull
    private String amount;
}
