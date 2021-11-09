/***************************************************
*                                                  *
* Leonardo Gabriel Mercurio Lino                   *
* 2018.0743.040-5                                  *
* Implementaçãoao 2                                *
* Disciplina: Estruturas de Dados e Programação I  *
* Professor: Ronaldo Fiorilo                       *
*                                                  *
***************************************************/

public class Arvore{
    
    //Nó raiz da árvre
    private No raiz;
    
	public Arvore(){
		
	}
    /*Realiza a chamada do método insere da classe OperacoesArvore para as duas palavras passadas por argumento, inserindo elas na árvore*/
    public void insere(String id1, String str1, String id2, String str2) {
        this.raiz = OperacoesArvore.insere(this.raiz, id1, str1, str2);
        this.raiz = OperacoesArvore.insere(this.raiz, id2, str2, str1);
    }
    
    /*Realiza a chamada do método remove da classe OperacoesArvore para a palavra passada por argumento, removendo ela da árvore.*/
    public void remove(String str) {
        this.raiz = OperacoesArvore.remove(this.raiz, str);
    }
    
    /*Realiza a chamada do método remove da classe OperacoesArvore para as palavras passadas por argumento, removendo a palavra 2 dos
    sinônimos da palavra 1, e a palavra 1 do sinônimos da palavra 2, desde que a palavra que terá o sinônimo removido não seja nula.*/
    public void remove(String str1, String str2){
        if(OperacoesArvore.buscaNo(raiz, str1) != null){
            this.raiz = OperacoesArvore.remove(this.raiz, str1, str2);
        }
        if(OperacoesArvore.buscaNo(raiz, str2) != null){
            this.raiz = OperacoesArvore.remove(this.raiz, str2, str1);
        }
    }
    
    /*Realiza a chamada do método buscaNo da classe OperacoesArvore para buscar a palavra passada por argumento, se não a encontrar,
    mostra para o usuário a mensagem "hein?", se encontrar, chama o método imprimeSinonimos da Palavra que mostra para o usuário todos os
    sinônimos armazenados nela.*/
    public void busca(String str){
        if(OperacoesArvore.buscaNo(this.raiz, str) == null){
            System.out.println("hein?");
        }else{
            OperacoesArvore.buscaNo(this.raiz, str).getPalavra().imprimeSinonimos();
        }      
    }
    
    /*Realiza a chamada do método lista da classe OperacoesArvore, exibindo todas as palavras que tem como idioma o idioma passado por argumento*/
    public void lista(String idioma){
        OperacoesArvore.lista(this.raiz, idioma);
    }
    
    /*Realiza a chamada do método lista da classe OperacoesArvore, exibindo todas as palavras que tem como idioma o idioma passado por argumento
    e que possuem seu caractere inicial entre os dois caracterers passados por argumento*/
    public void lista(String idioma, String letra1, String letra2){
        OperacoesArvore.lista(this.raiz, idioma, letra1, letra2);
    }
    
    /*Realiza a chamada do método mostraAltura da classe OperacoesArvore, exibindo todas os No da arvore com a sua altura*/
    /*public static void mostraAltura(){
        mostraAltura(this.raiz);
    }*/   
}
