package matheus.com.vendalivroscadernos.negocio;

import java.util.Optional;

import matheus.com.vendalivroscadernos.bancodedados.Banco;
import matheus.com.vendalivroscadernos.entidades.Produto;

public class ProdutoNegocio {
    private Banco bancoDeDados;
    
    public ProdutoNegocio(Banco banco) {
        this.bancoDeDados = banco;
    }
    
    public void salvar(Produto novoProduto) { //salva um novo produto na loja
        String codigo = "PR%04d"; //inicializa um valor pro codigo
        codigo = String.format(codigo, bancoDeDados.getProdutos().length); //formata o codigo: "PR504D + o tamanho do array". 1º produto será PR504d1, o segundo PR504d2 e assim por diante...
        novoProduto.setCodigo(codigo); //altera o valor do codigo do produto

        boolean produtoRepetido = false; 
        for (Produto produto: bancoDeDados.getProdutos()) { //percorrendo os produtos cadastrados
            if (produto.getCodigo().equals(novoProduto.getCodigo())) { //verificando se é um produto repetido
                produtoRepetido = true; 
                System.out.println("Produto já cadastrado.");
                break;
            }
        }

        if (produtoRepetido != true) { //se o produto nao for repetido
            this.bancoDeDados.adicionarProduto(novoProduto); //adiciona o produto ao banco de dados
            System.out.println("Produto cadastrado com sucesso.");
        }
    }
    
    public void excluir(String codigo) { //excluir produto
        for(int i=0; i<bancoDeDados.getProdutos().length; i++){
            Produto produto = (Produto) bancoDeDados.getProdutos()[i];
            if(produto.getCodigo().equals(codigo)){
                bancoDeDados.removerProduto(i);
                System.out.println("Produto removido");
                break;
            }
        }
    }
    
    public Optional<Produto> consultar(String codigo) { //obtém um produto a partir de seu codigo
        for (Produto produto: bancoDeDados.getProdutos()) {
            if (produto.getCodigo().equalsIgnoreCase(codigo)) {
                return  Optional.of(produto);
            }
            else{
                
            }
        }
        return Optional.empty();
    }
    
    public void listarTodos() { //lista os produtos cadastrados
        if (bancoDeDados.getProdutos().length == 0) { //verifica se existem produtos cadastrados
            System.out.println("Não existem produtos cadastrados");
        } else {
            for (Produto produto: bancoDeDados.getProdutos()) {
                System.out.println(produto.toString());
            }
        }
    }
}
