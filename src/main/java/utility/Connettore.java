package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connettore {
	
	
	private final String DRIVER="com.mysql.cj.jdbc.Driver"; //path della libreria jdbc
	private final String URLDB="jdbc:mysql://localhost:3306/ecommerceservlet"; //collegamento ad un specifico DB
	private final String USERDBMS="root"; //User per accedere al DBMS (mysql)
	private final String PWDDBMS="root"; //password per accedere al DBMS (mysql)
	//Oggetti che stabilisce la connessione col DBMS
	private Connection conn = null;
		
	public Connection apriConnessione() {
		try {
			Class.forName(DRIVER);
			conn=DriverManager.getConnection(URLDB, USERDBMS, PWDDBMS); //Prendo le credenziali
		}catch (ClassNotFoundException e) { //ClassNot si innesca se il path jdbc è scorretto!
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}return conn;
	}
	
			// Static è una keyword e stabilisce che la classe usata come prefisso possa richiamare attributi e metodi statici
			// tipo Connettore.istance o Connettore.getIstance
			//2) Attributo statico
			private static Connettore instance = null;
			
			//1) Costruttore privato
			private Connettore() {
				
			}
			// un metodo statico può leggere solo attrbuti statici
			public static Connettore getInstance() {
				if (instance == null) {
					instance = new Connettore();
				}
				return instance;
			}
}

