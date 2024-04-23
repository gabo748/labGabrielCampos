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

@WebServlet("/buscarCandidatoId")
public class BuscarCandidatoIdServlet extends HttpServlet {
    @Inject
    ICandidatoService iCandidatoService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // se declara un objeto de tipo estudiante donde solo se le da valor al ID que sera buscado en la BD
        Candidato candidatoBuscarPorId = new Candidato();
        candidatoBuscarPorId.setId(3);

        // se obtiene el estudiante de la BD por medio del metodo del servicio pasandole el objeto previamente creado.
        Candidato candidato = iCandidatoService.buscarCandidatoPorId(candidatoBuscarPorId);

        // Colocamos un atributo llamado "estudiante" que sera referenciado asi en la pagina buscarEstudianteCarnet.jsp
        request.setAttribute("candidato", candidato);

        // Definimos la pagina que va a renderizar por medio del archivo .jsp creado
        request.getRequestDispatcher("/buscarCandidatoID.jsp").forward(request, response);
    }
}
