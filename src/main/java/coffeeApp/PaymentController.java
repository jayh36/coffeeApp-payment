package coffeeApp;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PaymentController {

    private final PaymentService paymentService;
    @GetMapping("/payments/check")
    public String productCheck(@RequestParam String price){
        return paymentService.checkPayment(price);
    }

}
