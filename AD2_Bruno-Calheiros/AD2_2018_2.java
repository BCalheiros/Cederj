/** AD2 - POO - Cederj - 02/2018
**  @Aluno Bruno Calheiros
**/

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;

// Classe que representa um vértice de um Grafo
class Node{
	// Atributos
	private String nome;
	public ArrayList<Edge> conexoes = new ArrayList<Edge>();
	
	// Construtor da classe	
	//public Node(String nome){
	//	this.nome = nome;
	//}
	
	// Métodos
	public String toString(){
		return this.nome;
	}
	
	public void setNome(String nome){
		this.nome = nome;
	}
	
	public void addConexao(Node v1, Node v2){
		Edge aresta = new Edge(v1, v2);
		this.conexoes.add(aresta);
	}
	
	public ArrayList<Edge> getConexoes(){
			return conexoes;
	}
}
	
// Classe que representa uma aresta de um Grafo
class Edge{
	// Atributos
	private Node start;
	private Node end;
	
	// Construtor da classe
	public Edge(Node v1, Node v2){
		this.start = v1;
		this.end = v2;
	}
}

// Classe que representa um Grafo
class Grafo{
	//Atributos
	private ArrayList<Node> vertices = new ArrayList<Node>();
	
	// Métodos
	public int getTotalNodes(){
		return this.vertices.size();
	}
	
	public void addNode(Node n){
		this.vertices.add(n);
	}
}

// Classe Usuario que herda a classe Node
class Usuario extends Node{
	// Atributos exclusivos da classe Usuario
	private int idade;
	public ArrayList<Usuario> seguidores = new ArrayList<Usuario>();
	private ArrayList<Usuario> seguidos = new ArrayList<Usuario>();
	
	// Construtor da classe
	public Usuario(String nome, int idade){
		this.setNome(nome);
		this.idade = idade;
	}
	
	// Métodos
	public String getNome(){
		return this.toString();
	}
	
	public void addSeguidores(Usuario user){
		this.seguidores.add(user);
	}
		
	public ArrayList<Usuario> getSeguidores(){
		return this.seguidores;
	}
	
	public ArrayList<Usuario> getSeguido(){
		return this.seguidos;
	}
	
	public int getTotalSeguidosMaisVelhos(){
		// Retorna o numero de pessoas seguidas que são mais velhas do que a própria
		//TO DO
		return 0;
	}
}

// Classe TGrafo que herda da classe Grafo e representa a rede social 
class TGrafo extends Grafo{
	// Atributos exclusivos da classe TGrafo
	private Usuario maisPopular;
	private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
			
	// Métodos
	
	// Método que retorna o usuário de nome name
	public Usuario getUser(String name){
		Usuario n = null;
		
		for (Usuario u : usuarios){
			if(name.equals(u.toString())){
				n = u;
			}
		}
		return n;
	}
	
	// Método que retorna o total de usuarios da rede
	public int getTotalUsers(){
		return this.usuarios.size();
	}
	
	// Método que adiciona usuario na rede
	public void addUser(Usuario u){
		this.usuarios.add(u);
	}
	
	// Método que retorna o numero de seguidores de um usuario
	public int  numeroSeguidores(String nome){
        return this.getUser(nome).seguidores.size();
    }
	
	// Método que retorna os seguidores de um usuario
	public void getSeguidores(String nome){
        ArrayList<Usuario> seg = this.getUser(nome.toLowerCase()).seguidores;

        for(Usuario u : seg){
            System.out.println(u.getNome());
        }
    }
	
	// Método retorna o usuario mais popular da rede
	public String getMaisPopular(){
		maisPopular = null;
		
		for (int i=0; i < this.usuarios.size(); i++){
			if(i == 0){
				maisPopular = this.usuarios.get(i);
			}
			else {
				if (maisPopular.seguidores.size() < this.usuarios.get(i).seguidores.size()){
					maisPopular = this.usuarios.get(i);
				}
			}
		}
		return maisPopular.getNome();
	}
}

// Classe para resolução da AD2
class SolucaoAD2{
	
