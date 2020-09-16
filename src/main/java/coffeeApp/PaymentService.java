package coffeeApp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PaymentService {
    private final PaymentRepository paymentRepository;

    @Transactional
    public String checkPayment(String price) {
        // 자동으로 결제완료처리
        Payment payment = new Payment();
        payment.setPrice(price);
        payment.setStatus("결제완료");
        paymentRepository.save(payment);
        return payment.getStatus() ;
    }
}
