package Exercise_4;

// PayPalAdapter.java
public class PayPalAdapter implements PaymentProcessor {
    private PayPalService payPalService;

    public PayPalAdapter(PayPalService payPalService) {
        this.payPalService = payPalService;
    }

    @Override
    public void processPayment(double amount) {
        payPalService.makePayment(amount);
    }
}