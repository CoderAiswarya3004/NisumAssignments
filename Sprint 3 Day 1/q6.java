sealed class PaymentException extends Exception
        permits InvalidPaymentMethodException, InvalidOfferAppliedException {
    public PaymentException(String message) {
        super(message);
    }
}

final class InvalidPaymentMethodException extends PaymentException {
    public InvalidPaymentMethodException(String message) {
        super(message);
    }
}

final class InvalidOfferAppliedException extends PaymentException {
    public InvalidOfferAppliedException(String message) {
        super(message);
    }
}

public class PaymentService {

    public static void paymentMethod(String method, String offer) throws PaymentException {
        if (!method.equalsIgnoreCase("UPI") && !method.equalsIgnoreCase("CARD")) {
            throw new InvalidPaymentMethodException("Unsupported payment method: " + method);
        }

        if (offer != null && !offer.equalsIgnoreCase("WELCOME10")) {
            throw new InvalidOfferAppliedException("Invalid offer applied: " + offer);
        }

        System.out.println("Payment processed successfully with method: " + method +
                (offer != null ? " and offer: " + offer : ""));
    }

    public static void processPaymentMethod(String method, String offer) {
        try {
            paymentMethod(method, offer);
        } catch (PaymentException e) {
            switch (e) {
                case InvalidPaymentMethodException ipme ->
                        System.out.println("Handled Payment Method Error: " + ipme.getMessage());
                case InvalidOfferAppliedException ioae ->
                        System.out.println("Handled Offer Error: " + ioae.getMessage());
                default ->
                        System.out.println("Unknown Payment Error: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        processPaymentMethod("CARD", "WELCOME10");     // Valid
        processPaymentMethod("NETBANKING", "WELCOME10"); // Invalid method
        processPaymentMethod("UPI", "SUPER50");         // Invalid offer
    }
}
