package helmes.klassifikaator.model;

import helmes.core.model.BaseModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.List;

@Entity
@Table(name = "klassifikaator")
@DynamicInsert
@DynamicUpdate
@Getter
@Setter
//@EqualsAndHashCode(of = {"id"}, callSuper = false)
public class Klassifikaator extends BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "klassifikaator_seq_generator")
    @SequenceGenerator(name = "klassifikaator_seq_generator", sequenceName = "klassifikaator_seq", allocationSize = 1)
    private Long id;

    @Column(name = "domeen_kood", length = 100, nullable = false)
    private String domeenKood;

    @Column(name = "kood", length = 100, nullable = false, unique = true)
    private String kood;

    @Column(name = "ylem_kood", length = 100)
    private String ylemKood;

    @Column(name = "taseme_nr", nullable = false)
    private Integer tasemeNr;

    @Column(name = "on_ylem_kategooria", nullable = false)
    private Boolean onYlemKategooria;

    @Column(name = "jrk_nr", nullable = false)
    private Integer jrkNr;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ylem_kood", referencedColumnName = "kood", insertable = false, updatable = false)
    private Klassifikaator ylemKlassifikaator;

    @OneToMany(mappedBy = "ylemKlassifikaator", fetch = FetchType.LAZY)
    private List<Klassifikaator> alamKlassifikaatorid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "kood", referencedColumnName = "kood", insertable = false, updatable = false)
    private KlassifikaatorVaartus klassifikaatorVaartus;
}
