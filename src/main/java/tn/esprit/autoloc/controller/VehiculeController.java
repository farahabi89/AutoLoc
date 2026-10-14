
package tn.esprit.autoloc.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.service.IVehiculeService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/vehicule")
public class VehiculeController {

    private final IVehiculeService vehiculeService;

    @GetMapping("/retrieve-all-vehicules")
    public List<Vehicule> getVehicules() {
        return vehiculeService.retrieveAllVehicules();
    }

    @GetMapping("/retrieve-vehicule/{vehiculeId}")
    public Vehicule retrieveVehicule(@PathVariable Long vehiculeId) {
        return vehiculeService.retrieveVehicule(vehiculeId);
    }

    @PostMapping("/add-vehicule")
    public Vehicule addVehicule(@RequestBody Vehicule vehicule) {
        return vehiculeService.addVehicule(vehicule);
    }

    @DeleteMapping("/remove-vehicule/{vehiculeId}")
    public void removeVehicule(@PathVariable Long vehiculeId) {
        vehiculeService.removeVehicule(vehiculeId);
    }

    @PutMapping("/modify-vehicule")
    public Vehicule modifyVehicule(@RequestBody Vehicule vehicule) {
        return vehiculeService.modifyVehicule(vehicule);
    }
}
