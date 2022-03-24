package br.com.server.location.database.entitys;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Builder
@Entity
@Table(name = "TB_ADDRESS")
@GenericGenerator(
        name = "SEQ_ADDRESS",
        strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
        parameters = {
                @Parameter(name = "sequence_name", value = "SEQ_ADDRESS"),
                @Parameter(name = "initial_value", value = "1"),
                @Parameter(name = "increment_size", value = "1")
        }
)
@NoArgsConstructor
@AllArgsConstructor
public class AddressEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ADDRESS")
    @Column(name = "ID_ADDRESS", nullable = false)
    private Long id;

    @Column(name = "NR_ADDRESS", nullable = false)
    private Integer number;

    @Column(name = "NR_ZIP_COD", nullable = false)
    private String zipCod;

    @Column(name = "DSC_STREET", nullable = false)
    private String street;

    @Column(name = "DSC_DISTRICT", nullable = false)
    private String district;

    @Column(name = "DSC_COMPLEMENT", nullable = true)
    private String complement;

    @ManyToOne
    @JoinColumn(name = "ID_CITY")
    private CityEntity city;

}