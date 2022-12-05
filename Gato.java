public class Gato extends Mamifero {

    private String pelagem;
    
    //*-- Construtor do objeto da classe --*//
    public Gato(int ID,String nome, String raca, double idade, double peso, double altura, String pelagem) {
        super(nome, raca, idade, peso, altura, ID);
        setNome(nome);
        setRaca(raca);
        setIdade(idade);
        setPeso(peso);
        setAltura(altura);
        setPelagem(pelagem);
        setID(ID);
    }
    // *-- Criação do método que ira conter todos os dados do Objeto, utilizando os métodos get -- * //

    //*-- Gets e sets --*//
    public String getPelagem(){
        return pelagem;
    }

    public void setPelagem(String pelagem) {
        this.pelagem = pelagem;
    }

    public void exibirDados() {
        System.out.format("ID: " + getID() + "\tNome: " + getNome() + "\tRaça: " + getRaca() + "\tPeso: " + getPeso() + "kg" + "\tIdade: "
                            + getIdade() + " ano(s) "+  "\tAltura: " + getAltura() + " metro(s) " + "\tPelagem: " + getPelagem());
    }

    // *-- Criação do método que ira conter alguns dos principais dados do Objeto, utilizando os métodos get --* //
    // *-- Aqui, já retornando uma String para não ser necessário utilizar o print --* //
    public String listarDados() {
        return "ID: " + getID() + "\tNome: " + getNome() + "\tRaça: " + getRaca() + "\tIdade: " + getIdade() + " ano(s)";
    }
}
