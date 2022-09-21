package com.reba.repository;

import com.reba.entity.RelationEnum;
import com.reba.entity.db.Relation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RelationRepository extends JpaRepository<Relation, Long> {
    Relation findByRelation(RelationEnum relation);
}
