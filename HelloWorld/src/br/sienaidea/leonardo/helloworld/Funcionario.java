/**
 * 
 */
package br.sienaidea.leonardo.helloworld;

/**
 * @author Leonardo Christino
 * 
 */
public class Funcionario implements Runnable {
	private double salario = 300;

	public void aumentaSalario(double aumento){
		if (aumento < 0) {
			IllegalArgumentException erro = new IllegalArgumentException();
			throw erro;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		if (Double.doubleToLongBits(getSalario()) != Double
				.doubleToLongBits(other.getSalario()))
			return false;
		return true;
	}

	public double getSalario() {
		return salario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(getSalario());
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public void run() {
		while (true) {
			setSalario(getSalario() + 0.01);
		}
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	@Override
	public String toString() {
		return "Funcionario [salario=" + getSalario() + "]";
	}
}
