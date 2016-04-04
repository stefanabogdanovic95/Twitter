package com.twitter.poruke;

/**
 * Klasa predstavlja twitter poruku.
 * 
 * @author Stefana Bogdanovic
 * @version 0.1
*/
public class TwitterPoruka {
	

	/**
	 * Atribut koji predstavlja ime korisnika
	 */
	private String korisnik;

	/**
	 * Atribut koji predstavlja sadrzaj poruke
	 */
	private String poruka;


	/**
	 * Metoda vraca ime korisnika
	 * @return ime korisnika
	 */
	public String getKorisnik() {

		return korisnik;

	}


	/**
	 * Metoda postavlja vrednost atributa 'korisnik' na vrednost zadatog parametra
	 * @param korisnik ime korisnika
	 * @throws java.lang.RuntimeException ako je vrednost unetog parametra null ili prazan string
	 * 
	 */
	public void setKorisnik(String korisnik) {

		if (korisnik==null || korisnik == "")

			throw new RuntimeException(

					"Ime korisnika mora biti uneto");

		this.korisnik = korisnik;

	}


	/**
	 * Metoda vraca sadrzaj poruke
	 * @return twitter poruka
	 */
	public String getPoruka() {

		return "poruka";

	}


	/**
	 * Metoda postavlja vrednost atributa 'poruka' na zadatu vrednost
	 * @param poruka sadrzaj poruke
	 * @throws java.lang.RuntimeException ako je vrednost unetog parametra null ili je duzina stringa veca od 140
	 */
	public void setPoruka(String poruka) {

		if (poruka==null || this.poruka.length()>140)

			throw new RuntimeException(

					"Poruka mora biti uneta i mora imati najvise 140 znakova");

		this.poruka = poruka;

	}


	/**
	 * Redefinisana metoda 'toString'
	 * @return ime korisnika i poruku u zadatom formatu
	 */
	public String toString(){

		return "KORISNIK:"+korisnik+" PORUKA:"+poruka;

	}
}
