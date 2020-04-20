package caixa;

//classe cliente implementa IDados, paa criar o ID dos clientes
public class cliente implements IDados {

	private String cpf;
	private String nome;
	private int atendimento;
	private int intervalo;
	
	public cliente(String cpf, String nome, int atendimento, int intervalo) throws IllegalArgumentException {
	 
		if(cpf.length() < 11 ||!cpf.contains(".") || !cpf.contains("-"))
			throw new IllegalArgumentException ("CPF inválido.");
		else this.cpf = cpf;
		
		if(nome.length() < 5 ||!nome.contains(" "))
        throw new IllegalArgumentException("Nome inválido.");
		else this.nome = nome;		
	}
	
	public cliente() {
	}

	public String getCpf() {
		return cpf;
	}
	
	public String getNome() {
		return nome;
	}
	
	public int getAtendimento() {
		return atendimento;
	}
	
	public void setAtendimento(int atendimento) {
		if((atendimento >= 1) ||(atendimento <= 30)) {
			this.atendimento = atendimento;
		}
		else this.atendimento = 0;
	}
	
	public int intervalo() {
		return intervalo;
	}
	
	public void setIntervalo(int intervalo) {
		if((intervalo >= 0) || (intervalo <= 10)) {
			this.intervalo = intervalo;
		}
		else this.intervalo = 0;
	}
	
	//verificar se existem clientes com o mesmo nome
	@Override
	public int compareTo(IDados o) {
	 cliente aux = (cliente)o;
	 return (aux.nome.compareTo(this.nome));
	}
	
	@Override
	public boolean equals(Object obj) {
		cliente aux = (cliente)obj;
		return(aux.cpf == this.cpf);
	}
	
	//converter para string
	@Override
	public String toString() {
		return "CPF:"+this.cpf + " -Nome: "+this.nome+" -Atendimento: "+this.atendimento+" -Intervalo: "+this.intervalo;
	}
	
	//implementar um "verificador" de posicao atraves do cpf
	@Override 
	public String getID() {
		return this.cpf;
	}
}


