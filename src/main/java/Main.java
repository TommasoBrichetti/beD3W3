import models.*;
import models.DAO.ConcertoDAO;
import models.DAO.PartitaDiCalcioDAO;

import javax.persistence.*;
import java.util.List;

public class Main {

    public static void main( String[] args ) {
//        insertEvento();
//        insertLocation();
//        insertPersona();
//        System.out.println(findPersona(1));
//        System.out.println(findEvento(5));
//        insertPartecipazione(2, 5);

//        saveEventi();
        getConcertiInStreaming(false);
    }

    public static void saveEventi() {

        PartitaDiCalcio p1 = new PartitaDiCalcio("Inter", "Milan", "Inter", 2,
                1);

        PartitaDiCalcio p2 = new PartitaDiCalcio("Juventus", "Atalanta", null,  1,
                1);

        PartitaDiCalcioDAO.save(p1);
        PartitaDiCalcioDAO.save(p2);

        Concerto con1 = new Concerto(true, Genere.CLASSICO);

        Concerto con2 = new Concerto(false, Genere.POP);

        ConcertoDAO.save(con1);

        ConcertoDAO.save(con2);

    }

    public static void s2Query(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi");
        EntityManager em = emf.createEntityManager();

        try{
            Query q = em.createNativeQuery(
                    "SELECT concerto.id\n" +
                            "FROM concerto\n" +
                            "WHERE instreaming = false"
            );

            List<Object[]> r = q.getResultList();

            for (int i = 0; i < r.size(); i++) {
                System.out.println(r.get(i)[0]);
            }

        }catch (Exception e){
            System.out.println("errore");
        }

        em.close();
        emf.close();
    }

    public static void getConcertiInStreaming(boolean n){
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();

        Query q = em.createQuery(
                "SELECT c FROM Concerto c Where c.instreaming = :n "
        );

        q.setParameter("n", n);

        List<Concerto> r = q.getResultList();
        for (Concerto p : r) {
            System.out.println(p);
        }
        em.close();
    }

    public static void getConcertiPerGenere(Genere n){
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();

        Query q = em.createQuery(
                "SELECT c FROM Concerto c Where c.genere = :n "
        );

        q.setParameter("n", n);

        List<Concerto> r = q.getResultList();
        for (Concerto p : r) {
            System.out.println(p);
        }
        em.close();
    }


//    public static void insertEvento() {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi");
//        EntityManager em = emf.createEntityManager();
//        EntityTransaction et = em.getTransaction();
//
//        if (findLocation(1) != null){
//            et.begin();
//
//            Evento e = new Evento("Fiesta con i 4 Pagliacci", "1/12/2022", "Fiesta de fuego", TipoEvento.PUBBLICO, 500,
//                    findLocation(1));
//
//            em.persist(e);
//            et.commit();
//
//            em.close();
//            emf.close();
//        }
//
//    }
//    public static void insertPersona() {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi");
//        EntityManager em = emf.createEntityManager();
//        EntityTransaction et = em.getTransaction();
//
//        et.begin();
//
//        Persona e = new Persona("gigino", "pippolotto", "4dellapocalisse@apo.it", "22/04/1886", Sesso.UOMO);
//
//        em.persist(e);
//        et.commit();
//
//        em.close();
//        emf.close();
//    }
//    public static void insertLocation() {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi");
//        EntityManager em = emf.createEntityManager();
//        EntityTransaction et = em.getTransaction();
//
//        et.begin();
//
//        Location e = new Location("indianapolis", "Milano");
//
//        em.persist(e);
//        et.commit();
//
//        em.close();
//        emf.close();
//    }
//    public static Persona findPersona(int id) {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi");
//        EntityManager em = emf.createEntityManager();
//
//        Persona v = em.find(Persona.class, id);
//        if(v != null) {
//           return v;
//        }
//
//        em.close();
//        emf.close();
//        return null;
//    }
//    public static Evento findEvento(int id) {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi");
//        EntityManager em = emf.createEntityManager();
//
//        Evento v = em.find(Evento.class, id);
//        if(v != null) {
//            return v;
//        }
//
//        em.close();
//        emf.close();
//        return null;
//    }
//    public static Location findLocation(int id) {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi");
//        EntityManager em = emf.createEntityManager();
//
//        Location v = em.find(Location.class, id);
//        if(v != null) {
//            return v;
//        }
//
//        em.close();
//        emf.close();
//        return null;
//    }
//    public static void insertPartecipazione(int idP, int idE) {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi");
//        EntityManager em = emf.createEntityManager();
//        EntityTransaction et = em.getTransaction();
//
//        if(findPersona(idP) == null ||  findEvento(idE) == null){
//            System.out.println("not found");
//        }else{
//            et.begin();
//
//            Partecipazione e = new Partecipazione(findPersona(idP), findEvento(idE), Stato.DA_CONFERMARE);
//
//            em.persist(e);
//            et.commit();
//
//            em.close();
//            emf.close();
//        }
//    }



}
