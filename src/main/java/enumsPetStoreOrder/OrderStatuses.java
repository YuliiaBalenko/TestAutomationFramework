package enumsPetStoreOrder;

public enum OrderStatuses {

    PLACED("placed"),
    APPROVED("approved"),
    DELIVERED("delivered");

    private String orderStatus;

    OrderStatuses(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String orderStatus() {
        return orderStatus;
    }
}
