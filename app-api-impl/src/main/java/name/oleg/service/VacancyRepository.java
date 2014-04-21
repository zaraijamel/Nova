package name.oleg.service;

import name.oleg.entity.Vacancy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VacancyRepository extends JpaRepository<Vacancy, Long>, JpaSpecificationExecutor<Vacancy> {

    @Query("select v from Vacancy v where v.title = :title")
    public List<Vacancy> findVacancyByTitle(@Param("title") String title);

    @Query("select v from Vacancy v order by v.entranceDate")
    public List<Vacancy> findNewest(Pageable pageable);

    @Query("select v from Vacancy v")
    public List<Vacancy> findByCoordinate(Pageable pageable);

    @Query("select distinct v.title from Vacancy v where v.title like :searchTerm%")
    public List<String> findSuggestedVacancy(@Param("searchTerm") String searchTerm);

    @Query("select v.title from Vacancy v")
    public List<String> findOftenUsageTags(Pageable pageable);

    @Query("select v from Vacancy v where v.tags in (:tag)")
    public Page<Vacancy> findByTag(@Param("tag") String tag, Pageable pageable);
}
