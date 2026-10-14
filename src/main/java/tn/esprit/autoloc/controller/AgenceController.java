
package tn.esprit.autoloc.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.service.IAgenceService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/agence")
public class AgenceController {

    private final IAgenceService agenceService;

    @GetMapping("/retrieve-all-agences")
    public List<Agence> getAgences() {
        return agenceService.retrieveAllAgences();
    }

    @GetMapping("/retrieve-agence/{agenceId}")
    public Agence retrieveAgence(@PathVariable Long agenceId) {
        return agenceService.retrieveAgence(agenceId);
    }

    @PostMapping("/add-agence")
    public Agence addAgence(@RequestBody Agence agence) {
        return agenceService.addAgence(agence);
    }

    @DeleteMapping("/remove-agence/{agenceId}")
    public void removeAgence(@PathVariable Long agenceId) {
        agenceService.removeAgence(agenceId);
    }

    @PutMapping("/modify-agence")
    public Agence modifyAgence(@RequestBody Agence agence) {
        return agenceService.modifyAgence(agence);
    }
}


