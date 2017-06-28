package br.com.caelum.contas;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

import br.com.caelum.contas.modelo.Conta;
import javafx.scene.shape.LineTo;

public class RepositorioDeContas {

	public void salva(List<Conta> contas) {

		PrintStream stream;
		try {
			stream = new PrintStream("contas.txt");
			for (Conta conta : contas) {
				stream.println(conta.getTipo() + ", " + conta.getNumero() + conta.getAgencia() + ", "
						+ conta.getTitular() + ", " + conta.getSaldo());
			}
			stream.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	Scanner scanner = new Scanner(System.in);

	public String carrega() {

		String linha = scanner.nextLine();
		String[] valores = linha.split(", ");
		String tipo = valores[0];

		return tipo;
	}
}
