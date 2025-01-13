package estudo.uanderson.javadevdojo.javacore.ZZIjdbc.conn;


import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/anime_store";
        String userName = "root";
        String password = "root";

        return DriverManager.getConnection(url, userName, password);

    }//method getConnection

    public static JdbcRowSet getJdbcRowSet() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/anime_store";
        String userName = "root";
        String password = "root";

        JdbcRowSet cachedRowSet = RowSetProvider.newFactory().createJdbcRowSet();
        cachedRowSet.setUrl(url);
        cachedRowSet.setUsername(userName);
        cachedRowSet.setPassword(password);

        return cachedRowSet;
    }//method getConnection

    public static CachedRowSet getCacheRowSet() throws SQLException {
        return RowSetProvider.newFactory().createCachedRowSet();
        //SE estamos passando a concexão no excute do method é necessário
      //passar os dados da conexão. Maas se usado com multi-treds pode dar pau de uma mesma thed atualizar o mesmo objeto
        //SyncProviderException: 1 conflitos durante a sincronização

    }//method getConnection


}//class
/*
        String url = "jdbc:mysql://localhost:3306/anime_store";
        String userName = "root";
        String password = "root";


        cachedRowSet.setUrl(url);
        cachedRowSet.setUsername(userName);
        cachedRowSet.setPassword(password);
*/