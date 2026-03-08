package controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import model.*;

@WebServlet("/Avvio")
public class Avvio extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CrudService crud = new CrudService();
		CrudCategoria crudc = new CrudCategoria();
		CrudMarca crudm = new CrudMarca();
		
		int id = 0;
		String nomeProdotto = null;
		String nomeMarca = null;
		String nomeCategoria = null;
		double prezzo = 0;
		Date dataProduzione= null;
		int quantita = 0;
		Prodotto prodotto =null;
		if(request.getParameter("scelta")!=null) {
			int scelta=Integer.parseInt(request.getParameter("scelta"));
			switch(scelta) {
			case 0:
				/*Obbiettivo:
				 * Vogliamo arrivare al form di registrazione del prodotto
				 * con le liste di marche e categorie.
				 * In questo modo possiamo dare al form due menù a tendina dinamici
				 * in quanto alimentati dalle liste inviate precedentemente
				 */
				List<Marca> marche = crudm.leggi();
				List<Categoria> categorie = crudc.leggi();
				request.setAttribute("marche", marche);
				request.setAttribute("categorie", categorie);
				request.getRequestDispatcher("form.jsp").forward(request, response);
				break;
			case 1:
				nomeProdotto = request.getParameter("nomeProdotto");
				prezzo = Double.parseDouble(request.getParameter("prezzoProdotto"));
				dataProduzione = Date.valueOf(request.getParameter("dataProdotto"));
				quantita = Integer.parseInt(request.getParameter("quantitaProdotto"));
				int idCategoria = Integer.parseInt(request.getParameter("idCategoria"));
				int idMarca = Integer.parseInt(request.getParameter("idMarca"));
				prodotto = new Prodotto();
				prodotto.setNomeProdotto(nomeProdotto);
				prodotto.setPrezzo(prezzo);
				prodotto.setDataProduzione(dataProduzione);
				prodotto.setQuantita(quantita);
				prodotto.setId_categorie(idCategoria);
			    prodotto.setId_marche(idMarca);
				
				crud.inserisci(prodotto, idCategoria, idMarca);
				response.sendRedirect("Avvio?scelta=0");
				break;
			case 2:
				List<DtoProdotto> prodotti = crud.leggi();
				request.setAttribute("prodottiTotali", prodotti);
				request.getRequestDispatcher("tabella.jsp").forward(request, response);
				break;
			case 3:
				id=Integer.parseInt(request.getParameter("id"));
				crud.rimuovi(id);
				response.sendRedirect("Avvio?scelta=2");
				break;
			case 4:
				id = Integer.parseInt(request.getParameter("id"));
				prodotto = crud.leggi(id);
				marche = crudm.leggi();
				categorie = crudc.leggi();
			    request.setAttribute("prodotto", prodotto);
				request.setAttribute("marche", marche);
				request.setAttribute("categorie", categorie);
				request.getRequestDispatcher("formModifica.jsp").forward(request, response);
				break;
			case 5:
				id = Integer.parseInt(request.getParameter("id"));
				nomeProdotto = request.getParameter("nomeProdotto");
				nomeMarca = request.getParameter("nomeMarca");
				nomeCategoria = request.getParameter("nomeCategoria");
				prezzo = Double.parseDouble(request.getParameter("prezzoProdotto"));
				dataProduzione = Date.valueOf(request.getParameter("dataProduzione"));
				quantita = Integer.parseInt(request.getParameter("quantitaProdotto"));
				int idCategorie = Integer.parseInt(request.getParameter("idCategoria"));
				int idMarche = Integer.parseInt(request.getParameter("idMarca"));
				
				prodotto = new Prodotto();
				prodotto.setId(id);
				prodotto.setId_categorie(idCategorie);
				prodotto.setId_marche(idMarche);
				prodotto.setNomeProdotto(nomeProdotto);
				prodotto.setPrezzo(prezzo);
				prodotto.setDataProduzione(dataProduzione);
				prodotto.setQuantita(quantita);
				crud.modifica(prodotto);
				response.sendRedirect("Avvio?scelta=2");
				break;
			}
		}else {
			response.sendRedirect("home.html");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
