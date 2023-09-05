package matheus.com.vendalivroscadernos.entidades;

//importando pacotes
import matheus.com.vendalivroscadernos.entidades.constantes.Materias;

public class Caderno extends Produto {
    //atributos
    private Materias materias;
    
    //construtor
    public Caderno() {

    }
    
    //getters e setters
    public Materias getMaterias() {
        return materias;
    }

    public void setMaterias(Materias materias) {
        this.materias = materias;
    }
    
    //demais métodos
    @Override
    public double calcularFrete() {
        return preço * quantidade + materias.getFator(); //retorna o frete considerando o fator aditivo 
    }
    
        @Override
    public String toString() {
        return "Caderno{" +
                "materias='" + materias + '\'' +
                ", codigo='" + codigo + '\'' +
                ", preço='" + preço + '\'' +
                '}';
    }
}
