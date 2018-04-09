import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Executable;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.junit.*;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static junit.framework.TestCase.fail;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;



class BowlingGameTest {
	
	@Rule
    public ExpectedException exceptions = ExpectedException.none();

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test //Full test w/ test case input
	void testBowlingGame() throws Exception {
		String[] frames = {	"XXXXXXXXXXXX", 
							"9-9-9-9-9-9-9-9-9-9-", 
							"5/5/5/5/5/5/5/5/5/5/5",
							"X7/9-X-88/-6XXX81",
/*additional test cases */	"5-5-5-5-5-5-5-5-5-5-",
							"11111111111111111111"};
		
		
		assertEquals(300, BowlingGame.score(BowlingGame.parser(frames[0])));
		assertEquals(90, BowlingGame.score(BowlingGame.parser(frames[1])));
		assertEquals(150, BowlingGame.score(BowlingGame.parser(frames[2])));
		assertEquals(167, BowlingGame.score(BowlingGame.parser(frames[3])));
		assertEquals(50, BowlingGame.score(BowlingGame.parser(frames[4])));
	
	}

	@Test
	void testMain_1() throws Exception {
		BowlingGame result = new BowlingGame();
		
		Assert.assertNotNull(result);
	}
	
	@Test
    public void throwsArrayIndexOutOfBoundsException_1(){
        
            int[] frames = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17};
            BowlingGame.score(frames);

   
    }      //REQUIRES JUNIT 5 !
	@Test
	public void testMainForLoop() {
		int[] frames = {};
		BowlingGame game = new BowlingGame();
		
	}
	@Test
    public void throwsArrayIndexOutOfBoundsException(){
        try {
            int[] frames = {1, 2};
            BowlingGame.score(frames);

            fail("should throw an exception");
        } catch (ArrayIndexOutOfBoundsException e){
            assertThat(e.getMessage(), containsString("-1"));
            assertThat(e, instanceOf(ArrayIndexOutOfBoundsException.class));
        }
    }

	
	
	@Test
	void testParser1() {
		BowlingGame game = new BowlingGame();
		String[] frames = {"00000000000"};
		@SuppressWarnings("static-access")
		int[] result = game.parser(frames[0]);
		int result2 = BowlingGame.score(result);
		assertEquals(0, result2);
		
	}
	@Test 
	void testParser2() {
		BowlingGame game = new BowlingGame();
		String[] frames = {"xXXXxxxXxXxx"};
		// Lower Case test for switch statement
		int[] result = game.parser(frames[0]);
		int result2 = BowlingGame.score(result);
		assertEquals(300, result2);
	}
	
	@Test 
	void testGame() {
		BowlingGame game = new BowlingGame();
		
	}
	
	


}
