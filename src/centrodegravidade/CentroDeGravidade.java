/*
    Felipe Ferreira dos Santos Cruz.
    Jady Cardoso de Queiroz.
*/

package centrodegravidade;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CentroDeGravidade {
    
    public static double[][] doc()throws FileNotFoundException ,IOException {
        FileReader arquivo = new FileReader("matriz.txt");
        BufferedReader leBufferizado = new BufferedReader(arquivo);
        String linha = leBufferizado.readLine();
        
        String[] dados = linha.split(" ");
        
        int vetor[] = new int[dados.length];
        
        for( int i = 0; i < vetor.length; i++ ){
            vetor[i] = Integer.parseInt(dados[i]); // Convertendo os textos do arquivo txt para inteiro.
        }
        
        double mt[][] = new double[vetor[0]][vetor[1]];
        
        System.out.println(vetor[0]+" "+vetor[1]);
        for( int i=0; i < vetor[0]; i++){
            linha = leBufferizado.readLine();
            dados = linha.split(" ");
            for( int j=0; j < vetor[1]; j++ ){
                mt[i][j] = Double.parseDouble(dados[j]);
                System.out.print(mt[i][j]+" ");
            }
        System.out.println("");
        }
        
        return mt;
    }
    
    // Metodo auxiliar para somar as linhas da matriz.
    public static double[] somaDasLinhas( double mt[][] ){
        // Criando um vetor com a quantidade de Linhas da Matriz.
        double linha[] = new double[mt.length];
        
        for( int i = 0; i < mt.length; i++ ){
            for( int j = 0; j < mt[i].length; j++ ){
                linha[i] = linha[i] + mt[i][j];
            }
        }

        return linha;
    }
    // Metodo auxiliar para somar as colunas da matriz.
    public static double[] somaDasColunas( double mt[][] ){
        // Criando um vetor com a quantidade de Colunas da Matriz.
        double coluna[] = new double[ mt[1].length ];

        for( int i = 0; i < mt[1].length; i++ ){
            for( int j = 0; j < mt.length; j++ ){
                coluna[i] = coluna[i] + mt[j][j];
            }
        }

        return coluna;
    }
    
    public static int indiceDifAbsoluta( double v1[] ){
        double a=0;
        double b=0;
        double c=0;
        double m=1000;
        int p=0;
        
        // colocamos o 1 para que ele não pegue o primeiro valor e o -1 para não pegar o ultimo valor
        for( int i=1 ; i < v1.length-1 ; i++ ){
            for( int j = i-1; j >= 0; j-- ){
                a = a + v1[j];
            }
            
            for( int j = i+1; j < v1.length; j++ ){
                b = b + v1[j];
            }
            
            c = a-b;
            if( c < 0){
                c = c * -1;
            }
            if( c < m ){
                m = c;
                p = i;
            }
            a = 0;
            b = 0;
            c = 0;
        }
        p++;
        return p;
    }
    
    public static void main(String[] args)throws FileNotFoundException ,IOException {
        double matriz[][];
        double somaLinha[], somaColuna[];
        int linha, coluna;
        
        matriz = doc();
        somaLinha = somaDasLinhas( matriz );
        somaColuna = somaDasColunas( matriz );
        linha = indiceDifAbsoluta( somaLinha );
        coluna = indiceDifAbsoluta( somaColuna );
        
        System.out.println("( "+linha+", "+coluna+" )");
        
    }
    
}
