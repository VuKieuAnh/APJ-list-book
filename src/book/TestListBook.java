package book;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class TestListBook {
    public static void main(String[] args) {
        int count = 0;
        double sum = 0;
        ProgrammingBook p1 = new ProgrammingBook("Javascript for dummies",50,"Javascript");
        ProgrammingBook p2 = new ProgrammingBook("Effective Java",30,"Java");
        ProgrammingBook p3 = new ProgrammingBook("C++ for beginner",40,"C++");
        ProgrammingBook p4 = new ProgrammingBook("Everything you need with Java",200,"Java");
        ProgrammingBook p5 = new ProgrammingBook("Data Analyst with Python",50,"Python");

        FictionBook f1 = new FictionBook("Star war",30);
        FictionBook f2 = new FictionBook("My name is red",28);
        FictionBook f3 = new FictionBook("Calling of the wild",34);
        FictionBook f4 = new FictionBook("Hannibal",16);
        FictionBook f5 = new FictionBook("Into the star",19);

        Book[] a = {p1,p2,p3,p4,p5,f1,f2,f3,f4,f5};
        ProgrammingBook[] a1 = {p1,p2,p3,p4,p5};

        for (Book i: a) {
            sum += i.getPrice();
        }

        System.out.println("Total book price: "+sum);

        for (ProgrammingBook i:a1) {
            if (i.getLanguage().equalsIgnoreCase("Java"))
                count++;
        }

        System.out.println("Java programming book total is: "+count);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a book name for price: ");
        String inputName = scanner.nextLine();
        System.out.println(binarySearch(a,inputName));
        System.out.println("\nBefore sort:");
        display(a);
        selectionSort(a);
        System.out.println("\nAfter sort by price:");
        display(a);
    }

    public static double linearSearch(Book[] a, String name) {
        for (int i=0;i<a.length;i++){
            if (a[i].getName().equalsIgnoreCase(name))
                return a[i].getPrice();
        }
        return -1;
    }

    public static void bubbleSort(Book[] a) {
        boolean next;
        for (int i=0;i<a.length-1;i++){
            next = false;
            for (int j=0;j<a.length-1-i;j++){
                if (a[j].getPrice()>a[j+1].getPrice()){
                    Book temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    next = true;
                }
            }
            if (!next){
                break;
            }
        }
    }

    public static <E> void display(E[] array) {
        for (E e:array) {
            System.out.println(e.toString());
        }
    }

    public static void insertionSort(Book[] a) {
        for (int i=1;i<a.length;i++) {
            Book temp=a[i];
            int j;
            for (j=i-1;j>=0 && a[j].getPrice() > temp.getPrice();j--){
                a[j+1] = a[j];
            }
            a[j+1] = temp;
        }
    }

    public static void selectionSort(Book[] a) {
        for(int i=0;i<a.length-1;i++){
            int minIndex = i;
            for (int j=i+1;j<a.length;j++){
                if (a[j].getPrice()<a[minIndex].getPrice()){
                    minIndex = j;
                }
            }
            Book temp = a[minIndex];
            a[minIndex] = a[i];
            a[i] = temp;
        }
    }

    public static double binarySearch(Book[] a, String name){
        sortName(a);
        int first = 0;
        int last = a.length-1;
        int mid;
        while (last>=first){
            mid = (first+last)/2;
            if (a[mid].getName().compareToIgnoreCase(name)==0) return a[mid].getPrice();
            else if (a[mid].getName().compareToIgnoreCase(name)<0) first = mid + 1;
            else last = mid - 1;
        }
        return -1;
    }

    public static void sortName(Book[] a) {
        Arrays.sort(a, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });
    }
}
