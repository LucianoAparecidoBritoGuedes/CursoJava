package entites;


public class ContaBancaria {
	private String titular;
	private int conta = 0;
	private double saldo;
	private double deposito;
	private int saque;
	
	//Constructors:
	public ContaBancaria() {
	}
	
	public ContaBancaria(String titular) {
		this.conta += 1;
		this.titular = titular;
	}
	
	public ContaBancaria(String titular, double deposito) {
		this.conta += 1;
		this.titular = titular;
		
		try {
			this.deposito = deposito;
			this.saldo = this.deposito;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Getters and Setters:
	public int getConta() {
		return conta;
	}

	public double getSaldo() {
		return saldo;
	}

	private void setSaldo(double saldo) {
		this.saldo += saldo;
	}

	public double getDeposito() {
		return deposito;
	}

	public void setDeposito(int deposito) {
		this.deposito = deposito;
		this.setSaldo(deposito);
	}

	public int getSaque() {
		return saque;
	}

	public void setSaque(int saque) {
		this.saque = saque;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}
	

}
