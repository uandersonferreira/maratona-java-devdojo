package estudo.uanderson.javadevdojo.javacore.ZZIjdbc.service;

import estudo.uanderson.javadevdojo.javacore.ZZIjdbc.domain.Producer;
import estudo.uanderson.javadevdojo.javacore.ZZIjdbc.repository.ProducerRepository;

import java.util.List;

public class ProduceService {
    public static void save(Producer producer){
        ProducerRepository.save(producer);
    }//save

    public static void saveTransaction(List<Producer> producersList) {
        ProducerRepository.saveTransaction(producersList);
    }

        public static void delete(Integer id){
       requireValidId(id);
        ProducerRepository.delete(id);
    }//delete

     public static void update(Producer producer){
        requireValidId(producer.getId());
        ProducerRepository.update(producer);
    }//update
     public static void updatePreparedStatement(Producer producer){
        requireValidId(producer.getId());
        ProducerRepository.updatePreparedStatement(producer);
    }//update

    public static List<Producer> findAll(){
        return ProducerRepository.findAll();
    }//update

     public static List<Producer> findByname(String name){
        return ProducerRepository.findByName(name);
    }//findByName
     public static List<Producer> findByNamePreparedStatement(String name){
        return ProducerRepository.findByNamePreparedStatement(name);
    }
    public static List<Producer> findByNameCallableStatement(String name){
        return ProducerRepository.findByNameCallableStatement(name);
    }

    public static void showProducerMetaData(){
        ProducerRepository.showProducerMetaData();
    }//showProducerMetaData

    public static void showDriverMetaData(){
        ProducerRepository.showDriverMetaData();
    }//showDriverMetaData

    public static void showTypeScrollWorking(){
        ProducerRepository.showTypeScrollWorking();
    }//showDriverMetaData

    public static List<Producer> findByNameAndUpdateToUpperCase(String name){
        return ProducerRepository.findByNameAndUpdateToUpperCase(name);
    }
    public static List<Producer> findByNameAndInsertWhenNotFound(String name){
        return ProducerRepository.findByNameAndInsertWhenNotFound(name);
    }
    public static void findByNameAndDelete(String name){
        ProducerRepository.findByNameAndDelete(name);
    }


    public static void requireValidId(Integer id){
        if (id == null || id <= 0){
            throw new IllegalArgumentException("Invalid value for id ( ID têm que ser maior que zero e, não pode ser nulo )");
        }
    }


}//class
