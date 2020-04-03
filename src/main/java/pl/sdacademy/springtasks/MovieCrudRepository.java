package pl.sdacademy.springtasks;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class MovieCrudRepository implements MovieRepository {

  public final EntityManager entityManager;

  public MovieCrudRepository(final EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  public Optional<Movie> findById(final Long id) {
    return Optional.ofNullable(entityManager.find(Movie.class, id));
  }

  public List<Movie> findAll() {
    return entityManager
        .createQuery("SELECT v FROM movies v", Movie.class)
        .getResultList();
  }

  public Movie save(final Movie movie) {
    entityManager.persist(movie);
    return movie;
  }

  public Movie update(final Movie movie) {
    entityManager.merge(movie);
    return movie;
  }

  public void deleteById(final Long id) {
    entityManager.createQuery("DELETE FROM movies WHERE id = :id")
        .setParameter("id", id)
        .executeUpdate();
  }
}
