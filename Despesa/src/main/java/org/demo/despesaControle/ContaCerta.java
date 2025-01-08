/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.demo.despesaControle;

import java.util.Scanner;

/**
 *
 * @author breno.santos
 * @version 1.0.1
 */
public class ContaCerta {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            boolean continuar = true;
            while (continuar) {
                System.out.println("****************************************************************************");
                System.out.println("BEM VINDO AO CONTA CERTA, SEU SISTEMA DE GESTÃO FINANCEIRO R$\n");
                System.out.println("QUE TAL SELECIONAR UMA DAS OPÇÕES ABAIXO PARA CONTINUARMOS?\n");
                System.out.println(
                        "\n---------- 1 para Vendedor ----------\n---------- 2 para Passageiro ----------\n---------- 3 para Administrador ----------\n---------- 0 para Sair ----------");

                int opcao = sc.nextInt();
                switch (opcao) {
                    case 0:
                        continuar = false;
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opção inválida!");
                    case 1:
                        System.out.println("---------- MENU VENDEDOR ----------\nSELECIONE UMA DAS OPÇÕES");
                        System.out.println("1 - CADASTRAR PASSAGEIRO\n2 - VENDER PASSAGEM");
                }
            }

        } catch (

        Exception exception) {
            exception.printStackTrace();
        } finally {
        }

    }
}
