package estudo.uanderson.javadevdojo.javacore.ZZIjdbc.listener;

import lombok.extern.log4j.Log4j2;

import javax.sql.RowSet;
import javax.sql.RowSetEvent;
import javax.sql.RowSetListener;
import java.sql.SQLException;

@Log4j2
public class CustomRowSetListener implements RowSetListener {
    @Override
    public void rowSetChanged(RowSetEvent event) {
        //QUANDO O ECEXUTE É EXECUTADO
        log.info("Command execute triggered");//triggered= gatilho/provocado/acionado
    }

    @Override
    public void rowChanged(RowSetEvent event) {
        //QUANDO OCORRE ALGUMA ALTERAÇÃO NO BANCO DE DADOS
        log.info("Row inserted, update or deleted");
        if (event.getSource() instanceof RowSet){
            try {
                ((RowSet) event.getSource()).execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void cursorMoved(RowSetEvent event) {
        //QUANDO O CURSO DO ROWSET SE MOVE
        log.info("Cursor moved");
    }
}
