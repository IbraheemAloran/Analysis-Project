
import java.io.*;
import java.util.ArrayList;
import java.util.*;
import java.util.Arrays;
class Phase2 {
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

class FileManager{
	private ArrayList<String> lines;
	Scanner inputStream = null;
	PrintWriter outputStream = null;
	String filename;
	Scanner kb = new Scanner(System.in);
	public FileManager(String filename) {
		lines = new ArrayList<String>();
		this.filename = filename;
		try {
			inputStream = new Scanner(new FileInputStream(filename));
			while(inputStream.hasNextLine()) {
				lines.add(inputStream.nextLine());
			}
		}
		catch(FileNotFoundException f) {
			System.out.println(f);
		}
		inputStream.close();
		System.out.printf("Items have been loaded from %s\n", filename);
		for(int i=0;i<lines.size();i++) {
			System.out.println(lines.get(i));
		}
	}
	public void search() {
		String key;
		System.out.println("What would you like to search for?");
		key = kb.nextLine();
		for(int i=0;i<lines.size();i++) {
			if(lines.get(i).contains(key)) {
				System.out.printf("%d %s\n", i,lines.get(i));
			}
		}
	}
	public void save() {
		try {
			outputStream = new PrintWriter(new FileOutputStream(filename));
			for(int i=0;i<lines.size();i++) {
				outputStream.println(lines.get(i));
			}
		}
		catch(FileNotFoundException f) {
			System.out.println(f);
		}
		outputStream.close();
		System.out.printf("Items have been saved to %s\n", filename);
	}
	public void add() {
		int num;
		System.out.println("Please Enter the record in comma format (word,word,word,etc)");
		num = kb.nextInt();
		for(int i=0; i < num; i++) {
			System.out.println("Please enter the record in comma format (word,word,word,etc)");
			lines.add(kb.nextLine());
		}
	}
	public void update() {
		lines.clear();
		try {
			inputStream = new Scanner(new FileInputStream(filename));
			while(inputStream.hasNextLine()) {
				lines.add(inputStream.nextLine());
			}
		}
		catch(FileNotFoundException f) {
			System.out.println(f);
		}
		inputStream.close();
		System.out.println("Which Record would you like to update?");
		for(int i=0;i<lines.size();i++) {
			System.out.printf("%d %s\n", i,lines.get(i));
		}
		lines.remove(kb.nextInt());
		kb.nextLine();
		System.out.println("What would you like to change it too? (format: word,word,word,etc)");
		lines.add(kb.nextLine());
	}
}

