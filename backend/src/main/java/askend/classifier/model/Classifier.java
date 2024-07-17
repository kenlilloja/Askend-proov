package askend.classifier.model;

import askend.core.model.BaseModel;
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
@Table(name = "classifier")
@DynamicInsert
@DynamicUpdate
@Getter
@Setter
@EqualsAndHashCode(of = {"id"}, callSuper = false)
public class Classifier extends BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "classifier_seq_generator")
    @SequenceGenerator(name = "classifier_seq_generator", sequenceName = "classifier_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "domain_code", length = 100, nullable = false)
    private String domainCode;

    @Column(name = "code", length = 100, nullable = false, unique = true)
    private String code;

    @Column(name = "parent_code", length = 100)
    private String parentCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_code", referencedColumnName = "code", insertable = false, updatable = false)
    private Classifier parentClassifier;

    @OneToMany(mappedBy = "parentClassifier", fetch = FetchType.LAZY)
    private List<Classifier> subClassifiers;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "code", referencedColumnName = "code", insertable = false, updatable = false)
    private ClassifierValue classifierValue;
}
