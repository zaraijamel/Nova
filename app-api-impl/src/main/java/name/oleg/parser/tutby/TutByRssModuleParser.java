package name.oleg.parser.tutby;

import com.hp.hpl.sparta.Document;
import name.oleg.parser.data.Currency;
import name.oleg.util.Util;
import org.horrabin.horrorss.RssModuleParser;

import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TutByRssModuleParser implements RssModuleParser {
    private static final SimpleDateFormat CREATION_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
    private static final Pattern WORK_EXPERIENCE_PATTERN = Pattern.compile("(\\d+)[^\\d+]+(\\d+)", Pattern.CASE_INSENSITIVE);

    @Override
    public Object parseChannel(int i, Document document) throws Exception {
        return null;
    }

    @Override
    public Object parseImage(int i, Document document) throws Exception {
        return null;
    }

    @Override
    public Object parseItem(int i, Document document, int index) throws Exception {
        TutByVacancyAdditional additionalInfo = new TutByVacancyAdditional();

        String vacancyId = document.xpathSelectString("rss/channel/item[" + index + "]/hhvac:vacancyId/text()");
        additionalInfo.setVacancyId(Util.getIntegerOrNull(vacancyId));

        String creationDate = document.xpathSelectString("rss/channel/item[" + index + "]/hhvac:creationTime/text()");
        if (creationDate != null) {
            creationDate = creationDate.replaceAll("\\..+", "");
        }
        additionalInfo.setCreationDate(Util.getDateOrNull(creationDate, CREATION_DATE_FORMAT));

        String areaName = document.xpathSelectString("rss/channel/item[" + index + "]/hhvac:areaName/text()");
        additionalInfo.setAreaName(areaName);

        String profArea = document.xpathSelectString("rss/channel/item[" + index + "]/hhvac:profArea/text()");
        additionalInfo.setProfArea(profArea);

        String workExperience = document.xpathSelectString("rss/channel/item[" + index + "]/hhvac:workExperience/text()");
        if (workExperience != null) {
            Matcher matcher = WORK_EXPERIENCE_PATTERN.matcher(workExperience);
            if (matcher.find()) {
                Integer workExperienceFrom = Util.getIntegerOrNull(matcher.group(1));
                additionalInfo.setWorkExperienceFrom(workExperienceFrom);
                Integer workExperienceTo = Util.getIntegerOrNull(matcher.group(2));
                additionalInfo.setWorkExperienceTo(workExperienceTo);
            }
        }

        String description = document.xpathSelectString("rss/channel/item[" + index + "]/hhvac:description/text()");
        additionalInfo.setDescription(description);

        String compensationFrom = document.xpathSelectString("rss/channel/item[" + index + "]/hhvac:compensationFrom/text()");
        additionalInfo.setCompensationFrom(Util.getLongOrNull(compensationFrom));

        String compensationTo = document.xpathSelectString("rss/channel/item[" + index + "]/hhvac:compensationTo/text()");
        additionalInfo.setCompensationTo(Util.getLongOrNull(compensationTo));

        String compensationCurrency = document.xpathSelectString("rss/channel/item[" + index + "]/hhvac:compensationCurrency/text()");
        if (compensationCurrency != null) {
            if (compensationCurrency.equals("BYR")) {
                additionalInfo.setCompensationCurrency(Currency.BY);
            } else if (compensationCurrency.equals("USD")) {
                additionalInfo.setCompensationCurrency(Currency.USD);
            }
        }

        String employerId = document.xpathSelectString("rss/channel/item[" + index + "]/hhvac:employerId/text()");
        additionalInfo.setEmployerId(Util.getIntegerOrNull(employerId));

        String employerName = document.xpathSelectString("rss/channel/item[" + index + "]/hhvac:employerName/text()");
        additionalInfo.setEmployerName(employerName);

        String employerEmail = document.xpathSelectString("rss/channel/item[" + index + "]/hhvac:employerEmail/text()");
        additionalInfo.setEmployerEmail(employerEmail);

        String employerLogo = document.xpathSelectString("rss/channel/item[" + index + "]/hhvac:logoUrl/text()");
        additionalInfo.setEmployerLogo(employerLogo);

        return additionalInfo;
    }
}
