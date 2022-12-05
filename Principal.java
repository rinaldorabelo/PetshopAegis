import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Principal {

    final Scanner superScanner = new Scanner(System.in);
    final BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));
    // *-- Aqui é definido um scanner como constante de classe para ser usado em
    // todo o código ao invés de abrir múltiplos em vários pontos do código e
    // ficarem abertos gerando um memory sink --* //
    public static final ArrayList<Cachorro> cachorroArray = new ArrayList<Cachorro>();
    public static final ArrayList<Gato> gatoArray = new ArrayList<Gato>();
    public static final ArrayList<Passaro> passaroArray = new ArrayList<Passaro>();

    public static void main(String[] args) {
        // * -- Criação do ArrayList de Cachorro -- * //

        // *-- Criação dos cadastros dos Cachorros dentro do ArrayList --* //
        cachorroArray.add(new Cachorro(1, "Caramelo", "Vira Lata", 5, 10.0, 0.80));
        cachorroArray.add(new Cachorro(2, "Farinha", "Shitzu", 3, 1.0, 0.30));
        cachorroArray.add(new Cachorro(3, "Rex", "Pitbull", 2, 20.5, 1.20));
        cachorroArray.add(new Cachorro(4, "Teemo", "Chow-Chow", 6, 6.6, 0.90));
        cachorroArray.add(new Cachorro(5, "Bethoveen", "Labrador", 3, 10, 1.00));
        cachorroArray.add(new Cachorro(6, "Bidu", "Vira Lata", 9, 0.60, 5.80));
        cachorroArray.add(new Cachorro(7, "Gragas", "Vira Lata", 1, 50.09, 2.3));
        cachorroArray.add(new Cachorro(8, "Swain", "Labrador", 15, 10.5, 0.48));

        // *-- Criação dos cadastros dos Gatos dentro do ArrayList --* //
        gatoArray.add(new Gato(9, "Belle", "Vira Lata", 2, 4, 1, "Rajada"));
        gatoArray.add(new Gato(10, "Pingus", "Sphynx", 6, 3, 1, "Careca"));
        gatoArray.add(new Gato(11, "Ganfalf", "Americano", 1, 3, 1, "Curta"));
        gatoArray.add(new Gato(12, "Bob", "Siamês", 8, 6, 1, "Longa"));
        gatoArray.add(new Gato(13, "Selina", "Vira Lata", 7, 8, 1, "Ondulada"));

        // *-- Criação dos cadastros dos Pássaros dentro do ArrayList --* //
        passaroArray.add(new Passaro(14, "Pistola", "Pássaro", "Canário", 3, 0.5, 0.3, "Amarela", "Brancos"));
        passaroArray.add(new Passaro(15, "Maria", "Pássaro", "Canário", 3, 0.5, 0.3, "Amarela", "Brancos"));
        passaroArray.add(new Passaro(16, "Malvado", "Pássaro", "Cacatua", 5, 0.5, 0.3, "Branco", "Rosas"));
        passaroArray.add(new Passaro(17, "Beto", "Pássaro", "Cacatua", 5, 0.5, 0.3, "Branco", "Rosas"));

        // *-- Utilização da função do menu, assim sempre mantendo o looping enquanto o
        // usuário não selecionar a opção [99] --* //
        // *-- Assim que o mesmo selecionar a opção [99], o programa é finalizado e
        // exibe uma mensagem de "Fim do Programa". --* //
        Menus handlerMenus = new Menus();
        int isMenu = -1;
        while (isMenu != 99) {
            isMenu = handlerMenus.menu();
        }

    }

    public void exibirDadosGeral() {
        // *-- Função para percorrer o ArrayList utilizando foreach, e chamada do método
        // "exibirDados" para listar todos dados dos animais --* //
        for (Cachorro cachorro : cachorroArray) {
            cachorro.exibirDados();
            System.out.println();
        }
        System.out.println();
        for (Gato gato : gatoArray) {
            gato.exibirDados();
            System.out.println();
        }
        System.out.println();
        for (Passaro passaro : passaroArray) {
            passaro.exibirDados();
            System.out.println();
        }
    }

    public void listarDadosGeral() {
        // *-- Função para percorrer o ArrayList utilizando foreach, e chamada método
        // "listarDados" para listar 3 dos principais dados dos animais --* //
        for (Cachorro cachorro : cachorroArray) {
            System.out.println(cachorro.listarDados());
        }
        System.out.println();
        for (Gato gato : gatoArray) {
            System.out.println(gato.listarDados());
        }
        System.out.println();
        for (Passaro passaro : passaroArray) {
            System.out.println(passaro.listarDados());
        }
    }

    public void buscarNomeGeral() {
        // *-- Função para buscar um animal pelo nome nos três arraylist e devolver os
        // encontrados.--*//
        // *-- Usa a função formatador() para garantir que string inserida esterja
        // formatada para garantir que seja encontrada. --*//
        // *-- Utiliza um while que impede que a String inserida seja nula, vazia e/ou
        // não tenha caracteres.--*//
        boolean isInput = true;
        String nome = "teste";
        while (isInput) {
            System.out.println("Digite o nome do animal que deseja buscar: ");
            try {
                nome = buffReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (nome == null || nome.length() == 0 || nome.isEmpty()) {
                System.out.println("Erro! Tente novamente");
            } else {
                isInput = false;
            }
        }
        String nomeCorrigido = formatador(nome);
        boolean localizado = false;
        for (Cachorro cachorro : cachorroArray) {
            if (nomeCorrigido.contains(cachorro.getNome())) {
                cachorro.exibirDados();
                System.out.println();
                localizado = true;
            }
        }
        System.out.println();
        for (Gato gato : gatoArray) {
            if (nomeCorrigido.contains(gato.getNome())) {
                gato.exibirDados();
                System.out.println();
                localizado = true;
            }
        }
        System.out.println();
        for (Passaro passaro : passaroArray) {
            if (nomeCorrigido.contains(passaro.getNome())) {
                passaro.exibirDados();
                System.out.println();
                localizado = true;
            }
        }
        if (localizado == false) {
            System.out.println("Nome não localizado!! ");
        }
    }

    public String inputNome() {
        // *-- Função genérica de receber o nome do animal do usuário e devolver para o
        // programa --*/
        // *-- Usa a variável "nomeCorrigido" na função "formatador" para que todo
        // String inserido esteja
        // formatado em primeira letra maiúscula e o restante da String minúsculo --*//
        // *-- Utiliza um while que impede que a String inserida seja nula, vazia e/ou
        // não tenha caracteres.--*//
        boolean isInput = true;
        String nome = "teste";
        String nomeCorrigido;
        while (isInput) {
            System.out.println("Digite o nome do animal: ");
            try {
                nome = buffReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (nome == null || nome.length() == 0 || nome.isEmpty()) {
                System.out.println("Erro! Tente novamente");
            } else {
                isInput = false;
            }
        }
        nomeCorrigido = formatador(nome);
        return nomeCorrigido;
    }

    public String inputRaca() {
        // *-- Função genérica de receber a raça do animal do usuário e devolver para o
        // programa --*//
        // *-- Usa a variável "racaCorrigida" na função "formatador" para que todo
        // String inserido esteja
        // formatado em primeira letra maiúscula e o restante da String minúsculo --*//
        // *-- Utiliza um while que impede que a String inserida seja nula, vazia e/ou
        // não tenha caracteres.--*//
        boolean isInput = true;
        String raca = "teste";
        String racaCorrigida;
        while (isInput) {
            System.out.println("Digite a raça do animal: ");
            try {
                raca = buffReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (raca == null || raca.length() == 0 || raca.isEmpty()) {
                System.out.println("Erro! Tente novamente");
            } else {
                isInput = false;
            }
        }
        racaCorrigida = formatador(raca);
        return racaCorrigida;
    }

    public String inputPelagem() {
        // *-- Função genérica de receber a raça do animal do usuário e devolver para o
        // programa --*//
        // *-- Usa a variável "racaCorrigida" na função "formatador" para que todo
        // String inserido esteja
        // formatado em primeira letra maiúscula e o restante da String minúsculo --*//
        // *-- Utiliza um while que impede que a String inserida seja nula, vazia e/ou
        // não tenha caracteres.--*//
        boolean isInput = true;
        String pelagem = "teste";
        String pelagemCorrigida;
        while (isInput) {
            System.out.println("Digite a pelagem do animal: ");
            try {
                pelagem = buffReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (pelagem == null || pelagem.length() == 0 || pelagem.isEmpty()) {
                System.out.println("Erro! Tente novamente");
            } else {
                isInput = false;
            }
        }
        pelagemCorrigida = formatador(pelagem);
        return pelagemCorrigida;
    }

    public String inputCorPenas() {
        // *-- Função genérica de receber a raça do animal do usuário e devolver para o
        // programa --*//
        // *-- Usa a variável "racaCorrigida" na função "formatador" para que todo
        // String inserido esteja
        // formatado em primeira letra maiúscula e o restante da String minúsculo --*//
        // *-- Utiliza um while que impede que a String inserida seja nula, vazia e/ou
        // não tenha caracteres.--*//
        boolean isInput = true;
        String corPenas = "teste";
        String corPenasCorrigida;
        while (isInput) {
            System.out.println("Digite a cor das penas do pássaro: ");
            try {
                corPenas = buffReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (corPenas == null || corPenas.length() == 0 || corPenas.isEmpty()) {
                System.out.println("Erro! Tente novamente");
            } else {
                isInput = false;
            }
        }
        corPenasCorrigida = formatador(corPenas);
        return corPenasCorrigida;
    }

    public String inputCorOvos() {
        // *-- Função genérica de receber a raça do animal do usuário e devolver para o
        // programa --*//
        // *-- Usa a variável "racaCorrigida" na função "formatador" para que todo
        // String inserido esteja
        // formatado em primeira letra maiúscula e o restante da String minúsculo --*//
        // *-- Utiliza um while que impede que a String inserida seja nula, vazia e/ou
        // não tenha caracteres.--*//
        boolean isInput = true;
        String corOvos = "teste";
        String corOvosCorrigida;
        while (isInput) {
            System.out.println("Digite a cor dos ovos do ovíparo: ");
            try {
                corOvos = buffReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (corOvos == null || corOvos.length() == 0 || corOvos.isEmpty()) {
                System.out.println("Erro! Tente novamente");
            } else {
                isInput = false;
            }
        }
        corOvosCorrigida = formatador(corOvos);
        return corOvosCorrigida;
    }

    public String inputEspecie() {
        // *-- Função genérica de receber a espécie do animal do usuário e devolver para
        // o
        // programa --*//
        // *-- Usa a variável "especieCorrigida" na função "formatador" para que todo
        // String inserido esteja
        // formatado em primeira letra maiúscula e o restante da String minúsculo --*//
        // *-- Utiliza um while que impede que a String inserida seja nula, vazia e/ou
        // não tenha caracteres.--*//
        boolean isInput = true;
        String especie = "teste";
        String especieCorrigida;
        while (isInput) {
            System.out.println("Digite a especie do pássaro: ");
            try {
                especie = buffReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (especie == null || especie.length() == 0 || especie.isEmpty()) {
                System.out.println("Erro! Tente novamente");
            } else {
                isInput = false;
            }
        }
        especieCorrigida = formatador(especie);
        return especieCorrigida;
    }

    public String inputTipo() {
        // *-- Função genérica de receber o tipo do animal do usuário e devolver para o
        // programa --*//
        // *-- Usa a variável "tipoCorrigido" na função "formatador" para que todo
        // String inserido esteja
        // formatado em primeira letra maiúscula e o restante da String minúsculo --*//
        // *-- Utiliza um while que impede que a String inserida seja nula, vazia e/ou
        // não tenha caracteres.--*//
        boolean isInput = true;
        String tipo = "teste";
        String tipoCorrigido;
        while (isInput) {
            System.out.println("Digite a tipo do pássaro: ");
            try {
                tipo = buffReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (tipo == null || tipo.length() == 0 || tipo.isEmpty()) {
                System.out.println("Erro! Tente novamente");
            } else {
                isInput = false;
            }
        }
        tipoCorrigido = formatador(tipo);
        return tipoCorrigido;
    }

    public double inputIdade() {
        // *-- Função genérica de receber a idade do animal do usuário e devolver para o
        // programa --*//
        // *-- Tratamento de execção para evitar que o usuário insira o tipo errado de
        // dado para idade --*//

        double idade = -1;
        boolean done = false;
        while (!done) {
            try {
                System.out.println("Digite a idade do animal: ");
                idade = superScanner.nextDouble();
                if (idade > 0) {
                    done = true;
                } else {
                    System.out.println("Idade inválida, digite novamente");
                    superScanner.nextLine();
                    System.out.println();
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro! Tente novamente.");
                superScanner.next();
                System.out.println();
            } catch (Exception e) {
                System.out.println("Erro! Tente novamente.");
                superScanner.next();
                System.out.println();
            }
            System.out.println();
            // *-- No tratamento de exceção é feito de forma que o buffer do scanner é limpo
            // para evitar que
            // ele entre um loop infinito de InputMismatchException. Essa lógica é aplicada
            // em todos os momentos
            // do código que isso pode acontecer --* //

        }
        return idade;
    }

    public double inputPeso() {
        // *-- Função genérica de receber o peso do animal do usuário e devolver para o
        // programa --*//
        // *-- Tratamento de execção para evitar que o usuário insira o tipo errado de
        // dado para peso --*//

        double peso = 1;
        boolean done = false;
        while (!done) {
            try {
                System.out.println("Digite o peso do animal: ");
                peso = superScanner.nextDouble();
                if (peso > 0) {
                    done = true;
                } else {
                    System.out.println("Peso inválido, digite novamente");
                    superScanner.nextLine();
                    System.out.println();
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro! Tente novamente.");
                superScanner.next();
                System.out.println();
            } catch (Exception e) {
                System.out.println("Erro! Tente novamente.");
                superScanner.next();
                System.out.println();
            }
            System.out.println();
            // *-- No tratamento de exceção é feito de forma que o buffer do scanner é limpo
            // para evitar que
            // ele entre um loop infinito de InputMismatchException. Essa lógica é aplicada
            // em todos os momentos
            // do código que isso pode acontecer --* //
        }
        return peso;
    }

    public double inputAltura() {
        // *-- Função genérica de receber a altura do animal do usuário e devolver para
        // o programa --*//
        // *-- Tratamento de execção para evitar que o usuário insira o tipo errado de
        // dado para altura --*//
        double altura = -1;
        while (altura < 0) {
            System.out.println("Digite a altura do animal: ");
            try {
                altura = superScanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Erro! Tente novamente.");
                superScanner.next();
                System.out.println();
            } catch (Exception e) {
                System.out.println("Erro! Tente novamente.");
                superScanner.next();
                System.out.println();
            }
            if (altura < 0) {
                System.out.println("Altura inválida!");
                superScanner.next();
                System.out.println();
            }
            System.out.println();
            // *-- No tratamento de exceção é feito de forma que o buffer do scanner é limpo
            // para evitar que
            // ele entre um loop infinito de InputMismatchException. Essa lógica é aplicada
            // em todos os momentos
            // do código que isso pode acontecer --* //
        }
        return altura;
    }

    public String formatador(String stringInserida) {
        // *-- Função responsável por pegar a string inserida e formatar para que fique
        // com a primeira letra
        // maiúscula e as demais letras minúsculas --* //
        // *-- Primeiro ela torna todas as letras minúsculas. Depois, a string é
        // dividida em um array--* //
        // *-- Depois, em uma StringBuffer, cada palavra do array é adicionada e a sua
        // primeira letra muda
        // para maiúscula, deixando o resto minúsculo. Quando a palavra acaba, um espaço
        // é adicionado e o
        // loop segue até finalizar o array --*//
        // *-- Depois disso, a função retorna a StringBuffer em forma de String e faz um
        // ".trim()" para
        // evitar que a String devolvida tenha um espaço no final --* //
        String novaString = stringInserida.toLowerCase();
        String[] arrayDePalavras = novaString.split("\\s+");
        StringBuffer stringDeBuffer = new StringBuffer();

        for (int count = 0; count < arrayDePalavras.length; count++) {
            stringDeBuffer.append(Character.toUpperCase(arrayDePalavras[count].charAt(0)))
                    .append(arrayDePalavras[count].substring(1)).append(" ");
        }
        return stringDeBuffer.toString().trim();
    }

    public int getIndex(Integer IDprocurar, String tipoPet) {
        // *-- Função para ler o arraylist de determinado animal, procurando um elemento
        // específico
        // e retornando o index dele para o programa. Usa uma string "tipoPet" para
        // especificar o
        // arraylist que está procurando. Caso o tipoPet esteja incorreto, vai devolver
        // -1, dando
        // erro de ArrayIndexOutOfBoundsException, porém isso só acontece se o dev programar
        // a função de getIndex errado(). --*//
        int index = -1;
        switch (tipoPet) {
            case "Cachorro":
                for (int i = 0; i < Principal.cachorroArray.size(); i++) {
                    Cachorro cachorro = Principal.cachorroArray.get(i);
                    if (IDprocurar.equals(cachorro.getID())) {
                        return i;
                    }
                }
                break;
            case "Gato":
                for (int i = 0; i < Principal.gatoArray.size(); i++) {
                    Gato gato = Principal.gatoArray.get(i);
                    if (IDprocurar.equals(gato.getID())) {
                        return i;
                    }
                }
            case "Passaro":
                for (int i = 0; i < Principal.passaroArray.size(); i++) {
                    Passaro passaro = Principal.passaroArray.get(i);
                    if (IDprocurar.equals(passaro.getID())) {
                        return i;
                    }
                }
                break;
        }
        return index;
    }

}