
package tn.esprit.autoloc.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Equipement;
import tn.esprit.autoloc.service.IEquipementService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/equipement")
public class EquipementController {

    private final IEquipementService equipementService;

    @GetMapping("/retrieve-all-equipements")
    public List<Equipement> getEquipements() {
        return equipementService.retrieveAllEquipements();
    }

    @GetMapping("/retrieve-equipement/{equipementId}")
    public Equipement retrieveEquipement(@PathVariable Long equipementId) {
        return equipementService.retrieveEquipement(equipementId);
    }

    @PostMapping("/add-equipement")
    public Equipement addEquipement(@RequestBody Equipement equipement) {
        return equipementService.addEquipement(equipement);
    }

    @DeleteMapping("/remove-equipement/{equipementId}")
    public void removeEquipement(@PathVariable Long equipementId) {
        equipementService.removeEquipement(equipementId);
    }

    @PutMapping("/modify-equipement")
    public Equipement modifyEquipement(@RequestBody Equipement equipement) {
        return equipementService.modifyEquipement(equipement);
    }
}
