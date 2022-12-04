public class Passaro extends Oviparo{

    private String corPenas;
    private String especie;


    //*-- Construtor do objeto da classe --*//
    public Passaro(String nome, String tipo, String especie, double idade, double peso, double altura, String corPenas, String corOvos) {
        super(nome, tipo, idade, peso, altura);
        setNome(nome);
        setRaca(tipo);
        setIdade(idade);
        setPeso(peso);
        setAltura(altura);
        setCorOvos(corOvos);
        setCorPenas(corPenas);
        setEspecie(especie);
        setTipo(tipo);
        
    }
        // *-- Criação do método que ira conter todos os dados do Objeto, utilizando os métodos get -- * //

        

        public void exibirDados() {
            System.out.format("Nome: " + getNome() + "\tCor das Penas: " + getCorPenas() + "\tPeso: " + getPeso() + "kg" + "\tIdade: "+ getIdade() + " ano(s) "
            +  "\tAltura: " + getAltura() + " metro(s) " + "\tCor dos Ovos: " + getCorOvos() + "\tTipo: " + getTipo() + "\tEspécie: " + getEspecie());
        }
    
        // *-- Criação do método que ira conter alguns dos principais dados do Objeto, utilizando os métodos get --* //
        // *-- Aqui, já retornando uma String para não ser necessário utilizar o print --* //
        public String listarDados() {
            return "Nome: " + getNome() + "\tCor das Penas: " + getCorPenas() + "\tIdade: " + getIdade() + " ano(s)" + "\tEspécie: " + getEspecie();
        }

        //*-- Gets e sets --*//
        public String getCorPenas(){
            return corPenas;
        }
    
        public void setCorPenas(String corPenas){
            this.corPenas = corPenas;
        }

        public void setEspecie(String especie) {
            this.especie = especie;
        }

        public String getEspecie(){
            return especie;
        }
}
