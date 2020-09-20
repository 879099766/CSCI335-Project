/**
 * Hui (Henry) Chen    ID: 1242445
 * CSCI 335/ Fall 2019 – M01
 * Dr. Gu
 * Project – Binary Insertion Sort Algorithm
 * Dec 03, 2019
 *
 * Driver.java
 */
package CSCI335.test03;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

public class Driver {

  public static void main(String arg[]){
    try{
      /**
       * Steps:
       * 1. gets input source path
       * 2. asks sorted source's export path
       * 3. sends the path to BIS class
       * 4. reads the source from given path and then store the source to arraylist object
       * 5. sort the list by using binary insertion sorting algorithm
       * 6. EXTRA: count and display the runtime of the sort on the terminal
       * 7. display the list before and after the sort on the terminal
       * 8. export the sorted list to the given directory
       * */
      Scanner input = new Scanner(System.in);

      System.out.print("Please enter the path of the file: ");
      String file_path = input.nextLine();

      System.out.print("Please enter the file path that you want to export: ");
      String output_path = input.nextLine();

      System.out.println("========== Before sorting ==========");
      BIS bis = new BIS(file_path);

      long overall_start = System.currentTimeMillis();
      bis.sort();
      long overall_end = System.currentTimeMillis();

      System.out.println();
      System.out.println("========== After sorting ==========");
      System.out.println(bis.display_afterSort());
      bis.fileWriter(output_path);

      NumberFormat formatter = new DecimalFormat("#0.00000");
      System.out.print("Sort overall runtime is " + formatter.format((overall_end - overall_start) / 1000d) + " seconds");

    } catch (Exception err){
      System.out.println(err.getLocalizedMessage());
    }
  }
}
