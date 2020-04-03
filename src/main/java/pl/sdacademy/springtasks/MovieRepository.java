package pl.sdacademy.springtasks;

import java.util.List;
import java.util.Optional;

public interface MovieRepository {

  Optional<Movie> findById(Long id);
  List<Movie> findAll();
  Movie save(Movie movie);
  Movie update(final Movie movie);
  void deleteById(final Long id);
}
