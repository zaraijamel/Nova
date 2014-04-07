package name.oleg.service;

import name.oleg.entity.ProfessionalArea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessionalAreaServiceImpl implements ProfessionalAreaService {

    @Autowired
    private ProfessionalAreaRepository professionalAreaRepository;

    @Override
    public void add(ProfessionalArea professionalArea) {
        professionalAreaRepository.save(professionalArea);
    }
}
