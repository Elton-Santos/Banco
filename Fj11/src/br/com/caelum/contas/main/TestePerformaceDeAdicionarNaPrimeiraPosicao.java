package br.com.caelum.contas.main;

import java.util.LinkedList;
import java.util.List;

public class TestePerformaceDeAdicionarNaPrimeiraPosicao {

	public static void main(String[] args) {

		System.out.println("Iniciando");
		long inicio = System.currentTimeMillis();
		
		// troca depois por ArrauList
		List<Integer> teste = new LinkedList<>();
		
		for (int i = 0; i < 30000; i++) {
			teste.add(0, 1);
		}
		
		long fim = System.currentTimeMillis();
		double tempo = (fim - inicio) / 1000.0;
		System.out.println("Tempo gasto: " + tempo);
	}
}
