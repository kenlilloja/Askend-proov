package helmes.user.model;

import helmes.core.model.BaseModel;
import helmes.klassifikaator.model.Klassifikaator;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "kasutaja_sektor")
@DynamicInsert
@DynamicUpdate
@Getter
@Setter
@EqualsAndHashCode(of = {"sektor"}, callSuper = false)
public class KasutajaSektor extends BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "unique_id_generator")
    @SequenceGenerator(name = "unique_id_generator", sequenceName = "kasutaja_sektor_id_seq", allocationSize = 1)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "kasutaja_id")
    private KasutajaInfo kasutaja;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sektor_kood", referencedColumnName = "kood")
    private Klassifikaator sektor;
}
