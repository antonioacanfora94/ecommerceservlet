package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import model.*;

import java.io.IOException;
import java.util.List;


@WebServlet("/AvvioCategoria")
public class AvvioCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;
        
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CrudCategoria crud = new CrudCategoria();
		int id = 0;
		String nomeCategoria = null;
		Categoria categoria=null;
		if(request.getParameter("scelta")!=null) {
			int scelta=Integer.parseInt(request.getParameter("scelta"));
			switch(scelta) {
			case 1:
				nomeCategoria = request.getParameter("nomeCategoria");
				categoria = new Categoria();
				categoria.setNomeCategoria(nomeCategoria);
				crud.inserisci(categoria);
				response.sendRedirect("formFK.html");
				break;
			case 2:
				List<Categoria> categorie = crud.leggi();
				request.setAttribute("categorie", categorie);
				request.getRequestDispatcher("tabella.jsp").forward(request, response);
				break;
			case 3:
				id=Integer.parseInt(request.getParameter("id"));
				crud.rimuovi(id);
				response.sendRedirect("AvvioCategoria?scelta=2");
				break;
			case 4:
				id = Integer.parseInt(request.getParameter("id"));
				categoria = crud.leggi(id);
				request.setAttribute("categoria", categoria);
				request.getRequestDispatcher("formModifica.jsp").forward(request, response);
				break;
			case 5:
				id = Integer.parseInt(request.getParameter("id"));
				nomeCategoria = request.getParameter("nomeCategoria");
				categoria = new Categoria();
				categoria.setId(id);
				categoria.setNomeCategoria(nomeCategoria);
				crud.modifica(categoria);
				response.sendRedirect("AvvioCategoria?scelta=2");
				break;
			}
		} else {
			response.sendRedirect("home.html");
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
