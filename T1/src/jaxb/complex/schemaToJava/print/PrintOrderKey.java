package jaxb.complex.schemaToJava.print;

public class PrintOrderKey {

    private String client;
    private Long orderId;

    public PrintOrderKey() {
    }

    public PrintOrderKey(String client, Long orderId) {
        this.client = client;
        this.orderId = orderId;
    }

    public String getClient() {
        return client;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

}
