/**
 * 
 */
package ubu.gii.dass.test.c01;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ubu.gii.dass.c01.NotFreeInstanceException;
import ubu.gii.dass.c01.ReusablePool;

/**
 * @author Marcos Mill�n
 * @author Mario Santamaria
 *
 */
public class ReusablePoolTest {

	ReusablePool pool1;
	ReusablePool pool2;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		pool1 = ReusablePool.getInstance();
		pool2 = ReusablePool.getInstance();

	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link ubu.gii.dass.c01.ReusablePool#getInstance()}.
	 */
	@Test
	public void testGetInstance() {
		assertTrue(pool1 instanceof ReusablePool);
		assertTrue(pool2 instanceof ReusablePool);
		assertTrue(pool1.equals(pool2));
	}

	/**
	 * Test method for {@link ubu.gii.dass.c01.ReusablePool#acquireReusable()}.
	 */
	@Test
	public void testAcquireReusable() throws NotFreeInstanceException {
		
		ReusablePool pool1 = ReusablePool.getInstance();

		try {
			for (int i = 0; i < 3; i++) {
				pool1.acquireReusable();
				if (i >= 3) {
					assertTrue(false);
				}
			}
		} catch (NotFreeInstanceException e) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for
	 * {@link ubu.gii.dass.c01.ReusablePool#releaseReusable(ubu.gii.dass.c01.Reusable)}.
	 */
	@Test
	public void testReleaseReusable() {
		fail("Not yet implemented");
	}

}