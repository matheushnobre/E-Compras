package matheus.com.vendalivroscadernos.entidades;

//importando classes utilitárias
import java.util.ArrayList;

public class Pedido {
    //atributos
    private String codigo;
    private Cliente cliente;
    private ArrayList produtos;
    private double total;

    //construtor
    public Pedido() {
        this.produtos = new ArrayList();
    }

    //getters e setters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList produtos) {
        this.produtos = produtos;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    private String getProdutosComprados() { //pegar os produtos comprados em forma de string
        StringBuilder produtosComprados = new StringBuilder();
        produtosComprados.append("");
        
        for(int i=0; i<getProdutos().size(); i++){ //percorre todos os produtos pedidos
            Produto produto = (Produto) getProdutos().get(i);
            produtosComprados.append(produto.toString());
            produtosComprados.append("Qtd: ");
            produtosComprados.append(produto.getQuantidade());
            produtosComprados.append(" ");
        }
        produtosComprados.append("]");
        return produtosComprados.toString();
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "codigo='" + codigo + '\'' +
                ", cliente=" + cliente + '\'' +
                ", produtos='" + getProdutosComprados() + '\'' +
                ", total='" + total + '\'' +
                '}';
    }
    

    
}
