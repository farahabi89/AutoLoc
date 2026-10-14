
package tn.esprit.autoloc.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Employe;
import tn.esprit.autoloc.service.IEmployeService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/employe")
public class EmployeController {

    private final IEmployeService employeService;

    @GetMapping("/retrieve-all-employes")
    public List<Employe> getEmployes() {
        return employeService.retrieveAllEmployes();
    }

    @GetMapping("/retrieve-employe/{employeId}")
    public Employe retrieveEmploye(@PathVariable Long employeId) {
        return employeService.retrieveEmploye(employeId);
    }

    @PostMapping("/add-employe")
    public Employe addEmploye(@RequestBody Employe employe) {
        return employeService.addEmploye(employe);
    }

    @DeleteMapping("/remove-employe/{employeId}")
    public void removeEmploye(@PathVariable Long employeId) {
        employeService.removeEmploye(employeId);
    }

    @PutMapping("/modify-employe")
    public Employe modifyEmploye(@RequestBody Employe employe) {
        return employeService.modifyEmploye(employe);
    }
}
