package POSsys.dbHandler;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import POSsys.view.ErrorMessageHandler;

class ItemRegisterTest {
	
	ItemRegister itemReg = new ItemRegister();
	
	/**
     * testar om getPrice fungerar med 5 äpplen som input
     */

	@Test
	void testApples() {
		int val = itemReg.getPrice("apples", 5);
		boolean result = (val == 50);
		assertEquals(true, result, "values test normally");
	}
	
	/**
     * testar om getPrice fungerar med 10 bitar kött som input
     */
	
	@Test
	void testMeat() {
		int val = itemReg.getPrice("meat", 10);
		boolean result = (val == 250);
		assertEquals(true, result, "values test normally");
	}
	
	/**
     * testar identifier funktionen med päron som input
     */
	
	@Test
	void testIdentifier() {
		boolean result = false;
		try {
			result = itemReg.checkItemStatus("pears");
			assertEquals(true, true, "could find specified object");
		} catch (Exception e) {
			assertTrue("could not find specified object", e.getMessage().contains("Item with that name was not found in the register"));
		}
	}
	
	/**
     * testar identifier funktionen med dålig input
     */
	
	@Test
	void testIdentifierFalse() {
		boolean result = false;
		try {
			result = itemReg.checkItemStatus("gibberish");
			fail("could find specified object");
		} catch (Exception e) {
			assertTrue("could not find specified object", e.getMessage().contains("Item with that name was not found in the register"));
		}
	}
	
	@Test
	void testDatabase() {
		boolean result = false;
		try {
			result = itemReg.checkItemStatus("cats");
			fail("could find specified object");
		} catch (Exception e) {
			assertTrue("could not find specified object", e.getMessage().contains("LOG:Database could not be called"));
		}
	}
}
