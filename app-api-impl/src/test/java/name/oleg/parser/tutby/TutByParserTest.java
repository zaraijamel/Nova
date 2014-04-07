package name.oleg.parser.tutby;

import name.oleg.entity.Vacancy;
import name.oleg.mapper.VacancyMapper;
import name.oleg.parser.VacancyParser;
import name.oleg.parser.VacancyParserFactory;
import name.oleg.parser.VacancyParserType;
import name.oleg.parser.data.VacancyDto;
import name.oleg.parser.data.VacancyResult;
import name.oleg.service.VacancyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/service-context.xml"})
public class TutByParserTest {

    @Autowired
    private VacancyParserFactory vacancyParserFactory;

    @Autowired
    private VacancyService vacancyService;

    @Test
    public void parserTest() throws IOException {
        VacancyParser vacancyParser = vacancyParserFactory.getVacancyParser(VacancyParserType.TUT_BY);
        VacancyResult vacancyResult = vacancyParser.getVacancyResult();

        VacancyMapper vacancyMapper = new VacancyMapper();
        for (VacancyDto vacancyDto : vacancyResult.getVacancies()) {
            Vacancy vacancy = vacancyMapper.fromDto(vacancyDto);
            vacancyService.add(vacancy);
        }
    }
}
