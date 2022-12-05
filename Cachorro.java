public class Cachorro extends Mamifero {// *-- Criação da classe -- *//


    // *-- Criação do construtor da classe -- * //
    public Cachorro(int ID,String nome, String raca, double idade, double peso, double altura) {
        super(nome, raca, idade, peso, altura, ID);
        setNome(nome);
        setRaca(raca);
        setIdade(idade);
        setPeso(peso);
        setAltura(altura);
        setID(ID);
    }


    // *-- Criação do método que ira conter todos os dados do Objeto, utilizando os métodos get -- * //
    public void exibirDados(){
        System.out.format("ID: " + getID() + "\tNome: " + getNome() + "\tRaça: " + getRaca() + "\tPeso: " + getPeso() + "kg" + "\tIdade: "+ getIdade() + " ano(s) "+  "\tAltura: " + getAltura() + " metro(s)");
    }

    // *-- Criação do método que ira conter alguns dos principais dados do Objeto, utilizando os métodos get --* //
    // *-- Aqui, já retornando uma String para não ser necessário utilizar o print --* //
    public String listarDados() {
        return "ID: " + getID() + "\tNome: " + getNome() + "\tRaça: " + getRaca() + "\tIdade: " + getIdade() + " ano(s)";
    }
}
