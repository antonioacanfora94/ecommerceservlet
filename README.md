# E-Commerce Servlet Management System

## 1. Titolo del progetto
**E-Commerce Servlet Management System**

## 2. Descrizione
Questo progetto è un'applicazione web basata su Java EE (Jakarta EE) che funge da pannello di gestione per un E-Commerce. L'architettura segue il pattern **MVC (Model-View-Controller)** per separare la logica di business dall'interfaccia utente e utilizza il pattern **DAO** per l'accesso ai dati. L'applicazione consente agli amministratori di gestire in modo completo il ciclo di vita di prodotti, categorie e marche all'interno del database.

## 3. Funzionalità principali
*   **Gestione Prodotti**: Inserimento, lettura, modifica e cancellazione (CRUD) dei prodotti.
*   **Gestione Categorie**: Creazione e gestione delle categorie merceologiche.
*   **Gestione Marche**: Creazione e gestione dei brand.
*   **Relazioni Dinamiche**: Durante l'inserimento di un prodotto, è possibile selezionare Categoria e Marca da liste popolate dinamicamente dal database.
*   **Visualizzazione Tabellare**: Elenco completo dei prodotti con i dettagli delle relative categorie e marche (tramite JOIN/Vista SQL).

## 4. Tecnologie usate
*   **Linguaggio**: Java
*   **Web Technology**: Servlet, JSP (JavaServer Pages)
*   **Database**: MySQL
*   **Librerie**: MySQL Connector/J (JDBC Driver)
*   **Server Application**: Apache Tomcat (9 o 10)
*   **IDE**: Eclipse IDE for Enterprise Java Developers
*   **Build Tool**: Maven

## 5. Istruzioni per eseguirlo

### Prerequisiti
*   Java Development Kit (JDK) 8 o superiore.
*   MySQL Server installato e attivo sulla porta 3306.
*   Apache Tomcat configurato nell'IDE.

### Configurazione Database
1.  Creare un database MySQL chiamato `ecommerceservlet`.
2.  Creare le tabelle necessarie: `categorie`, `marche`, `prodotti`.
3.  **Importante**: Creare una vista (View) chiamata `prodottiTotali` nel database per permettere la lettura corretta dei prodotti con i nomi di marca e categoria associati.
4.  Verificare che le credenziali nel file `src/main/java/utility/Connettore.java` (`root`/`root`) corrispondano al tuo database locale.

### Come aprire e avviare il progetto (Eclipse)
1.  Aprire **Eclipse**.
2.  Andare su `File` > `Import` > `Maven` > `Existing Maven Projects`.
3.  Selezionare la cartella radice del progetto.
4.  Fare clic destro sul progetto nel "Project Explorer".
5.  Selezionare `Run As` > `Run on Server`.
6.  Scegliere il server Tomcat e cliccare su `Finish`.
7.  L'applicazione partirà all'indirizzo configurato (es. `http://localhost:8080/eCommerceServlet/home.html`).

## 6. Note aggiuntive / possibili estensioni
*   **Pattern Singleton**: La classe `Connettore` utilizza il pattern Singleton per ottimizzare la gestione dell'istanza di connessione.
*   **Miglioramenti futuri**:
    *   Implementazione di JPA/Hibernate per sostituire le query JDBC manuali.
    *   Aggiunta di un sistema di Login/Logout con gestione sessioni.
    *   Restyling grafico con Bootstrap.