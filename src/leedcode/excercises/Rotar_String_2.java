package leedcode.excercises;

/**
 * Programa 796 de Leetcode - Rotate String
 * Problema: Dada 2 cadenas de texto Cadena 1 y Cadena2 debemos crear un algoritmo para verificar
 * si la cadena 2 es una rotación de la cadena 1, debe retornar true o false
 * @author PC
 *
 */
public class Rotar_String_2 {
	
	public static void main(String[] args) {
		boolean rpta = rotateStringv1("abcade", "cadeab");
		System.out.println("La cadena cadeab es una rotacion de abcade? = " + rpta);
	}
	
	public static boolean rotateStringv1(String a, String b){	
		//duplicamos el valor de a. concatenamos el valor a con a
		a += a;
		return (a.length() != b.length() && a.contains(b));
		
	}
	
	public static boolean rotateString(String a, String b){
		//validamos si son cadenas de tamaño distinto
		if(a.length() != b.length()) return false;
		
		//si A es igual B no aplicamos el algoritmo
		if(a.equals(b)) return false;
		
		/**
		 * Algoritmo para determinar si B es una rotacion de la cadena A
		 * Ejemplo: 
		 * a = abcade
		 * b = cadeab
		 * Solucion propuesta:
		 * 1. Tomamos el primer caracter de la cadena a y lo buscamos dentro de la cadena b con el 
		 *    metodo de indexOf() para obtener la posición del caracter
		 * 2. Creamos una variable llamada c que contendrá desde la posición obtenida por el indexOf()
		 *    hacia elfinal de la cadena b y lo concatenamos desde el principio de b hasta antes
		 *    del indice dado por indexOf()
		 * 3. Si c == b entonces el algoritmo retorna true
		 * Nota: Si en la cadena a se repite un carcater entonces por ese segundo o las veces necesarias
		 *       se debe repetir el ejecución del algoritmo.
		 */
		
		//Obtenemos la primera posicion del primer caracter de a en b
		//indeOf retorna -1 si el primer caracteren a no se encuentra en b
		int index = b.indexOf(a.substring(0,1));
		
		//Mientras no sea -1 es decir, el primer caracter de a se encuentra en b
		while(index != -1) {
			//aplicamos un substring desde el indice hasta el final de la cadena b
			StringBuilder sb = new StringBuilder(b.substring(index)); //sb=adeab
			//adicionamos a sb el inicio de la cadena b hasta antes del index
			sb.append(b.substring(0, index));// sb = adeabc
			
			//realizamos la comparacion
			if(sb.toString().equals(a)) return true;
			//si no son iguales re-calculamos el index y pasamos a la siguiente posicion
			else {
				index = b.indexOf(a.substring(0,1), index+1);
			}
		}
		return false;
	}
}
