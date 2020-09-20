/**
 * Hui (Henry) Chen    ID: 1242445
 * CSCI 335/ Fall 2019 – M01
 * Dr. Gu
 * Project – Binary Insertion Sort Algorithm
 * Dec 03, 2019
 *
 * Person.java
 */
package CSCI335.test03;

public class Person {
  public int id;
  public String name;
  public int age;
  public double gpa;
  public int size;

  public Person(){}

  public Person(int i, String n, int a, double g){
    this.id = i;
    this.name = n;
    this.age = a;
    this.gpa = g;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public double getGpa() {
    return gpa;
  }

  public void setGpa(double gpa) {
    this.gpa = gpa;
  }

  public int getSize(){
    return name.length();
  }

}
