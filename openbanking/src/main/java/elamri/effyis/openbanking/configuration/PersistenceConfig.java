package elamri.effyis.openbanking.configuration;

import elamri.effyis.openbanking.entity.Client;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.data.relational.core.mapping.event.BeforeSaveEvent;

import java.util.UUID;

public class PersistenceConfig {


    @Bean
    public ApplicationListener<BeforeSaveEvent> idGenerator() {
        return event -> {
            var entity = event.getEntity();
            if (entity instanceof Client) {
                Client client = (Client) entity;
                UUID uuid = UUID.randomUUID();
                int uuidAsInt = uuid.hashCode(); // Convert UUID to int
                client.setId(uuidAsInt);;
            }
        };
    }
}