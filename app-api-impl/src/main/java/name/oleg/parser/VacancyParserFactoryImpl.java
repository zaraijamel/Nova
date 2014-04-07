package name.oleg.parser;

import name.oleg.parser.tutby.TutByVacancyParser;
import org.springframework.stereotype.Component;

@Component
public class VacancyParserFactoryImpl implements VacancyParserFactory {

    public VacancyParser getVacancyParser(VacancyParserType vacancyParserType) {
        switch (vacancyParserType) {
            case TUT_BY:
                return new TutByVacancyParser();
            case HEAD_HUNTERS:
                return null;
        }
        throw new IllegalArgumentException(vacancyParserType + " not implemented");
    }
}
