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
@Table(name = "TB_STATE")
@GenericGenerator(
        name = "SEQ_STATE",
        strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
        parameters = {
                @Parameter(name = "sequence_name", value = "SEQ_STATE"),
                @Parameter(name = "initial_value", value = "1"),
                @Parameter(name = "increment_size", value = "1")
        }
)
@NoArgsConstructor
@AllArgsConstructor
public class StateEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_STATE")
    @Column(name = "ID_STATE", updatable = false, nullable = false)
    private Long id;

    @Column(name = "DSC_NAME", unique = true, updatable = false, nullable = false)
    private String name;

    @Column(name = "DSC_INITIALS", nullable = false, length = 2)
    private String initials;

    @ManyToOne
    @JoinColumn(name = "ID_COUNTRY")
    private CountryEntity country;

    @OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH })
    @JoinTable(
            name = "TB_CITIES_STATE",
            joinColumns = @JoinColumn(name = "ID_STATE",
                                      referencedColumnName = "ID_STATE"),
            inverseJoinColumns = @JoinColumn(name = "ID_CITY",
                                             referencedColumnName = "ID_CITY"))
    private List<CityEntity> cities;

}