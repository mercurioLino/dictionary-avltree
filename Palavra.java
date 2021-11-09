/***************************************************
*                                                  *
* Leonardo Gabriel Mercurio Lino                   *
* 2018.0743.040-5                                  *
* Implementaçãoao 2                                *
* Disciplina: Estruturas de Dados e Programação I  *
* Professor: Ronaldo Fiorilo                       *
*                                                  *
***************************************************/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Palavra {
    //Estrutura de uma Palavra   
    private String nome;
    private List<String> sinonimos = new ArrayList<>();
    private String idioma;
    
    //Método Construtor
    public Palavra(String nome, String idioma) {
        this.nome = nome;
        this.idioma = idioma;
    }
    
    /*Método insereSinonimo, que recebe uma String por argumento e insere ela no List de Sinnimos da palavra, e depois, chama o método
    sort para ordenar essa lista de sinonimos*/ 
    public void insereSinonimo(String sinonimo){
        this.sinonimos.add(sinonimo);
        Collections.sort(sinonimos);
    }
    
    //Método imprimePalavra, que exibe seu nome e depois todos os seus sinônimos separados por virgula. 
    public void imprimePalavra() {
        int contador = 1;
        String str = this.nome + ": ";
        for(String sinonimo: this.sinonimos){
            if(contador < sinonimos.size()){
                str += sinonimo + ", ";
                contador++;
            } else{
                str += sinonimo;
            } 
        }
        System.out.println(str);
    }
    
    /*Método imprimeSinonimos, que imprime todos os sinônimos da palavra quebrando linha entre cada um*/
    public void imprimeSinonimos(){
        this.sinonimos.forEach((sinonimo) -> {
            System.out.println(sinonimo);
        });
    }
    
    //Getters e Setters
    public List<String> getSinonimos() {
        return sinonimos;
    }

    public void setString(List<String> sinonimos) {
        this.sinonimos = sinonimos;
    }
     
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }
  
}
