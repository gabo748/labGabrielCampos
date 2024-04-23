package web;

import dominio.Candidato;
import servicios.ICandidatoService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/actualizarCandidato")
public class ActualizarCandidatoServlet extends HttpServlet {
    @Inject
    ICandidatoService iCandidatoService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // se declara un objeto de tipo estudiante donde solo se le da valor al ID que sera buscado en la BD
        Candidato CandidatoParaEncontrar = new Candidato();
        CandidatoParaEncontrar.setId(3);

        // se obtiene el estudiante de la BD por medio del metodo del servicio pasandole el objeto previamente creado.
        Candidato candidatoAmodificar = iCandidatoService.buscarCandidatoPorId(CandidatoParaEncontrar);

        // actualizamos los datos del estudiante que viene de la BD
        candidatoAmodificar.setNombre("Julia");
        candidatoAmodificar.setApellidos("Lopez");
        candidatoAmodificar.setEdad(28);

        // Se llama al metodo que ejecuta el query para actualizar los datos en la BD
        iCandidatoService.modificarCandidato(candidatoAmodificar);

        // Colocamos un atributo llamado "estudianteActualizado" que sera referenciado asi en la pagina actualizarEstudiante.jsp
        request.setAttribute("candidatoAmodificar", candidatoAmodificar);

        // Definimos la pagina que va a renderizar por medio del archivo .jsp creado
        request.getRequestDispatcher("/actualizarCandidato.jsp").forward(request, response);
    }
}
