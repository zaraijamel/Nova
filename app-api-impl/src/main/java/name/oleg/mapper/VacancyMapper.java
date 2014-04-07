package name.oleg.mapper;

import name.oleg.entity.Vacancy;
import name.oleg.parser.data.Compensation;
import name.oleg.parser.data.Employer;
import name.oleg.parser.data.VacancyDto;
import name.oleg.util.Mapper;
import name.oleg.util.StringUtil;
import org.springframework.stereotype.Component;

@Component("vacancyMapper")
public class VacancyMapper implements Mapper<VacancyDto, Vacancy> {

    @Override
    public name.oleg.entity.Vacancy fromDto(VacancyDto from) {
        name.oleg.entity.Vacancy to = new name.oleg.entity.Vacancy();
        to.setIdentifier(from.getIdentifier());
        to.setTitle(from.getTitle());
        to.setDescription(from.getDescription());
        to.setPageContent(from.getPageContent());
        to.setSourceLink(from.getSourceLink());
        to.setArea(from.getArea());
        to.setEntranceDate(from.getEntranceDate());
        to.setTags(StringUtil.splitByWords(from.getTitle()));

        Employer employerFrom = from.getEmployer();
        name.oleg.entity.Employer employerTo = new name.oleg.entity.Employer();
        employerTo.setIdentifier(employerFrom.getIdentifier());
        employerTo.setTitle(employerFrom.getTitle());
        employerTo.setEmail(employerFrom.getEmail());
        employerTo.setLogoUrl(employerFrom.getLogo());
        to.setEmployer(employerTo);

        Compensation compensationFrom = from.getCompensation();
        name.oleg.entity.Compensation compensationTo = new name.oleg.entity.Compensation();
        compensationTo.setFrom(compensationFrom.getFrom());
        compensationTo.setTo(compensationFrom.getTo());
        //todo
//        compensationTo.setCurrency(Currency.valueOf(compensationFrom.getCurrency().name()));
        to.setCompensation(compensationTo);

        return to;
    }

    @Override
    public VacancyDto toDto(name.oleg.entity.Vacancy vacancy) {
        return null;
    }
}
