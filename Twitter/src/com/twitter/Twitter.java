package com.twitter;

import java.util.LinkedList;
import com.twitter.poruke.TwitterPoruka;
/**
 * Klasa Twitter 
 * @author Stefana Bogdanovic
 * @version 0.2
 *
 */
public class Twitter {
	

	/**
	 * Lista twitter poruka
	 * 
	 */
	private LinkedList<TwitterPoruka> poruke = new LinkedList<TwitterPoruka>();
	
	/**
	 * Metoda koja vraca listu poruka
	 * @return sve poruke
	 */
	public LinkedList<TwitterPoruka> vratiSvePoruke(){

		return poruke;

	}

	/**
	 * Metoda koja unosi novu twitter poruku
	 * @param korisnik ime korisnika koji unosi poruku
	 * @param poruka sadrzaj poruke
	 */
	public void unesi(String korisnik, String poruka) {

		//Pravi se nova poruka i puni podacima.

		TwitterPoruka tp = new TwitterPoruka();

		tp.setKorisnik(korisnik);

		tp.setPoruka(poruka);

		//Poruka se unosi u listu na kraj

		poruke.addLast(tp);

	}

	/**
	 * Metoda koja vraca niz poruka zadatog kapaciteta i koje u sebi sadrze zadati tag
	 * @param maxBroj kapacitet niza koji vracamo
	 * @param tag kljucna rec koju trazimo u listi poruka
	 * @return niz poruka
	 * @throws java.lang.RuntimeException ako je tag
	 * <ul>
	 * 		<li>null</li>
	 * 		<li>prazan string</li>
	 * </ul>
	 * 
	 */
	public TwitterPoruka[] vratiPoruke(int maxBroj, String tag) {

		if (tag==null || tag == "")

			throw new RuntimeException("Morate uneti tag");

		//Ako je maxBroj <=0, vraca maxBroj se postavlja na 100 poruka

		if (maxBroj<=0)

			maxBroj = 100;
 
		//Pomocna promenljiva koja predstavlja brojac upisanih poruka

		int brojac = 0; 

		//Pomocni niz koja predstavlja rezultat pretrage tj. sadrzace

		//sve poruke koje u sebi imaju zadati tag

		TwitterPoruka[] rezultat = new TwitterPoruka[maxBroj];

		//Pretrazuju se poruke i traze se one koje sadrze tag.

		//Ako se nadje neka takva, i ako nije prekoracen maxBroj

		//ona se upisuje u niz. Ako je prekoracen maxBroj,pretraga

		//se prekida.
		for (int i = 0; i < poruke.size(); i++)
		
			if (poruke.get(i).getPoruka().indexOf(tag)!=-1)
		
				if (brojac < maxBroj){
		
					rezultat[brojac]=poruke.get(i);
		
					brojac++;
		
				}

				else break;

		return rezultat;

	}
} 