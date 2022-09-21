package com.reba.config;

import com.reba.entity.RelationEnum;
import com.reba.entity.db.Relation;
import com.reba.repository.RelationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInit implements ApplicationRunner {

    @Autowired
    RelationRepository relationRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Relation hermanx = new Relation(RelationEnum.HERMANX);
        Relation padre = new Relation(RelationEnum.PADRE);
        Relation primx = new Relation(RelationEnum.PRIMX);
        Relation tix = new Relation(RelationEnum.TIX);

        if(relationRepository.findByRelation(RelationEnum.HERMANX) == null){
            relationRepository.save(hermanx);
        }
        if(relationRepository.findByRelation(RelationEnum.PADRE) == null){
            relationRepository.save(padre);
        }
        if(relationRepository.findByRelation(RelationEnum.PRIMX) == null){
            relationRepository.save(primx);
        }
        if(relationRepository.findByRelation(RelationEnum.TIX) == null){
            relationRepository.save(tix);
        }

    }
}
