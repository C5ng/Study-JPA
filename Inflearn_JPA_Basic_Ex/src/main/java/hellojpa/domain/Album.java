package hellojpa.domain;

import jakarta.persistence.Entity;

@Entity
public class Album extends Item {
    private String artis;
    private String etc;

    public String getArtis() {
        return artis;
    }

    public void setArtis(String artis) {
        this.artis = artis;
    }

    public String getEtc() {
        return etc;
    }

    public void setEtc(String etc) {
        this.etc = etc;
    }
}
