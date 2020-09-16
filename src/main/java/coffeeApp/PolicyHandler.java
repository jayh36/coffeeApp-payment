package coffeeApp;

import coffeeApp.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PolicyHandler{
    @Autowired
    PaymentRepository paymentRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void onStringEventListener(@Payload String eventString){

    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverReservationCanceled_QuantityChange(@Payload OrderCanceled orderCanceled){

        if(orderCanceled.isMe()){
            System.out.println("##### listener QuantityChange : " + orderCanceled.toJson());
            // 취소이벤트 전달받아 재고 원복작업
            Optional<Payment> optionalPayment = paymentRepository.findById(orderCanceled.getPaymentId());
            Payment payment = optionalPayment.orElseGet(Payment::new);
            payment.setStatus("결제취소");
            paymentRepository.save(payment);
        }
    }

}
