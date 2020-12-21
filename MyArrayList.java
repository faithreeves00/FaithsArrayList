package myarraylist;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MyArrayList {

    public static void main(String[] args) {
        
        FaithsArrayList<String> a = new FaithsArrayList<>();
        
        BufferedReader keyboardReader = new BufferedReader(new InputStreamReader(System.in)), 
        fileReader;
        
        String inFilePath, line, word;
        
        try {
            
            System.out.print("\nPlease enter the path for the input file: ");
            
            inFilePath = keyboardReader.readLine();
            
            fileReader = new BufferedReader(new FileReader(inFilePath));

            while (true) {
                
                line = fileReader.readLine();
                
                if (line == null) {
                    break;
                }
                
                a.add(line);
            } // while not end of file

            System.out.print("\n\nPlease enter the word you want to search for: ");
            
            word = keyboardReader.readLine();

            if (a.indexOf(word) >= 0) {
                System.out.println(word + " was found.\n\n");
            } 
            
            else {
                System.out.println(word + " was not found.\n\n");
            }
            
            System.out.print("Please enter the word you want to remove: ");
            
            word = keyboardReader.readLine();

            int removalCount = 0;
            
            while (a.remove(word)) {
                removalCount++;
            }

            switch (removalCount) {
                case 0 -> System.out.println(word + " was not found, so not removed.\n\n");
                case 1 -> System.out.println("The only instance of " + word + " was removed.\n\n");
                default -> System.out.println("All " + removalCount + " instances of " + word + " were removed.\n\n");
            }

            System.out.print("Please enter the word you want to append: ");
            
            word = keyboardReader.readLine();
            
            a.add(word);
            
            System.out.println(word + " was appended.\n\n");
            
            System.out.print("Please enter the word you want to upper case: ");
          
            word = keyboardReader.readLine();

            int position = a.indexOf(word);
            
            if (position >= 0) {
                a.set(position, word.toUpperCase());
                System.out.println(word + " was converted to upper-case.\n\n");
            } 
            
            else {
                System.out.println(word + " was not found, so not upper-cased.\n\n");
            }
            
            System.out.println("Here is the final version:\n" + a);
        } // try
        
        catch (IOException e) {
            System.out.println(e);
        } // catch   
    } // method main  
}
