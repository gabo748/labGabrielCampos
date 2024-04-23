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
import java.util.List;

@WebServlet("/candidatos")
public class CandidatosServlet extends HttpServlet {
    @Inject
    ICandidatoService iCandidatoService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Candidato> candidatos = iCandidatoService.buscarTodosCandidatos();
        request.setAttribute("candidatos", candidatos);
        request.getRequestDispatcher("/listadoCandidatos.jsp").forward(request,response);
    }

}
