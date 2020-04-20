package caixa;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class app {

	static void carregarDados(String nomeArq, Fila fila) throws FileNotFoundException{
		File arq = new File(nomeArq);
		Scanner leitor = new Scanner(arq);
		
		while(leitor.hasNextLine()) {
			String linha = leitor.nextLine();
			String[]detalhes = linha.split(";");
			String cpf = detalhes[0];
			String nome = detalhes[1];
			int atendimento = Integer.parseInt(detalhes[2]);
			int intervalo = Integer.parseInt(detalhes[3]);
			cliente novo = new cliente(cpf, nome, atendimento, intervalo);
			novo.setAtendimento(atendimento);
			novo.setIntervalo(intervalo);
			fila.adicionar(novo);
		}		
		leitor.close();
	}
	
	//Divide os clientes da maior fila
	// static void Preencher_cliente(Fila fila, Elemento aux) throws InterruptedException  {

	// 	Fila nova = new Fila();

	// 	if(fila.ExistenciaDados(aux)){
		   
	// 		if(fila.numeroElemento() > 5){
			
	// 			fila.dividir(nova);
	// 		}
	// 	}
	// }

	//Tempo de atendimento dos clientes
	// static void timeAtendimento (Fila Clientes, cliente novo) throws InterruptedException {
		
	// 	for (int time = novo.getAtendimento(); ; time++) {
		
	// 		if (time != 0 ) {

	// 		  System.out.println(time);
	// 		} 
	// 	}
	// }

	public static void main(String[] args) throws Exception {

		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		String str;
			
		Fila filaClientes = new Fila();
		Fila caixa1 = new Fila();
		Fila caixa2 = new Fila();
		Fila caixa3 = new Fila();
		Fila caixa4 = new Fila();
		Fila caixa5 = new Fila();
		cliente novo = new cliente ();
		 

		//mostra o cliente atendido em cada caixa e nas filas de espera
		int tempo_ate_proximo = 0, tempo_proximo = 0;

		while(!filaClientes.vazia()){

			if(tempo_ate_proximo == tempo_proximo){

				filaClientes.retirar();
				tempo_proximo = novo.getAtendimento();
				tempo_ate_proximo = 0;
				caixa1.adicionar(novo);				
			}

			if(caixa1.numeroElemento() > 5){
			   
				caixa1 = caixa1.dividir(caixa2);
				caixa2.adicionar(novo);
			}	
		}
				
		final String nomeArq = "dadosClientes.txt";
		carregarDados(nomeArq, filaClientes);

		//solicita a passagem de turno entre os atendimentos
		System.out.println(filaClientes);
		System.out.println("===========================================");
		System.out.println("\t PASSAGEM DE TURNO:");
		System.out.println("1. SIM:");
		System.out.println("2. NAO:");
		System.out.println("===========================================\n");
		System.out.print("Opcao desejada: ");
	
		str = entrada.readLine();
		int op = Integer.parseInt(str);
			
		switch (op)
		{
			case 1: ; break;
			case 2: ; break;
		}

		/*Anotações cruciais para pegar o tempo de atendimento:
		 *tirar da fila e colocar no caixa.
		 *olhar o tempo de espera.
		 *olhar o tempo de atendimento do primeiro cliente da fila.
		 *olhar se os caixas estao cheios e entao dividir.
		*/

	}

}
