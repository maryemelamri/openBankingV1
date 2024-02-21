package elamri.effyis.openbanking.service;

import elamri.effyis.openbanking.entity.Client;
import elamri.effyis.openbanking.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service

public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client create(Client client) {
        if (Objects.isNull(client)) return null;
        return clientRepository.save(client);
    }
    public Client findClientById(int id) {
        return clientRepository.findById(id);
    }

    public Iterable<Client> findAllClients() {
        return clientRepository.findAll();
    }

    public Client updateClient(Client client) {
        if (Objects.isNull(client)) return null;
       return clientRepository.save(client);
    }

    public boolean deleteClientById(Client client) {
        if (Objects.isNull(client)) return false;

        clientRepository.delete(client);
        return true;
    }

}
