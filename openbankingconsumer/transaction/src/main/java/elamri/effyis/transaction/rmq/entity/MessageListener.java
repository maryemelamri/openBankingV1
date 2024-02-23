package elamri.effyis.transaction.rmq.entity;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

    @RabbitListener(queues = MQConfig.QUEUE)
    public void listener(DemandeProducer demande) {
       //emandeRepository.save(demande);
        System.out.println(demande);

    }
}
