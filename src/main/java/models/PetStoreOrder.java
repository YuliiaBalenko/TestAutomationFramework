package models;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Objects;

public class PetStoreOrder {
    private long id;
    private long petId;
    private long quantity;
    private String status;
    private boolean complete = false;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPetId() {
        return petId;
    }

    public void setPetId(long petId) {
        this.petId = petId;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PetStoreOrder)) return false;
        PetStoreOrder that = (PetStoreOrder) o;
        return getId() == that.getId() &&
                getPetId() == that.getPetId() &&
                getQuantity() == that.getQuantity() &&
                isComplete() == that.isComplete() &&
                Objects.equals(getStatus(), that.getStatus());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getPetId(), getQuantity(), getStatus(), isComplete());
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("id", id)
                .append("petId", petId)
                .append("quantity", quantity)
                .append("status", status)
                .append("complete", complete)
                .toString();
    }
}
