import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;



public class Randnumbers {
    public  void GenerateNums(int l) throws IOException {
        String myPath ="Data.txt";
        File myFile = new File(myPath);

        PrintWriter outputFile=new PrintWriter(myPath);

        Random rd=new Random();
        int arr[]=new int[l];
        for (int i = 0; i < l; i++) {
            arr[i] = rd.nextInt(10000) ;
            outputFile.println(arr[i]);
        }
        outputFile.close();

    }
    public void Writenum(int arr[]) throws IOException{
        PrintWriter sortedFile=new PrintWriter("Sorted.txt");
        Scanner s = new Scanner(new File("Sorted.txt"));
        int[] array = new int[s.nextInt()];
        for (int i = 0; i < array.length; i++)
            array[i] = s.nextInt();

        for (int i = 0; i < array.length; i++) {
            sortedFile.println(array[i]);
        }
        sortedFile.close();


    }
}