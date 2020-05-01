package spbstu.project.varann.service;

import org.springframework.stereotype.Service;
import spbstu.project.varann.Variation;
import spbstu.project.varann.VariationID;
import spbstu.project.varann.VariationRepository;

@Service
public class VariantService {
  private final VariationRepository repository;

  public VariantService(VariationRepository repository) {
    this.repository = repository;
  }

  public Variation get(VariationID variationID) {
    return repository.findById(variationID).get();
  }
}
