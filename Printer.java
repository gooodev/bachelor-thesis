import java.io.*;

public class Printer {
    public static void numberPrint(double num, String filename){
        try{
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(filename, true)));
            pw.print(num + "\n");
            pw.close();
        }catch(IOException e){
            System.out.println(e);
        }
    }
    public static void arrayPrint(double[] array, String filename){
        try{
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(filename,true)));
            for(double a : array) pw.print(a + ",");
            pw.print("\n");
            pw.close();
        }catch(IOException e){
            System.out.println(e);
        }
    }
    public static void twoArraysPrint(double[][] arrays, String filename){
        try{
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(filename, true)));
            for(int i = 0; i < arrays.length; i++){
                for(int j = 0; j < arrays[i].length; j++){
                    pw.print(arrays[i][j] + ",");
                }
                pw.print("\n");
            }
            pw.close();
        }catch(IOException e){
            System.out.println(e);
        }
    }
    public static void outPrint(double[] array){
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + ",");
        }
    }
    public static void outPrint(int[] array){
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + ",");
        }
    }
    public static void twoOutPrint(double[][] array){
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[i].length; j++){
                System.out.print(array[i][j] + ",");
            }
            System.out.println();
        }
    }
    public static void twoOutPrint(int[][] array){
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[i].length; j++){
                System.out.print(array[i][j] + ",");
            }
            System.out.println();
        }
    }
    public static void randomOutPrint(double[][][][] array){
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[i].length; j++){
                for(int k = 0; k < array[i][j].length; k++){
                    for(int l = 0; l < array[i][j][k].length; l++){
                        System.out.print(array[i][j][k][l] + " : ");
                    }
                    System.out.println();
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}