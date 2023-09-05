package matheus.com.vendalivroscadernos.console;

import java.util.Optional;
import matheus.com.vendalivroscadernos.bancodedados.Banco;
import matheus.com.vendalivroscadernos.entidades.Caderno;
import matheus.com.vendalivroscadernos.entidades.Cliente;
import matheus.com.vendalivroscadernos.entidades.Cupom;
import matheus.com.vendalivroscadernos.entidades.Livro;
import matheus.com.vendalivroscadernos.entidades.Pedido;
import matheus.com.vendalivroscadernos.negocio.ClienteNegocio;
import matheus.com.vendalivroscadernos.negocio.PedidoNegocio;
import matheus.com.vendalivroscadernos.negocio.ProdutoNegocio;
import matheus.com.vendalivroscadernos.utilidades.Leitora;

public class Start {

    private static Cliente clienteLogado = null;
    private static Banco banco = new Banco();
    private static ClienteNegocio clienteNegocio = new ClienteNegocio(banco);
    private static PedidoNegocio pedidoNegocio = new PedidoNegocio(banco);
    private static ProdutoNegocio produtoNegocio = new ProdutoNegocio(banco);

    public static void main(String[] args) {
        System.out.println("Bem vindo ao e-Compras");
        String opcao = ""; //inicializa a variavel de opção desejada

        while(true) { //loop para o programa ficar rodando

            if (clienteLogado == null) { //verificando se o cliente esta logado. se nao estiver...
                System.out.println("Digite o cpf: "); //pega o cpf do cliente
                String cpf = "";
                cpf = Leitora.lerDado(); //lê o cpf
                identificarUsuario(cpf); //identifica esse usuario
                
                //lembre-se que por enquanto o único cliente cadastrado possui cpf "1234". mais para frente esse sistema será capaz de comportar mais de um cliente por vez
            }

            //menu que aparece na tela
            System.out.println("Selecione uma opção:");
            System.out.println("1 - Cadastrar Livro");
            System.out.println("2 - Excluir Livro");
            //TODO Desafio: Consultar Livro(nome)
            System.out.println("3 - Cadastrar Caderno");
            System.out.println("4 - Excluir Caderno");
            //TODO Desafio: Consultar Caderno(matéria)
            System.out.println("5 - Fazer pedido");
            System.out.println("6 - Excluir pedido");
            //TODO Desafio: Consultar Pedido(código)
            System.out.println("7 - Listar produtos");
            System.out.println("8 - Listar pedidos");
            System.out.println("9 - Deslogar");
            System.out.println("10 - Sair");

            opcao = Leitora.lerDado();

            switch (opcao) {
                case "1":
                    Livro livro = Leitora.lerLivro();
                    produtoNegocio.salvar(livro); 
                    break;
                case "2":
                    System.out.println("Digite o código do livro: ");
                    String codigoLivro = Leitora.lerDado();
                    produtoNegocio.excluir(codigoLivro); 
                    break;
                case "3":
                    Caderno caderno = Leitora.lerCaderno();
                    produtoNegocio.salvar(caderno);
                    break;
                case "4":
                    System.out.println("Digite o código do caderno: ");
                    String codigoCaderno = Leitora.lerDado();
                    produtoNegocio.excluir(codigoCaderno);
                    break;
                case "5":
                    Pedido pedido = Leitora.lerPedido(banco);
                    Optional<Cupom> cupom = Leitora.lerCupom(banco);
                    if (cupom.isPresent()) {
                        pedidoNegocio.salvar(pedido, cupom.get());
                    } else {
                        pedidoNegocio.salvar(pedido);
                    }
                    break;
                case "6":
                    System.out.println("Digite o código do pedido");
                    String codigoPedido = Leitora.lerDado();
                    pedidoNegocio.excluir(codigoPedido);
                    break;
                case "7":
                    produtoNegocio.listarTodos();
                    break;
                case "8":
                    pedidoNegocio.listarPedidos();
                    break;
                case "9":
                    System.out.println(String.format("Volte sempre %s!", clienteLogado.getNome()));
                    clienteLogado = null;
                    break;
                case "10":
                    System.out.println("Aplicação encerrada.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }

    private static void identificarUsuario(String cpf) { //metodo para procurar o usuario na base de dados
        Optional<Cliente> resultado = clienteNegocio.consultar(cpf);

        if (resultado.isPresent()) {
            Cliente cliente = resultado.get();
            System.out.println(String.format("Olá %s! Você está logado.", cliente.getNome()));
            clienteLogado = cliente;
        } else {
            System.out.println("Usuário não cadastrado.");
            System.exit(0);
        }
    }
}
