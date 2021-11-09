/***************************************************
*                                                  *
* Leonardo Gabriel Mercurio Lino                   *
* 2018.0743.040-5                                  *
* Implementaçãoao 2                                *
* Disciplina: Estruturas de Dados e Programação I  *
* Professor: Ronaldo Fiorilo                       *
*                                                  *
***************************************************/

public class No {
    //Estrutura base de um No
    private Palavra palavra;
    private int altura = 1;
    private int fb;
    private No esquerda;
    private No direita;
    
    //Método Construtor
    public No(Palavra palavra) {
        this.palavra = palavra;
    }
    
    //Getters e Setters
    public int getAltura() {
        return altura;  
    }

    public int getFb() {
        return fb;
    }

    public void setFb(int fb) {
        this.fb = fb;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }
    
    public Palavra getPalavra() {
        return palavra;
    }

    public void setPalavra(Palavra palavra) {
        this.palavra = palavra;
    }

    public No getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(No esquerda) {
        this.esquerda = esquerda;
    }

    public No getDireita() {
        return direita;
    }

    public void setDireita(No direita) {
        this.direita = direita;
    }
  
}
