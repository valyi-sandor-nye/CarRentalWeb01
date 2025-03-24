package hu.valyis.progenv.carrentalweb01.model;

import java.time.LocalDate;

public class RentalEvent {
    private int id;
    private int carId;
    private int customerId;
    private LocalDate rentalDate;
    private LocalDate returnDate;
    private double totalCost;
    private boolean isClosed;

    private RentalEvent(Builder builder) {
        this.id = builder.id;
        this.carId = builder.carId;
        this.customerId = builder.customerId;
        this.rentalDate = builder.rentalDate;
        this.returnDate = builder.returnDate;
        this.totalCost = builder.totalCost;
        this.isClosed = builder.isClosed;
    }

    public RentalEvent() { }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private int id;
        private int carId;
        private int customerId;
        private LocalDate rentalDate;
        private LocalDate returnDate;
        private double totalCost;
        private boolean isClosed;

        public Builder id(int id) {this.id = id; return this; }
        public Builder carId(int carId) { this.carId = carId; return this; }
        public Builder customerId(int customerId) { this.customerId = customerId; return this; }
        public Builder rentalDate(LocalDate rentalDate) { this.rentalDate = rentalDate; return this; }
        public Builder returnDate(LocalDate returnDate) { this.returnDate = returnDate; return this; }
        public Builder totalCost(double totalCost) { this.totalCost = totalCost; return this; }
        public Builder isClosed(boolean isClosed) { this.isClosed = isClosed;return this; }
        public RentalEvent build() {
            return new RentalEvent(this);
        }

    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public LocalDate getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(LocalDate rentalDate) {
        this.rentalDate = rentalDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed(boolean isClosed) {
        this.isClosed = isClosed;
    }

    @Override
    public String toString() {
        return "RentalEvent{" +
                "id=" + id +
                ", carId=" + carId +
                ", customerId=" + customerId +
                ", rentalDate=" + rentalDate +
                ", returnDate=" + returnDate +
                ", totalCost=" + totalCost +
                ", isClosed=" + isClosed +
                '}';
    }
}
