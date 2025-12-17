package com.pberna.psp.netword.inetaddress;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class UrlReader {
	public static void leerUrlTexto(String url) {

		URI uri = URI.create(url);		
		URL ies;
		try {
			ies = uri.toURL();
			try(BufferedReader in = new BufferedReader(new InputStreamReader(ies.openStream()));) {
				String inputLine;
				while ((inputLine = in.readLine()) != null)
					System.out.println(inputLine);	
			}
			
		} catch (MalformedURLException e) {

			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
