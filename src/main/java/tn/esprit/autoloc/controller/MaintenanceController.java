
package tn.esprit.autoloc.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Maintenance;
import tn.esprit.autoloc.service.IMaintenanceService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/maintenance")
public class MaintenanceController {

    private final IMaintenanceService maintenanceService;

    @GetMapping("/retrieve-all-maintenances")
    public List<Maintenance> getMaintenances() {
        return maintenanceService.retrieveAllMaintenances();
    }

    @GetMapping("/retrieve-maintenance/{maintenanceId}")
    public Maintenance retrieveMaintenance(@PathVariable Long maintenanceId) {
        return maintenanceService.retrieveMaintenance(maintenanceId);
    }

    @PostMapping("/add-maintenance")
    public Maintenance addMaintenance(@RequestBody Maintenance maintenance) {
        return maintenanceService.addMaintenance(maintenance);
    }

    @DeleteMapping("/remove-maintenance/{maintenanceId}")
    public void removeMaintenance(@PathVariable Long maintenanceId) {
        maintenanceService.removeMaintenance(maintenanceId);
    }

    @PutMapping("/modify-maintenance")
    public Maintenance modifyMaintenance(@RequestBody Maintenance maintenance) {
        return maintenanceService.modifyMaintenance(maintenance);
    }
}
