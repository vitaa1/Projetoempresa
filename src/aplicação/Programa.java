package aplicação;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entidades.Pessoa;
import entidades.PessoaFisica;
import entidades.PessoaJuridica;

public class Programa {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Pessoa> lista = new ArrayList<>();
		
		System.out.print("insira o número de contribuintes: ");
		int n = sc.nextInt();
		
		for (int i = 1; i <= n; i++) {
			System.out.println("Contribuinte # " + i + " data:");
			System.out.print("indivíduo ou empresa (i/c)? ");
			char ch = sc.next().charAt(0);
			System.out.print("Nome: ");
			sc.nextLine();
			String nome = sc.nextLine();
			System.out.print("Rendimento anual: ");
			double rendaAnual = sc.nextDouble();
			
			if (ch == 'i') {
				System.out.print("despesas de saúde: ");
				double gastosComSaude = sc.nextDouble();
				Pessoa pessoa = new PessoaFisica(nome, rendaAnual, gastosComSaude);
				lista.add(pessoa);
			} else {
				System.out.print("Número de funcionários: ");
				int numeroDeFuncionarios = sc.nextInt();
				Pessoa pessoa = new PessoaJuridica(nome, rendaAnual, numeroDeFuncionarios);
				lista.add(pessoa);
			}
		}
		
		System.out.println();
		System.out.println("TAXAS DE PAGAMENTOS: ");
		for (Pessoa pessoa : lista) {
			System.out.println(pessoa.getNome() + ": $" + String.format("%.2f", pessoa.imposto()));
		}
		
		System.out.println();
		double somaTotal = 0.0;
		for (Pessoa pessoa : lista) {
			somaTotal = somaTotal + pessoa.imposto();
		}
		
		System.out.print("TOTAL DAS TAXAS DE IMPOSTO: $ " + String.format("%.2f", somaTotal));
		
		sc.close();
				
				

	}

}
