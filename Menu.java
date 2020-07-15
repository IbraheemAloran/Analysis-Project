import java.io.*;
import java.util.ArrayList;
import java.util.*;
import java.util.Arrays;
class Menu {
	public static void main(String [] args) {
		Scanner kb = new Scanner(System.in);
		int option = 0;
		System.out.println("Please Enter the file name");
		FileManager fm = new FileManager(kb.nextLine());
		while(option != 5) {
			System.out.println("What would you like to do?");
			System.out.println("1. Make a new record");
			System.out.println("2. Update an existing record");
			System.out.println("3. Save to a file");
			System.out.println("4. Search the file");
			System.out.println("5. Exit");
			option = kb.nextInt();
			if(option == 1) {
				fm.add();
			}
			else if(option == 2) {
				fm.update();
			}
			else if(option == 3) {
				fm.save();
			}
			else if(option == 4) {
				fm.search();
			}
		}
	}
}
