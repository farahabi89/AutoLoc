
package tn.esprit.autoloc.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Contrat;
import tn.esprit.autoloc.service.IContratService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/contrat")
public class ContratController {

    private final IContratService contratService;

    @GetMapping("/retrieve-all-contrats")
    public List<Contrat> getContrats() {
        return contratService.retrieveAllContrats();
    }

    @GetMapping("/retrieve-contrat/{contratId}")
    public Contrat retrieveContrat(@PathVariable Long contratId) {
        return contratService.retrieveContrat(contratId);
    }

    @PostMapping("/add-contrat")
    public Contrat addContrat(@RequestBody Contrat contrat) {
        return contratService.addContrat(contrat);
    }

    @DeleteMapping("/remove-contrat/{contratId}")
    public void removeContrat(@PathVariable Long contratId) {
        contratService.removeContrat(contratId);
    }

    @PutMapping("/modify-contrat")
    public Contrat modifyContrat(@RequestBody Contrat contrat) {
        return contratService.modifyContrat(contrat);
    }
}
