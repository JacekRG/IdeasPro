package pl.jacekplacek.ideasPro.question.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "questions")
public class  Question {
    private String name;
    @Id
    private UUID id;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Question{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    public Question() {
    }

    public Question(String name) {
        this.name = name;
        this.id = UUID.randomUUID();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
