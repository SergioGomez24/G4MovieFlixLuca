package gui;

import java.util.ArrayList;

public class Vista {
	public static <T> void imprimirColeccion(ArrayList<T> arr) {
		for(T r : arr)
			System.out.println(r.toString());
	}
}
