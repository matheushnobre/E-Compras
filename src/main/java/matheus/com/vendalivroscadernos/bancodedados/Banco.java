package matheus.com.vendalivroscadernos.bancodedados;

import java.util.ArrayList;
import java.util.List;

import matheus.com.vendalivroscadernos.entidades.Cliente;
import matheus.com.vendalivroscadernos.entidades.Cupom;
import matheus.com.vendalivroscadernos.entidades.Pedido;
import matheus.com.vendalivroscadernos.entidades.Produto;

public class Banco {
    //atributos
    private List<Produto> produtos;
    private List<Pedido> pedidos;
    private List<Cupom> cupons;
    private Cliente cliente;

    //construtor
    public Banco() {
        this.produtos = new ArrayList<>();
        this.pedidos = new ArrayList<>();
        this.cliente = new Cliente();
        this.cupons = new ArrayList<>();
        cupons.add(new Cupom("CUPOM2", 2)); //cupom de desconto 2 reais
        cupons.add(new Cupom("CUPOM5", 5)); //cupom de desconto 5 reais
        cupons.add(new Cupom("CUPOM7", 7)); //cupom de desconto 7 reais
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cupom[] getCupons() {
        return cupons.toArray(new Cupom[cupons.size()]);
    }

    public Pedido[] getPedidos() {
        return pedidos.toArray(new Pedido[pedidos.size()]);
    }

    public Produto[] getProdutos() {
        return produtos.toArray(new Produto[produtos.size()]);
    }

    public void adicionarProduto(Produto produto) { //adiciona um produto ao banco
        produtos.add(produto);
    }

    public void removerProduto(int posicao) { //remove um produto do banco
        produtos.remove(posicao);
    }

    public void adicionarPedido(Pedido pedido) { //adiciona um pedido ao banco
        pedidos.add(pedido);
    }

    public void removerPedido(int posicao) { //remove um pedido do banco
        pedidos.remove(posicao);
    }
}

