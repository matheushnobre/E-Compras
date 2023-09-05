package matheus.com.vendalivroscadernos.utilidades;

//importando classes utilitárias Java
import java.util.Optional;
import java.util.Scanner;

//importando pacotes
import matheus.com.vendalivroscadernos.entidades.Livro;
import matheus.com.vendalivroscadernos.entidades.Pedido;
import matheus.com.vendalivroscadernos.entidades.constantes.Genero;
import matheus.com.vendalivroscadernos.bancodedados.Banco;
import matheus.com.vendalivroscadernos.entidades.Caderno;
import matheus.com.vendalivroscadernos.entidades.Cupom;
import matheus.com.vendalivroscadernos.entidades.Produto;
import matheus.com.vendalivroscadernos.entidades.constantes.Materias;
import matheus.com.vendalivroscadernos.negocio.ProdutoNegocio;

public final class Leitora {
    //atributos
    private static Scanner scanner;
    
    //inicializando o scanner
    static{
        scanner = new Scanner(System.in);
    }
    
    public static String lerDado() {
	String texto = scanner.nextLine(); //lê um texto
	return texto; //retorna o texto lido
    }
    
    public static Livro lerLivro() { //ler os dados do livro a ser cadastrado e retornar os dados desse livro
        System.out.println("Cadastrando livro...");
        Livro livro = new Livro(); //cria um livro, que será retornado ao final do método

        System.out.println("Digite o nome: ");
        String nome = lerDado(); //lê o nome do livro, digitado pelo usuário
        livro.setNome(nome); //modifica o valor do nome do livro criado
                
        System.out.println("Digite o gênero (DRAMA, SUSPENSE, ROMANCE): ");
        String genero = lerDado(); //lê o gênero do livro, digitado pelo usuario
        livro.setGenero(Genero.valueOf(genero.toUpperCase())); //adiciona um valor ao atributo gênero do livro criado

        System.out.println("Digite o preço(padrão 0.0): ");
        String preco = lerDado(); //lê o preço do livro
        livro.setPreço(Double.parseDouble(preco)); //modifica o valor do preço 

        return livro; //retorna o livro lido
    }
    
    public static Caderno lerCaderno(){
        System.out.println("Cadastrando caderno...");
        Caderno caderno = new Caderno(); //cria um caderno, que será retornado ao final do método
        
        System.out.println("Digite o número de matérias (M2, M5, M10): ");
        String materias = lerDado(); //lê o número  de matérias do caderno
        caderno.setMaterias(Materias.valueOf(materias.toUpperCase())); //modifica o valor de materias do caderno criado
        
        System.out.println("Digite o preço(padrão 0.0): ");
        String preço = lerDado(); //lê o preço
        caderno.setPreço(Double.parseDouble(preço)); //atribui um valor ao preço
        
        return caderno;
    }
    
    public static Pedido lerPedido(Banco banco){ //ler os dados do pedido e retornar um objeto a partir deste
        ProdutoNegocio produtoNegocio = new ProdutoNegocio(banco);
        
        System.out.println("Cadastrando pedido...");
        Pedido pedido = new Pedido(); //cria o pedido que será retornado
        
        String opção = "s";
        do{
            System.out.println("Digite o código do produto (livro/caderno): ");
            String codigo = lerDado(); //lê o codigo digitado
            
            Optional<Produto> resultado = produtoNegocio.consultar(codigo); //consulta o produto
            if(resultado.isPresent()){ //se existir um produto com o codigo digitado...
                Produto produto = resultado.get(); //pega o produto
                
                System.out.println("Digite a quantidade: ");
                String quantidade = lerDado(); //lê a quantidade
                produto.setQuantidade(Integer.parseInt(quantidade)); //altera o valor da quantidade
                
                pedido.getProdutos().add(produto); //adiciona ao pedido
            } else{
                System.out.println("Produto inexistente. Escolha um produto válido.");
            }
            System.out.println("Deseja selecionar mais um produto? (Digite 's' para sim e 'n' para não): ");
            opção = lerDado(); //lê a opção desejada
        } while (opção.equalsIgnoreCase("s")); //esse trecho só roda enquanto a opção selecionada pelo usuário for igual a 's'
        
        return pedido;
    }
    
    public static Optional<Cupom> lerCupom (Banco banco){ //ler os dados do cupom e retornar um objeto a partir destes
        System.out.println("Caso queira utilizar algum cupom escolha entre: CUPOM2, CUPOM5, CUPOM7. Se não desejar, deixe em branco.");
        
        String desconto = lerDado(); //pega o cupom digitado
        
        for(Cupom cupom : banco.getCupons()){ //pega os cupons do banco de dados
            if(cupom.getCodigo().equalsIgnoreCase(desconto)){ //analisa se o cupom digitado é igual ao cupom do banco
                return Optional.of(cupom); //se for, o retorno será esse cupom
            } 
        }
        return Optional.empty();
    }
}
