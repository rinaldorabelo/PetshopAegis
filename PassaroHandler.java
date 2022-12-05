import java.io.IOException;
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
        String corOvos = p.inputCorOvos();
        String corPenas = p.inputCorPenas();
        String tipo = p.inputTipo();
        String especie = p.inputEspecie();
        double idade = p.inputIdade();
        double peso = p.inputPeso();
        double altura = p.inputAltura();
        int idcadastro = Principal.gatoArray.size() + Principal.cachorroArray.size() + Principal.passaroArray.size()
                + 1;
        Principal.passaroArray
                .add(new Passaro(idcadastro, nome, tipo, especie, idade, peso, altura, corPenas, corOvos));
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
        // *-- O sistema de cadastros utiliza uma id única atribuida a cada animal para
        // diferencia-los
        // em caso de duplicidade --*//
        boolean isInput = true;
        String nome = "teste";
        while (isInput) {
            System.out.println("Digite o nome do pássaro que deseja editar: ");
            try {
                nome = p.buffReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
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
        if (localizado == true) {
            Integer pesquisaID = -2;
            while (pesquisaID < 0) {
                System.out.println("Confirme a ID do passaro que deseja editar: ");
                try {
                    pesquisaID = p.superScanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Erro! Tente novamente.");
                    p.superScanner.next();
                    System.out.println();
                } catch (Exception e) {
                    System.out.println("Erro! Tente novamente.");
                    p.superScanner.next();
                    System.out.println();
                }
            }
            for (Passaro passaro : Principal.passaroArray) {
                if (pesquisaID.equals(passaro.getID())) {
                    int rotinaEditarCachorro = -1;
                    while (rotinaEditarCachorro != 99) {
                        passaro.exibirDados();
                        System.out.println("\nDigite o dado que deseja editar: ");
                        System.out.println(
                                "1. Nome\n2. Raça\n3. Peso\n4. Idade\n5. Altura\n6. Cor dos Ovos\n7. Tipo\n8. Espécie\n9. Cor das Penas");
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
                            case 9:
                                String newPenas = p.inputCorPenas();
                                passaro.setCorPenas(newPenas);
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
        // *-- O sistema de cadastros utiliza uma id única atribuida a cada animal para
        // diferencia-los
        // em caso de duplicidade --*//
        boolean isInput = true;
        String nome = "teste";
        int removedor = -2;
        while (isInput) {
            System.out.println("Digite o nome do pássaro que deseja apagar: ");
            try {
                nome = p.buffReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (nome == null || nome.length() == 0 || nome.isEmpty()) {
                System.out.println("Erro! Tente novamente");
            } else {
                isInput = false;
            }
        }
        String nomeCorrigido = p.formatador(nome);
        boolean localizadoNome = false;
        for (Passaro passaro : Principal.passaroArray) {
            if (nomeCorrigido.contains(passaro.getNome())) {
                passaro.exibirDados();
                System.out.println();
                localizadoNome = true;
            }
        }
        if (localizadoNome == true) {
            boolean localizadoIndex = false;
            Integer IDprocurar = -2;
            while (IDprocurar < 0) {
                System.out.println("Confirme a ID do pássaro:");
                try {
                    IDprocurar = p.superScanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Erro! Tente novamente.");
                    p.superScanner.next();
                    System.out.println();
                } catch (Exception e) {
                    System.out.println("Erro! Tente novamente.");
                    p.superScanner.next();
                    System.out.println();
                }
            }
            if (localizadoNome == true) {
                for (Passaro passaro : Principal.passaroArray) {
                    if (IDprocurar.equals(passaro.getID())) {
                        removedor = p.getIndex(IDprocurar, "Passaro");
                        passaro.exibirDados();
                        localizadoIndex = true;
                    }
                }
            }
            if (localizadoIndex == true) {
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
            }
        }
        if (localizadoNome == false) {
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
            try {
                nome = p.buffReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
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
            try {
                especie = p.buffReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
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
            try {
                corpena = p.buffReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (corpena == null || corpena.length() == 0 || corpena.isEmpty()) {
                System.out.println("Erro! Tente novamente");
            } else {
                isInput = false;
            }
        }
        String corpenaCorrigido = p.formatador(corpena);
        boolean localizado = false;
        for (Passaro passaro : Principal.passaroArray) {
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
            try {
                corOvo = p.buffReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
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