	// Questão 1: Quantas pessoas uma determinada pessoa segue?
	public static int  numero_seguidores (TGrafo g, String nome){
        return g.numeroSeguidores(nome);
    }

	// Questão 2: Quem são os seguidores de uma determinada pessoa?
    public static void seguidores (TGrafo g, String nome){
        g.getSeguidores(nome);
    }

	// Questão 3: Quem é a pessoa mais popular?
    public static String mais_popular (TGrafo g){
        return g.getMaisPopular();
    }
	
	// Questão 4: Quais são as pessoas que só seguem pessoas mais velhas do que ela própria?
    public static void seegue_mais_velho(TGrafo g){
		// To-DO
		System.out.println("Método a implementar");
    }
}
	
// Classe principal - Main
public class AD2_2018_2{
	public static void main(String[] args){
		/* Testando...
		// Criando instancia de um Usuario
		// Aqui foi testado a criação dos usuarios
		Usuario joao = new Usuario("Joao", 25);
		Usuario ana = new Usuario("Ana", 23);
		Usuario caio = new Usuario("Caio", 20);
		Usuario pedro = new Usuario("Pedro", 20);
		//System.out.println(joao.getNome());
		// Testando a criação da rede social
		joao.addConexao(joao, ana);
		joao.addConexao(joao, pedro);
		joao.addConexao(joao, caio);
		caio.addConexao(caio, pedro);
		// Adicionando seguidores
		joao.addSeguidores(ana);
		ana.addSeguidores(joao);
		pedro.addSeguidores(joao);
		caio.addSeguidores(joao);
		caio.addSeguidores(pedro);
		// Criando a rede
		TGrafo instagram = new TGrafo();
		
		instagram.addUser(joao);
		//System.out.println(instagram.getUser("Joao"));
		instagram.addUser(ana);
		//System.out.println(instagram.getUser("Ana"));
		instagram.addUser(caio);
		//System.out.println(instagram.getUser("Caio"));
		instagram.addUser(pedro);
		//System.out.println(instagram.getUser("Pedro"));
		//System.out.println(instagram.getTotalUsers());
		// Testando os métodos da classe TGrafo
		//System.out.println("Total de usuarios: " + instagram.getTotalUsers());
		//System.out.println("Mais popular: " + instagram.getMaisPopular());
		*/
		
		
		// 
		//String home;
        //home = System.getProperty("user.home");
        //File fileName = new java.io.File(home + "\AD2_Bruno-Calheiros");
	    String line = null;
	    TGrafo instagram = new TGrafo();


	    try{
            FileReader filereader = new FileReader(args[0]);
            BufferedReader bufferedReader = new BufferedReader(filereader);
			Usuario user;
			
            while ((line = bufferedReader.readLine()) !=  null){
                String[] data = line.split("\\s");
                char number  = data[1].charAt(0);

                if(Character.isDigit(number) && data != null){
                    user = new Usuario(data[0].toLowerCase(), Integer.parseInt(data[1]));
                    instagram.addUser(user);

                } else{
                    instagram.getUser(data[0]).addConexao(instagram.getUser(data[0]), 
															instagram.getUser(data[1]));
					instagram.getUser(data[1]).addSeguidores(instagram.getUser(data[0]));
                }
            }


            bufferedReader.close();
        }
        catch(FileNotFoundException fl){
	        System.out.println("Não foi possivel abrir o arquivo ");
        }
        catch(IOException ex){
            System.out.println("Error ao ler o arquivo ");
        }
		
		
		
        // Resposta para pergunta 1
        System.out.println("O numero de seguidores é: ");
        System.out.println(SolucaoAD2.numero_seguidores(instagram, "Pedro"));

        // Resposta para pergunta 2
        System.out.println("Os seguidores desse user são: ");
        SolucaoAD2.seguidores(instagram, "Renata");

        // Resposta para pergunta 3
        System.out.println("Pessoa mais popular é: ");
        System.out.println(SolucaoAD2.mais_popular(instagram));
		
	}
}