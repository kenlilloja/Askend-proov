package helmes.klassifikaator.model;

import helmes.core.model.BaseModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;


@Entity
@Table(name = "klassifikaator_vaartus")
@DynamicInsert
@DynamicUpdate
@Getter
@Setter
@EqualsAndHashCode(of = {"id"}, callSuper = false)
public class KlassifikaatorVaartus extends BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "klassifikaator_vaartus_seq_generator")
    @SequenceGenerator(name = "klassifikaator_vaartus_seq_generator", sequenceName = "klassifikaator_vaartus_seq", allocationSize = 1)
    private Long id;

    @Column(name = "kood", length = 100, nullable = false)
    private String kood;

    @Column(name = "vaartus", length = 100, nullable = false)
    private String vaartus;

    @Column(name = "keel_kood", length = 100, nullable = false)
    private String keelKood;
}
