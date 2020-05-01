package spbstu.project.varann.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import spbstu.project.varann.domain.Variation;
import spbstu.project.varann.domain.VariationID;
import spbstu.project.varann.service.VariationService;

@RestController
@RequestMapping("variation")
public class VariationController {
  private final VariationService variationService;

  public VariationController(VariationService variationService) {
    this.variationService = variationService;
  }

  @PostMapping
  public void postVariation(@RequestParam("file") MultipartFile file) {
    variationService.post(file);
  }

  @GetMapping
  public Variation getVariation(@RequestBody VariationID variationID) {
    return variationService.get(variationID);
  }
}
