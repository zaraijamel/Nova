package name.oleg.parser.data;

import java.util.ArrayList;
import java.util.List;

public class VacancyResult {
    private List<VacancyDto> vacancies = new ArrayList<VacancyDto>();

    public VacancyResult(List<VacancyDto> vacancies) {
        this.vacancies = vacancies;
    }

    public List<VacancyDto> getVacancies() {
        return vacancies;
    }
}
