package matrix;

import java.io.*;
import java.util.*;

public class MatrixIO {
    public static Scanner scan;

    /* ===========================================*/
    /*                 MATRIX I/O                 */
    /* ===========================================*/

    /*=================== INPUT ==================*/
    public static void keyboardInputMatrix(Matrix M){
        scan = new Scanner(System.in);
        System.out.println("Masukkan elemen-elemen matriks");
        for (int i = 0; i < M.Row; i++){
            for (int j = 0; j < M.Col; j++){
                M.elements[i][j] = scan.nextDouble();
            }
        }
        System.out.println(""); // Biar ada newline (styling)
    }

    public static Matrix fileInputMatrix(){
        scan = new Scanner(System.in);
        System.out.println("Masukkan nama file (contoh: a.txt)");
        String filename = scan.nextLine();
        String path = "..\\test\\" + filename;
        System.out.println("Opening " + path + "...");

        try {
            int nRow, nCol;
            nRow = nCol = 0;
            File file = new File(path);
            Scanner scanFile = new Scanner(file);

            // Taro di luar? biar ngeliat m sekali aja
            while(scanFile.hasNextLine()){
                nCol = (scanFile.nextLine().split(" ").length);
                nRow++;
            }
            scanFile.close();

            // Create matrix
            Matrix M = new Matrix(nRow, nCol);
            scanFile = new Scanner(file);

            // Read file and assign each element
            for (int i = 0; i < nRow; i++){
                for (int j = 0; j < nCol; j++){
                    M.setElmt(i, j, scanFile.nextDouble());
                }
            }

            scanFile.close();
            return M;

        } catch (FileNotFoundException e) {
            System.out.println("File not found...");
            Matrix zero = new Matrix(1, 1);
            zero.setElmt(0, 0, 0);
            // return 0 nanti di cek di main sebagai boolean value
            return zero;
        }
    }

    /*=================== OUTPUT ==================*/

    public static void terminalOutputMatrix(Matrix M) {
        for (int i = 0; i < M.Row; i++){
            for (int j = 0; j < M.Col; j++){
                System.out.print(M.elements[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }

    public static void fileOutputMatrix(){

    }
    public static void printRow(Matrix M, int idx) {
        System.out.println(Arrays.toString(M.getRow(idx)));
     }
    public void printCol(Matrix M, int idx){
        double col[] = M.getCol(idx);
        int i;
        for (i = 0; i < M.Row;i++) {
            System.out.print("[");
            System.out.print(col[i]);
            System.out.print("]\n");
        }
    }

    // public static void fileOutMatrix(Matrix M){

    // }
    public static void main(String[] args) {
        Matrix M;
        M = fileInputMatrix();
        terminalOutputMatrix(M);
    }
}
