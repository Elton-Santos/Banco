package br.com.caelum.contas.modelo;

public class ContaCorrente extends Conta implements Tributavel {
	
	// // Declara conta como Poupança
	public String getTipo(){
		return "Conta Corrente";
	}
	
	//	 Tira valor da conta corrente descontando valor de 10%.
	//	 Testa se tentar valor negativo e retorna uma Exception.
	@Override
	public void saca(double valor){
		if (valor <= 0) {
			throw new IllegalArgumentException("Voce tentou sacar um valor negativo");
		}
		if(this.saldo < valor){
			throw new SaldoInsuficienteException(valor);
		}
		this.saldo -= valor - 0.10;
	}

	//	Calcular valor de imposto
	@Override
	public double getValorImposto() {
		return this.getSaldo() * 0.01;
	}
}

