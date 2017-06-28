package br.com.caelum.contas.modelo;

public abstract class Conta implements Comparable<Conta> {

	// Atributos
	private String titular;
	private int numero;
	private String agencia;
	protected double saldo;

	@Override
	public String toString() {
		this.titular = this.titular.toUpperCase();
		return "[ Titular: " + this.titular + " | " + "Conta: " + this.numero + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		Conta outraConta = (Conta) obj;

		return this.numero == outraConta.numero && this.agencia.equals(outraConta.agencia);
	}

	// Métodos getters and setters
	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	// Método soma valor depositado mais saldo
	public void deposita(double quantia) {
		if (quantia < 0) {
			throw new IllegalArgumentException("Voce tentou depositar" + " um valor negativo");
		} else {
			this.saldo += quantia;
		}
	}

	/**
	 * Método subtrai do saldo valor retirado, verificando antes se há saldo
	 * suficiente.
	 * 
	 */
	public void saca(double valor) {
		if (valor <= 0) {
			throw new IllegalArgumentException("Voce tentou sacar um valor negativo");
		}
		if (this.saldo < valor) {
			throw new SaldoInsuficienteException(valor);
		}
		this.saldo -= valor - 0.10;
	}

	public void transfere(double valor, Conta conta) {
		this.saca(valor);
		conta.deposita(valor);
	}

	// Método que diferencia uma classe da outra
	public abstract String getTipo();
	
	public int compareTo(Conta outraConta) {
		return this.titular.compareTo(outraConta.titular);	
	}
	
	

}
