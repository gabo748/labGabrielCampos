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

@WebServlet("/eliminarCandidato")
public class EliminarCandidatoServlet extends HttpServlet {
    @Inject
    ICandidatoService iCandidatoService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Candidato candidatoParaEncontrar = new Candidato();
        candidatoParaEncontrar.setId(2);
        request.setAttribute("candidatoEliminadoID", candidatoParaEncontrar.getId());
        Candidato candidatoAEliminar = iCandidatoService.buscarCandidatoPorId(candidatoParaEncontrar);
        iCandidatoService.eliminarCandidato(candidatoAEliminar);
        request.getRequestDispatcher("/eliminarEstudiante.jsp").forward(request, response);
    }
}
