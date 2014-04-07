package name.oleg.service;

import name.oleg.entity.Employer;

public interface EmployerService {

    public void add(Employer employer);

    public Employer find(Long id);

    public Employer find(String title);
}
