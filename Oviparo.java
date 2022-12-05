public class Oviparo extends Animal{

    private String tipo;
    private String corOvos;

    //*-- Construtor do objeto da classe --*//
    public Oviparo( String nome, String tipo, double idade, double peso, double altura, int ID) {
        super(nome, tipo, idade, peso, altura, ID);
        setNome(nome);
        setIdade(idade);
        setAltura(altura);
        setTipo(tipo);
        setID(ID);
    }

    //*-- Gets e sets --*//
    public String getTipo(){
        return tipo;
    }

    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    public String getCorOvos(){
        return corOvos;
    }

    public void setCorOvos(String corOvos){
        this.corOvos = corOvos;
    }
}
