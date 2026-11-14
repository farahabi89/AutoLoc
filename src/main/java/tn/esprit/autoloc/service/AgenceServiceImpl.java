package tn.esprit.autoloc.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.repository.AgenceRepository;
import tn.esprit.autoloc.repository.VehiculeRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class AgenceServiceImpl implements IAgenceService {

    private final AgenceRepository agenceRepository;
    private final VehiculeRepository vehiculeRepository;

    @Override
    public List<Agence> retrieveAllAgences() {
        return agenceRepository.findAll();
    }

    @Override
    public Agence retrieveAgence(Long agenceId) {
        return agenceRepository.findById(agenceId).orElse(null);
    }

    @Override
    public Agence addAgence(Agence agence) {
        return agenceRepository.save(agence);
    }

    @Override
    public void removeAgence(Long agenceId) {
        agenceRepository.deleteById(agenceId);
    }

    @Override
    public Agence modifyAgence(Agence agence) {
        return agenceRepository.save(agence);
    }

    // Créer une agence et lui affecter deux véhicules
    @Override
    @Transactional
    public Agence ajouterAgenceEtAffecterVehicules(Agence agence) {

        List<Vehicule> vehicules = agence.getVehicules();

        if (vehicules == null || vehicules.size() != 2) {
            throw new IllegalArgumentException(
                    "L'agence doit contenir exactement deux véhicules."
            );
        }

        // 1. Enregistrer la nouvelle agence
        Agence nouvelleAgence = agenceRepository.save(agence);

        // 2. Affecter chaque véhicule à cette agence et l'enregistrer
        for (Vehicule vehicule : vehicules) {
            vehicule.setAgence(nouvelleAgence);
            vehiculeRepository.save(vehicule);
        }

        // 3. Retourner l'agence créée
        return nouvelleAgence;
    }
}
