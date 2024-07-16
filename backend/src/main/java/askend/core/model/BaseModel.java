package askend.core.model;

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

    @Column(name = "created_at", nullable = false)
    @Setter
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "modified_at", nullable = false)
    @Setter
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedAt;

    @PrePersist
    public void prePersist() {
        createdAt = new Date();
        modifiedAt = new Date();
    }

    @PreUpdate
    public void preUpdate() {
        modifiedAt = new Date();
    }
}
