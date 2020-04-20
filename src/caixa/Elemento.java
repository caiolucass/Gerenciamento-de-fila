package caixa;

//classe para implementar os elementos contidos dentro da fila

public class Elemento {

	public IDados dado;
	public Elemento proximo;
	
	public Elemento(IDados dado) {
		this.dado = dado;
		this.proximo = null;
	}
}
