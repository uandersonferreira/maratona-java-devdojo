package estudo.uanderson.javadevdojo.javacore.ZZJcrud.repository;


import estudo.uanderson.javadevdojo.javacore.ZZJcrud.conn.ConnectionFactory;
import estudo.uanderson.javadevdojo.javacore.ZZJcrud.domain.Anime;
import estudo.uanderson.javadevdojo.javacore.ZZJcrud.domain.Producer;
import lombok.extern.log4j.Log4j2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Log4j2
public class AnimeRepository {
    public static List<Anime> findByName(String name){
        log.info("Finding  Animes By Name '{}'", name);
        List<Anime> animesList = new ArrayList<>();
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement ps = createPrepareStatementFindByName(connection,name);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()){
                Producer producer = Producer.builder()
                        .name(rs.getString("producer_name"))
                        .id(rs.getInt("produce_id"))
                        .build();

                Anime newAnime = Anime.builder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("nome"))
                        .episodes(rs.getInt("episodes"))
                        .producer(producer)
                        .build();
                animesList.add(newAnime);
            }
        } catch (SQLException e) {
            log.error("Error while trying to find all  anime ", e);
        }
        return animesList;
    }//method findByNamePreparedStatement

    private static PreparedStatement createPrepareStatementFindByName(Connection connection, String name) throws SQLException {
        String sql = """
        SELECT
        a.id, a.nome, a.episodes, a.produce_id, p.nome as 'producer_name'
        FROM anime_store.anime a
        INNER JOIN anime_store.producer p on a.produce_id = p.id
        WHERE a.nome like ?
        """;

        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1,String.format("%%%s%%",name));
        return ps;
    }
//---------------------------- FindById ---------------------------

    public static Optional<Anime> findById(Integer id){
        log.info("Finding  Animes By Name '{}'", id);
        List<Anime> animesList = new ArrayList<>();
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement ps = createPrepareStatementFindById(connection,id);
             ResultSet rs = ps.executeQuery()) {

            if (!rs.next()) return Optional.empty();
            Producer producer = Producer.builder()
                    .name(rs.getString("producer_name"))
                    .id(rs.getInt("produce_id"))
                    .build();

            Anime newAnime = Anime.builder()
                    .id(rs.getInt("id"))
                    .name(rs.getString("nome"))
                    .episodes(rs.getInt("episodes"))
                    .producer(producer)
                    .build();

            return Optional.of(newAnime);

        } catch (SQLException e) {
            log.error("Error while trying to find all animes anime ", e);
        }

        return Optional.empty();
    }//method findByNamePreparedStatement

    private static PreparedStatement createPrepareStatementFindById(Connection connection, Integer id) throws SQLException {
        String sql = """
        SELECT
        a.id, a.nome, a.episodes, a.produce_id, p.nome as 'producer_name'
        FROM anime_store.anime a
        INNER JOIN anime_store.producer p on a.produce_id = p.id
        WHERE a.id = ?
        """;
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1,id);
        return ps;
    }


    public static void delete(int id){
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement ps = createPrepareStatementDelete(connection, id)) {
             ps.execute();
            log.info("Delete anime '{}' from the Database",id);
        } catch (SQLException e) {
            log.error("Error while trying to delete anime '{}'", id, e);
        }
    }//method delete

    private static PreparedStatement createPrepareStatementDelete(Connection connection, Integer id) throws SQLException {
        String sql = "DELETE FROM `anime_store`.`anime` WHERE (`id` = ?);";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1,id);
        return ps;
    }//delete


    public static void save(Anime anime){
        log.info("Saving Anime '{}'", anime);
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement ps = createPreparedStatementSave(connection,anime)) {
             ps.execute();
            log.info("Update anime '{}'",anime.getId());

        } catch (SQLException e) {
            log.error("Error while trying to save anime '{}'", anime.getId(), e);
        }
    }//method update

    private static PreparedStatement createPreparedStatementSave(Connection connection,Anime anime) throws SQLException {
        String sql = "INSERT INTO `anime_store`.`anime`  (`nome`,`episodes`,`produce_id`) VALUES (?,?,?);";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, anime.getName());
        ps.setInt(2, anime.getEpisodes());
        ps.setInt(3, anime.getProducer().getId());
        return ps;
    }


    public static void update(Anime anime){
        log.info("Updating anime '{}'", anime);
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement ps = createPreparedStatementUpdate(connection,anime)) {
             ps.execute();
            log.info("Update anime '{}' ",anime.getId());

        } catch (SQLException e) {
            log.error("Error while trying to update anime '{}'", anime.getId(), e);
        }
    }//method update

    private static PreparedStatement createPreparedStatementUpdate(Connection connection, Anime anime) throws SQLException {
        String sql = "UPDATE `anime_store`.`anime` SET `nome` = ?,`episodes` = ? WHERE (`id` = ?);";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, anime.getName());
        ps.setInt(2, anime.getEpisodes());
        ps.setInt(3, anime.getId());
        return ps;
    }




}//class
