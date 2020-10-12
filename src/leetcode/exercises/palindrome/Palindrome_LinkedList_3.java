package leetcode.exercises.palindrome;

import java.util.Stack;

/*
 * Palindrome LinkedList - leetcode 234
 * Tenemos una estructura de datos (linked list). Una lista enlazada es un etiquetado que hacemos
 * a los objetos para determinar un secuencia entre ellos u orden lógico
 * 
 * Este ejercicio consiste en construir un algoritmo que nos retorne true si la lista enlazada
 * es un palíndrome
 * 
 * 1er caso: la suma de los elementos en la lista enlazada es un total par
 * Ejemplo: 1-> 2 -> 3 -> 3 -> 2 -> 1
 * Declaramos 2 punteros: f y s 
 * puntero fast: este puntero avanza 2 posiciones
 * puntero slow: este puntero avanza 1 posicion
 * Cuanto el puntero f (fast) llegue al final de la lista el puntero s (slow) estara a la mitad
 * Creamos un stack donde pondremos los valores que le puntero s esta recorriendo
 * 
 * Inicia la iteracion
 * Vamos a preguntar si 2 posiciones despues es nulo (como en nuestro caso no lo es f avanza 2)
 * 1-> 2 -> 3 -> 3 -> 2 -> 1
 * f   f    f
 * s   s
 * 
 * Stack contiene: 
 * 					2
 * 					1
 * 
 * Volvemos a preguntar si 2 posiciones despues es nulo (como en nuestro caso no lo es f avanza 2)
 * 1-> 2 -> 3 -> 3 -> 2 -> 1 -> null
 * f   f    f    f    f
 * s   s    s    s
 * Stack contiene
 * 					3
 * 					2
 * 					1
 * Volvemos a preguntar si 2 posiciones despues es nulo que es true (no se realiza la sgte iteracion)
 * 
 * Empezamos una iteracion por el stack
 * Empezamos a preguntar: sacamos el primer valor top del stack (3) es igual al valor donde
 * esta el puntero s (3) , si es igual entonces avanzo(3 sale del stack con pop)
 * 
 * 1-> 2 -> 3 -> 3 -> 2 -> 1 -> null
 * f   f    f    f    f
 * s   s    s    s    s
 * 
 * Empezamos a preguntar: sacamos el primer valor top del stack (2) es igual al valor donde
 * esta el puntero s (2) , si es igual entonces avanzo(2 sale del stack con pop)
 * 
 * 1-> 2 -> 3 -> 3 -> 2 -> 1 -> null
 * f   f    f    f    f
 * s   s    s    s    s    s
 * 
 * Empezamos a preguntar: sacamos el primer valor top del stack (1) es igual al valor donde
 * esta el puntero s (1) , si es igual entonces avanzo(1 sale del stack con pop) fin de la iteracion
 * retornamos true
 * 
 * 2do caso: la suma de los elementos en la lista enlazada es un total impar, es dedir tiene un centro
 * 
 *  		1-> 2 -> 3 -> 2 -> 1
 *  puntero f
 *  puntero s
 *  
 *  preguntamos si el valor actual y siguente es nulo? false. entonce f avanza 2 posiciones, s una posicion
 *   1-> 2 -> 3 -> 2 -> 1
 *   f   f    f
 *   s   s
 *  stack: almacena el valor actual de s
 *  		1
 * 
 * preguntamos el valor donde esta f es null? rpta no, el siguiente? rpta no, entonces avanza s una posicion
 * y lo almacenamos en el stack
 * 
 * 1-> 2 -> 3 -> 2 -> 1
 * f   f    f    f    f
 * s   s    s
 *  stack: almacena el valor actual de s
 *  		2				
 *  		1
 * 
 * Preguntamos: el valor actual del puntero f es null? rpta false, pero el siguiente si es null
 * lo que significa que la estructura tiene un centro, entonces
 * 
 * Avanzamos a la siguiente posicion puntero s:
 * 
 * 1-> 2 -> 3 -> 2 -> 1
 * f   f    f    f    f
 * s   s    s    s
 *  stack: almacena el valor actual de s
 *  		2				
 *  		1
 * 
 * empezamos a validad: 
 * 
 * Sacamos el ultimo elemento ingresado al stack = 2, preguntamos si 2 es igual al elemento donde
 * esta posicionado el puntero s (2 = 2) rpta si, entonces avanzamos el puntero s una posicion,
 * 
 * 1-> 2 -> 3 -> 2 -> 1
 * f   f    f    f    f
 * s   s    s    s    s
 *  stack: almacena el valor actual de s				
 *  		1
 * Sacamos el ultimo elemento ingresado al stack = 1, preguntamos si 1 es igual al elemento donde
 * esta posicionado el puntero s (1 = 1) rpta true, entonces es palindrome
 * 
 */
public class Palindrome_LinkedList_3 {
	
	public static void main(String[] args) {
		ListNode list = new ListNode(1);
		ListNode list1 = new ListNode(1, list);
		
		boolean isPali = isPalindrome(list1);
		
		System.out.println(isPali);
	}
	
	public static boolean isPalindrome(ListNode head) {
		
		if(head == null || head.next == null) return true;
		
		Stack<Integer> stack = new Stack<Integer>();
		
		//creamos los punteros
		ListNode f = head;
		ListNode s = head;
		
		//mientras el puntero f no sea null y que no apunte a un null. este ciclo termina
		//justo a la mitad de nuestra estructura
		while(f != null && f.next != null) {
			//metemos el 1er valor de puntero s al stack
			stack.push(s.val);
			
			//avanzamos puntero 2 una posicion
			s = s.next;
			//avanzamos el puntero f dos posiciones
			f = f.next.next;
		}
		
		//preguntamos si nuestra lista es para o impar
		/**
		 * Si f != null quiere decir que llegamos al final de la lista y f sigue teniendo un valor
		 */
		if(f != null) {
			//avanzamos 1 posicion s para saltarnos el centro de la lista
			s = s.next;
		}
		
		//ya que nos saltamos el centro, iteramos el resto de la lista
		while(s != null) {
			//comparamos el valor del nodo con lo que tenemos en el stack
			//si el valor de nuestro nodo no es igual al elemento top del stack quiere decir que
			//no es un palindrome
			if(s.val != stack.pop()) {
				return false;
			}
			//si son iguales avanzado al siguiente elemento de la lista
			s = s.next;
		}
		
		return true;
	}

}
