package data;


import dominio.Candidato;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ICandidatoDao
{
    public List<Candidato> buscarTodosCandidatos();
    public Candidato buscarCandidatoPorId(Candidato candidato);
    public Candidato buscarEstudiantePorApellido(Candidato candidato);
    public void insertarCandidato(Candidato candidato);
    public void modificarCandidato(Candidato candidato);
    public  void eliminarCandidato(Candidato candidato);
}
