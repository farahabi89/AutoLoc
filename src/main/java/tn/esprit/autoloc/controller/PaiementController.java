
package tn.esprit.autoloc.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Paiement;
import tn.esprit.autoloc.service.IPaiementService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/paiement")
public class PaiementController {

    private final IPaiementService paiementService;

    @GetMapping("/retrieve-all-paiements")
    public List<Paiement> getPaiements() {
        return paiementService.retrieveAllPaiements();
    }

    @GetMapping("/retrieve-paiement/{paiementId}")
    public Paiement retrievePaiement(@PathVariable Long paiementId) {
        return paiementService.retrievePaiement(paiementId);
    }

    @PostMapping("/add-paiement")
    public Paiement addPaiement(@RequestBody Paiement paiement) {
        return paiementService.addPaiement(paiement);
    }

    @DeleteMapping("/remove-paiement/{paiementId}")
    public void removePaiement(@PathVariable Long paiementId) {
        paiementService.removePaiement(paiementId);
    }

    @PutMapping("/modify-paiement")
    public Paiement modifyPaiement(@RequestBody Paiement paiement) {
        return paiementService.modifyPaiement(paiement);
    }
}
