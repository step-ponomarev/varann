package spbstu.project.varann;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@IdClass(VariationID.class)
public class Variation {
    @Id
    private String chrom;

    @Id
    private int pos;

    @Id
    private String ref;

    @Id
    private String alt;

    private String info;
}
