package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import model.*;

import java.io.IOException;
import java.util.List;


@WebServlet("/AvvioMarca")
public class AvvioMarca extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CrudMarca crud = new CrudMarca();
		int id = 0;
		String nomeMarca = null;
		Marca marca=null;
		if(request.getParameter("scelta")!=null) {
			int scelta=Integer.parseInt(request.getParameter("scelta"));
			switch(scelta) {
			case 1:
				marca = new Marca();
				nomeMarca = request.getParameter("nomeMarca");
				marca.setNomeMarca(nomeMarca);
				crud.inserisci(marca);
				response.sendRedirect("formFK.html");
				break;
			case 2:
				List<Marca> marche = crud.leggi();
				request.setAttribute("marche", marche);
				request.getRequestDispatcher("tabella.jsp").forward(request, response);
				break;
			case 3:
				id=Integer.parseInt(request.getParameter("id"));
				crud.rimuovi(id);
				response.sendRedirect("AvvioMarca?scelta=2");
				break;
			case 4:
				id = Integer.parseInt(request.getParameter("id"));
				marca = crud.leggi(id);
				
				request.setAttribute("marca", marca);
				request.getRequestDispatcher("formModifica.jsp").forward(request, response);
				break;
			case 5:
				id = Integer.parseInt(request.getParameter("id"));
				nomeMarca = request.getParameter("nomeMarca");
				marca = new Marca();
				marca.setId(id);
				marca.setNomeMarca(nomeMarca);
				crud.modifica(marca);
				response.sendRedirect("AvvioMarca?scelta=2");
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
