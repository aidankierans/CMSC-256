/** Song.java - 
 * An object that represents a song in a music collection.
 * 
 * @author Aidan Kierans
 * @version 1.0
 * @since Project 2 of CMSC 256, Fall 2017
 */
public class Song implements Comparable<Song> {
	private String title;
	private String artist;
	private String album;
	
	/** Default song constructor.
	 */
	public Song() {
		setTitle("");
		setArtist("");
		setAlbum("");
	}

	/** General purpose song constructor.
	 * 
	 * @param title The song title.
	 * @param artist The song artist or band.
	 * @param album The song album.
	 */
	public Song(String title, String artist, String album) {
			setTitle(title);
			setArtist(artist);
			setAlbum(album);
	}
	
	/** Gets the song title.
	 * @return the song's title. 
	 */
	public String getTitle() {
		return title;
	}

	/** Set and trim the song title.
	 * @param ti String to be set as the title.
	 */
	public void setTitle(String ti) {
		try{
			title = ti.trim();
		}
		catch(NullPointerException nullArg) {
			title = "";
		}
	}
	
	/** Gets the song artist.
	 * @return the song's artist.
	 */
	public String getArtist() {
		return artist;
	}

	/** Set and trim the song artist.
	 * @param ar String to be set as the artist.
	 */
	public void setArtist(String ar) {
		try{
			artist = ar.trim();
		}
		catch(NullPointerException nullArg) {
			artist = "";
		}
	}
	
	/** Gets the song album.
	 * @return the song's album.
	 */
	public String getAlbum() {
		return album;
	}

	/** Sets and trims the song album.
	 * @param al String to be set as the album.
	 */
	public void setAlbum(String al) {
		try{
			album = al.trim();
		}
		catch(NullPointerException nullArg) {
			album = "";
		}
	}
	
	/** Checks if this song's title, artist, and album match that of the argument song.
	 * @param arg  The song being compared to this one.
	 * @return true if the songs' toString methods return the same string, ignoring case. Otherwise,
	 * 			returns false.
	 */
	@Override
	public boolean equals(Object arg) {
		if(arg == null) {
			return false;
		}
		else if(this == arg) {
			return true;
		}
		else if(!(arg instanceof Song)) {
			return false;
		}
		Song other = (Song) arg;
		
		if(this.getTitle().equalsIgnoreCase(other.getTitle()) &&
				this.getAlbum().equalsIgnoreCase(other.getAlbum()) &&
				this.getArtist().equalsIgnoreCase(other.getArtist())) {
			return true;
		}
		return false;
	}
	
	/** Converts the song to a string by combining the title, artist, and album.
	 */
	@Override
	public String toString() {	
		return "Title: " + getTitle() +  "\nArtist: " + getArtist() + "\nAlbum: " + getAlbum() + "\n";
	}
	
	/** Compares this song's album and title lexicographically to those of the argument.
	 * @param arg  The song being compared to this one.
	 * @return -1, 0, or 1 based on the compareToIgnoreCase() of the songs' albums, or that of
	 * 			the songs' titles if the albums were equal, or that of the songs' artists if
	 * 			the songs' albums and title were both equal. Thus, the result is -1 if this song's
	 * 			album lexicographically precedes that of the argument song, et cetera.
	 */
	@Override
	public int compareTo(Song arg) throws NullPointerException {
		if(arg == null) {
			throw new NullPointerException();
		}
		
		int albumCompResult = this.getAlbum().compareToIgnoreCase(arg.getAlbum());
		
		if(albumCompResult != 0){
			return albumCompResult;
		}
		else { // albums are equal
			int titleCompResult = this.getTitle().compareToIgnoreCase(arg.getTitle());
			
			if (titleCompResult != 0) {
				return titleCompResult;
			}
			else { // titles are equal
				return this.getArtist().compareToIgnoreCase(arg.getArtist());
			}
		}
	}
}
