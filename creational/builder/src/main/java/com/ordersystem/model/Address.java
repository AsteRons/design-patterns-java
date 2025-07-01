package com.ordersystem.model;

public final class Address {
    private final String street;
    private final String city;
    private final String zipCode;

    private Address(AddressBuilder builder) {
        this.street = builder.street;
        this.city = builder.city;
        this.zipCode = builder.zipCode;
    }
    @Override
    public String toString() {
        return street + ", " + city + " " + zipCode;
    }

    public static class AddressBuilder {
        private String street;
        private String city;
        private String zipCode;

        public AddressBuilder street(String street) {
            this.street = street;
            return this;
        }

        public AddressBuilder city(String city) {
            this.city = city;
            return this;
        }

        public AddressBuilder zipCode(String zipCode) {
            this.zipCode = zipCode;
            return this;
        }

        public Address build() {
            if (street == null || city == null || zipCode == null) {
                throw new IllegalStateException("All address fields are required");
            }
            return new Address(this);
        }
    }
}