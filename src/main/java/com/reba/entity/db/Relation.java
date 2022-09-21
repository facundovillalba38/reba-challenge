package com.reba.entity.db;

import com.reba.entity.RelationEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Relation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Enumerated(EnumType.STRING)
    RelationEnum relation;

    public Relation(RelationEnum relation) {
        this.relation = relation;
    }
    public Relation() {
    }
}
