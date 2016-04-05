/**
 * 
 */
package com.twitter;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.twitter.poruke.TwitterPoruka;

/**
 * @author Stefana
 *
 */
public class TwitterTest {
	private Twitter twitter;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		twitter = new Twitter();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		twitter = null;
	}

	/**
	 * Test method for {@link com.twitter.Twitter#vratiSvePoruke()}.
	 */
	@Test
	public void testVratiSvePoruke() {
		twitter.unesi("Haled Hoseini", "Hiljadu cudesnih sunaca");
		twitter.unesi("Haruki Murakami", "Norveska suma");
		TwitterPoruka tp1 = new TwitterPoruka();
		tp1.setKorisnik("Haled Hoseini");
		tp1.setPoruka("Hiljadu cudesnih sunaca");
		TwitterPoruka tp2 = new TwitterPoruka();
		tp2.setKorisnik("Haruki Murakami");
		tp2.setPoruka("Norveska suma");
		assertEquals(tp1.toString(), twitter.vratiSvePoruke().getFirst().toString());
		assertEquals(tp2.toString(), twitter.vratiSvePoruke().getLast().toString());
	}

	/**
	 * Test method for {@link com.twitter.Twitter#unesi(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testUnesi() {
		twitter.unesi("Dafni Kalotaj", "Dodir muzike");
		TwitterPoruka tp = new TwitterPoruka();
		tp.setKorisnik("Dafni Kalotaj");
		tp.setPoruka("Dodir muzike");
		assertEquals(tp.toString(), twitter.vratiSvePoruke().getLast().toString());
	}

	/**
	 * Test method for {@link com.twitter.Twitter#vratiPoruke(int, java.lang.String)}.
	 */
	@Test
	public void testVratiPoruke() {
		TwitterPoruka[] niz1 = new TwitterPoruka[2];
		twitter.unesi("Misa", "You're my crush");
		twitter.unesi("Deda", "Trla baba lan");
		twitter.unesi("Daft Punk", "Instant crush");
		niz1 = twitter.vratiPoruke(2, "crush");
		TwitterPoruka[] niz2 = {twitter.vratiSvePoruke().getFirst(), twitter.vratiSvePoruke().getLast()};
		assertArrayEquals(niz2, niz1);
	}
	@Test
	public void testVratiPorukePrazanNiz(){
		TwitterPoruka[] niz1 = new TwitterPoruka[2];
		twitter.unesi("Misa", "You're my crush");
		twitter.unesi("Deda", "Trla baba lan");
		twitter.unesi("Daft Punk", "Instant crush");
		niz1 = twitter.vratiPoruke(2, "suma");
		TwitterPoruka[] niz2 = new TwitterPoruka[2];
		assertArrayEquals(niz2, niz1);
	}
	@Test (expected=java.lang.RuntimeException.class)
	public void testVratiPorukeNull() {
		twitter.vratiPoruke(7, null);
	}
	
	@Test (expected=java.lang.RuntimeException.class)
	public void testVratiPorukePrazanString() {
		twitter.vratiPoruke(7, "");
	}

}
