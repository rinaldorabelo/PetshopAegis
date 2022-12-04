import java.util.InputMismatchException;

public class CachorroHandler {

    private static final Principal p = new Principal();

    public void cadastroCachorro() {
        // *-- Função para cadastrar um novo animal dentro do ArrayList --* //
        // *-- Utiliza funções genéricas com o prefixo "input" para receber as respostas
        // do usuário --*//
        System.out.println("Iremos agora cadastrar um novo Cachorro!!");
        String nome = p.inputNome();
        String raca = p.inputRaca();
        double idade = p.inputIdade();
        double peso = p.inputPeso();
        double altura = p.inputAltura();
        Principal.cachorroArray.add(new Cachorro(nome, raca, idade, peso, altura));
        System.out.println("Cachorro cadastrado com sucesso!!");
    }

    public void editarCachorro() {
        // *-- Função responsável por editar um registro no sistema. Depois de encontrar
        // o registro
        // ela entra em loop e permanece até o usuário sair. Usa switch case para
        // decidir o que editar.
        // ao editar usa as funções genéricas inputAlgumaCoisa() e os setAlgumaCoisa()
        // da própria classe
        // para editar o registro do animal. Como duplicidades podem ocorrer, ele
        // mostrará todos os registros
        // de forma sequencial para o usuário editar. Cabe ao usuário decidir quais
        // editar conforme aparecem.--*//
        // *-- Utiliza um while que impede que a String inserida seja nula, vazia e/ou
        // não tenha caracteres.--*//
        boolean isInput = true;
        String nome = "teste";
        String nomeCorrigido;
        boolean localizado = false;
        while (isInput) {
            System.out.println("Digite o nome do cachorro que deseja editar: ");
            nome = p.superScanner.nextLine();
            if (nome == null || nome.length() == 0 || nome.isEmpty()) {
                System.out.println("Erro! Tente novamente");
            } else {
                isInput = false;
            }
        }
        nomeCorrigido = p.formatador(nome);
        for (Cachorro cachorro : Principal.cachorroArray) {
            if (nomeCorrigido.contains(cachorro.getNome())) {
                int rotinaEditarCachorro = -1;
                while (rotinaEditarCachorro != 99) {
                    cachorro.exibirDados();
                    System.out.println("\nDigite o dado que deseja editar: ");
                    System.out.println("1. Nome\n2. Raça\n3. Peso\n4. Idade\n5. Altura");
                    System.out.println("Digite [99] para sair desse cadastro");
                    int operador = -1;
                    try {
                        operador = p.superScanner.nextInt();
                        p.superScanner.nextLine();
                    } catch (InputMismatchException e) {
                        p.superScanner.next();
                        System.out.println();
                    } catch (Exception e) {
                        p.superScanner.next();
                        System.out.println();
                    }
                    switch (operador) {
                        case 1:
                            String newNome = p.inputNome();
                            cachorro.setNome(newNome);
                            break;
                        case 2:
                            String newRaca = p.inputRaca();
                            cachorro.setRaca(newRaca);
                            break;
                        case 3:
                            double newPeso = p.inputPeso();
                            cachorro.setPeso(newPeso);
                            break;
                        case 4:
                            double newIdade = p.inputIdade();
                            cachorro.setIdade(newIdade);
                            break;
                        case 5:
                            double newAltura = p.inputAltura();
                            cachorro.setAltura(newAltura);
                            break;
                        case 99:
                            System.out.println("Encerrando subrotina.");
                            rotinaEditarCachorro = 99;
                            break;
                        default:
                            System.out.println("Erro!! Tente novamente");
                    }
                }
                localizado = true;
            }
        }
        if (localizado == false) {
            System.out.println("Nome não localizado!!");
        }
    }

