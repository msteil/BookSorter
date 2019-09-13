/**
 *
 * This application reads titles of books in a input file called BookTitles.inp and writes them
 *  to an output file called uniqueTites.out,  removing any duplicate titles. Extensive notes due to it being a school project.
 *
 */


import java.io.*;

public class BookSorter {

   public static void main(String[] args) throws IOException {

    String book = null; //book title to compare
    String compareBook = null; //book titles to check for duplicates
    
    int count = 0; //stores place of book in list
    int duplicate = 0;// counts amount of duplicate books in the list
    
    //instantiate first file object
    FileReader file = new FileReader("bookTitles.inp");
    BufferedReader input = new BufferedReader(file);
    
    //instantiate a second file object to compare with first
    FileReader file2 = new FileReader("bookTitles.inp");
    BufferedReader input2 = new BufferedReader(file2);
    
    //output file with non duplicate titles
    FileWriter fw = new FileWriter("uniqueTitles.out");
    BufferedWriter bw = new BufferedWriter(fw);
    PrintWriter outFile = new PrintWriter(bw);

    //iterate through each title individualy until no titles left
    while((book = input.readLine()) != null)
    {
     
     count++; //counts current place on the list
     file2 = new FileReader("bookTitles.inp"); //instantiate a new list to iterate through
     input2 = new BufferedReader(file2);
    
     //iterate up to current place on the list
     for(int i = 0; i<count; i++)
     {
      compareBook = input2.readLine();
     }
     
     //nested loop to iterate through second list and count duplicates
     while((compareBook = input2.readLine()) != null)
     {
      if(book.equals(compareBook))
      {
       duplicate++; //count if there is a duplicate
      }
     }
     
     //once no duplicates add the book to output file
     if(duplicate == 0)
     {
      outFile.write(book);
      outFile.println();
     }
      
      duplicate = 0; //reset to zero for next iteration
    }
     
      //finally close the outfile
      outFile.close();
      System.out.println("Process complete please go to UniqueTitles.out file");
  }
}
