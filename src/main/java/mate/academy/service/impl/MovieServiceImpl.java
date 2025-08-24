package mate.academy.service.impl;

import java.util.List;
import mate.academy.dao.MovieDao;
import mate.academy.exception.DataProcessingException;
import mate.academy.lib.Inject;
import mate.academy.lib.Service;
import mate.academy.model.Movie;
import mate.academy.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService {
    @Inject
    private MovieDao movieDao;

    @Override
    public Movie add(Movie movie) {
        return movieDao.add(movie);
    }

    @Override
    public Movie get(Long id) {
        if (movieDao.get(id).isPresent()) {
            return movieDao.get(id).get();
        }
        throw new DataProcessingException("Can't get movie by id " + id + " from DB");
    }

    @Override
    public List<Movie> getAll() {
        return movieDao.getAll();
    }
}
