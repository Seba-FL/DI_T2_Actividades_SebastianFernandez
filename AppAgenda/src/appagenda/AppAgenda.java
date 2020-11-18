/*
 * Autor : Sebastián Fernández López
 * Descripción : Clase AppAgenda
 */
package appagenda;

import entidades.Provincia;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author UsuarioDAM
 */
public class AppAgenda {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AppAgendaPU");
        EntityManager em = emf.createEntityManager();

        em.close();
        emf.close();
        try {
            DriverManager.getConnection("jdbc:derby:BDAgenda;shutdown=true");
        } catch (SQLException ex) {
        }

    }

}
