package helmes.core.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
@MappedSuperclass
public abstract class BaseModel implements Serializable {

    @Column(name = "loomis_aeg", nullable = false)
    @Setter
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "muutmis_aeg")
    @Setter
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedAt;

    @PrePersist
    public void prePersist() {
        createdAt = new Date();
        lastModifiedAt = new Date();
    }

    @PreUpdate
    public void preUpdate() {
        lastModifiedAt = new Date();
    }
}
