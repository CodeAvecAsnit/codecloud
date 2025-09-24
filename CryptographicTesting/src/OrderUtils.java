public class OrderUtils {
    private final Hashing hashing = new Hashing();

    public void loadThePayload(OrderDetails orderDetails)throws Exception{
        String orderData = orderDetails.toString();
        String payload = generateHmac(orderData);
        orderDetails.setPayload(payload);
    }

    private String generateHmac(String data) throws Exception {
            return hashing.getHmac(data);
    }

    public boolean verifyObject(OrderDetails orderDetails) throws Exception {
        String payload = orderDetails.getPayload();
        if (payload == null) throw new IllegalStateException("Payload is null");
        String objectJson = orderDetails.toString();
        String regeneratedPayload = generateHmac(objectJson);
        return payload.equals(regeneratedPayload);
    }

}
