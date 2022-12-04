package estudo.uanderson.javadevdojo.javacore.ZZJcrud.repository;


import estudo.uanderson.javadevdojo.javacore.ZZJcrud.conn.ConnectionFactory;
import estudo.uanderson.javadevdojo.javacore.ZZJcrud.domain.Producer;
import lombok.extern.log4j.Log4j2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Log4j2
public class ProducerRepository {
    public static List<Producer> findByName(String name){
        log.info("Finding  Producers By Name '{}'", name);
        List<Producer> producersList = new ArrayList<>();
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement ps = createPrepareStatementFindByName(connection,name);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()){
                Producer newProducer = Producer.builder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("nome"))
                        .build();
                producersList.add(newProducer);
            }
        } catch (SQLException e) {
            log.error("Error while trying to find all producers producer ", e);
        }
        return producersList;
    }//method findByNamePreparedStatement

    private static PreparedStatement createPrepareStatementFindByName(Connection connection, String name) throws SQLException {
        String sql = "SELECT * FROM anime_store.producer where nome like ?;";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1,String.format("%%%s%%",name));
        return ps;
    }
//---------------------------- FindById ---------------------------

    public static Optional<Producer> findById(Integer id){
        log.info("Finding  Producers By Name '{}'", id);
        List<Producer> producersList = new ArrayList<>();
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement ps = createPrepareStatementFindById(connection,id);
             ResultSet rs = ps.executeQuery()) {

            if (!rs.next()) return Optional.empty();

            return Optional.of(
                        Producer.builder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("nome"))
                        .build()
            );

        } catch (SQLException e) {
            log.error("Error while trying to find all producers producer ", e);
        }

        return Optional.empty();
    }//method findByNamePreparedStatement

    private static PreparedStatement createPrepareStatementFindById(Connection connection, Integer id) throws SQLException {
        String sql = "SELECT * FROM anime_store.producer where id = ?;";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1,id);
        return ps;
    }


    public static void delete(int id){
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement ps = createPrepareStatementDelete(connection, id)) {
             ps.execute();
            log.info("Delete producer '{}' from the Database",id);
        } catch (SQLException e) {
            log.error("Error while trying to delete producer '{}'", id, e);
        }
    }//method delete

    private static PreparedStatement createPrepareStatementDelete(Connection connection, Integer id) throws SQLException {
        String sql = "DELETE FROM `anime_store`.`producer` WHERE (`id` = ?);";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1,id);
        return ps;
    }//delete


    public static void save(Producer producer){
        log.info("Saving Producer '{}'", producer);
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement ps = createPreparedStatementSave(connection,producer)) {
             ps.execute();
            log.info("Update producer '{}'",producer.getId());

        } catch (SQLException e) {
            log.error("Error while trying to save producer '{}'", producer.getId(), e);
        }
    }//method update

    private static PreparedStatement createPreparedStatementSave(Connection connection,Producer producer) throws SQLException {
        String sql = "INSERT INTO `anime_store`.`producer`  (`nome`) VALUES (?);";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, producer.getName());
        return ps;
    }


    public static void update(Producer producer){
        log.info("Updating producer '{}'", producer);
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement ps = createPreparedStatementUpdate(connection,producer)) {
             ps.execute();
            log.info("Update producer '{}' ",producer.getId());

        } catch (SQLException e) {
            log.error("Error while trying to update producer '{}'", producer.getId(), e);
        }
    }//method update

    private static PreparedStatement createPreparedStatementUpdate(Connection connection, Producer producer) throws SQLException {
        String sql = "UPDATE `anime_store`.`producer` SET `nome` = ? WHERE (`id` = ?);";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, producer.getName());
        ps.setInt(2, producer.getId());
        return ps;
    }




}//class