    public void apagarCachorro() {
        // *-- Função que apaga registros do arraylist com base no nome inserido. Todo
        // nome
        // é tratado pela função formatador() para que esteja formatado. Utiliza um
        // while
        // que impede que a String inserida seja nula, vazia e/ou não tenha caracteres.
        // Caso o registro seja encontrado, o usuário verá as informações do cadastro e
        // é perguntado se ele realmente quer apagar o cadastro. Utiliza a função
        // getIndex()
        // para encontrar o index do registro com base no nome registro. Como podem
        // ocorrer duplicidades
        // no sistema, o código irá mostrar todos os registros encontrados, e o usuário
        // precisa
        // decidir se deseja apaga-los também.--*//
        // *-- Utiliza um while que impede que a String inserida seja nula, vazia e/ou
        // não tenha caracteres.--*//
        boolean isInput = true;
        String nome = "teste";
        String nomeCorrigido;
        boolean localizado = false;
        while (isInput) {
            System.out.println("Digite o nome do cachorro que deseja apagar: ");
            nome = p.superScanner.nextLine();
            if (nome == null || nome.length() == 0 || nome.isEmpty()) {
                System.out.println("Erro! Tente novamente");
            } else {
                isInput = false;
            }
        }
        nomeCorrigido = p.formatador(nome);
        int removedor = -2;
        for (Cachorro cachorro : Principal.cachorroArray) {
            if (nomeCorrigido.contains(cachorro.getNome())) {
                removedor = p.getIndex(nomeCorrigido, "Cachorro");
                cachorro.exibirDados();
                localizado = true;
            }
        }
        if (localizado == true) {
            System.out.println("\nDeseja mesmo apagar esse cadastro?");
            System.out.println("1. Sim\n2. Não");
            int escolha = p.superScanner.nextInt();
            p.superScanner.nextLine();
            if (escolha == 1) {
                Principal.cachorroArray.remove(removedor);
                System.out.println("Cadastro removido com sucesso.");
            } else {
                System.out.print("Cadastro mantido.");
            }
        } else {
            System.out.println("Nome não localizado!!");
        }
    }

    public void exibirDadosCachorro() {
        // *-- Função para percorrer o ArrayList utilizando foreach, e chamada do método
        // "exibirDados" para listar todos dados dos animais --* //
        for (Cachorro cachorro : Principal.cachorroArray) {
            cachorro.exibirDados();
            System.out.println();
        }
    }

    public void listarDadosCachorro() {
        // *-- Função para percorrer o ArrayList utilizando foreach, e chamada método
        // "listarDados" para listar 3 dos principais dados dos animais --* //
        for (Cachorro cachorro : Principal.cachorroArray) {
            System.out.println(cachorro.listarDados());
        }
    }

    public void buscarNomeCachorro() {
        boolean isInput = true;
        String nome = "teste";
        while (isInput) {
            System.out.println("Digite o nome do cachorro que deseja buscar: ");
            nome = p.superScanner.nextLine();
            if (nome == null || nome.length() == 0 || nome.isEmpty()) {
                System.out.println("Erro! Tente novamente");
            } else {
                isInput = false;
            }
        }
        String nomeCorrigido = p.formatador(nome);
        boolean localizado = false;
        for (Cachorro cachorro : Principal.cachorroArray) {
            if (nomeCorrigido.contains(cachorro.getNome())) {
                cachorro.exibirDados();
                System.out.println();
                localizado = true;
            }
        }
        if (localizado == false) {
            System.out.println("Nome não localizado!!");
        }
    }

    public void buscarRacaCachorro() {
        boolean isInput = true;
        String raca = "teste";
        while (isInput) {
            System.out.println("Digite a raça do animal que deseja buscar: ");
            raca = p.superScanner.nextLine();
            if (raca == null || raca.length() == 0 || raca.isEmpty()) {
                System.out.println("Erro! Tente novamente");
            } else {
                isInput = false;
            }
        }
        String racaCorrigido = p.formatador(raca);
        boolean localizado = false;
        for (Cachorro cachorro : Principal.cachorroArray) {
            if (racaCorrigido.contains(cachorro.getRaca())) {
                cachorro.exibirDados();
                System.out.println();
                localizado = true;
            }
        }
        if (localizado == false) {
            System.out.println("Raça não localizada!! ");
        }
    }
}
