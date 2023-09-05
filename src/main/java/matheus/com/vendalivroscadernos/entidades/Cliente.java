package matheus.com.vendalivroscadernos.entidades;

public class Cliente {
    //atributos
    private String nome;
    private String cpf;
    
    //construtor
    public Cliente() {
        this.nome = "Fulano";
        this.cpf = "1234";
    }
    
    //getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", cpf=" + cpf + '\'' +
                '}';
    }
}
