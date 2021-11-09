/***************************************************
*                                                  *
* Leonardo Gabriel Mercurio Lino                   *
* 2018.0743.040-5                                  *
* Implementaçãoao 2                                *
* Disciplina: Estruturas de Dados e Programação I  *
* Professor: Ronaldo Fiorilo                       *
*                                                  *
***************************************************/

public class OperacoesArvore {
               
    /*Este método recebe por argumento um nó (normalmente é passado a raiz), e os dados que compõem uma palavra.
    Então, verifica se a árvore é nula, se for, cria uma nova Palavra com os dados passados por argumento e a retorna.
    Se o No não for nulo, percorre recursivamente a arvore, comparando lexicograficamente o nome da palavra do no com 
    o nome da palavra passado por argumento, se a palavra for menor que a palavra do nó, chama o método recursivamente 
    para o filho esquerdo do no, se for maior, realiza o mesmo para o nó direito, se for igual, apenas adiciona o sinonimo
    passado por argumento no no. Por fim, atualiza a altura do nó que está no método e retorna a função realizaRotacao para
    realizar rotacoes na arvore caso necessário*/
    public static No insere(No no, String idioma, String str, String sinonimo){
        if(no == null){
            Palavra palavra = new Palavra(str, idioma);
            palavra.insereSinonimo(sinonimo);
            return new No(palavra);
        }
        if(no.getPalavra().getNome().compareTo(str) > 0){
            no.setEsquerda(insere(no.getEsquerda(), idioma, str, sinonimo));
        } else if(no.getPalavra().getNome().compareTo(str) < 0){
            no.setDireita(insere(no.getDireita(), idioma, str, sinonimo));
        } else {
            no.getPalavra().insereSinonimo(sinonimo);
        }
        atualizaAltura(no);
        return realizaRotacao(no);
    }
   
    /*Este método recebe por argumento um nó(normalmente a raiz), e uma String que condiz com o nome de uma palavra.
    Então, verifica se a árvoore é nula, se sim, retorna null e encerra o método, se não for, percorre recursivamente a
    árvore comparando lexicograficamente o nome da palavra do no com o nome da palavra passado por argumento, se a palavra
    passada por argumento for menor, chama novamente o método para o filho esquerdo do nó, se for maior, realiza o mesmo para 
    o filho direito, se for igual, verifica em qual dos casos de remoção se encontra esse caso, se ambos os filhos forem nulos 
    retorna nulo, se apenas um filho não for nulo retorna ele, e se ambos não forem nulos, seta o conteúdo do nó com o conteúdo
    do nó mais a direita da sub-árvore esquerda e remove o nó que subiu de posição. Por fim, atualiza a altura do nó que está no método 
    e retorna a função realizaRotacao para realizar rotacoes na arvore caso necessário*/
    public static No remove(No no, String str){
        if(no == null){
            return null;
        }
        if(no.getPalavra().getNome().compareTo(str) > 0){
            no.setEsquerda(remove(no.getEsquerda(), str));
        } else if(no.getPalavra().getNome().compareTo(str) < 0){
            no.setDireita(remove(no.getDireita(), str));
        } else{
            if(no.getEsquerda() == null && no.getDireita() == null){
                return null;
            } else if(no.getEsquerda() == null && no.getDireita() != null){
                return no.getDireita();
            } else if(no.getEsquerda() != null && no.getDireita() == null){
                return no.getEsquerda();
            } else{
                no.setPalavra(getMax(no.getEsquerda()));
                no.setEsquerda(remove(no.getEsquerda(), no.getPalavra().getNome()));
            }
        }
        atualizaAltura(no);
        return realizaRotacao(no);  
    }
    
    /*Este método recebe por argumento um nó (normalmante a raiz), uma string com o nome de uma palavra e o seu sinonimo, então, 
    busca a palavra com o nome passado por argumento na árvore, remove dela o sinonimo passado por argumento, e verifica se após a remoção
    do sinônimo a lista de sinônimos ficou vazia, se sim, remove ela da árvore chamando o método remove*/
    public static No remove(No no, String str, String sinonimo){
        No noAux = buscaNo(no, str);
        if(noAux == null){
            return null;
        }
        noAux.getPalavra().getSinonimos().remove(sinonimo);
        if(noAux.getPalavra().getSinonimos().isEmpty()){
            no = remove(no, str);
        }
        return no;
    }
    
    /*Este método recebe por argumento um No, e um idioma, então percorre a árvore a partir desse nó com um
    percurso em ordem, exibindo para o usuário apenas as palavras que tem como idioma o mesmo que passado por argumento*/
    public static void lista(No no, String idioma){
        if(no!= null){
            lista(no.getEsquerda(), idioma);
            if(no.getPalavra().getIdioma().trim().toLowerCase().matches(idioma.trim().toLowerCase())){
                no.getPalavra().imprimePalavra();
            }
            lista(no.getDireita(), idioma);
        }
    }
    
    /*Este método recebe por argumento um No, um idioma, e dois caracteres, então percorre a árvore a partir desse nó com um
    percurso em ordem, exibindo para o usuário apenas as palavras que tem como idioma o mesmo que passado por argumento e
    que tem o caractere inicial entre os dois passados por argumento*/
    public static void lista(No no, String idioma, String letra1, String letra2){
        if(no!= null){
            lista(no.getEsquerda(), idioma, letra1, letra2);
            if((no.getPalavra().getIdioma().trim().toLowerCase().matches(idioma.trim().toLowerCase())) 
                    && ((int) no.getPalavra().getNome().charAt(0) >= (int) letra1.charAt(0)) 
                    && ((int) no.getPalavra().getNome().charAt(0) <= (int) letra2.charAt(0))){
                no.getPalavra().imprimePalavra();
            }
            lista(no.getDireita(), idioma, letra1, letra2);
        }
    }
    
