package tn.esprit.autoloc.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Contrat;
import tn.esprit.autoloc.service.IContratService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/contrat")
@Tag(name = "Contrat", description = "Gestion des contrats de location")
public class ContratController {

    private final IContratService contratService;

    @Operation(summary = "Récupérer tous les contrats")
    @GetMapping("/retrieve-all-contrats")
    public List<Contrat> getContrats() {
        return contratService.retrieveAllContrats();
    }

    @Operation(summary = "Récupérer un contrat par son identifiant")
    @GetMapping("/retrieve-contrat/{contratId}")
    public Contrat retrieveContrat(@PathVariable Long contratId) {
        return contratService.retrieveContrat(contratId);
    }

    @Operation(summary = "Ajouter un contrat")
    @PostMapping("/add-contrat")
    public Contrat addContrat(@RequestBody Contrat contrat) {
        return contratService.addContrat(contrat);
    }

    @Operation(summary = "Supprimer un contrat")
    @DeleteMapping("/remove-contrat/{contratId}")
    public void removeContrat(@PathVariable Long contratId) {
        contratService.removeContrat(contratId);
    }

    @Operation(summary = "Modifier un contrat")
    @PutMapping("/modify-contrat")
    public Contrat modifyContrat(@RequestBody Contrat contrat) {
        return contratService.modifyContrat(contrat);
    }
}
