package com.revature.models;

public enum EnumUser_Role {

	employee {
        @Override
        public String toString() {
            return "employee";
        }
    },
	finance_manager {
        @Override
        public String toString() {
            return "finance manager";
        }
    }

}