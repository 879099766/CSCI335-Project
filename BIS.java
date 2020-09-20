/**
 * Hui (Henry) Chen    ID: 1242445
 * CSCI 335/ Fall 2019 – M01
 * Dr. Gu
 * Project – Binary Insertion Sort Algorithm
 * Dec 03, 2019
 *
 * BIS.java
 */
package CSCI335.test03;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class BIS {
  private ArrayList<Person> person;

  public BIS(String file_path) {
    // creates a new ArraryList and reads file
    person = new ArrayList<Person>();
    readTXT(file_path);
  }

  public void readTXT(String path) {
    // reads file from the given path
    try {

      int id;
      String name;
      int age;
      double gpa;
      Person temp;

      Scanner scanner = new Scanner(new File(path));

      while (scanner.hasNext()) {
        Scanner line = new Scanner(scanner.nextLine()).useDelimiter(",");

        id = line.nextInt();
        name = line.next();
        age = line.nextInt();
        gpa = line.nextDouble();

        temp = new Person(id, name, age, gpa);
        person.add(temp);

        // output the original source
        System.out.println(id + "\t\t" + name + "\t\t" + age + "\t\t" + gpa);
      }

    } catch (Exception err) {
      System.out.println("An error has occurred due to: " + err.getLocalizedMessage());
    }

  }

  public void sort() {
    // sort the arrarylist by using binary insertion sort algorithm
    int i, j, mid;
    Person temp;

    for (i = 1; i < person.size(); i++) {
      int left = 0;
      int right = i - 1;
      temp = person.get(i);

      while (left <= right) {
        // binary search section

        mid = (int) Math.floor((left + right) / 2);

        if (temp.getId() > person.get(mid).getId())
          left = mid + 1;
        else
          right = mid - 1;

      }

      for (j = i; j > left; j--) {
        // insert the object to the correct position
        person.set(j, person.get(j - 1));
      }

      // insert to the specified location
      person.set(left, temp);
    }
  }

  public String display_afterSort(){
    // loop through the arrarylist
    // OUTPUT: return the formatted arrarylist
    String result = "";

    for(int x = 0; x < person.size(); x++)
      result += person.get(x).getId() + " \t\t" + person.get(x).getName() + "\t\t" + person.get(x).getAge() + "\t\t" + person.get(x).getGpa() + "\n";

    return result;
  }

  public void fileWriter(String path) {
    // write sorted list to user defined path
    try {
      File f = new File(path);
      FileOutputStream fw = new FileOutputStream(f);
      BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(fw));

      for (int x = 0; x < person.size(); x++)
        bf.write(person.get(x).getId() + "," + person.get(x).getName() + "," + person.get(x).getAge() + "," + person.get(x).getGpa() + "\n");

      bf.close();
      System.out.println("Export data successfully!");

    } catch (Exception err) {
      System.out.println("File write failed due to: " + err);
    }
  }

}
