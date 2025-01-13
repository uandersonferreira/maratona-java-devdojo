package estudo.uanderson.javadevdojo.javacore.ZZIjdbc.test;

import estudo.uanderson.javadevdojo.javacore.ZZIjdbc.domain.Producer;
import estudo.uanderson.javadevdojo.javacore.ZZIjdbc.service.ProduceService;
import lombok.extern.log4j.Log4j2;
import java.sql.SQLException;
import java.util.List;

@Log4j2
public class ConnectionFactoryTest01 {
    public static void main(String[] args) throws SQLException {
        Producer producer = Producer.builder()
                .name("Studio Deen ")
                .build();
        Producer producerToUpdate = Producer.builder()
                .id(2)
                .name("madhouse ")
                .build();

        ProduceService.save(producer);

//        Connection connection = ConnectionFactory.getConnection();
//        System.out.println(connection);

        //ProduceService.showProducerMetaData();
        //ProduceService.showDriverMetaData();
       // ProduceService.showTypeScrollWorking();
//        List<Producer> producers = ProduceService.findByNameAndInsertWhenNotFound("Aldeia Studios");
//        log.info("Producers found '{}'",producers)
//        ProduceService.findByNameAndDelete("Bones");
//        List<Producer> producers = ProduceService.findByNamePreparedStatement("Aldeia");
//   log.info("Producers found '{}'",producers);
//        ProduceService.updatePreparedStatement(producerToUpdate);

//        List<Producer> producers = ProduceService.findByNameCallableStatement("NHK");
//        log.info("Producers found '{}'",producers);

    }//main
}//class
/*
Formatos de mensagens do Lombock

        log.info("INFO");
        log.debug("DEBUG");
        log.warn("WARN");
        log.error("ERROR");
        log.trace("TRACE");
 */