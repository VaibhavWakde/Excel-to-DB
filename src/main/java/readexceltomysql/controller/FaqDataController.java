package readexceltomysql.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.multipart.MultipartFile;
import readexceltomysql.entity.FaqData;
import readexceltomysql.helper.Helper;
import readexceltomysql.service.FaqDataService;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("/faqData")
public class FaqDataController {
    @Autowired
    private FaqDataService faqDataService;

    @PostMapping("/upload")
    public ResponseEntity<?> upload(@RequestParam("file")MultipartFile file) throws IOException {
        if(Helper.checkExcelFormat(file)) {
            this.faqDataService.save(file);
            return ResponseEntity.ok(Map.of("message","File is Uploaded and data is saved to DB"));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please Upload Excel file");
    }

    @GetMapping("/faqData")
    public List<FaqData> getAllFaqData() {
        return this.faqDataService.getAllFaqData();
    }

}
