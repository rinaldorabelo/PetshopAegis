public class Mamifero extends Animal {// *-- Criação da classe -- *//

    // *-- Criação dos atributos da classe --* //
    private String corPelo;
    private String alimento;

    // *-- Criação do construtor da classe -- * //
    public Mamifero(String nome, String raca, double idade, double peso, double altura, int ID) {
        super(nome, raca, idade, peso, altura, ID);
        setNome(nome);
        
        setIdade(idade);
        
        setAltura(altura);

        setID(ID);
    }

    // *-- Criação dos métodos getters e setters --* //
    public String getCorPelo(){
        return corPelo;
    }

    public void setCorPelo(String corPelo) {
        this.corPelo = corPelo;
    }

    public String getAlimento() {
        return alimento;
    }

    public void setAlimento(String alimento) {
        this.alimento = alimento;
    }

}
