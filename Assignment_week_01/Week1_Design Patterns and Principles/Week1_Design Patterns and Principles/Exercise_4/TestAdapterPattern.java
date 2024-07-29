package Exercise_4;
// TestAdapterPattern.java
public class TestAdapterPattern {
    public static void main(String[] args) {
        PaymentProcessor payPalProcessor = new PayPalAdapter(new PayPalService());
        payPalProcessor.processPayment(100.0);

        PaymentProcessor creditCardProcessor = new CreditCardAdapter(new CreditCardService());
        creditCardProcessor.processPayment(200.0);
    }
}

