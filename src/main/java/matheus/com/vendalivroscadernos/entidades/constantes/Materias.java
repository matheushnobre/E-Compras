package matheus.com.vendalivroscadernos.entidades.constantes;

public enum Materias {
    //materias
    M2(2), M5(5), M10(10);
    
    //atributo
    int fator;
    
    //construtor
    Materias(int fator){
        this.fator = fator;
    }
    
    //get
    public int getFator() {
        return fator;
    }
    
}
