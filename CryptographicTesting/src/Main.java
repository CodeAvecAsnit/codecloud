public class Main {
    public static void main(String[] args) throws Exception{
        OrderDetails orderDetails = new OrderDetails(1,3000,2000,3,"Kathmandu,Nepal");
        System.out.println(orderDetails.toString());
        OrderUtils orderUtils = new OrderUtils();
        orderUtils.loadThePayload(orderDetails);
        String encrypted = Encryption.encrypt(orderDetails.allToString());
        String decryptedJson = Encryption.decrypt(encrypted);
        if(decryptedJson.equals(orderDetails.allToString())){
            System.out.println("Encryption Success");
        }else {
            System.out.println("Problem in Encryption or decryption");
        }
        if(orderUtils.verifyObject(orderDetails)){
            System.out.println("Test 1 passed");
        }else {
            System.out.println("Change Detected");
        }
    }
}