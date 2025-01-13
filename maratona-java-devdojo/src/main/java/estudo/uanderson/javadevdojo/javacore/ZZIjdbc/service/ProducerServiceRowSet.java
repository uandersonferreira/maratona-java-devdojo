package estudo.uanderson.javadevdojo.javacore.ZZIjdbc.service;

import estudo.uanderson.javadevdojo.javacore.ZZIjdbc.domain.Producer;
import estudo.uanderson.javadevdojo.javacore.ZZIjdbc.repository.ProducerRepositoryRowSet;

import java.util.List;

public class ProducerServiceRowSet {
    public static List<Producer> findByNameJdbcRowSet(String name){
        return ProducerRepositoryRowSet.findByNameJdbcRowSet(name);
    }

    public static void updateJdbcRowSet(Producer producer){
         ProducerRepositoryRowSet.updateJdbcRowSet(producer);
    }

    public static void updateCacheRowSet(Producer producer){
         ProducerRepositoryRowSet.updateCacheRowSet(producer);
    }


    }//class
