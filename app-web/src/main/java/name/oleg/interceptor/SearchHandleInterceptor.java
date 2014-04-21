package name.oleg.interceptor;

import name.oleg.search.*;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SearchHandleInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        HttpSession session = httpServletRequest.getSession();
        VacancySearchParam vacancySearchParam = (VacancySearchParam) session.getAttribute("vacancySearchParam");
        if (vacancySearchParam == null) {
            vacancySearchParam = new VacancySearchParam();
            session.setAttribute("vacancySearchParam", vacancySearchParam);
        }
        httpServletRequest.setAttribute("vacancySearchParam", vacancySearchParam);
        httpServletRequest.setAttribute("vacancySearchSort", VacancySearchSort.values());
        httpServletRequest.setAttribute("vacancySearchPeriod", VacancySearchPeriod.values());
        httpServletRequest.setAttribute("vacancySearchEducation", VacancySearchEducation.values());
        httpServletRequest.setAttribute("vacancySearchExperience", VacancySearchExperience.values());
        httpServletRequest.setAttribute("vacancySearchWorkSchedule", VacancySearchWorkSchedule.values());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
