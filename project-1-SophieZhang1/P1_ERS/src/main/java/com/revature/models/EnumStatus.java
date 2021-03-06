package com.revature.models;

public enum EnumStatus {

    PENDING {
        @Override
        public String toString() {
            return "Pending";
        }
    },
    APPROVED {
        @Override
        public String toString() {
            return "Approved";
        }
    },
    DENIED {
        @Override
        public String toString() {
            return "Denied";
        }
    }
}