package name.oleg.service;

import name.oleg.entity.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VacancyRepository extends JpaRepository<Vacancy, Long> {

    @Query("select v from Vacancy v where v.title = ?1")
    public List<Vacancy> findVacancyByTitle(String title);
}
