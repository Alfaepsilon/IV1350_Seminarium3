package POSsys.dbHandler;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ItemRegisterTest {

	ItemRegister itemReg = new ItemRegister();

	/**
	@author Amiran
     * testar om getPrice fungerar med 5 �pplen som input
     */

	@Test
	void testApples() {
		int val = itemReg.getPrice("apples", 5);
		boolean result = (val == 50);
		assertEquals(true, result, "values test normally");
	}

	/**
	@author Amiran
     * testar om getPrice fungerar med 10 bitar k�tt som input
     */

	@Test
	void testMeat() {
		int val = itemReg.getPrice("meat", 10);
		boolean result = (val == 250);
		assertEquals(true, result, "values test normally");
	}

	/**
	@author Amiran
     * testar identifier funktionen med p�ron som input
     */

	@Test
	void testIdentifier() {
		boolean result = itemReg.checkItemStatus("pears");
		assertEquals(true, result, "values test normally");
	}

	/**
	@author Amiran
     * testar identifier funktionen med d�lig input
     */

	@Test
	void testIdentifierFalse() {
		boolean result = !(itemReg.checkItemStatus("gibberish"));
		assertEquals(true, result, "values test normally");
	}
}
