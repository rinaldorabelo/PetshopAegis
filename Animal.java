
public abstract class Animal { // *-- Criação da classe -- *//

    // *-- Criação dos atributos da classe mãe --* //
    private String nome;
    private String raca;
    private double idade;
    private double peso;
    private double altura;

   // *-- Criação do construtor da classe -- * //
    public Animal(String nome, String raca, double idade, double peso, double altura) {
      
    }

    // *-- Criação dos métodos getters e setters --* //
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getIdade() {
        return idade;
    }

    public void setIdade(double idade) {
        this.idade = idade;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
}
