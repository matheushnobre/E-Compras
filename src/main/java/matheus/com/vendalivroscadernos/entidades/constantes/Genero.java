package matheus.com.vendalivroscadernos.entidades.constantes;

public enum Genero {
    //tipos de gênero
    DRAMA (0.15), SUSPENSE (0.10), ROMANCE (0.05);
    
    //atributos
    private double fator; //será utilizado para cálculos mais a frente
    
    //construtor
    Genero(double fator){
        this.fator = fator;
    }
    
    //getters 
    public double getFator() {
        return fator;
    }
    
}
