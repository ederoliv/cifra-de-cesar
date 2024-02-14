package io.github.ederoliv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

public class Main {
    public static void main(String[] args) throws IOException {

        final char[] ALFABETO_MINUSCULO = {
                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
                'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
        };

        final int TAM_ALFABETO = 25;

        String palavraCifrada = " ";

        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Digite uma palavra: ");

        String entradaUsuario = buffer.readLine().toLowerCase(Locale.getDefault());

        System.out.print("Digite uma chave (1 a 26): ");

        int chave = Integer.parseInt(buffer.readLine());
        int novaChave;

        System.out.println("Palavra original: " + entradaUsuario);

        for (int indiceEntrada = 0; indiceEntrada < entradaUsuario.length(); indiceEntrada++) {

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

        System.out.print("Palavra Cifrada: ");
        System.out.print(palavraCifrada);
    }
}