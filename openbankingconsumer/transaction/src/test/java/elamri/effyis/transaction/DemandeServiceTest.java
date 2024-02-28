package elamri.effyis.transaction;

import elamri.effyis.transaction.controller.DemandeController;
import elamri.effyis.transaction.domain.DemandeProducer;
import elamri.effyis.transaction.repository.DemandeProducerRepository;
import elamri.effyis.transaction.service.DemandeService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class
DemandeServiceTest {

    @Mock
    DemandeProducerRepository demandeRepository;

    @InjectMocks
    DemandeService demandeService;



    @Test
    void testSave() {
        DemandeProducer demandeToSave = new DemandeProducer(0,1,2,-1000.0,null);

        DemandeProducer resultNegativeAmount = demandeService.save(demandeToSave);
        System.out.println("testtttttttttt0"+resultNegativeAmount.toString());
        assertEquals(0, resultNegativeAmount.getMontant(), "Mantont should not be negative");


        DemandeProducer resultNotSpecificReason = demandeService.save(demandeToSave);
        System.out.println(resultNotSpecificReason.getReason());
        assertEquals("Reason not specific ", resultNotSpecificReason.getReason(), "ID should not be zero");

    }
    @Test
    void testDeleteById() {
        long demandeId = 1L;
        demandeService.deleteById(demandeId);
        verify(demandeRepository, times(1)).deleteById(demandeId);
    }

    @Test
    void testFindById() {
        long demandeId = 1L;
        when(demandeRepository.findById(demandeId)).thenReturn(Optional.of(new DemandeProducer(demandeId,1,2,1000.0,"some reasons")));
        DemandeProducer found = demandeService.findById(demandeId);
        assertNotNull(found);
        assertEquals("some reasons", found.getReason());
        assertEquals(1000.0, found.getMontant());
        assertEquals(1, found.getId_compte_to());
        assertEquals(2, found.getId_compte_from());

        verify(demandeRepository, times(1)).findById(demandeId);
    }



}
