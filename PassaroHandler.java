import java.util.InputMismatchException;

public class PassaroHandler {

    private static final Principal p = new Principal();

    public void cadastroPassaro() {
        // *-- Função para cadastrar um novo animal dentro do ArrayList --* //
        // *-- Utiliza funções genéricas com o prefixo "input" para receber as respostas
        // do usuário --*//
        Principal p = new Principal();
        System.out.println("Iremos agora cadastrar um novo Pássaro!!");
        String nome = p.inputNome();
        double idade = p.inputIdade();
        double peso = p.inputPeso();
        double altura = p.inputAltura();
        String corOvos = p.inputCorOvos();
        String corPenas = p.inputCorPenas();
        String tipo = p.inputTipo();
        String especie = p.inputEspecie();
        Principal.passaroArray.add(new Passaro(nome, tipo, especie, idade, peso, altura, corPenas, corOvos));
        System.out.println("Pássaro cadastrado com sucesso!! ");
    }

    public void editarPassaro() {
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
            System.out.println("Digite o nome do pássaro que deseja editar: ");
            nome = p.superScanner.nextLine();
            if (nome == null || nome.length() == 0 || nome.isEmpty()) {
                System.out.println("Erro! Tente novamente");
            } else {
                isInput = false;
            }
        }
        nomeCorrigido = p.formatador(nome);
        for (Passaro passaro : Principal.passaroArray) {
            if (nomeCorrigido.contains(passaro.getNome())) {
                int rotinaEditarPassaro = -1;
                while (rotinaEditarPassaro != 99) {
                    passaro.exibirDados();
                    System.out.println("\nDigite o dado que deseja editar: ");
                    System.out.println(
                            "1. Nome\n2. Raça\n3. Peso\n4. Idade\n5. Altura\n6. Cor dos Ovos\n7. Tipo\n8. Espécie");
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
                            passaro.setNome(newNome);
                            break;
                        case 2:
                            String newRaca = p.inputRaca();
                            passaro.setRaca(newRaca);
                            break;
                        case 3:
                            double newPeso = p.inputPeso();
                            passaro.setPeso(newPeso);
                            break;
                        case 4:
                            double newIdade = p.inputIdade();
                            passaro.setIdade(newIdade);
                            break;
                        case 5:
                            double newAltura = p.inputAltura();
                            passaro.setAltura(newAltura);
                            break;
                        case 6:
                            String newOvo = p.inputCorOvos();
                            passaro.setCorOvos(newOvo);
                            break;
                        case 7:
                            String newTipo = p.inputTipo();
                            passaro.setTipo(newTipo);
                            break;
                        case 8:
                            String newEspecie = p.inputEspecie();
                            passaro.setEspecie(newEspecie);
                            break;
                        case 99:
                            System.out.println("Encerrando subrotina.");
                            rotinaEditarPassaro = 99;
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

    public void apagarPassaro() {
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
            System.out.println("Digite o nome do pássaro que deseja editar: ");
            nome = p.superScanner.nextLine();
            if (nome == null || nome.length() == 0 || nome.isEmpty()) {
                System.out.println("Erro! Tente novamente");
            } else {
                isInput = false;
            }
        }
        nomeCorrigido = p.formatador(nome);
        int removedor = -2;
        for (Passaro passaro : Principal.passaroArray) {
            if (nomeCorrigido.contains(passaro.getNome())) {
                removedor = p.getIndex(nomeCorrigido, "Passaro");
                passaro.exibirDados();
                localizado = true;
            }
        }
        if (localizado == true) {
            System.out.println("\nDeseja mesmo apagar esse cadastro?");
            System.out.println("1. Sim\n2. Não");
            int escolha = p.superScanner.nextInt();
            p.superScanner.nextLine();
            if (escolha == 1) {
                Principal.passaroArray.remove(removedor);
                System.out.println("Cadastro removido com sucesso.");
            } else {
                System.out.print("Cadastro mantido.");
            }
        } else {
            System.out.println("Nome não localizado!!");
        }
    }

    public void exibirDadosPassaro() {
        // *-- Função para percorrer o ArrayList utilizando foreach, e chamada do método
        // "exibirDados" para listar todos dados dos animais --* //
        for (Passaro passaro : Principal.passaroArray) {
            passaro.exibirDados();
            System.out.println();
        }
    }

    public void listarDadosPassaro() {
        // *-- Função para percorrer o ArrayList utilizando foreach, e chamada método
        // "listarDados" para listar 3 dos principais dados dos animais --* //
        for (Passaro passaro : Principal.passaroArray) {
            System.out.println(passaro.listarDados());
        }
    }

    public void buscarNomePassaro() {
        boolean isInput = true;
        String nome = "teste";
        while (isInput) {
            System.out.println("Digite o nome do pássaro que deseja buscar: ");
            nome = p.superScanner.nextLine();
            if (nome == null || nome.length() == 0 || nome.isEmpty()) {
                System.out.println("Erro! Tente novamente");
            } else {
                isInput = false;
            }
        }
        String nomeCorrigido = p.formatador(nome);
        boolean localizado = false;
        for (Passaro passaro : Principal.passaroArray) {
            if (nomeCorrigido.contains(passaro.getNome())) {
                passaro.exibirDados();
                System.out.println();
                localizado = true;
            }
        }
        if (localizado == false) {
            System.out.println("Nome não localizado!!");
        }
    }

    public void buscarEspeciePassaro() {
        boolean isInput = true;
        String especie = "teste";
        while (isInput) {
            System.out.println("Digite a espécie do pássaro que deseja buscar: ");
            especie = p.superScanner.nextLine();
            if (especie == null || especie.length() == 0 || especie.isEmpty()) {
                System.out.println("Erro! Tente novamente");
            } else {
                isInput = false;
            }
        }
        String especieCorrigido = p.formatador(especie);
        boolean localizado = false;
        for (Passaro passaro : Principal.passaroArray) {
            if (especieCorrigido.contains(passaro.getEspecie())) {
                passaro.exibirDados();
                System.out.println();
                localizado = true;
            }
        }
        if (localizado == false) {
            System.out.println("Espécie não localizada!! ");
        }
    }

    public void buscarPenaPassaro() {
        boolean isInput = true;
        String corpena = "teste";
        while (isInput) {
            System.out.println("Digite o corpena do animal que deseja buscar: ");
            corpena = p.superScanner.nextLine();
            if (corpena == null || corpena.length() == 0 || corpena.isEmpty()) {
                System.out.println("Erro! Tente novamente");
            } else {
                isInput = false;
            }
        }
        String corpenaCorrigido = p.formatador(corpena);
        boolean localizado = false;
        for (Passaro passaro : Principal.passaroArray){
            if (corpenaCorrigido.contains(passaro.getCorPenas())) {
                passaro.exibirDados();
                System.out.println();
                localizado = true;
            }
        }
        if (localizado == false) {
            System.out.println("Cor de pena não localizada!! ");
        }
    }

    public void buscarCorOvoPassaro() {
        boolean isInput = true;
        String corOvo = "teste";
        while (isInput) {
            System.out.println("Digite o corOvo do animal que deseja buscar: ");
            corOvo = p.superScanner.nextLine();
            if (corOvo == null || corOvo.length() == 0 || corOvo.isEmpty()) {
                System.out.println("Erro! Tente novamente");
            } else {
                isInput = false;
            }
        }
        String corOvoCorrigido = p.formatador(corOvo);
        boolean localizado = false;
        for (Passaro passaro : Principal.passaroArray) {
            if (corOvoCorrigido.contains(passaro.getCorOvos())) {
                passaro.exibirDados();
                System.out.println();
                localizado = true;
            }
        }
        if (localizado == false) {
            System.out.println("Cor de ovo não localizada!! ");
        }
    }
}
