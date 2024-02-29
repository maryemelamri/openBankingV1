package elamri.effyis.transaction.controller;

import elamri.effyis.transaction.domain.DemandeProducer;
import elamri.effyis.transaction.service.DemandeService;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("test")
public class DemandeController {
    private  final DemandeService demandeService;

    public DemandeController(DemandeService demandeService) {
        this.demandeService = demandeService;
    }


    @PutMapping("/update/{id}")
    public DemandeProducer save(@RequestBody DemandeProducer p,@PathVariable long id) {
        DemandeProducer demandeProducer = demandeService.findById(id);
        if (demandeProducer != null) {
            if (p.getReason() != null) {
                demandeProducer.setReason(p.getReason());

            }
            if (p.getId_compte_from() != 0L) {
                demandeProducer.setId_compte_from(p.getId_compte_from());
            }
            if(p.getId_compte_to() != 0L) {
                demandeProducer.setId_compte_to(p.getId_compte_to());
            }
            if(p.getReason() != null) {
                demandeProducer.setReason(p.getReason());
            }
            return demandeService.save(demandeProducer);
        }
        return null;
    }

    @GetMapping("/getTop")
    public  List<DemandeProducer> findTopTrasaction() {
        return demandeService.findTopTrasaction();
    }


    @GetMapping("/findbycompte/{id}")
    public List<DemandeProducer> findDemandeByCompteId(@PathVariable Long id) {
        return demandeService.findByCompteId(id);
    }


    @GetMapping("/demande/id/")
    public ResponseEntity<DemandeProducer> findStudentById(@PathParam(value = "id") long id) {
        var demande = demandeService.findById(id);
        return ResponseEntity.ok(demande);
    }


}
