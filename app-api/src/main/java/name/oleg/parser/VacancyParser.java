package name.oleg.parser;

import name.oleg.parser.data.VacancyResult;

import java.io.IOException;

public interface VacancyParser {

    public VacancyParserType getVacancyParserType();

    public VacancyResult getVacancyResult() throws IOException;
}
