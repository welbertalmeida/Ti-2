import java.util.*;
class SomarDoisNumeros {
	public static Scanner sc = new Scanner(System.in);
	
	public static void main (String[] args) {
		//Declaração de variaveis
		int num1, num2, soma;
		
		//ler primeira variavel
		System.out.println("Digite um numero");
		num1 = sc.nextInt();
		
		//ler segunda variavel
		System.out.println("Digite outro numero");
		num2 = sc.nextInt();
		
		//somar
		soma = num1 + num2;
		
		//Mostrar na tela
		System.out.println("Soma: " + soma);
	}


}
