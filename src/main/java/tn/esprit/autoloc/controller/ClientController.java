
package tn.esprit.autoloc.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.service.IClientService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/client")
public class ClientController {

    private final IClientService clientService;

    @GetMapping("/retrieve-all-clients")
    public List<Client> getClients() {
        return clientService.retrieveAllClients();
    }

    @GetMapping("/retrieve-client/{clientId}")
    public Client retrieveClient(@PathVariable Long clientId) {
        return clientService.retrieveClient(clientId);
    }

    @PostMapping("/add-client")
    public Client addClient(@RequestBody Client client) {
        return clientService.addClient(client);
    }

    @DeleteMapping("/remove-client/{clientId}")
    public void removeClient(@PathVariable Long clientId) {
        clientService.removeClient(clientId);
    }

    @PutMapping("/modify-client")
    public Client modifyClient(@RequestBody Client client) {
        return clientService.modifyClient(client);
    }
}
