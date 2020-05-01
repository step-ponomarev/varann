package spbstu.project.varann.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import spbstu.project.varann.domain.Variation;
import spbstu.project.varann.domain.VariationID;
import spbstu.project.varann.VariationRepository;
import spbstu.project.varann.parser.VcfParser;

@Service
public class VariationService {
  private final VariationRepository repository;
  private final VcfParser parser;

  public VariationService(VariationRepository repository, VcfParser parser) {
    this.repository = repository;
    this.parser = parser;
  }

  public Variation get(VariationID variationID) {
    return repository.findById(variationID).get();
  }

  public void post(MultipartFile file) {
    try {
      var variations = parser.parse(file.getInputStream());

      variations.forEach(variation -> {

        var newVariation = Variation.builder()
            .chrom(variation.getContig())
            .pos(variation.getStart())
            .ref(variation.getReference().getDisplayString())
            .alt(variation.getAlternateAlleles().toString())
            .info(variation.getCommonInfo().getAttributes().toString())
            .build();

        repository.save(newVariation);
      });

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
