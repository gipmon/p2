/* Rafael Ferreira */
/*###################################################
 *Podes consultar um guia sobre linux em GLUA.ua.pt
 *ou directamente em: http://glua.ua.pt/guiao.pdf
 *##################################################*/
/*
 * A instrução "rm arca/" permite eliminar o directório arca e todo o seu conteúdo. FALSE , para remover um diretório e todo o seu conteúdo é necessário executar a instrução rm -rf *diretorio*; o r vai remover o diretório e o f vai forçar a remoção
 
 * A instrução "mv lista.txt lista.old" permite mudar o nome ao ficheiro "lista.txt". TRUE
 
 * Para criar um sub-directório chamado  novo  no directório do utilizador (home directory), pode-se executar o comando mkdir ~/novo, qualquer que seja o directório actual. TRUE
 
 * A instrução "cat lista.txt" permite visualizar página-a-página o conteúdo do ficheiro "lista.txt". FALSE
Esta instrução imprime no ecrã o conteúdo do ficheiro lista.txt, para que fosse imprimido página a página teria de ser more lista.txt
 
 * 
 
 O Linux (UNIX) dispoe de diversos comandos de manipulacao de ficheiros. Eis alguns: 
 
 cat fic — imprime no dispositivo de sa ́ıda standard (por defeito o ecr ̃a) o conteu ́do do
 ficheiro fic.
 
 rm fic — remove (apaga) o ficheiro fic.
 
 mv fic1 fic2 — muda o nome do ficheiro fic1 para fic2.
 
 mv fic dir — move o ficheiro fic para dentro do direct ́orio dir.
 
 cp fic1 fic2 — cria uma c ́opia do ficheiro fic1 chamada fic2.
 
 cp fic dir — cria uma c ́opia do ficheiro fic dentro do direct ́orio dir.
 
 head fic — mostra as primeiras linhas do ficheiro de texto fic.
 
 tail fic — mostra as u ́ltimas linhas do ficheiro de texto fic.
 
 more fic — imprime no dispositivo de sa ́ıda standard (por defeito o ecr ̃a), p ́agina a p ́agina, o conteu ́do do ficheiro fic.
 grep padr~ao fic — selecciona as linhas do ficheiro texto fic que satisfazem o crit ́erio de selec ̧c ̃ao padr~ao.
 
 wc fic — conta o nu ́mero de linhas, palavras e caracteres do ficheiro fic.
 
 sort fic — ordena as linhas do ficheiro fic.
 
 find dir -name fic — procura um ficheiro com o nome fic a partir do direct ́orio dir.
 
 Al ́em destes pode ainda considerar outros tais como: less, cut, paste, tr, etc. Todos estes comandos podem ser invocados usando argumentos opcionais que configuram o seu modo de funcionamento.
 
 */