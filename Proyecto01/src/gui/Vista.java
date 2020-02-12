package gui;

import java.util.ArrayList;
import java.util.Map;

public class Vista {
	public static <T> void imprimirColeccion(ArrayList<T> arr) {
		for(T r : arr)
			System.out.println(r.toString());
	}
	
	public static <K, V> void imprimirColeccion(Map<K,V> mapa) {
		for (Map.Entry<K, V> entrada : mapa.entrySet())
			System.out.println(entrada.getKey() + ": " + entrada.getValue().toString());
	}
}
