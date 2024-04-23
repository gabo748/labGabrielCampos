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

@WebServlet("/buscarCandidatoApellido")
public class BuscarCandidatoApellido extends HttpServlet {
    @Inject
    ICandidatoService iCandidatoService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // se declara un objeto de tipo estudiante donde solo se le da valor al Carnet que sera buscado en la BD
        Candidato candidatoBuscarPorCarnet = new Candidato();
        candidatoBuscarPorCarnet.setApellidos("Lopez");

        // se obtiene el estudiante de la BD por medio del metodo del servicio pasandole el objeto previamente creado.
        Candidato candidato = iCandidatoService.buscarEstudiantePorApellido(candidatoBuscarPorCarnet);

        // Colocamos un atributo llamado "estudiante" que sera referenciado asi en la pagina buscarEstudianteCarnet.jsp
        request.setAttribute("candidato", candidato);

        // Definimos la pagina que va a renderizar por medio del archivo .jsp creado
        request.getRequestDispatcher("/buscarCandidatoApellido.jsp").forward(request, response);
    }
}
