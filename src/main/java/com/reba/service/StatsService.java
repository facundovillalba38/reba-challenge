package com.reba.service;

import com.reba.entity.Stats;
import com.reba.entity.db.Person;
import com.reba.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StatsService {

    private PersonRepository personRepository;

    @Autowired
    public StatsService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }


    public List<Stats> getStats() {
        List<Person> people = personRepository.findAll();
        Integer total = people.size();
        List<Stats> stats = new ArrayList<>();
        Map<String, Long> percentage = people.stream()
                .collect(Collectors.groupingBy(Person::getNationality, Collectors.counting()));
        for(Map.Entry<String, Long> set : percentage.entrySet()){
            Stats stat = new Stats();
            stat.setCountry(set.getKey());
            stat.setPercentage(set.getValue().doubleValue() / total * 100);
            stats.add(stat);
        }
        return stats;
    }
}
