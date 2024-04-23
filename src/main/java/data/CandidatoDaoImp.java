package data;

import dominio.Candidato;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class CandidatoDaoImp implements ICandidatoDao {
    @PersistenceContext(unitName = "CandidateUP")
    EntityManager em;
    @Override
    public List<Candidato> buscarTodosCandidatos() {
        TypedQuery<Candidato> q = em.createQuery("SELECT e FROM Candidato e ORDER BY e.id", Candidato.class);
        return q.getResultList();
    }

    @Override
    public Candidato buscarCandidatoPorId(Candidato candidato) {
        return em.find(Candidato.class, candidato.getId());
    }

    @Override
    public Candidato buscarEstudiantePorApellido(Candidato candidato) {
        Query q = em.createQuery("select e from Candidato e where e.apellidos = :apellidos");
        q.setParameter("apellidos", candidato.getApellidos());
        return (Candidato) q.getSingleResult();
    }

    @Override
    public void insertarCandidato(Candidato candidato) {
        em.persist(candidato);
    }

    @Override
    public void modificarCandidato(Candidato candidato) {
        em.merge(candidato);
    }

    @Override
    public void eliminarCandidato(Candidato candidato) {
        em.remove(em.merge(candidato));
    }
}
