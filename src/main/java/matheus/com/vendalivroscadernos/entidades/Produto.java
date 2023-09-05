package matheus.com.vendalivroscadernos.entidades;

public abstract class Produto {
    //atributos
    protected double preço;
    protected String codigo;
    protected int quantidade;

    //construtor
    public Produto() {

    }

    //getters e setters
    public double getPreço() {
        return preço;
    }

    public void setPreço(double preço) {
        this.preço = preço;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    public abstract double calcularFrete();
    
}
