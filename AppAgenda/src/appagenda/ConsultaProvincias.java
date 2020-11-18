/*
 * Autor : Sebastián Fernández López
 * Descripción : Clase ConsultaProvincia
 */
package appagenda;

import entidades.Provincia;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author UsuarioDAM
 */
public class ConsultaProvincias {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AppAgendaPU");
        EntityManager em = emf.createEntityManager();

        Query queryProvincias = em.createNamedQuery("Provincia.findAll");
        List<Provincia> listProvincias = queryProvincias.getResultList();

        // Muestra el nombre de todas las tablas provincias
        for (Provincia provincia : listProvincias) {
            System.out.println(provincia.getNombre());
        }

        System.out.println("");
        System.out.println("Muestra todas las provincias con un array de forma tradicional");

        // Muestra todas las provincias de forma tradicional
        for (int i = 0; i < listProvincias.size(); i++) {
            Provincia provincia = listProvincias.get(i);
            System.out.println(provincia.getNombre());
        }

        System.out.println("");
        System.out.println("Muestra el nombre y el ID de la provincia que nostros le pasemos");

        Query queryProvinciaCadiz = em.createNamedQuery("Provincia.findByNombre");
        queryProvinciaCadiz.setParameter("nombre", "Cadiz");
        List<Provincia> listProvinciasCadiz = queryProvinciaCadiz.getResultList();
        for (Provincia provinciaCadiz : listProvinciasCadiz) {
            System.out.print(provinciaCadiz.getId() + ":");
            System.out.println(provinciaCadiz.getNombre());
        }

        System.out.println("");
        System.out.println("Muestra el ID y el nombre de la provincia, la cual le pasemoa un ID");

        Provincia provinciaId2 = em.find(Provincia.class, 2);
        if (provinciaId2 != null) {
            System.out.print(provinciaId2.getId() + ":");
            System.out.println(provinciaId2.getNombre());
        } else {
            System.out.println("No hay ninguna provincia con ID=2");
        }

        System.out.println("");
        System.out.println("Asigan a una provincia unas las siglas que le pasemos");

        Query queryProvinciaCadizAsigna = em.createNamedQuery("Provincia.findByNombre");
        queryProvinciaCadizAsigna.setParameter("nombre", "Cádiz");
        List<Provincia> listProvinciasCadizAsigna = queryProvinciaCadizAsigna.getResultList();
        em.getTransaction().begin();
        for (Provincia provinciaCadiz : listProvinciasCadizAsigna) {
            provinciaCadiz.setCodigo("CA");
            em.merge(provinciaCadiz);
        }
        em.getTransaction().commit();

        System.out.println("");
        System.out.println("Elimina de la base de datos aquella provincia con el ID que le pasemos");
        
        Provincia provinciaId12 = em.find(Provincia.class, 12);
        em.getTransaction().begin();
        if (provinciaId12 != null) {
            em.remove(provinciaId12);
        } else {
            System.out.println("No hay ninguna provincia con ID=12");
        }
        em.getTransaction().commit();

        
        
    }

}
