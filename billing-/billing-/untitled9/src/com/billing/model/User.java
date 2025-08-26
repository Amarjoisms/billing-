package com.billing.model;

import java.util.Optional;

public class User {
    private final int uId;
    private final String userName;
    private final Optional<String> address;
    private final String phNumber;

    private User(Builder builder) {
        this.uId = builder.uId;
        this.userName = builder.userName;
        this.address = Optional.ofNullable(builder.address);
        this.phNumber = builder.phNumber;
    }

    public int getUId() { return uId; }
    public String getUserName() { return userName; }
    public Optional<String> getAddress() { return address; }
    public String getPhNumber() { return phNumber; }

    public static class Builder {
        private int uId;
        private String userName;
        private String address;
        private String phNumber;

        public Builder withUserId(int userId) {
            this.uId = userId;
            return this;
        }
        public Builder withName(String name) {
            this.userName = name;
            return this;
        }
        public Builder withAddress(String add) {
            this.address = add;
            return this;
        }
        public Builder withPhoneNumber(String phoneNumber) {
            this.phNumber = phoneNumber;
            return this;
        }
        public User build() {
            return new User(this);
        }
    }
}
