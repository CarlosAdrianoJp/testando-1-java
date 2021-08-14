package principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entidades.Pessoa;
import entidades.PessoaFisica;
import entidades.PessoaJuridica;

public class Main {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		
		List<Pessoa> lista = new ArrayList<>();
		
		
		System.out.println("digite o numero de pessoas");
		int n = in.nextInt();
		for (int i=1; i<=n; i++) {
			System.out.println("pessoa fisica ou juridica (F/J)");
			char ch = in.next().charAt(0);
			System.out.println("nome: ");
			String nome = in.next();
			System.out.println("renda Anual: ");
			double renda = in.nextDouble();
			
			
			if(ch == 'f') {
				System.out.println("digite os gastos com saude: ");
				double gastos = in.nextDouble();
				lista.add(new PessoaFisica(nome, renda, gastos));
			}else {
				System.out.println("digite o numero de funcionarios: ");
				int func = in.nextInt();
				lista.add(new PessoaJuridica(nome, renda, func));
			}
		}
		
		double soma = 0;
		System.out.println("taxas");
		for(Pessoa p : lista) {
			double tax = p.taxas();
			System.out.println(p.getNome() + " : $ " + String.format("%.2f", tax));
			soma += tax;
		}
		
		System.out.println();
		System.out.println("taxa total: " + String.format("%.2f", soma));
		in.close();
	}

}
