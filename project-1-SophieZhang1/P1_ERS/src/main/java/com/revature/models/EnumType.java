package com.revature.models;

public enum EnumType {

	lodging {
		@Override
        public String toString() {
            return "lodging";
        }
    },
	travel {
        @Override
        public String toString() {
            return "travel";
        }
    },
	food {
        @Override
        public String toString() {
            return "food";
        }
    },
	other {
        @Override
        public String toString() {
            return "other";
        }
    }

}