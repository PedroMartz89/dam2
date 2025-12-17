package com.pberna.psp.netword.inetaddress;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class UrlSamples {
	public static void infoUrl(String strUrl) {
		try {			
			URI uri = URI.create(strUrl);			
			URL url = uri.toURL();
			
			mostrarInfoURL(url);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void mostrarInfoURL(URL url) {
		
		System.out.println("Authority:" + url.getAuthority());
		System.out.println("getDefaultPort:" + url.getDefaultPort());
		System.out.println("getHost:" + url.getHost());
		System.out.println("getPath:" + url.getPath());
		System.out.println("getPort:" + url.getPort());
		System.out.println("getProtocol:" + url.getProtocol());
		System.out.println("getQuery:" + url.getQuery());
		
		if(url.getQuery() != null) {
			for(String variableYNombre : url.getQuery().split("&")) {
				String[] variableYNombreDividido = variableYNombre.split("=");
				
				System.out.println("Variable:" + variableYNombreDividido[0] + 
							"=" + variableYNombreDividido[1]);
				
			}
		}
		
		System.out.println("getRef:" + url.getRef());
		System.out.println("getUserInfo:" + url.getUserInfo());		
	}
	
	public static void urlRelativas() {
						
		URL miURL;
		try {
			miURL = new URL("http://example.com/pages/");
			URL page1URL = new URL(miURL, "page1.html");
			URL page2URL = new URL(miURL, "page2.html");
			
			mostrarInfoURL(page2URL);
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}
}
