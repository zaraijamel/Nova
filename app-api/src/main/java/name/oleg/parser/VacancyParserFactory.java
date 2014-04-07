package name.oleg.parser;

public interface VacancyParserFactory {

    public VacancyParser getVacancyParser(VacancyParserType vacancyParserType);
}
