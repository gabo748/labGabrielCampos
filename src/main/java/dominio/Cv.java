package dominio;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Cv {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;

    private String experienciaLaboral;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExperienciaLaboral() {
        return experienciaLaboral;
    }

    public void setExperienciaLaboral(String experienciaLaboral) {
        this.experienciaLaboral = experienciaLaboral;
    }

    public Integer getAniosDeTrabajo() {
        return aniosDeTrabajo;
    }

    public void setAniosDeTrabajo(Integer aniosDeTrabajo) {
        this.aniosDeTrabajo = aniosDeTrabajo;
    }

    public Candidato getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    private  Integer aniosDeTrabajo;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "candidatoId")
    private Candidato candidato;

}
