package com.revature.models;

public class Remib_Type {

    private int remib_type_id;
    private EnumType remib_type;
        
    public Remib_Type() {
        super();
    }

    
    public Remib_Type(int remib_type_id, EnumType remib_type) {
        super();
        this.remib_type_id = remib_type_id;
        this.remib_type = remib_type;
        }
    
    @Override
    public String toString() {
        return "Remib_Type [remib_type_id=" + remib_type_id + ", remib_type=" + remib_type + ", reibm_id" + "]";
    }

    public int getRemib_type_id() {
        return remib_type_id;
    }

    public void setRemib_type_id(int remib_type_id) {
        this.remib_type_id = remib_type_id;
    }

    public EnumType getRemib_type() {
        return remib_type;
    }

    public void setRemib_type(EnumType remib_type) {
        this.remib_type = remib_type;
    }
    
       
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + remib_type_id;
        result = prime * result + ((remib_type == null) ? 0 : remib_type.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Remib_Type other = (Remib_Type) obj;
        if (remib_type_id != other.remib_type_id)
            return false;
        if (remib_type == null) {
            if (other.remib_type != null)
                return false;
        } else if (!remib_type.equals(other.remib_type))
            return false;
        return true;
    }
}
