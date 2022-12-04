package estudo.uanderson.javadevdojo.javacore.ZZIjdbc.repository;

import estudo.uanderson.javadevdojo.javacore.ZZIjdbc.conn.ConnectionFactory;
import estudo.uanderson.javadevdojo.javacore.ZZIjdbc.domain.Producer;
import lombok.extern.log4j.Log4j2;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Log4j2
public class ProducerRepository {
    public static void save(Producer producer){
        String sql = String.format("INSERT INTO `anime_store`.`producer` (`nome`) VALUES ('%s');", producer.getName());

        try (Connection connection = ConnectionFactory.getConnection();
             Statement ps = connection.createStatement()) {

            int rowsAffected = ps.executeUpdate(sql);
           log.info("Inserted producer '{}' from the Database, rows affected '{}'",producer.getName(), rowsAffected);

        } catch (SQLException e) {
           log.error("Error while trying to insert producer '{}'", producer.getName(), e);
            //e.printStackTrace();
        }
    }//method save

    public static void saveTransaction(List<Producer> producersList){
        try (Connection connection = ConnectionFactory.getConnection()) {
            connection.setAutoCommit(false);//Não deixa o banco salvar/executar automaticamente os comandos sql ao chamar o execute()
            preparedStatementsaveTransaction(connection, producersList);
            connection.commit();//executa/salva os comandos sql que foi desabilidatos do automatico
            connection.setAutoCommit(true);//é preciso voltar para true a cada/por conexão que existir
        } catch (SQLException e) {
            log.error("Error while trying to save producers '{}'", producersList, e);
        }
    }//method update

    private static void preparedStatementsaveTransaction(Connection connection, List<Producer> producers) throws SQLException{
        String sql = "INSERT INTO `anime_store`.`producer` (`nome`) VALUES (?);";
       boolean shouldRollback = false;
        for(Producer p: producers){
            try(PreparedStatement ps = connection.prepareStatement(sql);){
               log.info("Save producer '{}'",p.getName());
                ps.setString(1, p.getName());
//                if (p.getName().equals("White fox")) throw new SQLException("Can't save white fox");
                ps.execute();
            }catch (SQLException e){
                e.printStackTrace();
                shouldRollback = true;
            }
     }//for
        if (shouldRollback){
            log.warn("Transaction is going be rollback");
            connection.rollback();
        }
    }//method

//------------------------------------------------------
       public static void delete(int id){
        String sql = String.format("DELETE FROM `anime_store`.`producer` WHERE (`id` = '%d');", id);

        try (Connection connection = ConnectionFactory.getConnection();
             Statement ps = connection.createStatement()) {

            int rowsAffected = ps.executeUpdate(sql);
           log.info("Delete producer '{}' from the Database, rows affected '{}'",id, rowsAffected);

        } catch (SQLException e) {
           log.error("Error while trying to delete producer '{}'", id, e);
        }
    }//method delete

