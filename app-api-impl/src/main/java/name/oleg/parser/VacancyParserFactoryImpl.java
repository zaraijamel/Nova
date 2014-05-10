package name.oleg.parser;

import name.oleg.parser.joblab.JoblabVacancyParser;
import name.oleg.parser.rdw.RdwVacancyParser;
import name.oleg.parser.tutby.TutByVacancyParser;
import name.oleg.parser.yandex.YandexVacancyParser;
import org.springframework.stereotype.Component;

@Component
public class VacancyParserFactoryImpl implements VacancyParserFactory {

    public VacancyParser getVacancyParser(VacancyParserType vacancyParserType) {
        switch (vacancyParserType) {
            case TUT_BY:
                return new TutByVacancyParser();
            case YANDEX_JOB:
                return new YandexVacancyParser();
            case JOBLAB:
                return new JoblabVacancyParser();
            case RDW:
                return new RdwVacancyParser();
        }
        throw new IllegalArgumentException(vacancyParserType + " not implemented");
    }
}
