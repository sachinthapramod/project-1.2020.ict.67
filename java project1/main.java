import java.util.*;

class Main{
	public static void main(String[] args){
		Book[] books = {
			new Book("The Catcher in the Rye", "B001", "J.D. Salinger", 240),
			new Book("To Kill a Mockingbird", "B002", "Harper Lee", 281),
			new Book("1984", "B003", "George Orwell", 328),
			new Book("Pride and Prejudice", "B004", "Jane Austen", 432),
			new Book("The Hobbit", "B005", "J.R.R. Tolkien", 320)
		};

		Magazine[] megazines = {
			new Magazine("National Geographic", "M001", "August 2023", "National Geographic Society"),
			new Magazine("Time", "M002", "September 2023", "Time USA, LLC"),
			new Magazine("Forbes", "M003", "June 2023", "Forbes Media"),
			new Magazine("Vogue", "M004", "July 2023", "Condé Nast"),
			new Magazine("Sports Illustrated", "M005", "July 2023", "Maven Coalition")
		};

		LibraryMember[] libraryMembers = {
			new LibraryMember("L001", "John Doe"),
			new LibraryMember("L002", "Jane Smith"),
			new LibraryMember("L003", "David Johnson"),
			new LibraryMember("L004", "Sarah Williams"),
			new LibraryMember("L005", "Michael Brown")
		};

		Scanner s = new Scanner(System.in);

		System.out.println("\nBooks:");
		for(Book book:books){
			System.out.print("Checking Book Name : " + book.getTitle() + " (true or false) : ");
			String input = s.next();
			if(input.equalsIgnoreCase("true")){
				book.setCheck(true);
				System.out.println("\nChecked!" + book.displayItemDetails());
			}else if(input.equalsIgnoreCase("false")){
				book.setCheck(false);
				System.out.println("Not Checked!" + book.displayItemDetails());
			}else{
				System.out.println("You Entered Mistake Plz Enter True or False");
			}
			System.out.println();
		}

		System.out.println("\n\nMagazines:");
		for(Magazine megazine:megazines){
			System.out.print("Checking Magazine Name : " + megazine.getTitle() + " (true or false) : ");
			String input = s.next();
			if(input.equalsIgnoreCase("true")){
				megazine.setCheck(true);
				System.out.println("\nChecked!" + megazine.displayItemDetails());
			}else if(input.equalsIgnoreCase("false")){
				megazine.setCheck(true);
				System.out.println("Not Checked!" + megazine.displayItemDetails());
			}else{
				System.out.println("You Entered Mistake Plz Enter True or False");
			}
			System.out.println();
		}

		System.out.println("\nLibrary Members:");
		for(LibraryMember libraryMember:libraryMembers){
			System.out.print("Checking Library Member Name : " + libraryMember.getName() + " (true or false) : ");
			String input = s.next();
			if(input.equalsIgnoreCase("true")){
				System.out.println("Checked!" + libraryMember.displayMemberDetails());
			}else if(input.equalsIgnoreCase("false")){
				System.out.println("Not Checked!" + libraryMember.displayMemberDetails());
			}else{
				System.out.println("You Entered Mistake Plz Enter True or False");
			}
			System.out.println();
		}
	}
}
//----------------------------------------------library item class

abstract class LibraryItem{
	private String title;
	private String itemID;
	private boolean check;

	public LibraryItem(String title, String itemID){
		this.title = title;
		this.itemID = itemID;
		this.check = false;
	}

	public boolean getCheck(){
		return check;
	}

	public void setCheck(boolean check) {
        this.check = check;
    }

	public String displayItemDetails() {
       return "\nTitle: " + title + "\nItem ID: " + itemID;
    }

	public String getTitle(){
		return title;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getItemId(){
		return itemID;
	}

	public void setItemId(String itemID){
		this.itemID = itemID;
	}
}
//---------------------------------------------------book class;

class Book extends LibraryItem{
	private String author;
	private int numPages;

	public Book(String title, String itemID, String author, int numPages) {
        super(title, itemID);
        this.author = author;
        this.numPages = numPages;
    }

	public String displayItemDetails() {
        return super.displayItemDetails() + "\nAuthor: " + author + "\nNumber of Pages: " + numPages;
    }

	public int getNumPages(){
		return numPages;
	}

	public void setNumPages(int numPages){
		this.numPages = numPages;
	}

	public String getAuthor(){
		return author;
	}

	public void setAuthor(String author){
		this.author = author;
	}
}
//---------------------------------------------------magazine class;

class Magazine extends LibraryItem{
	private String issueDate;
	private String publisher;

	public Magazine(String title, String itemID, String issueDate, String publisher){
		super(title, itemID);
		this.issueDate = issueDate;
		this.publisher = publisher;
	}

	public String displayItemDetails() {
        return super.displayItemDetails() + "\nIssue Date: " + issueDate + "\nPublisher: " + publisher;
    }

	public String getIssueDate(){
		return issueDate;
	}

	public void setIssueDate(){
		this.issueDate = issueDate;
	}

	public String getPublisher(){
		return publisher;
	}

	public void setPublisher(String publisher){
		this.publisher = publisher;
	}
}
//------------------------------------------library member class;

class LibraryMember{
	private String memberID;
	private String name;

	LibraryMember(String memberID, String name){
		this.memberID = memberID;
		this.name = name;
	}

    public String displayMemberDetails() {
       return "\nMember ID: " + memberID + "\nName: " + name;
    }

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getMemberId(){
		return memberID;
	}

	public void setMemberId(String memberID){
		this.memberID = memberID;
	}
}