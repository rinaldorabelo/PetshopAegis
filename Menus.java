
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menus extends Principal {
    
    private static final Scanner scannerMenus = new Scanner(System.in);
    private static final CachorroHandler handlerCachorro = new CachorroHandler();
    private static final GatoHandler handlerGato = new GatoHandler();
    private static final PassaroHandler handlerPassaro = new PassaroHandler();
    private static final Principal p = new Principal();

    public int menu() {
        // *-- Função para criação do Menu, utilizando os métodos e funções criadas, com
        // a utilização do switch para seleção das opções --* //
        // *-- Nessa função, se mantém o looping, com todas as opções que o sistema
        // ofereçe, até o usuário selecionar a opção [9], que significa o final do
        // programa --* //
        System.out.print("\n##--             Petshop Aegis              --##\n");
        System.out.print("------------------------------------------------\n");
        System.out.print("|[01] Cadastrar Novo Cachorro                  |\n");
        System.out.print("|[02] Buscar Cachorro Cadastrados              |\n");
        System.out.print("|[03] Exibir Todos os Cachorros Cadastrados    |\n");
        System.out.print("|[04] Editar Cachorro Cadastrado               |\n");
        System.out.print("|[05] Apagar Cachorro Cadastrado               |\n");
        System.out.print("|                                              |\n");
        System.out.print("|[06] Cadastrar Novo Gato                      |\n");
        System.out.print("|[07] Buscar Gato Cadastrados                  |\n");
        System.out.print("|[08] Exibir Todos os Gatos Cadastrados        |\n");
        System.out.print("|[09] Editar Gato Cadastrado                   |\n");
        System.out.print("|[10] Apagar Gato Cadastrado                   |\n");
        System.out.print("|                                              |\n");
        System.out.print("|[11] Cadastrar Novo Pássaro                   |\n");
        System.out.print("|[12] Buscar Pássaro Cadastrado                |\n");
        System.out.print("|[13] Exibir Todos os Pássaros Cadastrados     |\n");
        System.out.print("|[14] Editar Pássaro Cadastrado                |\n");
        System.out.print("|[15] Apagar Pássaro Cadastrado                |\n");
        System.out.print("|                                              |\n");
        System.out.print("|[16] Exibir Todos os Animais Cadastrados      |\n");
        System.out.print("|[17] Buscar Animal Cadastrado                 |\n");
        System.out.print("|                                              |\n");
        System.out.print("|                                              |\n");
        System.out.print("|[99] Sair                                     |\n");
        System.out.print("------------------------------------------------\n");
        System.out.println("\nDigite uma opção: ");
        int escolha = -1;
        try {
            escolha = scannerMenus.nextInt();
            scannerMenus.nextLine();
        } catch (InputMismatchException e) {
            scannerMenus.next();
            System.out.println();
        } catch (Exception e) {
            scannerMenus.next();
            System.out.println();
        }

        // *-- No tratamento de exceção é feito de forma que o buffer do scanner é limpo
        // para evitar que ele entre um loop infinito de InputMismatchException. Essa lógica é aplicada
        // em vários momentos do código que isso pode acontecer --* //

        switch (escolha) {
            case 1:
                System.out.println("Opção [Cadastrar Novo Cachorro] selecionado\n");
                handlerCachorro.cadastroCachorro();
            break;
            case 2:
                System.out.println("Opção [Buscar Cachorro Cadastrados] selecionada\n");
                subMenuBuscaCachorro();
            break;
            case 3:
                System.out.println("Opção [Exibir Todos os Cachorros Cadastrados] selecionada\n");
                subMenuExibirCachorro();
            break;
            case 4:
                System.out.println("Opção [Editar Cachorro Cadastrado] selecionada\n");
                handlerCachorro.editarCachorro();
            break;
            case 5:
                System.out.println("Opção [Apagar Cachorro Cadastrado] selecionada\n");
                handlerCachorro.apagarCachorro();
            break;
            case 6:
                System.out.println("Opção [Cadastrar Novo Gato] selecionada\n");
                handlerGato.cadastroGato();
            break;
            case 7:
                System.out.println("Opção [Buscar Gato Cadastrados] selecionada\n");
                subMenuBuscaGato();
            break;
            case 8:
                System.out.println("Opção [Exibir Todos os Gatos Cadastrados] selecionada\n");
                subMenuExibirGato();             
            break;
            case 9:
                System.out.println("Opção [Editar Gato Cadastrado] selecionada\n");
                handlerGato.editarGato();  
            break;
            case 10:
                System.out.println("Opção [Apagar Gato Cadastrado] selecionada\n");
                handlerGato.apagarGato();
            break;
            case 11:
                System.out.println("Opção [Cadastrar Novo Pássaro] selecionada\n");
                handlerPassaro.cadastroPassaro();
            break;
            case 12:
                System.out.println("Opção [Buscar Pássaro Cadastrados] selecionada\n");
                subMenuBuscaPassaro();
            break;
            case 13:
                System.out.println("Opção [Exibir Todos os Pássaros Cadastrados] selecionada\n");
                subMenuExibirPassaro();
            break;
            case 14:
                System.out.println("Opção [Editar Pássaro Cadastrado] selecionada\n");
                handlerPassaro.editarPassaro();
            break;
            case 15:
                System.out.println("Opção [Apagar Pássaro Cadastrado] selecionada\n");
                handlerPassaro.apagarPassaro();
            break;
            case 16:
                System.out.println("Opção [Exibir Todos os Animais Cadastrados] selecionada\n");
                subMenuExibirTudo();
            break;
            case 17:
                System.out.println("Opção [Buscar Animal Cadastrado] selecionada\n");
                p.buscarNomeGeral();
            break;
            case 99:
                System.out.println("Fim do Programa, Obrigado!!");
                break;
            default:
                System.out.println("Erro! Tente novamente");
        }
        return escolha;
    }

    public void subMenuBuscaCachorro() {
        // *-- Submenu feito para que o usuário selecione entre os dois tipos de busca
        // utilizando os numeradores mostrados --* //
        // *-- Se a opção [9] for selecionada, a função se encerra e sem chamar a busca
        // e retorna ao menu principal --* //
        // *-- A função se mantém em loop até que a opção de voltar ao menu seja
        // selecionada --*/
        

        boolean isMenu = true;
        while (isMenu) {
            System.out.println("\n|Subrotina para buscar cachorros cadastrados|");
            System.out.println("|-------------------------------------------|");
            System.out.println("|[1] Buscar Por Nome                        |");
            System.out.println("|[2] Buscar Por Raça                        |");
            System.out.println("|                                           |");
            System.out.println("|[9] Retornar ao Menu Anterior              |");
            System.out.println("|-------------------------------------------|");
            System.out.println("\nDigite uma opção: ");
            int escolhaBusca = -1;
            try {
                escolhaBusca = scannerMenus.nextInt();
                scannerMenus.nextLine();
            } catch (InputMismatchException e) {
                scannerMenus.next();
                System.out.println();
            } catch (Exception e) {
                scannerMenus.next();
                System.out.println();
            }

            // *-- No tratamento de exceção é feito de forma que o buffer do scanner é limpo
            // para evitar ele entre um loop infinito de InputMismatchException. Essa lógica é aplicada
            // em vários momentos do código que isso pode acontecer --* //

            switch (escolhaBusca) {
                case 1:
                    System.out.println("Opção [Buscar Por Nome] selecionada\n");
                    handlerCachorro.buscarNomeCachorro();
                    break;
                case 2:
                    System.out.println("Opção [Buscar Por Raça] selecionada\n");
                    handlerCachorro.buscarRacaCachorro();
                    break;
                case 9:
                    System.out.println("Retornando ao menu principal");
                    isMenu = false;
                    break;

                default:
                    System.out.println("Erro! Tente novamente");
            }
        }
    }

    public void subMenuExibirCachorro() {
        // *-- Submenu feito para que o usuário selecione entre os dois tipos de
        // exibição utilizando os numeradores mostrados --*//
        // *-- Se a opção [9] for selecionada, a função se encerra e sem chamar a busca
        // e retorna ao menu principal --*//
        // *-- A função se mantém em loop até que a opção de voltar ao menu seja
        // selecionada --*//
        boolean isMenu = true;
        while (isMenu) {
            System.out.println("\n|Subrotina para exibir todos os cachorros cadastrados|");
            System.out.println("|------------------------------------------------------|");
            System.out.println("|[1] Exibir Dados Principais                           |");
            System.out.println("|[2] Exibir Todos os Dados                             |");
            System.out.println("|                                                      |");
            System.out.println("|[9] Retornar ao Menu Anterior                         |");
            System.out.println("|------------------------------------------------------|");
            System.out.println("\nDigite uma opção: ");
            int escolhaExibir = -1;
            try {
                escolhaExibir = scannerMenus.nextInt();
                scannerMenus.nextLine();
            } catch (InputMismatchException e) {
                scannerMenus.next();
                System.out.println();
            } catch (Exception e) {
                scannerMenus.next();
                System.out.println();
            }

        // *-- No tratamento de exceção é feito de forma que o buffer do scanner é limpo
        // para evitar que ele entre um loop infinito de InputMismatchException. Essa lógica é aplicada
        // em vários momentos do código que isso pode acontecer --* //

            switch (escolhaExibir) {
                case 1:
                    System.out.println("Opção [Exibir Dados Principais] selecionada\n");
                    handlerCachorro.listarDadosCachorro();
                    break;
                case 2:
                    System.out.println("Opção [Exibir Todos os Dados] selecionada\n");
                    handlerCachorro.exibirDadosCachorro();
                    break;
                case 9:
                    System.out.println("Retornando ao menu principal");
                    isMenu = false;
                    break;

                default:
                    System.out.println("Erro! Tente novamente");
            }
        }
    }



    public void subMenuBuscaGato() {
        // *-- Submenu feito para que o usuário selecione entre os dois tipos de busca
        // utilizando os numeradores mostrados --* //
        // *-- Se a opção [9] for selecionada, a função se encerra e sem chamar a busca
        // e retorna ao menu principal --* //
        // *-- A função se mantém em loop até que a opção de voltar ao menu seja
        // selecionada --*/
        

        boolean isMenu = true;
        while (isMenu) {
            System.out.println("\n|Subrotina para buscar gatos cadastrados|");
            System.out.println("|---------------------------------------|");
            System.out.println("|[1] Buscar Por Nome                    |");
            System.out.println("|[2] Buscar Por Raça                    |");
            System.out.println("|[3] Buscar Por Pelagem                 |");
            System.out.println("|                                       |");
            System.out.println("|[9] Retornar ao Menu Anterior          |");
            System.out.println("|---------------------------------------|");
            System.out.println("\nDigite uma opção: ");
            int escolhaBusca = -1;
            try {
                escolhaBusca = scannerMenus.nextInt();
                scannerMenus.nextLine();
            } catch (InputMismatchException e) {
                scannerMenus.next();
                System.out.println();
            } catch (Exception e) {
                scannerMenus.next();
                System.out.println();
            }

            // *-- No tratamento de exceção é feito de forma que o buffer do scanner é limpo
            // para evitar ele entre um loop infinito de InputMismatchException. Essa lógica é aplicada
            // em vários momentos do código que isso pode acontecer --* //

            switch (escolhaBusca) {
                case 1:
                    System.out.println("Opção [Buscar Por Nome] selecionada\n");
                    handlerGato.buscarNomeGato();
                    break;
                case 2:
                    System.out.println("Opção [Buscar Por Raça] selecionada\n");
                    handlerGato.buscarRacaGato();
                    break;
                case 3:
                    System.out.println("Opção [Buscar Por Pelagem] selecionada\n");
                    handlerGato.buscarPelagemGato();
                    break;
                case 9:
                    System.out.println("Retornando ao menu principal");
                    isMenu = false;
                    break;

                default:
                    System.out.println("Erro! Tente novamente");
            }
        }
    }

    public void subMenuExibirGato() {
        // *-- Submenu feito para que o usuário selecione entre os dois tipos de
        // exibição utilizando os numeradores mostrados --*//
        // *-- Se a opção [9] for selecionada, a função se encerra e sem chamar a busca
        // e retorna ao menu principal --*//
        // *-- A função se mantém em loop até que a opção de voltar ao menu seja
        // selecionada --*//
        boolean isMenu = true;
        while (isMenu) {
            System.out.println("\n|Subrotina para exibir todos os gatos cadastrados|");
            System.out.println("|--------------------------------------------------|");
            System.out.println("|[1] Exibir Dados Principais                       |");
            System.out.println("|[2] Exibir Todos os Dados                         |");
            System.out.println("|                                                  |");
            System.out.println("|[9] Retornar ao Menu Anterior                     |");
            System.out.println("|--------------------------------------------------|");
            System.out.println("\nDigite uma opção: ");
            int escolhaExibir = -1;
            try {
                escolhaExibir = scannerMenus.nextInt();
                scannerMenus.nextLine();
            } catch (InputMismatchException e) {
                scannerMenus.next();
                System.out.println();
            } catch (Exception e) {
                scannerMenus.next();
                System.out.println();
            }

        // *-- No tratamento de exceção é feito de forma que o buffer do scanner é limpo
        // para evitar que ele entre um loop infinito de InputMismatchException. Essa lógica é aplicada
        // em vários momentos do código que isso pode acontecer --* //

            switch (escolhaExibir) {
                case 1:
                    System.out.println("Opção [Exibir Dados Principais] selecionada\n");
                    handlerGato.listarDadosGato();
                    break;
                case 2:
                    System.out.println("Opção [Exibir Todos os Dados] selecionada\n");
                    handlerGato.exibirDadosGato();
                    break;
                case 9:
                    System.out.println("Retornando ao menu principal");
                    isMenu = false;
                    break;

                default:
                    System.out.println("Erro! Tente novamente");
            }
        }
    }



    public void subMenuBuscaPassaro() {
        // *-- Submenu feito para que o usuário selecione entre os dois tipos de busca
        // utilizando os numeradores mostrados --* //
        // *-- Se a opção [9] for selecionada, a função se encerra e sem chamar a busca
        // e retorna ao menu principal --* //
        // *-- A função se mantém em loop até que a opção de voltar ao menu seja
        // selecionada --*/
        

        boolean isMenu = true;
        while (isMenu) {
            System.out.println("|Subrotina para buscar pássaros cadastrados|");
            System.out.println("|------------------------------------------|");
            System.out.println("|[1] Buscar Por Nome                       |");
            System.out.println("|[2] Buscar Por Espécie                    |");
            System.out.println("|[3] Buscar Por Cor das Penas              |");
            System.out.println("|[4] Buscar Por Cor dos Ovos               |");
            System.out.println("|                                          |");
            System.out.println("|[9] Retornar ao Menu Anterior             |");
            System.out.println("|                                          |");
            System.out.println("|------------------------------------------|");
            System.out.println("\nDigite uma opção: ");
            int escolhaBusca = -1;
            try {
                escolhaBusca = scannerMenus.nextInt();
                scannerMenus.nextLine();
            } catch (InputMismatchException e) {
                scannerMenus.next();
                System.out.println();
            } catch (Exception e) {
                scannerMenus.next();
                System.out.println();
            }

            // *-- No tratamento de exceção é feito de forma que o buffer do scanner é limpo
            // para evitar ele entre um loop infinito de InputMismatchException. Essa lógica é aplicada
            // em vários momentos do código que isso pode acontecer --* //

            switch (escolhaBusca) {
                case 1:
                    System.out.println("Opção [Buscar Por Nome] selecionada\n");
                    handlerPassaro.buscarNomePassaro();
                    break;
                case 2:
                    System.out.println("Opção [Buscar Por Espécie] selecionada\n");
                    handlerPassaro.buscarEspeciePassaro();
                    break;
                case 3:
                    System.out.println("Opção [Buscar Por Cor das Penas] selecionada\n");
                    handlerPassaro.buscarPenaPassaro();
                    break;
                case 4:
                    System.out.println("Opção [Buscar Por Cor dos Ovos] selecionada\n");
                    handlerPassaro.buscarCorOvoPassaro();
                    break;    
                case 9:
                    System.out.println("Retornando ao menu principal");
                    isMenu = false;
                    break;

                default:
                    System.out.println("Erro! Tente novamente");
            }
        }
    }

    public void subMenuExibirPassaro() {
        // *-- Submenu feito para que o usuário selecione entre os dois tipos de
        // exibição utilizando os numeradores mostrados --*//
        // *-- Se a opção [9] for selecionada, a função se encerra e sem chamar a busca
        // e retorna ao menu principal --*//
        // *-- A função se mantém em loop até que a opção de voltar ao menu seja
        // selecionada --*//
        boolean isMenu = true;
        while (isMenu) {
            System.out.println("\n|Subrotina para exibir todos os pássaros cadastrados|");
            System.out.println("|-----------------------------------------------------|");
            System.out.println("|[1] Exibir Dados Principais                          |");
            System.out.println("|[2] Exibir Todos os Dados                            |");
            System.out.println("|                                                     |");
            System.out.println("|[9] Retornar ao Menu Anterior                        |");
            System.out.println("|-----------------------------------------------------|");
            System.out.println("\nDigite uma opção: ");
            int escolhaExibir = -1;
            try {
                escolhaExibir = scannerMenus.nextInt();
                scannerMenus.nextLine();
            } catch (InputMismatchException e) {
                scannerMenus.next();
                System.out.println();
            } catch (Exception e) {
                scannerMenus.next();
                System.out.println();
            }

        // *-- No tratamento de exceção é feito de forma que o buffer do scanner é limpo
        // para evitar que ele entre um loop infinito de InputMismatchException. Essa lógica é aplicada
        // em vários momentos do código que isso pode acontecer --* //

            switch (escolhaExibir) {
                case 1:
                    System.out.println("Opção [Exibir Dados Principais] selecionada\n");
                    handlerPassaro.listarDadosPassaro();
                    break;
                case 2:
                    System.out.println("Opção [Exibir Todos os Dados] selecionada\n");
                    handlerPassaro.exibirDadosPassaro();
                    break;
                case 9:
                    System.out.println("Retornando ao menu principal");
                    isMenu = false;
                    break;

                default:
                    System.out.println("Erro! Tente novamente");
            }
        }
    }



    public void subMenuExibirTudo() {
        // *-- Submenu feito para que o usuário selecione entre os dois tipos de
        // exibição utilizando os numeradores mostrados --*//
        // *-- Se a opção [9] for selecionada, a função se encerra e sem chamar a busca
        // e retorna ao menu principal --*//
        // *-- A função se mantém em loop até que a opção de voltar ao menu seja
        // selecionada --*//
        boolean isMenu = true;
        while (isMenu) {
            System.out.println("\n|Subrotina para exibir todos os animais cadastrados|");
            System.out.println("|--------------------------------------------------|");
            System.out.println("|[1] Exibir Dados Principais                       |");
            System.out.println("|[2] Exibir Todos os Dados                         |");
            System.out.println("|                                                  |");
            System.out.println("|[9] Retornar ao Menu Anterior                     |");
            System.out.println("|--------------------------------------------------|");
            System.out.println("\nDigite uma opção: ");
            int escolhaExibir = -1;
            try {
                escolhaExibir = scannerMenus.nextInt();
                scannerMenus.nextLine();
            } catch (InputMismatchException e) {
                scannerMenus.next();
                System.out.println();
            } catch (Exception e) {
                scannerMenus.next();
                System.out.println();
            }

        // *-- No tratamento de exceção é feito de forma que o buffer do scanner é limpo
        // para evitar que ele entre um loop infinito de InputMismatchException. Essa lógica é aplicada
        // em vários momentos do código que isso pode acontecer --* //

            switch (escolhaExibir) {
                case 1:
                    System.out.println("Opção [Exibir Dados Principais] selecionada\n");
                    listarDadosGeral();
                    break;
                case 2:
                    System.out.println("Opção [Exibir Todos os Dados] selecionada\n");
                    exibirDadosGeral();
                    break;
                case 9:
                    System.out.println("Retornando ao menu principal");
                    isMenu = false;
                    break;

                default:
                    System.out.println("Erro! Tente novamente");
            }
        }
    }
}

