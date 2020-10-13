package leedcode.excercises;

import java.util.Stack;

/**
 * Tenemos 2 arreglo de enteros:
 * 1. pushed[1,2,3,4,5]
 * 2. pop[4,5,3,2,1]
 * 
 * Debemos diseñar un algoritmo que al validar el arreglo pop da como resultado
 * operaciones hechas en un stack (Un stack es un contenedor de objetos donde lo primero que sale
 * es el ultimo objeto en ingresar Last Input/First Out)
 * 
 * Para realizar las operaciones pop segun el segundo arreglo debemos seguir la siguiente secuencia:
 * push 1
 * push 2
 * push 3
 * push 4
 * 
 * pop 4
 * push 5
 * pop 5
 * pop 3
 * pop 2
 * pop 1
 * 
 * Solucion
 * ========
 * 
 * 1. Creamos un stack
 * 2. Barremos los valores de pushed
 * 3. Con un index extra vamos iterando pop para ver si las operaciones de pop son posibles segun como
 *    vaya avanzando nuestro ciclo for a iterar pushed
 */
public class Validate_Stack_Sequence 
{
	
	public static void main(String[] args) {
		int[] pushed = {1,2,3,4,5};
		int[] popped = {4,5,3,2,1};
		
		System.out.println("Las operaciones en popped corresponden a las de pushed= " + validateStackSeq(pushed, popped));
	}
	
	public static boolean validateStackSeq(int[] pushed, int[] popped) {
		Stack<Integer> stack = new Stack<Integer>();
		int indexPop = 0;
		
		for(int push : pushed) {
			//los valores de pushed los colocamos en nuestro stack
			stack.push(push);
			//cuando pasa el primer valor, con un while los comparamos con lo que esta en popped
			while(!stack.isEmpty() && popped[indexPop] == stack.peek()) {
				indexPop++;
				stack.pop();
			}
		}
		//si el stack queda vacio quiere decir que las operaciones en popped si corresponde a las
		//operaciones en push
		 return stack.isEmpty() ? true : false;
	}
}