        public static void update(Producer producer){
        String sql = String.format("UPDATE `anime_store`.`producer` SET `nome` = '%s' WHERE (`id` = '%d');", producer.getName(), producer.getId());

        try (Connection connection = ConnectionFactory.getConnection();
             Statement ps = connection.createStatement()) {

            int rowsAffected = ps.executeUpdate(sql);
            log.info("Update producer '{}' , rows affected '{}'",producer.getId(),rowsAffected);

        } catch (SQLException e) {
            log.error("Error while trying to update producer '{}'", producer.getId(), e);
        }
    }//method update
    public static void updatePreparedStatement(Producer producer){
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement ps = preparedStatementUpdate(connection,producer)) {
            int rowsAffected = ps.executeUpdate();
            log.info("Update producer '{}' , rows affected '{}'",producer.getId(),rowsAffected);

        } catch (SQLException e) {
            log.error("Error while trying to update producer '{}'", producer.getId(), e);
        }
    }//method update

    private static PreparedStatement preparedStatementUpdate(Connection connection, Producer producer) throws SQLException {
        String sql = "UPDATE `anime_store`.`producer` SET `nome` = ? WHERE (`id` = ?);";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, producer.getName());
        ps.setInt(2, producer.getId());
        return ps;
    }

    public static List<Producer> findAll(){
        log.info("Finding all Producers");
        return findByName("");//quando é vazia retorna todos os registro da tabela

     /*   String sql = "SELECT id, nome FROM anime_store.producer;";
        List<Producer> producersList = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getConnection();
             Statement ps = connection.createStatement();
             ResultSet rs = ps.executeQuery(sql)) {

            while (rs.next()){
               // var id = rs.getInt("id");
                //var name = rs.getString("name");

                Producer newProducer = Producer.builder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("nome"))
                        .build();
                producersList.add(newProducer);
            }

        } catch (SQLException e) {
            log.error("Error while trying to find all producers producer ", e);
        }
        return producersList;*/
    }//method findAll

     public static List<Producer> findByName(String name){
        log.info("Finding  Producers By Name");
         String sql = String.format("SELECT * FROM anime_store.producer where nome like '%%%s%%';",name);//"%"+name+"%"
        List<Producer> producersList = new ArrayList<>();
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery(sql)) {
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
    }//method findByName
    public static List<Producer> findByNamePreparedStatement(String name){
        log.info("Finding  Producers By Name");
        List<Producer> producersList = new ArrayList<>();
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement ps = preparedStatementFindByName(connection,name);
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

    private static PreparedStatement preparedStatementFindByName(Connection connection, String name) throws SQLException {
        String sql = "SELECT * FROM anime_store.producer where nome like ?;";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1,String.format("%%%s%%",name));
        return ps;
    }

    public static List<Producer> findByNameCallableStatement(String name){
        log.info("Finding  Producers By Name");
        List<Producer> producersList = new ArrayList<>();
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement ps = callableStatementFindByName(connection,name);
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
    }//method findByNameCallableStatement

    private static CallableStatement callableStatementFindByName(Connection connection, String name) throws SQLException {
        String sql = "CALL `anime_store`.`SP_GET_PRODUCER_BY_NAME`(?);";
        CallableStatement ps = connection.prepareCall(sql);
        ps.setString(1,String.format("%%%s%%",name));
        return ps;
        //callableStatement é para quando queremos executar uma função sql/trigger
    }

    public static void showProducerMetaData(){
       log.info("showing Producer MetaData");

        String sql = "SELECT * FROM anime_store.producer";

        try (Connection connection = ConnectionFactory.getConnection();
             Statement ps = connection.createStatement();
             ResultSet rs = ps.executeQuery(sql)) {

            ResultSetMetaData rsMetaData = rs.getMetaData();
            rs.next();//percorre uma linha(opcional)
            int columnCount = rsMetaData.getColumnCount();
            log.info("Columns count '{}'", columnCount);

            for (int i = 1; i <= columnCount; i++) {
                log.info("Table name '{}'", rsMetaData.getTableName(i));
               log.info("Column name '{}'", rsMetaData.getColumnName(i));
                log.info("Column size '{}'", rsMetaData.getColumnDisplaySize(i));
               log.info("Column type '{}'", rsMetaData.getColumnType(i));

            }

        } catch (SQLException e) {
           log.error("Error while trying showing Producer MetaData ", e);
        }
    }//method

    public static void showDriverMetaData(){
        log.info("showing Producer MetaData");
        try (Connection connection = ConnectionFactory.getConnection()){
            DatabaseMetaData dbMetaData = connection.getMetaData();

            if (dbMetaData.supportsResultSetType(ResultSet.TYPE_FORWARD_ONLY)){
                log.info("Supports TYPE_FORWARD_ONLY ");
                if (dbMetaData.supportsResultSetConcurrency(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE)){
                    log.info("And Supports CONCUR_UPDATABLE ");
                }
            }//1° if

            if (dbMetaData.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE)){
                log.info("Supports TYPE_SCROLL_INSENSITIVE ");
                if (dbMetaData.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)){
                    log.info("And Supports CONCUR_UPDATABLE ");
                }
            }//2° if

            if (dbMetaData.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE)){
                log.info("Supports TYPE_SCROLL_SENSITIVE ");
                if (dbMetaData.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)){
                    log.info("And Supports CONCUR_UPDATABLE ");
                }
            }//3° if

        } catch (SQLException e) {
            log.error("Error while trying showing Producer MetaData ", e);
        }
    }//method

    public static void showTypeScrollWorking(){
        log.info("Finding  Producers By Name");

        String sql = "SELECT * FROM anime_store.producer order by nome desc ;";

        try (Connection connection = ConnectionFactory.getConnection();
             Statement ps = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
             ResultSet rs = ps.executeQuery(sql)) {

            log.info("Last Line? '{}'", rs.last());
            log.info("Row number '{}'", rs.getRow());
            log.info(Producer.builder().id(rs.getInt("id")).name(rs.getString("nome")).build());
            log.info("---------------------------");
            log.info("First Line? '{}'", rs.first());
            log.info("Row number '{}'", rs.getRow());
            log.info(Producer.builder().id(rs.getInt("id")).name(rs.getString("nome")).build());
            log.info("---------------------------");
            log.info("Row Absolute'{}'", rs.absolute(2));
            log.info("Row number '{}'", rs.getRow());
            log.info(Producer.builder().id(rs.getInt("id")).name(rs.getString("nome")).build());
            log.info("---------------------------");
            log.info("Row Relative'{}'", rs.relative(-1));
            log.info("Row number '{}'", rs.getRow());
            log.info(Producer.builder().id(rs.getInt("id")).name(rs.getString("nome")).build());
            log.info("---------------------------");
            log.info("is last? '{}'", rs.isLast());//não muda o curso do resulSet
            log.info("Row number '{}'", rs.getRow());
            log.info("---------------------------");
            log.info("is first? '{}'", rs.isFirst());//não muda o curso do resulSet
            log.info("Row number '{}'", rs.getRow());
            log.info("---------------------------");
            log.info("Last row? '{}'", rs.last());
             rs.next();
            log.info("After last row? '{}'",rs.isAfterLast());
            while (rs.previous()){
                log.info(Producer.builder().id(rs.getInt("id")).name(rs.getString("nome")).build());
            }

        } catch (SQLException e) {
            log.error("Error while trying to showTypeScrollWorking producers  ", e);
        }
    }//method showTypeScrollWorking

    public static List<Producer> findByNameAndUpdateToUpperCase(String name){
        log.info("Finding  Producers By Name");

        String sql = String.format("SELECT * FROM anime_store.producer where nome like '%%%s%%';",name);//"%"+name+"%"
        List<Producer> producersList = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getConnection();
             Statement ps = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
             ResultSet rs = ps.executeQuery(sql)) {

            while (rs.next()){
                rs.updateString("nome", rs.getString("nome").toUpperCase());
               // rs.cancelRowUpdates();//para voltar ao estado anterio do dado retornado query
                rs.updateRow();//para que a alteração seja feita no banco de dados;
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
    }//method findByNameAndUpdateToUpperCase

    public static List<Producer> findByNameAndInsertWhenNotFound(String name){
        //inserir caso não encontre nada e retornar o novo objeto inserido
        log.info("Finding  Producers By Name findByNameAndInsertWhenNotFound");

        String sql = String.format("SELECT * FROM anime_store.producer where nome like '%%%s%%';",name);//"%"+name+"%"
        List<Producer> producersList = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getConnection();
             Statement ps = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
             ResultSet rs = ps.executeQuery(sql)) {

            if (!rs.next()){
                rs.moveToInsertRow();
                rs.updateString("nome",name);
                rs.insertRow();//insere a nova linha no banco de dados
                rs.beforeFirst();//volta o cursor para uma posição anterior a primeira
                rs.next();//move o curso para a 1a posição
                Producer newProducer = Producer.builder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("nome"))
                        .build();
                producersList.add(newProducer);

            }

        } catch (SQLException e) {
            log.error("Error while trying to findByNameAndInsertWhenNotFound ", e);
        }
        return producersList;
    }//findByNameAndInsertWhenNotFound
  public static void findByNameAndDelete(String name){
        log.info("Finding  Producers By Name and Delete");
        String sql = String.format("SELECT * FROM anime_store.producer where nome like '%%%s%%';",name);//"%"+name+"%"
        try (Connection connection = ConnectionFactory.getConnection();
             Statement ps = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
             ResultSet rs = ps.executeQuery(sql)) {
            while (rs.next()){
               log.info("Deleting '{}'", rs.getString("nome"));
               rs.deleteRow();
            }
        } catch (SQLException e) {
            log.error("Error while trying to findByNameAndInsertWhenNotFound ", e);
        }
    }//findByNameAndDelete





}//class
/*
Estudar o Conceito PII

link:https://www.ibm.com/docs/en/informix-servers/12.10?topic=SSGU8G_12.1.0/com.ibm.esqlj.doc/ids_esqlj_023.html

 */