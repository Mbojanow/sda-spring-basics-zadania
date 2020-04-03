package pl.sdacademy.springtasks;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class MovieCrudRepositoryTest {

  @Autowired
  private MovieRepository movieRepository;

  @Autowired
  private EntityManager entityManager;

  @AfterEach
  void tearDown() {
    entityManager.createQuery("DELETE FROM movies")
        .executeUpdate();
  }

  @Test
  void shouldNotFindMovieById() {
    final Optional<Movie> movie = movieRepository.findById(100L);

    assertThat(movie).isNotPresent();
  }

  @Test
  void shouldInsertMovie() {
    final Movie savedMovie = movieRepository.save(new Movie(null, "title1", 3));
    final Movie expectedMovie = new Movie(savedMovie.getId(),"title1", 3);

    assertThat(savedMovie)
        .isNotNull()
        .isEqualTo(expectedMovie);
  }

  @Test
  void shouldSelectMovieById() {
    final Movie movieToSave = new Movie(null, "title2", 5);
    final Movie savedMovie = movieRepository.save(movieToSave);
    final Movie expectedMovie = new Movie(savedMovie.getId(), "title2", 5);

    final Optional<Movie> movie = movieRepository.findById(savedMovie.getId());

    assertThat(movie)
        .isPresent()
        .hasValue(expectedMovie);
  }

  @Test
  void shouldUpdateMovie() {
    final Movie movieToSave = new Movie(null, "title3", 8);
    final Movie savedMovie = movieRepository.save(movieToSave);
    savedMovie.setLengthInMinutes(11);
    savedMovie.setTitle("NewTitle");

    final Movie updatedMovie = movieRepository.update(savedMovie);

    assertThat(updatedMovie).isEqualTo(savedMovie);
  }

  @Test
  void shouldDeleteMovie() {
    final Movie firstMovie = new Movie(null, "first", 11);
    final Movie secondMovie = new Movie(null, "second", 11);
    final Movie savedFirstMovie = movieRepository.save(firstMovie);
    final Movie savedSecondMovie = movieRepository.save(secondMovie);

    movieRepository.deleteById(savedSecondMovie.getId());

    final List<Movie> remainingMovies = movieRepository.findAll();
    assertThat(remainingMovies).hasSize(1).contains(savedFirstMovie);
  }

  @Test
  void shouldGetAllMovies() {
    final Movie firstMovie = new Movie(null, "Wacraft", 33);
    final Movie secondMovie = new Movie(null, "Starcraft", 22);
    final Movie savedFirstMovie = movieRepository.save(firstMovie);
    final Movie savedSecondMovie = movieRepository.save(secondMovie);

    final List<Movie> remainingMovies = movieRepository.findAll();

    assertThat(remainingMovies).containsExactlyInAnyOrder(savedFirstMovie, savedSecondMovie);
  }

  @Test
  void shouldBeAnnotatedWithRepository() {
    final Repository annotation = MovieCrudRepository.class.getDeclaredAnnotation(Repository.class);

    assertThat(annotation).isNotNull();
  }
}