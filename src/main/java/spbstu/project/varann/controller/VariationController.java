package spbstu.project.varann.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import spbstu.project.varann.domain.Variation;
import spbstu.project.varann.domain.VariationID;
import spbstu.project.varann.service.VariationService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("variation")
public class VariationController {
  private final VariationService variationService;

  @PostMapping
  public List<Variation> storeVariation(@RequestParam("file") MultipartFile file) {
    try {
      return variationService.store(file.getInputStream());
    } catch (Exception e) {
      e.printStackTrace();
    }

    return null;
  }

  @GetMapping
  public Variation annotateVariation(@RequestBody VariationID variationID) {
    return variationService.annotate(variationID);
  }
}
