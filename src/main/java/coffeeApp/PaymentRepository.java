package coffeeApp;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface PaymentRepository extends PagingAndSortingRepository<Payment, Long>{

    //Optional<Product> findByProductId(Long productId);
}