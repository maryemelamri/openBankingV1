package elamri.effyis.openbanking.service;

import elamri.effyis.openbanking.entity.Client;
import elamri.effyis.openbanking.repository.ClientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Slf4j
public class ClientService {
    @Autowired
    private final ClientRepository clientRepository;
    @Autowired
    JdbcTemplate temp;

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
        String sql = "select * from client";
        RowMapper<Client> mapper = new RowMapper<Client>() {
            @Override
            public Client mapRow(ResultSet rs, int rowNum) throws SQLException {
                Client a = new Client();
                a.setId(rs.getInt(1)); // Supposons que l'ID est dans la première colonne
                a.setNom(rs.getString(2)); // Supposons que le nom est dans la deuxième colonne
                a.setPrenom(rs.getString(3)); // Supposons que la technologie est dans la troisième colonne
                return a;
            }
        };
        List<Client> cliens = temp.query(sql, mapper);
        return cliens;
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
