/**
 * 
 */
package br.sienaidea.leonardo.helloworld;

/**
 * @author Leonardo
 *
 */
public class HelloWorld {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Funcionario f = new Funcionario();
		BasicJDBCDemo demo;

		try {
			f.aumentaSalario(-10);
		} catch (IllegalArgumentException e) {
			System.out.println("Houve uma IllegalArgumentException ao aumentar o salário");
		}

		System.out.println(f.getSalario());
		Thread funcionario = new Thread(f);
		funcionario.start();
		long inicio = System.currentTimeMillis();
		while(true){
			if (System.currentTimeMillis() - inicio > 300)
				break;
		}
		funcionario.stop();
		System.out.println(f.getSalario());

		demo = new BasicJDBCDemo();
	}
	


}
