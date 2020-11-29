package enumsPetStoreOrder;

public enum PetStatuses {

        AVAILABLE("available"),
        PENDING("pending"),
        SOLD("sold");

        private String status;

        PetStatuses(String status) {
            this.status = status;
        }

        public String status() {
            return status;
        }
    }
