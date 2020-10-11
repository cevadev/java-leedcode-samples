package leedcode.excercises;

/**
 * Caso: Rotate Image
 * En este ejemplo se entendera como funcionan las matrices bidimensionales y su manipulacion
 * Premisa del problema: Tenemos una imagen y la debemos rotar 90 grados
 * input: Tenemos una matriz de 3 x 3
 * 1,2,3
 * 4,5,6
 * 7,8,9
 * Debemos imaginar que esta es nuestra imagen y cada coordenada es un pixel de la imagen. La idea
 * del ejercicio es crear un algoritmo que dicha matriz la convierta en:
 * 7,4,1
 * 8,5,2
 * 9,6,3
 * 
 * Desarrollo:
 * 
 * 1. Empeza a trabajar con las orillas de la matriz y lograr que se pasen al lugar adecuado
 * 2. Hecho el paso 1, aumentamos el valor de la primera coordenada y hacemos lo mismo con la segunda
 * 
 * Matriz de ejemplo para explicar el problema
 * 1,	2,	3,	4,	5
 * 6,	7,	8,	9,	10
 * 11,	12,	13,	14,	15
 * 16,	17,	18,	19,	20
 * 21,	22,	23,	24,	25
 * 
 * i = 0 -> fila
 * j = 0 -> columna
 * 
 * 1. 1 -> 0,0 / 5-> 0,4 / 25 -> 4,4 / 21 -> 4,0
 * 
 * En la segunda iteracion j = 1
 * 
 * Tips
 * No siempre cuando trabajamos con matriz es necesario recorrer toda la matriz
 * @author PC
 *
 */
public class Rotar_Matriz_1 
{
	private int[][] inputMatrix()
	{
		int[][] matrix = {
				{1,2,3},{4,5,6}
		}; 
		return matrix;
	}
	
	private int[][] rotate(int[][] matrix)throws Exception
	{
		/**
		 * Validacion de datos basuras
		 * 1. La matrix es null o empty
		 */
		if(matrix == null || matrix.length == 0)
		{
			throw new Exception("La matriz no puede estar vacia");
		}
		
		//obtenemos la longitud de la matriz
		int matrixSize = matrix.length;
		
		//iteracion de la matrix solo hasta la mitad
		for(int i = 0; i < matrixSize / 2; i++)
		{
			//iteracion de j -> 
			for(int j = i;  j < matrixSize - 1 - i; j++ )
			{
				/**
				 * 	Pasamos el numero de la coordenada (4,0 -> 21) hacia la posicion 0,0 -> 1
				 * 		almacenamos el valor de la coordenada 0,0
				 */
				int temp = matrix[i][j];
				
				//movemos el valor de la coordenada 4,0 hacia la coordenada 0,0
				//para ello debemos barrer la matrix en las i es decir filas
				matrix[i][j] = matrix[matrixSize-1-j][i]; //obtengo el valor de la coordenada 4,0
				
				/**
				 * Pasamos el valor de la coordenada (4,4-> 25) hacia la coordenada 4,0
				 * 4,0 = 4,4
				 */
				matrix[matrixSize-1-j][i] = matrix[matrixSize-1-i][matrixSize-1-j];
				
				/**
				 * Pasamos el valor de la coordenada (0,4-> 5) hacia la coordenada 4,4
				 * 4,4 = 0,4
				 */
				matrix[matrixSize-1-i][matrixSize-1-j] = matrix[j][matrixSize-1-i];
				
				//Pasamos el valor temporal capturado a la coordenada 0,4
				matrix[j][matrixSize-1-i]= temp;
			}
		}
		
		return matrix;
	}
	
	public void printMatrix(int[][] matrix)
	{
		for(int i = 0; i < matrix.length; i++)
		{
			for(int j = 0; j < matrix[i].length; j++)
			{
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
	}
	
	public void process()
	{
		try
		{
			int[][] matrix = rotate(inputMatrix());
			printMatrix(matrix);
		}
		catch(Exception e)
		{
			System.out.println("Error: "  + e.getMessage());
		}
	}
	
	public static void main(String[] args)
	{
		Rotar_Matriz_1 r = new Rotar_Matriz_1();
		r.process();
	}
}
