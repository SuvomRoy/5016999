package Exercise_4;
public class CreditCardAdapter implements PaymentProcessor {
    private CreditCardService creditCardService;

    public CreditCardAdapter(CreditCardService creditCardService) {
        this.creditCardService = creditCardService;
    }

    @Override
    public void processPayment(double amount) {
        creditCardService.pay(amount);
    }
}
