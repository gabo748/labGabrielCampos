
import dominio.Candidato;
import dominio.Cv;
import org.apache.logging.log4j.LogManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.apache.logging.log4j.*;

public class Test {
    static Logger log = LogManager.getRootLogger();

    public static void main(String[] args) {
        testCascada();

    }

    private  static  void  testCascada() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory ("CandidateUP");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Candidato candidato = new Candidato();
        candidato.setApellidos("Romano");
        candidato.setNombre("Juan");
        candidato.setEdad(35);

        Cv candidatoCV = new Cv();
        candidatoCV.setExperienciaLaboral("Programardo iOS");
        candidatoCV.setAniosDeTrabajo(3);
        candidatoCV.setCandidato(candidato);

        em.persist(candidatoCV);
        tx.commit();

    }
}