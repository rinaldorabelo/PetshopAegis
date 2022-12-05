import java.io.IOException;
import java.util.InputMismatchException;

public class GatoHandler {

    private static final Principal p = new Principal();

    public void cadastroGato() {
        // *-- Função para cadastrar um novo animal dentro do ArrayList --* //
        // *-- Utiliza funções genéricas com o prefixo "input" para receber as respostas
        // do usuário --*//
        Principal p = new Principal();
        System.out.println("Iremos agora cadastrar um novo Gato!!");
        String nome = p.inputNome();
        String raca = p.inputRaca();
        String pelagem = p.inputPelagem();
        double idade = p.inputIdade();
        double peso = p.inputPeso();
        double altura = p.inputAltura();
        int idcadastro = Principal.gatoArray.size() + Principal.cachorroArray.size() + Principal.passaroArray.size()
                + 1;
        Principal.gatoArray.add(new Gato(idcadastro, nome, raca, idade, peso, altura, pelagem));
        System.out.println("Gato cadastrado com sucesso!! ");
    }

    public void editarGato() {
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
        // *-- O sistema de cadastros utiliza uma id única atribuida a cada animal para diferencia-los
        // em caso de duplicidade --*//
        boolean isInput = true;
        String nome = "teste";
        while (isInput) {
            System.out.println("Digite o nome do gato que deseja editar: ");
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
        for (Gato gato : Principal.gatoArray) {
            if (nomeCorrigido.contains(gato.getNome())) {
                gato.exibirDados();
                System.out.println();
                localizado = true;
            }
        }
        Integer pesquisaID = -1;
        while (pesquisaID < 0) {
            System.out.println("Confirme a ID do gato que deseja editar: ");
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

        if (localizado == true) {
            for (Gato gato : Principal.gatoArray) {
                if (pesquisaID.equals(gato.getID())) {
                    int rotinaEditarCachorro = -1;
                    while (rotinaEditarCachorro != 99) {
                        gato.exibirDados();
                        System.out.println("\nDigite o dado que deseja editar: ");
                        System.out.println("1. Nome\n2. Raça\n3. Peso\n4. Idade\n5. Altura\n6. Pelagem");
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
                                gato.setNome(newNome);
                                break;
                            case 2:
                                String newRaca = p.inputRaca();
                                gato.setRaca(newRaca);
                                break;
                            case 3:
                                double newPeso = p.inputPeso();
                                gato.setPeso(newPeso);
                                break;
                            case 4:
                                double newIdade = p.inputIdade();
                                gato.setIdade(newIdade);
                                break;
                            case 5:
                                double newAltura = p.inputAltura();
                                gato.setAltura(newAltura);
                                break;
                            case 6:
                                String newPelagem = p.inputPelagem();
                                gato.setPelagem(newPelagem);
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

    public void apagarGato() {
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
        // *-- O sistema de cadastros utiliza uma id única atribuida a cada animal para diferencia-los
        // em caso de duplicidade --*//
        boolean isInput = true;
        String nome = "teste";
        int removedor = -2;
        while (isInput) {
            System.out.println("Digite o nome do gato que deseja apagar: ");
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
        for (Gato gato : Principal.gatoArray) {
            if (nomeCorrigido.contains(gato.getNome())) {
                gato.exibirDados();
                System.out.println();
                localizadoNome = true;
            }
        }
        boolean localizadoIndex = false;
        Integer IDprocurar = -1;
        while (IDprocurar < 0) {
            System.out.println("Confirme a ID do gato:");
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

            for (Gato gato : Principal.gatoArray) {
                if (IDprocurar.equals(gato.getID())) {
                    removedor = p.getIndex(IDprocurar, "Gato");
                    gato.exibirDados();
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
                Principal.gatoArray.remove(removedor);
                System.out.println("Cadastro removido com sucesso.");
            } else {
                System.out.print("Cadastro mantido.");
            }
        } else {
            System.out.println("Nome não localizado!!");
        }
    }

    public void exibirDadosGato() {
        for (Gato gato : Principal.gatoArray) {
            gato.exibirDados();
            System.out.println();
        }
    }

    public void listarDadosGato() {
        for (Gato gato : Principal.gatoArray) {
            System.out.println(gato.listarDados());
        }
    }

    public void buscarNomeGato() {
        boolean isInput = true;
        String nome = "teste";
        while (isInput) {
            System.out.println("Digite o nome do gato que deseja buscar: ");
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
        for (Gato gato : Principal.gatoArray) {
            if (nomeCorrigido.contains(gato.getNome())) {
                gato.exibirDados();
                System.out.println();
                localizado = true;
            }
        }
        if (localizado == false) {
            System.out.println("Nome não localizado!!");
        }
    }

    public void buscarRacaGato() {
        boolean isInput = true;
        String raca = "teste";
        while (isInput) {
            System.out.println("Digite o raça do gato que deseja buscar: ");
            try {
                raca = p.buffReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (raca == null || raca.length() == 0 || raca.isEmpty()) {
                System.out.println("Erro! Tente novamente");
            } else {
                isInput = false;
            }
        }
        String racaCorrigido = p.formatador(raca);
        boolean localizado = false;
        for (Gato gato : Principal.gatoArray) {
            if (racaCorrigido.contains(gato.getRaca())) {
                gato.exibirDados();
                System.out.println();
                localizado = true;
            }
        }
        if (localizado == false) {
            System.out.println("Raça não localizada!!");
        }
    }

    public void buscarPelagemGato() {
        boolean isInput = true;
        String pelagem = "teste";
        while (isInput) {
            System.out.println("Digite o pelagem do animal que deseja buscar: ");
            try {
                pelagem = p.buffReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (pelagem == null || pelagem.length() == 0 || pelagem.isEmpty()) {
                System.out.println("Erro! Tente novamente");
            } else {
                isInput = false;
            }
        }
        String pelagemCorrigido = p.formatador(pelagem);
        boolean localizado = false;
        for (Gato gato : Principal.gatoArray) {
            if (pelagemCorrigido.contains(gato.getPelagem())) {
                gato.exibirDados();
                System.out.println();
                localizado = true;
            }
        }
        if (localizado == false) {
            System.out.println("Pelagem não localizada!!");
        }
    }

}
