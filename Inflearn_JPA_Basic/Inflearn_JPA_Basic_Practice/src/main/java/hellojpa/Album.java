package hellojpa;

import jakarta.persistence.Entity;

@Entity
public class Album extends Item {
    private String aritst;

    public String getAritst() {
        return aritst;
    }

    public void setAritst(String aritst) {
        this.aritst = aritst;
    }
}
