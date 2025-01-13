package estudo.uanderson.javadevdojo.javacore.ZZIjdbc.repository;

import estudo.uanderson.javadevdojo.javacore.ZZIjdbc.conn.ConnectionFactory;
import estudo.uanderson.javadevdojo.javacore.ZZIjdbc.domain.Producer;
import estudo.uanderson.javadevdojo.javacore.ZZIjdbc.listener.CustomRowSetListener;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ProducerRepositoryRowSet {
    public static List<Producer> findByNameJdbcRowSet(String name){
        String sql = "SELECT * FROM anime_store.producer where nome like ?;";
        List<Producer> producersList = new ArrayList<>();

        try (JdbcRowSet jrs = ConnectionFactory.getJdbcRowSet()){
            jrs.addRowSetListener(new CustomRowSetListener());
            jrs.setCommand(sql);
            jrs.setString(1,String.format("%%%s%%", name));
            jrs.execute();

            while (jrs.next()){
                Producer newProducer = Producer.builder()
                        .id(jrs.getInt("id"))
                        .name(jrs.getString("nome"))
                        .build();

                producersList.add(newProducer);

            }


        }catch (SQLException e) {
            e.printStackTrace();
        }

        return producersList;
    }//method

/*    public static void updateJdbcRowSet(Producer producer){
        String sql = "UPDATE `anime_store`.`producer` SET `nome` = ? WHERE (`id` = ?);";
        try (JdbcRowSet crs
 = ConnectionFactory.getJdbcRowSet()){
            crs
.setCommand(sql);
            crs
.setString(1, producer.getName());
            crs
.setInt(2, producer.getId());
            crs
.execute();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }*/

    public static void updateJdbcRowSet(Producer producer){
        String sql = "SELECT * FROM anime_store.producer WHERE (`id` = ?);";
        try (JdbcRowSet jrs = ConnectionFactory.getJdbcRowSet()){
            jrs.addRowSetListener(new CustomRowSetListener());
            jrs.setCommand(sql);
            jrs.setInt(1, producer.getId());
            jrs.execute();
            if (!jrs.next()) return;
            jrs.updateString("nome", producer.getName());
            jrs.updateRow();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }//updateJdbcRowSet

    public static void updateCacheRowSet(Producer producer){
        String sql = "SELECT * FROM producer WHERE (`id` = ?);";
        try (CachedRowSet crs = ConnectionFactory.getCacheRowSet();
             Connection connection = ConnectionFactory.getConnection()){
            //crs.addRowSetListener(new CustomRowSetListener());
           connection.setAutoCommit(false);//Can't call commit when autocommit=true
            crs.setCommand(sql);
            crs.setInt(1, producer.getId());
            crs.execute(connection);
            if (!crs.next()) return;
            crs.updateString("nome", producer.getName());
            crs.updateRow();
            TimeUnit.SECONDS.sleep(10);
            crs.acceptChanges();
        }catch (SQLException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}//class
