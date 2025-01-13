package estudo.uanderson.javadevdojo.javacore.ZZIjdbc.test;

import estudo.uanderson.javadevdojo.javacore.ZZIjdbc.domain.Producer;
import estudo.uanderson.javadevdojo.javacore.ZZIjdbc.repository.ProducerRepositoryRowSet;
import estudo.uanderson.javadevdojo.javacore.ZZIjdbc.service.ProducerServiceRowSet;
import lombok.extern.log4j.Log4j2;

import java.util.List;

@Log4j2
public class ConnectionFactoryTest02 {
    public static void main(String[] args) {
        Producer producerToUpdate = Producer.builder()
                .id(2)
                .name("MADHOUSE2")
                .build();

        //ProducerRepositoryRowSet.updateJdbcRowSet(producerToUpdate);
        ProducerRepositoryRowSet.updateCacheRowSet(producerToUpdate);
        log.info("-------------------------");
        List<Producer> producers = ProducerServiceRowSet.findByNameJdbcRowSet(" ");
        log.info(producers);


    }//amin
}//class
