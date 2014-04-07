package name.oleg.service;

import name.oleg.entity.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployerServiceImpl implements EmployerService {

    @Autowired
    private EmployerRepository employerRepository;

    @Override
    public void add(Employer employer) {
        employerRepository.save(employer);
    }

    @Override
    public Employer find(Long id) {
        return null;
    }

    @Override
    public Employer find(String title) {
        return null;
    }
}
