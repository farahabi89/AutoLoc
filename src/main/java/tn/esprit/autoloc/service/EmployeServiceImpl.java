package tn.esprit.autoloc.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Employe;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.repository.EmployeRepository;
import tn.esprit.autoloc.repository.AgenceRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeServiceImpl implements IEmployeService {

    private final EmployeRepository employeRepository;
    private final AgenceRepository agenceRepository;

    @Override
    public List<Employe> retrieveAllEmployes() {
        return employeRepository.findAll();
    }

    @Override
    public Employe retrieveEmploye(Long employeId) {
        return employeRepository.findById(employeId).orElse(null);
    }

    @Override
    public Employe addEmploye(Employe employe) {
        return employeRepository.save(employe);
    }

    @Override
    public void removeEmploye(Long employeId) {
        employeRepository.deleteById(employeId);
    }

    @Override
    public Employe modifyEmploye(Employe employe) {
        return employeRepository.save(employe);
    }

    // Désaffecter un employé de son agence
    @Override
    public Employe desaffecterEmploye(Long idEmploye) {

        Employe employe = employeRepository.findById(idEmploye).orElse(null);

        if (employe != null) {
            employe.setAgence(null);
            return employeRepository.save(employe);
        }

        return null;
    }

    // Affecter un employé à une nouvelle agence
    @Override
    public Employe affecterEmploye(Long idEmploye, Long idAgence) {

        Employe employe = employeRepository.findById(idEmploye).orElse(null);
        Agence agence = agenceRepository.findById(idAgence).orElse(null);

        if (employe != null && agence != null) {
            employe.setAgence(agence);
            return employeRepository.save(employe);
        }

        return null;
    }
}