package servicios;

import data.ICandidatoDao;
import dominio.Candidato;

import javax.ejb.Stateful;
import javax.inject.Inject;
import java.util.List;

@Stateful
public class CandidatoServiceImp implements ICandidatoService {
    @Inject
    private ICandidatoDao iCandidato;

    @Override
    public List<Candidato> buscarTodosCandidatos() {
        return iCandidato.buscarTodosCandidatos();
    }

    @Override
    public Candidato buscarCandidatoPorId(Candidato candidato) {
        return iCandidato.buscarCandidatoPorId(candidato);
    }

    @Override
    public Candidato buscarEstudiantePorApellido(Candidato candidato) {
        return iCandidato.buscarEstudiantePorApellido(candidato);
    }

    @Override
    public void insertarCandidato(Candidato candidato) {
        iCandidato.insertarCandidato(candidato);
    }

    @Override
    public void modificarCandidato(Candidato candidato) {
        iCandidato.modificarCandidato(candidato);
    }

    @Override
    public void eliminarCandidato(Candidato candidato) {
        iCandidato.eliminarCandidato(candidato);
    }
}
