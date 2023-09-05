package matheus.com.vendalivroscadernos.negocio;

//classes utilitarias
import java.time.LocalDate;
import java.util.List;

//pacotes
import matheus.com.vendalivroscadernos.bancodedados.Banco;
import matheus.com.vendalivroscadernos.entidades.Cupom;
import matheus.com.vendalivroscadernos.entidades.Pedido;
import matheus.com.vendalivroscadernos.entidades.Produto;

public class PedidoNegocio {
    //atributo
    private Banco bancoDeDados;
    
    //construtor
    public PedidoNegocio(Banco bancoDeDados) {
        this.bancoDeDados = bancoDeDados;
    }
    
    private double calcularTotal(List<Produto> produtos, Cupom cupom){ //retorna o preço total do pedido
        double total = 0.0;
        for (Produto produto : produtos){ //percorre o array de produtos
            total += produto.getPreço() * produto.getQuantidade() + produto.calcularFrete(); 
        }
        
        if(cupom != null){ //verifica se possui um cupom
            return total - cupom.getDesconto(); //calcula o preço com o desconto
        } else{
            return total; //retorna o preço total
        }
    }
    
    public void salvar (Pedido novoPedido){ //salva um pedido sem cupom de desconto
        salvar(novoPedido, null);
    }
    
    public void salvar (Pedido novoPedido, Cupom cupomDesconto){ //salva um novo pedido com cupom de desconto
        String codigo = "PE%4d%2d%04d"; //insere o codigo
        LocalDate hoje = LocalDate.now(); //pega a data
        codigo = String.format(codigo, hoje.getYear(), hoje.getMonthValue(), bancoDeDados.getPedidos().length); //formata o codigo

        novoPedido.setCodigo(codigo); 
        novoPedido.setCliente(bancoDeDados.getCliente());
        novoPedido.setTotal(calcularTotal(novoPedido.getProdutos(), cupomDesconto));
        bancoDeDados.adicionarPedido(novoPedido);
        System.out.println("Pedido cadastrado com sucesso.");
    }
    
    public void excluir(String codigo){ //exclui um pedido a partir de seu codigo de rastreio
        int pedidoExclusao = -1;
        for(int i =0; i<bancoDeDados.getPedidos().length; i++){ //percorre os pedidos do banco de dados
            
            Pedido pedido = bancoDeDados.getPedidos()[i]; //pega um pedido no array para analisar
            if(pedido.getCodigo().equals(codigo)){ //se os codigos forem iguais
                pedidoExclusao = i; //o pedido a ser excluido é esse
                break;
            }   
        }
        
        if (pedidoExclusao != -1) { //se encontrarmos o pedido, o valor dessa variavel sera diferente de -1
            bancoDeDados.removerPedido(pedidoExclusao); //remove-se o pedido
            System.out.println("Pedido excluído com sucesso."); //imprime na tela
       } else {
             System.out.println("Pedido inexistente."); //imprime na tela
            }
    }

    public void listarPedidos(){ //lista todos os pedidos realizados
        if(bancoDeDados.getPedidos().length == 0){
            System.out.println("Não existem pedidos cadastrados");
        }
        else{
            for(Pedido pedido : bancoDeDados.getPedidos()){
                System.out.println(pedido.toString());
            }
        }
    }
}
