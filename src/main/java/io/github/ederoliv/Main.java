package io.github.ederoliv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        menu(buffer);

    }

    public static void menu (BufferedReader buffer) throws IOException{

        String opcao;

        System.out.println(CaesarCipher.LETREIRO);

        while (true) {

            System.out.print("Escolha uma opção: \n 1 - Cifrar \n 2 - Decifrar \n 3 - Força bruta \n 0 - Sair \n opcao: ");
            opcao = buffer.readLine();

            switch (opcao) {
                case "1" -> CaesarCipher.cifra(buffer);
                case "2" -> CaesarCipher.decifra(buffer);
                case "3" -> CaesarCipher.bruteForce(buffer);
                case "0" -> System.exit(0);
            }
        }
    }
}