import java.util.List;
import java.util.HashMap;
import java.util.ArrayList; 

public class BackEnd implements BackendInterface{
  
  HashMap<String,ArrayList<MovieInterface>> genre = new HashMap<>(); 
  HashMap<String,ArrayList<MovieInterface>> ratings = new HashMap<>(); 
  
  
  public BackEnd(List<MovieInterface> movie_list) {
    //ArrayList<String> g = null; 
    
    for(MovieInterface m : movie_list)
    {
      if(genre.containsKey(m.getGenres())) //getGenre returns a String arraylist of all the genres that correspond to a movie 
      {
        genre.get(m.getGenres()).add(m); 
      }
      else
      {
        genre.put(m.getGenres(),m); 
      } 
    }
    
    for(Movie m : movie_list)
    {
      if(ratings.containsKey(m.getGenre))
      {
        ratings.get(m.getRating).add(m); 
      }
      else
      {
        ratings.put(m.getRating(),m); 
      } 
    } 
  }
  
  public BackEnd(String[] args)
  {
    
  }
  
  @Override
  public void addGenre(String genre) {
    genre.put(genre,new ArrayList<MovieInterface>());
    // go through genres and then add a new genre key value pair 
  }

  @Override
  public void addAvgRating(String rating) {
    ratings.put(rating,new ArrayList<MovieInterface>()); 
    //go through ratings hashmap you just add a new key value pair that corresponds to the rating 
  }

  @Override
  public void removeGenre(String genre) {
    if(genres.keySet().contains(genre))
    {
      genre.remove(genre); 
    }
    //go through the hashmap and remove the key value pair that corresponds to the genre 
  }

  @Override
  public void removeAvgRating(String rating) {
    if(ratings.keySet().contains(rating))
    {
      ratings.remove(rating); 
    }
    // go through hashmap and remove the specified rating 
    // remove key,value pair 
  }

  @Override
  public List<String> getGenres(){
    ArrayList<String> genre_List = genre.keySet(); 
    return genre_List; 
  }

  @Override
  public List<String> getAvgRatings() {
    ArrayList<String> average_rating = ratings.keySet(); 
    return average_rating; 
  }

  @Override
  public int getNumberOfMovies() {
    ArrayList<String> num_movies = genre.values(); 
    return num_movies.size(); 
  }

  @Override
  public List<String> getAllGenres() {
    ArrayList<String> genre_List = genre.keySet(); 
    return genre_List; 
  }

  @Override
  public List<MovieInterface> getThreeMovies(int startingIndex) {
    ArrayList<MovieInterface> final_movies = new ArrayList<>(); 
    ArrayList<String> string_ratings = (ArrayList<String>) ratings.keySet(); 
    ArrayList<Double> double_ratings = new ArrayList<>(); 
    for(String s : string_ratings)
    {
      double_ratings.add(Double.parseDouble(s)); 
    }
    Double max_rating = java.util.Collections.max(double_ratings);
    ArrayList<MovieInterface> max_movies = new ArrayList<>(); 
    max_movies = ratings.get(max_rating); 
    for(int i = startingIndex;i<startingIndex + 3;i++)
    {
      final_movies.add(max_movies.get(i)); 
    }
    return final_movies; 
    //check with the TA on this one 
    // maybe sort the ratings from high to low and then return 3 movies that after the specified index including the start 
    // Ex: startingIndex = 3. get the 3rd highest ranked movie,the 4th and 5th 
    //{6[],7[],8[]}
  }
  
  

}