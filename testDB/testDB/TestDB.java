package testDB;

import static org.junit.Assert.*;

import org.junit.Test;

import utility.Connettore;

public class TestDB {

	@Test
	public void test() {
		Connettore connettore = Connettore.getInstance();
		assertNotNull("Connessione non risucita", connettore.apriConnessione());
	}

}
