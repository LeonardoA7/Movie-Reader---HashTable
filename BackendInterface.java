import java.util.NoSuchElementException;
import java.util.LinkedList;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList; 
public interface BackendInterface {
  public void addGenre(String genre);
  public void addAvgRating(String rating);
  public void removeGenre(String genre);
  public void removeAvgRating(String rating);
  public List<String> getGenres();
  public List<String> getAvgRatings();
  public int getNumberOfMovies();
  public List<MovieInterface> getThreeMovies(int startingIndex);
  public List<String> getAllGenres();
  }