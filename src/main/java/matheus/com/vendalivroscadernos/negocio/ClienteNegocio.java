package matheus.com.vendalivroscadernos.negocio;

import java.util.Optional;

//importando pacotes
import matheus.com.vendalivroscadernos.bancodedados.Banco;
import matheus.com.vendalivroscadernos.entidades.Cliente;

public class ClienteNegocio {
    //atributos
    private Banco bancoDeDados;
    
    //construtor
    public ClienteNegocio(Banco bancoDeDados) {
        this.bancoDeDados = bancoDeDados;
    }
    
    public Optional<Cliente> consultar(String cpf){ //consulta o cliente e retorna o cliente que tiver o cpf passado como parâmetro
        if(bancoDeDados.getCliente().getCpf().equals(cpf)){
            return Optional.of(bancoDeDados.getCliente());
        } else{
            return Optional.empty();
        }
    }
    
}
