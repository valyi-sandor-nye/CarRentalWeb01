package hu.valyis.progenv.carrentalweb01.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;

@Entity
public class RentalEvent {
    @Id
    private int id;
    @ManyToOne
    @JoinColumn(name = "car_rented_id")
    private Car carRented;
    @ManyToOne
    @JoinColumn(name = "rental_customer_id")
    private Customer rentalCustomer;
    private LocalDate rentalDate;
    private LocalDate returnDate;
    private double totalCost;
    private boolean isClosed;

    public Customer getRentalCustomer() {
        return rentalCustomer;
    }

    public void setRentalCustomer(Customer rentalCustomer) {
        this.rentalCustomer = rentalCustomer;
    }

    public Car getCarRented() {
        return carRented;
    }

    public void setCarRented(Car carRented) {
        this.carRented = carRented;
    }


    private RentalEvent(Builder builder) {
        this.id = builder.id;
        this.carRented = builder.carRented;
        this.rentalCustomer = builder.rentalCustomer;
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
        private Car carRented;
        private Customer rentalCustomer;
        private LocalDate rentalDate;
        private LocalDate returnDate;
        private double totalCost;
        private boolean isClosed;

        public Builder id(int id) {this.id = id; return this; }
        public Builder car(Car car) { this.carRented = car; return this; }
        public Builder customer(Customer customer) { this.rentalCustomer = customer; return this; }
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

    public Car getCar() {
        return carRented;
    }

    public void setCar(Car car) {
        this.carRented = car;
    }

    public Customer getCustomer() {
        return rentalCustomer;
    }

    public void setCustomerId(Customer customer) {
        this.rentalCustomer = customer;
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
                ", car=" + carRented +
                ", customer=" + rentalCustomer +
                ", rentalDate=" + rentalDate +
                ", returnDate=" + returnDate +
                ", totalCost=" + totalCost +
                ", isClosed=" + isClosed +
                '}';
    }
}
