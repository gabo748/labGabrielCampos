package web;

import dominio.Candidato;
import servicios.CandidatoServiceImp;
import servicios.ICandidatoService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/agregarCandidato")
public class AgregarCandidatoServlet extends HttpServlet {

    @Inject
    ICandidatoService iCandidatoService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Candidato nuevoCandidato = new Candidato();
        nuevoCandidato.setApellidos("Colocho");
        nuevoCandidato.setEdad(21);
        nuevoCandidato.setNombre("Karla");

        iCandidatoService.insertarCandidato(nuevoCandidato);
        Candidato buscarNuevoCandidato = iCandidatoService.buscarEstudiantePorApellido(nuevoCandidato);
        request.setAttribute("nuevoCandidato", buscarNuevoCandidato);
        request.getRequestDispatcher("/agregarCandidato.jsp").forward(request, response);
    }

}
