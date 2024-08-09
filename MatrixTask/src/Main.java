/*Дана матрица размера N*M.
 Преобразовать матрицу, поменяв  местами  минимальный и максимальный элемент вкаждой строке.*/

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input a number of rows: ");
        int rows = in.nextInt();
        while (rows<2) {
            System.out.println("Wrong number. Try again. (Number of rows must be greater than 1.)");
            rows = in.nextInt();
        }
        System.out.print("Input a number of columns: ");
        int columns = in.nextInt();
        while (columns<2) {
            System.out.println("Wrong number. Try again. (Number of columns must be greater than 1.)");
            columns = in.nextInt();
        }
        int[][] arr = new int[rows][columns];
        for (int i=0;i<arr.length;i++){
            for (int j=0;j<arr[0].length;j++){
                arr[i][j]=(int) ((-10)+(Math.random()*((10-(-10))+1)));
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();

        for (int i=0;i<arr.length;i++){
            int max=-100000;
            int min=100000;
            for (int j=0;j<arr[0].length;j++){
                if(min>arr[i][j]) min = arr[i][j];
                if(max<arr[i][j]) max = arr[i][j];
            }
            int k=0; int a=-1; int n=0;
            for (int z=0;z<arr[0].length;z++){
                if (arr[i][z]==min && k==0){ arr[i][z] = max; k+=1; a=z;}
                if (arr[i][z]==max && z!=a && n==0){ arr[i][z] = min; n+=1;}
            }
        }

        for (int i=0;i<arr.length;i++){
            for (int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println("That's all.");
    }
}