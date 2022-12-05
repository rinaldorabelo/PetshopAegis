import java.util.InputMismatchException;
import java.io.IOException;

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
        int idcadastro = Principal.gatoArray.size() + Principal.cachorroArray.size() + Principal.passaroArray.size()
                + 1;
        Principal.cachorroArray.add(new Cachorro(idcadastro, nome, raca, idade, peso, altura));
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
        // *-- O sistema de cadastros utiliza uma id única atribuida a cada animal para diferencia-los
        // em caso de duplicidade --*//
        boolean isInput = true;
        String nome = "teste";
        while (isInput) {
            System.out.println("Digite o nome do cachorro que deseja editar: ");
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
        for (Cachorro cachorro : Principal.cachorroArray) {
            if (nomeCorrigido.contains(cachorro.getNome())) {
                cachorro.exibirDados();
                System.out.println();
                localizado = true;
            }
        }

        Integer pesquisaID = -1;
        while (pesquisaID < 0) {
            System.out.println("Confirme a ID do cachorro que deseja editar: ");
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
            for (Cachorro cachorro : Principal.cachorroArray) {
                if (pesquisaID.equals(cachorro.getID())) {
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
        }
        if (localizado == false) {
            System.out.println("Nome não localizado!!");
        }
    }

    public void apagarCachorro(){
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
            System.out.println("Digite o nome do cachorro que deseja apagar: ");
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
        for (Cachorro cachorro : Principal.cachorroArray) {
            if (nomeCorrigido.contains(cachorro.getNome())) {
                cachorro.exibirDados();
                System.out.println();
                localizadoNome = true;
            } else {
                break;
            }
        }
        Integer IDprocurar = -1;
        while (IDprocurar < 0) {
            System.out.println("Confirme a ID do cachorro:");
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
        boolean localizadoIndex = false;
        if (localizadoNome == true) {
            for (Cachorro cachorro : Principal.cachorroArray) {
                if (IDprocurar.equals(cachorro.getID())) {
                    removedor = p.getIndex(IDprocurar, "Cachorro");
                    cachorro.exibirDados();
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
        System.out.println();
        System.out.println();
        boolean isInput = true;
        String nome = "teste";
        while (isInput) {
            System.out.println("Digite o nome do cachorro que deseja buscar: ");
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
        System.out.println();
        System.out.println();
        boolean isInput = true;
        String raca = "teste";
        while (isInput) {
            System.out.println("Digite a raça do animal que deseja buscar: ");
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
