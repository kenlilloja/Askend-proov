package helmes.user.model;

import helmes.core.model.BaseModel;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.Set;

@Entity
@Table(name = "kasutaja_info")
@DynamicInsert
@DynamicUpdate
@Getter
@Setter
@EqualsAndHashCode(of = {"id"}, callSuper = false)
public class KasutajaInfo extends BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "unique_id_generator")
    @SequenceGenerator(name = "unique_id_generator", sequenceName = "kasutaja_info_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "nimi")
    private String nimi;

    @Column(name = "on_nous_tingimustega")
    private Boolean onNousTingimustega = false;

    @OneToMany(mappedBy = "kasutaja", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<KasutajaSektor> sektorid;
}