    /*Este método recebe por argumento um No, e percorre a árvore recursivamente a partir deste nó buscando o que tem 
    palavra com maior valor, quando encontra, retorna essa palavra*/
    public static Palavra getMax(No no){
        if(no.getDireita() != null){
            return getMax(no.getDireita());
        }
        return no.getPalavra();
    }
    
    /*Este método realiza a rotação de um No. Ele começa calculando o Fb do No passado por argumento, se o Fb for 2,
    considera o filho esquerdo e atualiza também seu Fb, se o Fb do filho esquerdo for -1, realiza uma rotação a esquerda no filho esquerdo
    do No passado por argumento (caso em que é necessário a rotação dupla direita), retorna uma rotação direita nesse nó. Se o Fb for -2
    considera o filho direito e atualiza também seu Fb, se o Fb do filho esquerdo for -1, realiza uma rotação a direita no filho direito
    do No passado por argumento (caso em que é necessário a rotação dupla esquerda), retorna uma rotação esquerda nesse nó. Se não entrar em 
    nenhuma das condições, apenas retona o nó*/
    public static No realizaRotacao(No no){
        atualizaFb(no);
        if(no.getFb() == 2){
            atualizaFb(no.getEsquerda());
            if(no.getEsquerda().getFb() == -1){
                no.setEsquerda(rotacaoEsquerda(no.getEsquerda()));
            }
            return rotacaoDireita(no);
        }
        if(no.getFb() == -2){
            atualizaFb(no.getDireita());
            if(no.getDireita().getFb() == 1){
                no.setDireita(rotacaoDireita(no.getDireita()));
            }
            return rotacaoEsquerda(no);
        }
        return no;
    }
    
    /*Este método realiza uma rotação a direita em um Nó passado por argumento, criando uma nova raiz que recebe o filho esquerdo desse No
    e um outro No para armazenar o antigo filho direito da nova raiz, seta o novo filho direito da nova raiz com o no passado por argumento
    e seta a esquerda do no passado por argumento a antiga direita, atualiza a altura tanto do no passado por argumento quanto da nova raiz, 
    e por fim retorna a nova raiz*/
    public static No rotacaoDireita(No no){
        No novaRaiz = no.getEsquerda();
        No antigaDireita = novaRaiz.getDireita();
        novaRaiz.setDireita(no);
        no.setEsquerda(antigaDireita);
        atualizaAltura(no);
        atualizaAltura(novaRaiz);
        return novaRaiz;
    }
    
    /*Este método realiza uma rotação a esquerda em um Nó passado por argumento, criando uma nova raiz que recebe o filho direito desse No
    e um outro No para armazenar o antigo filho esquerdo da nova raiz, seta o novo filho esquerdo da nova raiz com o no passado por argumento
    e seta a direita do no passado por argumento a antiga esquerda, atualiza a altura tanto do no passado por argumento quanto da nova raiz, 
    e por fim retorna a nova raiz*/
    public static No rotacaoEsquerda(No no){
        No novaRaiz = no.getDireita();
        No antigaEsquerda = novaRaiz.getEsquerda();
        novaRaiz.setEsquerda(no);
        no.setDireita(antigaEsquerda);
        atualizaAltura(no);
        atualizaAltura(novaRaiz);
        return novaRaiz;
    }
  
    /*Este método atualiza a altura de um nó passado por argumento, setando sua nova altura como a maior altura entre seus dois filhos +1*/
    public static void atualizaAltura(No no){
        if(altura(no.getEsquerda()) >= altura(no.getDireita())){
            no.setAltura(altura(no.getEsquerda()) + 1);
        } else{
            no.setAltura(altura(no.getDireita()) + 1);
        }
    }
    
    /*Este método retorna a altura de um nó passado por argumento, se ele não for nulo, retorna seu método getAltura, se for, retorna 0*/
    public static int altura(No no){
        if(no!= null){
            return no.getAltura();
        }else{
            return 0;
        }
    }
    
    /*Este método atualiza o Fb de um nó passado por argumento, para o valor da altura do seu filho esquerdo - valor do seu filho direito*/
    public static void atualizaFb(No no){
        no.setFb(altura(no.getEsquerda()) - altura(no.getDireita()));
    }
    
    /*Este método recebe por argumento um No (normalmente a raiz) e o nome de uma palavra, então, percorre a árvore recursivamente 
    a partir deste nó buscando o que tem palavra com maior valor, quando encontra, retorna essa palavra*/
    public static No buscaNo(No no, String palavra){
        if(no == null){
            return null;
        }
        if(no.getPalavra().getNome().compareTo(palavra) > 0){
            return buscaNo(no.getEsquerda(), palavra);
        } else if(no.getPalavra().getNome().compareTo(palavra) < 0){
            return buscaNo(no.getDireita(), palavra);
        } else{
            return no;
        }
    }
    
    /*MÉTODO PARA MOSTRAR OS NÓS COM SUA ALTURA
    private static void mostraAltura(No no){
        if(no != null){
            mostraAltura(no.getEsquerda());
            System.out.println(no.getPalavra().getNome() + ": " + no.getAltura());
            mostraAltura(no.getDireita());
        }
    }*/
}
