package br.com.server.location.database.entitys;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Builder
@Entity
@Table(name = "TB_COUNTRY")
@GenericGenerator(
        name = "SEQ_COUNTRY",
        strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
        parameters = {
                @Parameter(name = "sequence_name", value = "SEQ_COUNTRY"),
                @Parameter(name = "initial_value", value = "1"),
                @Parameter(name = "increment_size", value = "1")
        }
)
@NoArgsConstructor
@AllArgsConstructor
public class CountryEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_COUNTRY")
    @Column(name = "ID_COUNTRY", updatable = false, nullable = false)
    private Long id;

    @Column(name = "DSC_NAME", unique = true, updatable = false, nullable = false, length = 30)
    private String name;

    @OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH })
    @JoinTable(
            name = "TB_COUNTRY_STATES",
            joinColumns = @JoinColumn(name = "ID_COUNTRY",
                                      referencedColumnName = "ID_COUNTRY"),
            inverseJoinColumns = @JoinColumn(name = "ID_STATE",
                                             referencedColumnName = "ID_STATE"))
    private List<StateEntity> states;

}