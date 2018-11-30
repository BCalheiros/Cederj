// Classe que implementa um elemento da lista
class Elemento{
	/** 
	/* 
	/ @param nome		nome do elemento
	/ @param prox		proximo elemento da lista
	**/
	private String nome;
	private Elemento prox;
	
	// Construtor da classe - vazio
	public Elemento(){}
	
	// Métodos getters and setters
	public String getNome(){
		return nome;
	}
	
	public Elemento getProx(){
		return prox;
	}
	
	public void setNome(String n){
		this.nome = n;
	}
	
	public void setProx(Elemento prox){
		this.prox = prox;
	}
}

// Classe que implementa uma lista simplesmente encadeada
class Lista{
	/**
	/*
	/ @param p				ponteiro que aponta para o primeiro elemento da lista (nó cabeça)
	/ @param u				ponteiro que aponta para o último elemento da lista
	/ @param numElementos	numero de elementos da lista
	**/
	Elemento p;
	Elemento u;
	int numElementos;
	
	// Construtor da lista: Lista vazia
	public Lista(){
		this.p = this.u = null;
		numElementos = 0;
	}
	
	// Método para adicionar elementos
	public void add(String nome){
		// Se a lista for vazia
		if (numElementos == 0) {
			// Criando o nó cabeça
			p = new Elemento();
			p.setNome("cabeca");
			// Criando o novo elemento que será adicionado na lista
			Elemento novo = new Elemento();
			novo.setNome(nome);
			novo.setProx(null);
			
			p.setProx(novo);
			u = novo;
			numElementos++;
		}
		// Se a lista não for vazia, adicionando no final
		else{
			// Criando o novo elemento que será adicionado na lista
			Elemento novo = new Elemento();
			novo.setNome(nome);
			novo.setProx(null);
			
			u.setProx(novo);
			u = novo;
			numElementos++;	
		}
	}
}

public class ListaEncadeada{
	public static void main(String[] args){
		System.out.println("OK");
		
		Lista l = new Lista();
		System.out.println(l.numElementos);
		System.out.println(l.p);
		System.out.println(l.u);
		l.add("Bruno");
		System.out.println(l.numElementos);
		System.out.println(l.p.getNome());
		System.out.println(l.u.getNome());
		l.add("Higor");
		System.out.println(l.numElementos);
		System.out.println(l.p.getNome());
		System.out.println(l.u.getNome());
		l.add("Andre");
		System.out.println(l.numElementos);
		System.out.println(l.p.getNome());
		System.out.println(l.u.getNome());
		
	}
	
}