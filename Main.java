/***************************************************
*                                                  *
* Leonardo Gabriel Mercurio Lino                   *
* 2018.0743.040-5                                  *
* Implementaçãoao 2                                *
* Disciplina: Estruturas de Dados e Programação I  *
* Professor: Ronaldo Fiorilo                       *
*                                                  *
***************************************************/

import java.util.Scanner;

public class Main {
    //Main que realiza leitura dos dados passados pelo usuário e chama as devidas funções.
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Arvore arvore = new Arvore();
        while (true) {
            String[] strOp = teclado.nextLine().split(" ");
            switch (strOp[0]) {
                case "insere":
                    if(strOp.length == 5){
                        arvore.insere(strOp[1], strOp[2], strOp[3], strOp[4]);
                    } 
                    break;
                case "busca":   
                    if(strOp.length == 2){
                        arvore.busca(strOp[1]);
                    }
                    break;
                case "remove":
                    if(strOp.length == 3){
                        arvore.remove(strOp[1], strOp[2]);
                    } else if(strOp.length == 2){
                        arvore.remove(strOp[1]);
                    }
                    break;
                case "lista":
                    if(strOp.length == 4){
                        arvore.lista(strOp[1], strOp[2], strOp[3]);
                    } else if(strOp.length == 2){
                        arvore.lista(strOp[1]);
                    } 
                    break;
                /*case "altura":
                    arvore.mostraAltura();
                    break;*/
                case "fim":
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }
}
