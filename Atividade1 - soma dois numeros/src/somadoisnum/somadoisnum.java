package somadoisnum;
import java.util.Scanner; 

public class somadoisnum {
	
	public static void main(String [] args) {
		Scanner receive = new Scanner(System.in);
		
		System.out.println("Insira o primeiro num");
		int num1 = receive.nextInt();
		
		System.out.println("Insira o segundo num");
		int num2 = receive.nextInt();
		
		int soma = num1 + num2;
		
		System.out.println("Soma:" + soma);
	}
}
