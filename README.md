# dictionary-avltree

Esta implementação foi um trabalho feito para a matéria de Estrutura de Dados I no curso de Sistemas de Informação da UFMS - CPTL.
Feita pelo discente Leonardo Gabriel Mercurio Lino e orientada pelo professor Ronaldo Fiorilo dos Santos.
É um dicionário utilizando a estrutura de dados Árvore AVL.
Para utilizá-lo é necessário apenas compilá-lo e executalo em qualquer compilador java.

Ele possui como comandos: 

1. insere <id1> <str1> <id2> <srt2>
2. remove <str>
3. remove <str1> <str2>
4. busca <str>
5. lista <id>
6. lista <id> <char1> <char2>
7. fim

Descrição dos comandos:

1. Insere um par de palavras na estrutura. Essa operacaao provoca duas insercoes na estrutura, a do par (<str1>, <str2>) e tambem a do par
(<str2>, <str1>). Uma palavra pode ter mais de um sinonimo, dessa forma, caso <str1> ja exista na estrutura, 
<str2> deve ser inserida como um dos possiveis sinonimos de <str1>, ao menos que <str2> ja esteja nessa lista de sinonimos. 
O mesmo vale para <str1> com relacao a <str2> ja pertencer a estrutura. <id1> e <id2> indicam os idiomas de <str1> e <str2>, respectivamente. 
Os idiomas aceitos por seu programa sao “pt” (portuguˆes) e “en” (inglˆes). Na
operacao de insercao considere sempre que <id1> # <id2>. Este comando nao gera nenhuma saida na tela.
Exemplos:
insere en car pt automovel
insere pt carro en car
Executando os comandos acima, serao inseridas 3 palavras na estrutura (car, automovel e carro).
A palavra car esta associada a dois sinonimos, enquanto as outras estao associadas a apenas um
sinonimo cada.

2. Busca a palavra <str> na estrutura. Caso a palavra nao seja encontrada na estrutura e exibida a mensagem “hein?”, sem as aspas, na tela. 
Caso contrario, as palavras sinonimas a digitada devem ser exibidas, uma em cada linha, em ordem alfabetica.
Exemplos:
busca car
automovel
carro
busca carro
car
busca carros
hein?

3. Remove a palavra <str> da estrutura. Este comando nao gera nenhuma saida
na tela.
Exemplo:
remove car
Ao executar esse comando a palavra car e removida da estrutura junto com sua lista de sinonimos,
logo se procurarmos por car nao devemos encontrar nada na estrutura. Repare, porem, que se
procurarmos por automovel ou carro, a palavra car continua como sinonimo de ambas.

4. Remove os pares de palavras (<str1>, <str2>) e (<str2>, <str1>) da estrutura. 
Caso a lista de sinonimos de uma das palavras removidas fique vazia, essa palavra deve ser removida da estrutura. 
Em outras palavras, essa operacao remove <str2>(<str1>) da lista de sinonimos de <str1>(<str2>) e remove <str1>(<str2>) 
caso a lista de sinonimos desta ultima fique vazia ao remover <str2>(<str1>). Este comando nao gera nenhuma saida na tela.
Exemplo:
remove car automovel
Ao executar o comando acima, sera removida a palavra automovel da lista de sinonimos de car,
que ainda continuara com carro como sinonimo, e tambem sera removida a palavra car da lista
de sinonimos de automovel. Como car e o unico sinonimo de automovel, a palavra automovel e
removida da estrutura, restando apenas as palavras car e carro na estrutura.

5. Lista, em ordem alfabetica, todas as palavras do idioma <id> presentes na estrutura, e seus respectivos sinonimos. 
Cada palavra e mostrada em uma linha, seguida pelos seus sinonimos. As palavras sao separadas dos seus sinonimos atraves de dois pontos, 
e os sinonimos sao separados entre si por vırgulas.
Exemplos:
lista en
car : automovel, carro
lista pt
automovel : car
carro : car

6. Lista, em ordem alfabetica, as palavras do idioma <id> que possuem as iniciais entre os caracteres <char1> e <char2>, 
inclusive, e seus respectivos sinonimos. Cada palavra e mostrada em uma linha, seguida pelos seus sinonimos. 
As palavras sao separadas dos seus sinonimos atraves de dois pontos, e os sinonimos sao separados entre si por vırgulas. Neste
comando considere sempre <char1> ≤ <char2>.
Exemplos:
lista pt a h
automovel : car
carro : car
lista en g s

7. Encerra a execucao do programa.
Exemplo:
fim

