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
	/*public void load(){
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
		System.out.printf("Items have been loaded from %s\n", filename);
		for(int i=0;i<lines.size();i++) {
			System.out.println(lines.get(i));
		}
	}*/
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
}