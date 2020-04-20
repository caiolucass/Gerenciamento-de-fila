package caixa;

class Fila {
	
	public Elemento primeiro, ultimo;
	
	public Fila() {
		this.primeiro = new Elemento(null);//cria elemento vazio
		this.ultimo = this.primeiro;
	}
	
	public void adicionar(cliente novo) {
		Elemento novoE1 = new Elemento(novo);//cria novo elemento
		this.ultimo.proximo = novoE1; //coloca na primeira posicao e salta para a proxima
		this.ultimo = novoE1;
	}

	public IDados retirar() {
		if(this.primeiro == this.ultimo) {
			return null;
		}		
		Elemento retirada = this.primeiro.proximo;//retira o elemento da primeira posicao
		this.primeiro.proximo = retirada.proximo;
		
		if(retirada == this.ultimo) {
			this.ultimo = this.primeiro;
		}
	     return retirada.dado; //retira o dado da posicao
	}

	//mostra se a fila esta vazia
	public Boolean vazia() {
		return (this.primeiro == this.ultimo);
	}

	//Obtem o número de elementos da fila
	public int numeroElemento() {
		int cont = 1;
		Elemento obter = this.primeiro.proximo;
		if (this.primeiro == this.ultimo)
			cont = 0;

		while (obter != this.ultimo) {
			cont++;
			obter = obter.proximo;
		}
		return cont;
	}

	//divide a fila entre e par e impar
	public Fila dividir(Fila secundaria){
		Fila principal = new Fila();
		Elemento aux = this.primeiro.proximo;
		int cont = 1;

		if(!vazia()){
		   
			while(aux!= null){
			   
				if(cont % 2 == 0){
					secundaria.adicionar((cliente) aux.dado);
				}
				else{
					principal.adicionar((cliente) aux.dado);
				}
				aux = aux.proximo;
				cont++;
			}
		}
		principal.ultimo.proximo = null;
		secundaria.ultimo.proximo = null;
		return principal;
	}

	//obtem o primeiro elemento da fila
	public IDados primeiro() {
		
		if(!vazia()){
			return this.primeiro.proximo.dado;
		}
		else {
			return null;
		}
	}
	 
	//verifica a existencia de dados na fila
	public Boolean ExistenciaDados(Elemento aux){

		 aux = this.primeiro.proximo;

		while(aux!= null){

			if(aux.dado == aux){
				return true;
			}
			else{
				aux = aux.proximo;
			}
		}
		return false;
	}

	//verifica a quantidade de elementos depois do elemento atual
	public int quantidadeFrente(Elemento aux){

		aux = this.primeiro.proximo;
		int cont = 0;

		while(aux != null){
			if(aux.dado == aux){
				return cont;
			}
			else{
				aux = aux.proximo;
				cont++;
			}
		}
		 return cont;
	}

	//localizar um cliente na fila pelo cpf
	public int localizar(Elemento aux, String cpf)
        {
            int cont = 0;
            aux = primeiro.proximo;

            while (aux != null)
            {
                if (aux.dado.getID().equals(cpf))
                {
                    cont = cont + 1;
                    aux = aux.proximo;
                }
                else
                {
                    aux = aux.proximo;
                }
            }
            return cont;
		}
		
	    //copiar dados para uma nova fila
		public Fila copiar()
        {
            Fila nova = new Fila();
            Elemento aux = this.primeiro.proximo;
            while (aux != null)
            {
                nova.adicionar((cliente) aux.dado);
                aux = aux.proximo;
            }
            return nova;
        }

	//converte os dados para string
	@Override
	public String toString()	{
		StringBuilder resposta = new StringBuilder();
		Elemento aux = this.primeiro.proximo;
		while(aux!=null) {
			resposta.append(aux.dado);
			resposta.append("\n");
			aux = aux.proximo;
		}
		return resposta.toString();
	}

}