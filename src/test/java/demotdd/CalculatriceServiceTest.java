package demotdd;


import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

public class CalculatriceServiceTest {
	
	private CalculatriceService calculatriceService;
	
	@BeforeEach 
	@Timeout(5)
	public void SetUp() throws InterruptedException {
		TimeUnit.SECONDS.sleep(3);
		calculatriceService = new CalculatriceService();
		System.out.println("On initialise les ressources");
	}
	
	@Test
	@Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
	public void TestAddition()  {
		
		System.out.println("Test Addition");
		int resultat = calculatriceService.Addition(3,4);
		int expected = 7;
		assertTrue(resultat==expected," Resultat not ok ");
		
	}
	
	@Test()
	public void TestDivisonZeroWithException() {
		System.out.println("Test Division per zero");
		
		assertThrows(ArithmeticException.class,() -> {
			int resultat = calculatriceService.DivisionZero(3);
			int expected = 0;
			assertTrue(resultat==expected," Doit donner comme résultat 0");
		});
		
		
		
	}
	
	@AfterEach 
	@Timeout(5)
	public void TearDown() throws InterruptedException {
		TimeUnit.SECONDS.sleep(3);
		calculatriceService = null;
		System.out.println("On libère les ressources");
	}

}
