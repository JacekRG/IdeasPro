package pl.jacekplacek.ideasPro.category.domain.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "categories")
public class Category {
    private String name;
    @Id
    private UUID id;

    public Category() {
        this.id = UUID.randomUUID();
    }

    public Category(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
