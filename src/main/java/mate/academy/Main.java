package mate.academy;

import java.time.LocalDate;
import java.time.LocalDateTime;
import mate.academy.lib.Injector;
import mate.academy.model.CinemaHall;
import mate.academy.model.Movie;
import mate.academy.model.MovieSession;
import mate.academy.service.CinemaHallService;
import mate.academy.service.MovieService;
import mate.academy.service.MovieSessionService;

public class Main {
    public static void main(String[] args) {

        Movie fastAndFurious = new Movie("Fast and Furious");
        fastAndFurious.setDescription("An action film about street racing, heists, and spies.");

        Injector injector = Injector.getInstance("mate.academy");
        MovieService movieService = (MovieService) injector.getInstance(MovieService.class);
        System.out.println(movieService.add(fastAndFurious));
        System.out.println(movieService.get(fastAndFurious.getId()));
        movieService.getAll().forEach(System.out::println);

        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setCapacity(50);
        cinemaHall.setDescription("Small cinema hall.");

        CinemaHallService cinemaHallService = (CinemaHallService) injector.getInstance(
                CinemaHallService.class);
        System.out.println(cinemaHallService.add(cinemaHall));
        System.out.println(cinemaHallService.get(cinemaHall.getId()));
        cinemaHallService.getAll().forEach(System.out::println);

        MovieSession movieSession1 = new MovieSession();
        movieSession1.setMovie(fastAndFurious);
        movieSession1.setCinemaHall(cinemaHall);
        movieSession1.setShowTime(LocalDateTime.of(2024, 5, 10, 14, 0));

        MovieSession movieSession2 = new MovieSession();
        movieSession2.setMovie(fastAndFurious);
        movieSession2.setCinemaHall(cinemaHall);
        movieSession2.setShowTime(LocalDateTime.of(2024, 5, 10, 20, 30));

        MovieSession movieSession3 = new MovieSession();
        movieSession3.setMovie(fastAndFurious);
        movieSession3.setCinemaHall(cinemaHall);
        movieSession3.setShowTime(LocalDateTime.of(2024, 5, 11, 14, 0));

        MovieSessionService movieSessionService = (MovieSessionService) injector
                .getInstance(MovieSessionService.class);
        System.out.println(movieSessionService.add(movieSession1));
        System.out.println(movieSessionService.add(movieSession2));
        System.out.println(movieSessionService.add(movieSession3));
        System.out.println(movieSessionService.get(movieSession1.getId()));
        movieSessionService.findAvailableSessions(movieSession1.getId(),
                LocalDate.of(2024, 5, 10)).forEach(System.out::println);
    }
}
