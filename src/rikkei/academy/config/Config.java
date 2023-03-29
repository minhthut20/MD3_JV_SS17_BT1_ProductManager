package rikkei.academy.config;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Config<T> {
    //DDọc file
    public static final String PATH_PRODUCT = "src/rikkei/academy/database/product.txt";
    public static Scanner scanner(){
        Scanner scanner = new Scanner(System.in);
        return scanner;
    }
    public List<T> readFromFile(String pathFile){
        List<T> tList = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(pathFile);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            tList = (List<T>) objectInputStream.readObject();
            fileInputStream.close();
            objectInputStream.close();
        }catch (FileNotFoundException erro){
            System.out.println("File Not Foun");
        }catch (IOException i ){
            System.out.println("IOEExceptoin");
        }catch (ClassNotFoundException c ){
            System.out.println("Class Not Found");
        }
        return tList;
    }
    // ghi file
    public void writeFile(String pathFile, List<T>tList){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(pathFile);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(tList);
            fileOutputStream.close();
            objectOutputStream.close();

        }catch (FileNotFoundException f){
            System.err.println("File Not Found");
        }catch (IOException i){
            System.err.println("IOE Exception");
        }
    }
}
