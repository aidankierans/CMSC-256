import java.util.Scanner;
import java.io.File;
import java.util.EmptyStackException;
import java.util.NoSuchElementException;
import java.io.FileNotFoundException;
import java.lang.IllegalArgumentException;

/** SongReader.java - 
 * A tool for creating Song objects from a list within a file. The file is chosen via the command line.
 * 
 * @author Aidan Kierans
 * @version 1.0
 * @since Project 2 of CMSC 256, Fall 2017
 */
public class SongReader {

	private static LinkedStack<String> tagStack = new LinkedStack<String>(); // A linked stack that will hold tags
	private static Song currentSong = new Song();

	/** The main class primarily relies on Song and LinkedStack to work, in addition to the imported libraries.
	 * @param args 
	 */ 
	public static void main(String[] args) {
		printHeading();

		try{
			Scanner fileReader = openFile();

			String nextLine = fileReader.nextLine().trim();
			String previousLine = "";

			while(fileReader.hasNextLine()) {
				if (previousLine.startsWith("<") && previousLine.endsWith(">") 
						&& !(previousLine.startsWith("</")) ) { // Basically, "if previous line was an opening tag"
					try {
						addToTagStack(previousLine, nextLine); // May throw IllegalArgumentException
					} 
					catch(IllegalArgumentException nullArgument) { // Thrown if an empty set of tags was encountered
						while(!previousLine.equalsIgnoreCase("</song>")) { // Iterates until end of current song
							previousLine = fileReader.nextLine().trim(); // Moves the scanner down the file
						} // end of while
					} // end of catch
					catch(NullPointerException e) {
					}
				} // end of if

				if(previousLine.startsWith("</") && previousLine.endsWith(">")) { // Checks if previous line was a closing tag
					closeTag(previousLine);
				}

				previousLine = nextLine; // Saves the value of the current line so it can be used in future iterations
				try{
					nextLine = fileReader.nextLine().trim();
				}
				catch(NoSuchElementException e){
				}
			} // end of while loop
		} // end of try
		catch(FileNotFoundException noFile){
			System.out.println("There was an error opening or reading from the file.");
		}
	}

	/** Adds the parameter to the stack of tags if it denotes a title, artist, or album, and 
	 * 	saves the line following that tag to the appropriate parameter.
	 * @param previousLine A tag beginning with "<" and ending with ">".
	 * @param nextLine A title, artist, or album.
	 * @throws IllegalArgumentException If one of a song's fields is empty
	 */
	private static void addToTagStack(String previousLine, String nextLine) throws IllegalArgumentException {
		if(previousLine.equalsIgnoreCase("<title>")) {
			tagStack.push(previousLine);

			if(nextLine.equals("") || nextLine.equalsIgnoreCase("</title>") || nextLine.equals(null)) {
				throw new IllegalArgumentException("Songs cannot have null fields.");
			}
			else {
				currentSong.setTitle(nextLine); 
			}
		}
		if(previousLine.equalsIgnoreCase("<album>")) {
			tagStack.push(previousLine);

			if(nextLine.equals("") || nextLine.equalsIgnoreCase("</album>") || nextLine.equals(null)) {
				throw new IllegalArgumentException("Songs cannot have null fields.");
			}
			else {
				currentSong.setAlbum(nextLine);
			}
		}
		if(previousLine.equalsIgnoreCase("<artist>")) {
			tagStack.push(previousLine);

			if(nextLine.equals("") || nextLine.equalsIgnoreCase("</artist>") || nextLine.equals(null)) {
				throw new IllegalArgumentException("Songs cannot have null fields.");
			}
			else {
				currentSong.setArtist(nextLine);
			}
		}
	}

	/** Removes the previous tag from the top of the stack if it matches the
	 *  song, title, artist, or album tag parameter.
	 * @param previousLine A tag beginning with "</" and ending with ">".
	 */
	private static void closeTag(String previousLine) {
		if(previousLine.equalsIgnoreCase("</song>")) {
			endSong();
		}
		try {
			if(previousLine.equalsIgnoreCase("</title>")) {
				if (tagStack.peek().equalsIgnoreCase("<title>")) {
					tagStack.pop();
				}
				else {
					throw new IllegalArgumentException("Tags improperly closed.");
				}
			}			
			if(previousLine.equalsIgnoreCase("</album>")) {
				if (tagStack.peek().equalsIgnoreCase("<album>")) {
					tagStack.pop();
				}
				else {
					throw new IllegalArgumentException("Tags improperly closed.");
				}
			}			
			if(previousLine.equalsIgnoreCase("</artist>")) {
				if (tagStack.peek().equalsIgnoreCase("<artist>")) {
					tagStack.pop();
				}	
				else {
					throw new IllegalArgumentException("Tags improperly closed.");
				}
			}
		} 
		catch(IllegalArgumentException BadTags) {
		} // No action necessary
	}

	/** Prints the current song object and resets it for any future songs.
	 */
	private static void endSong() {
		try {
			System.out.println(currentSong.toString());

			if (!tagStack.pop().equalsIgnoreCase("<song>")) {
				throw new IllegalArgumentException("A tag was left unclosed.");
			}
		}
//		catch(IllegalArgumentException BadTag) {			
//			tagStack.clear();
//		}
		catch(EmptyStackException e) {
		}
		
		assert (tagStack.isEmpty());

		Song blankSong = new Song(); //Resets song data between songs
		currentSong = blankSong;
	}

	/** Prompts the user for a filepath, and scans the console for a response.
	 * @return User inputted filepath
	 */
	private static String promptForFilePath() {
		System.out.println("Enter the file path: ");
		Scanner input = new Scanner(System.in);
		String f = input.nextLine();

		input.close();
		return f;
	}

	
	/** Verify that the file exists, then creates a scanner to read it.
	 * @param fileName
	 * @return Scanner to read the file
	 * @throws FileNotFoundException
	 */
	private static Scanner openFile() throws FileNotFoundException {
		File file = new File("");
		file = new File(promptForFilePath());

		return new Scanner(file);
	}

	/** Prints a heading about the program to the console.
	 */
	private static void printHeading() {
		System.out.println("Aidan Kierans\nProject 2\nCMSC 256\nFall 2017");
	}

}
