package matheus.com.vendalivroscadernos.entidades;

//importando pacotes necessarios
import matheus.com.vendalivroscadernos.entidades.constantes.Genero;

public class Livro extends Produto {
    //atributos
    private String nome;
    private Genero genero;
    
    //construtor

    public Livro() {
        
    }
    
    //getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }
    
    //demais métodos
    @Override
    public double calcularFrete() {
        return preço * quantidade * genero.getFator();  //retorna o valor do frete considerando as constantes
    }

    @Override
    public String toString() {
        return "Livro{" +
                "nome='" + nome + '\'' +
                ", genero=" + genero + '\'' +
                ", codigo='" + codigo + '\'' +
                ", preço='" + preço + '\'' +
                '}';
    }

}
