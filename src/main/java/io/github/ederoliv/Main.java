package io.github.ederoliv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

public class Main {

    //CONTRANTES UTILIZADAS
    static final char[] ALFABETO_MINUSCULO = {
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
    };

    static final int TAM_ALFABETO = 25;
    public static void main(String[] args) throws IOException {

        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        menu(buffer);

    }
    public static void cifra (BufferedReader buffer) throws IOException {

        String palavraCifrada = "";
        int novaChave;

        System.out.print("Digite uma palavra: ");

        String entradaUsuario = buffer.readLine().toLowerCase(Locale.getDefault());

        System.out.print("Digite uma chave (1 a 26): ");

        int chave = Integer.parseInt(buffer.readLine());


        for (int indiceEntrada = 0; indiceEntrada < entradaUsuario.length(); indiceEntrada++) {

            /*verifica se o caractere daquele laço for é um espaço, caso seja, eu mantenho o espaço
            na mesmo posição da frase cifrada e incremeto o valor do indice que será usado pra buscar
            o caractere equivalente da frase no alfabeto, para então fazer o reposicionamento com a chave
             */
            if (Character.isWhitespace(entradaUsuario.charAt(indiceEntrada))) {

                palavraCifrada = palavraCifrada + " ";
                indiceEntrada++;

            }


            for (int indiceAlfabeto = 0; indiceAlfabeto <= TAM_ALFABETO; indiceAlfabeto++ ){

                if((indiceAlfabeto + chave) > TAM_ALFABETO){

                    if (entradaUsuario.charAt(indiceEntrada) == ALFABETO_MINUSCULO[indiceAlfabeto]) {

                        novaChave = ((indiceAlfabeto + chave) - TAM_ALFABETO);
                        palavraCifrada = palavraCifrada + ALFABETO_MINUSCULO[novaChave - 1];

                    }

                }else {

                    if (entradaUsuario.charAt(indiceEntrada) == ALFABETO_MINUSCULO[indiceAlfabeto]) {

                        palavraCifrada = palavraCifrada + ALFABETO_MINUSCULO[indiceAlfabeto + chave];
                    }
                }
            }
        }

        System.out.println("Palavra Cifrada: " + palavraCifrada);

    }


    public static void decifra() throws IOException{
        System.out.println("Decifra");
    }

    public static void bruteForce(BufferedReader buffer) throws IOException{
        System.out.println("Força Bruta!");

        String palavraCifrada = "";
        int novaChave;

        System.out.print("Digite uma palavra: ");

        String entradaUsuario = buffer.readLine().toLowerCase(Locale.getDefault());

        System.out.print("Digite uma chave (1 a 26): ");

        int chave = Integer.parseInt(buffer.readLine());


        for (int indiceBruteForce = 0; indiceBruteForce <= TAM_ALFABETO; indiceBruteForce++) {

            System.out.println("\n Chave: " + (indiceBruteForce + 1) + " Resultado: ");

            for (int indiceEntrada = 0; indiceEntrada < entradaUsuario.length(); indiceEntrada++) {

                if (Character.isWhitespace(entradaUsuario.charAt(indiceEntrada))) {

                    palavraCifrada = palavraCifrada + " ";
                    indiceEntrada++;

                }

                for (int indiceAlfabeto = 0; indiceAlfabeto <= TAM_ALFABETO; indiceAlfabeto++) {

                    if ((indiceAlfabeto + chave) > TAM_ALFABETO) {

                        if (entradaUsuario.charAt(indiceEntrada) == ALFABETO_MINUSCULO[indiceAlfabeto]) {

                            novaChave = ((indiceAlfabeto + chave) - TAM_ALFABETO);
                            palavraCifrada = palavraCifrada + ALFABETO_MINUSCULO[novaChave - 1];

                        }

                    } else {

                        if (entradaUsuario.charAt(indiceEntrada) == ALFABETO_MINUSCULO[indiceAlfabeto]) {

                            palavraCifrada = palavraCifrada + ALFABETO_MINUSCULO[indiceAlfabeto + chave];
                        }
                    }
                }
            }
        }

    }

    public static void menu (BufferedReader buffer) throws IOException{

        String opcao = "";

        while (true) {

            System.out.print("\nEscolha uma opção: \n 1 - Cifrar \n 2 - Decifrar \n 3 - Força bruta \n 0 - Sair \n opcao: ");
            opcao = buffer.readLine();

            switch (opcao) {
                case "1" -> cifra(buffer);
                case "2" -> decifra();
                case "3" -> bruteForce(buffer);
                case "0" -> System.exit(0);
            }
        }


    }
}