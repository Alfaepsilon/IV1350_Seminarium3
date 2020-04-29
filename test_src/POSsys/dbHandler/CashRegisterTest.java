package POSsys.dbHandler;

import static org.junit.jupiter.api.Assertions.*;
import POSsys.dbHandler.CashRegister;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CashRegisterTest {

	private CashRegister register;
	boolean result;

	/**
	@author Amiran
     * skapar en ny CashRegister och s�tter result till false f�r varje test
     */

	@BeforeEach
	void setUp() throws Exception {
		register = new CashRegister();
		result = false;
	}

	/**
	@author Amiran
     * testar funktionen som �kar register v�rdet med ett normalt v�rde som 10
     */

	@Test
	void increaseAmountNormalValuesTest() {
		int testVal = 10;
		register.increaseAmountPresentInRegisterWithAmountPaid(testVal);
		if(register.getAmount() == testVal)
		{
			register.increaseAmountPresentInRegisterWithAmountPaid(testVal);
			result = (register.getAmount() == testVal + testVal);
		}
		assertEquals(true, result, "values test normally");
	}

	/**
	@author Amiran
     * testar funktionen som �kar register v�rdet med olika v�rden, en positiv och en negativ
     */

	@Test
	void increaseAmountDifferentNormalValuesTest() {
		int testVal = 10;
		int testVal2 = -10;
		register.increaseAmountPresentInRegisterWithAmountPaid(testVal);
		if(register.getAmount() == testVal)
		{
			register.increaseAmountPresentInRegisterWithAmountPaid(testVal2);
			result = (register.getAmount() == testVal + testVal2);
		}
		assertEquals(true, result, "values test normally");
	}

	/**
	@author Amiran
     * testar funktionen som �kar register v�rdet med bara negativa v�rden
     */

	@Test
	void increaseAmountNegativeValuesTest() {
		int testVal = -10;
		register.increaseAmountPresentInRegisterWithAmountPaid(testVal);
		if(register.getAmount() == testVal)
		{
			register.increaseAmountPresentInRegisterWithAmountPaid(testVal);
			result = (register.getAmount() == testVal + testVal);
		}
		assertEquals(true, result, "values test normally");
	}

	/**
	@author Amiran
     * testar funktionen som �kar register v�rdet med nollor
     */

	@Test
	void increaseAmountZeroValuesTest() {
		int testVal = 0;
		register.increaseAmountPresentInRegisterWithAmountPaid(testVal);
		if(register.getAmount() == testVal)
		{
			register.increaseAmountPresentInRegisterWithAmountPaid(testVal);
			result = (register.getAmount() == testVal + testVal);
		}
		assertEquals(true, result, "values test normally");
	}

	/**
	@author Amiran
     * testar calculateChange funktionen med tv� positiva v�rden
     */

	@Test
	void calculateChangeTest() {
		int testVal = 5;
		int testVal2 = 5;
		if(register.calculateChange(testVal, testVal2) == testVal - testVal2)
		{
			result = true;
		}
		assertEquals(true, result, "values test normally");
	}

	/**
	@author Amiran
     * testar calculateChange funktionen med tv� negativa v�rden
     */

	@Test
	void calculateChangeNegTest() {
		int testVal = -5;
		int testVal2 = -5;
		if(register.calculateChange(testVal, testVal2) == testVal - testVal2)
		{
			result = true;
		}
		assertEquals(true, result, "values test normally");
	}

	/**
	@author Amiran
     * testar calculateChange funktionen med tv� olika v�rden, positiv och negativ
     */

	@Test
	void calculateChangeDiffTest() {
		int testVal = 5;
		int testVal2 = -5;
		if(register.calculateChange(testVal, testVal2) == testVal - testVal2)
		{
			result = true;
		}
		assertEquals(true, result, "values test normally");
	}

	/**
	@author Amiran
     * testar calculateChange funktionen med nollor
     */

	@Test
	void calculateChangeZeroTest() {
		int testVal = 0;
		int testVal2 = 0;
		if(register.calculateChange(testVal, testVal2) == testVal - testVal2)
		{
			result = true;
		}
		assertEquals(true, result, "values test normally");
	}
}
