package name.oleg.parser.tutby;

import com.hp.hpl.sparta.Document;
import name.oleg.util.Util;
import org.horrabin.horrorss.RssModuleParser;

import java.text.SimpleDateFormat;

public class TutByRssModuleParser implements RssModuleParser {
    private static final SimpleDateFormat CREATION_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

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
            //todo
            creationDate = creationDate.replaceAll("\\..+", "");
        }
        additionalInfo.setCreationDate(Util.getDateOrNull(creationDate, CREATION_DATE_FORMAT));

        String areaName = document.xpathSelectString("rss/channel/item[" + index + "]/hhvac:areaName/text()");
        additionalInfo.setAreaName(areaName);

        String profArea = document.xpathSelectString("rss/channel/item[" + index + "]/hhvac:profArea/text()");
        additionalInfo.setProfArea(profArea);

        String workExperience = document.xpathSelectString("rss/channel/item[" + index + "]/hhvac:workExperience/text()");
        additionalInfo.setWorkExperience(workExperience);

        String description = document.xpathSelectString("rss/channel/item[" + index + "]/hhvac:description/text()");
        additionalInfo.setDescription(description);

        String compensationFrom = document.xpathSelectString("rss/channel/item[" + index + "]/hhvac:compensationFrom/text()");
        additionalInfo.setCompensationFrom(Util.getLongOrNull(compensationFrom));

        String compensationTo = document.xpathSelectString("rss/channel/item[" + index + "]/hhvac:compensationTo/text()");
        additionalInfo.setCompensationTo(Util.getLongOrNull(compensationTo));

        String compensationCurrency = document.xpathSelectString("rss/channel/item[" + index + "]/hhvac:compensationCurrency/text()");
        additionalInfo.setCompensationCurrency(compensationCurrency);

        String employerId = document.xpathSelectString("rss/channel/item[" + index + "]/hhvac:employerId/text()");
        additionalInfo.setEmployerId(Util.getIntegerOrNull(employerId));

        String employerName = document.xpathSelectString("rss/channel/item[" + index + "]/hhvac:employerName/text()");
        additionalInfo.setEmployerName(employerName);

        String employerEmail = document.xpathSelectString("rss/channel/item[" + index + "]/hhvac:employerEmail/text()");
        additionalInfo.setEmployerEmail(employerEmail);

        String employerLogo = document.xpathSelectString("rss/channel/item[" + index + "]/hhvac:employerLogo/text()");
        additionalInfo.setEmployerLogo(employerLogo);

        return additionalInfo;
    }
}
