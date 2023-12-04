package readexceltomysql.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import readexceltomysql.entity.ServiceGuide;
import readexceltomysql.repository.ServiceGuideRepo;
import readexceltomysql.service.ServiceGuideService;

import java.util.List;
import java.util.Optional;

@RestController
public class ServiceGuideController {

    @Autowired
    private ServiceGuideRepo serviceGuideRepo;

    @Autowired
    private ServiceGuideService service;

    @PostMapping("/saveServiceGuide/{categoryId}/{vehicleType}")
    public ResponseEntity<String> saveHtmlData(@PathVariable Long categoryId, @PathVariable Long vehicleType,@RequestBody String htmlData) {
        service.saveHtmlData(categoryId, vehicleType, htmlData);
        return ResponseEntity.ok("HTML data saved successfully");
    }

    @PostMapping
    public ResponseEntity<?> saveServiceGuide(@RequestBody ServiceGuide serviceGuide) {
        this.service.saveServiceGuide(serviceGuide);
        return ResponseEntity.ok("Data Saved Successfully");
    }

    @GetMapping("/getServiceGuide/{categoryId}/{vehicleType}")
    public ServiceGuide getServiceGuideById(@PathVariable Long categoryId, @PathVariable Long vehicleType) {
        Optional<ServiceGuide> entity = Optional.ofNullable(serviceGuideRepo.getServiceGuideByCategoryId(categoryId, vehicleType));
        return entity.orElse(null);
    }

    @GetMapping("/getAllServiceGuide")
    public List<ServiceGuide> getAllServiceGuide() {
        return serviceGuideRepo.findAll();
    }


}
