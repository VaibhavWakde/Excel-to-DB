package readexceltomysql.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import readexceltomysql.entity.FaqData;
import readexceltomysql.helper.Helper;
import readexceltomysql.repository.FaqDataRepo;

import java.io.IOException;
import java.util.List;

@Service
public class FaqDataService {

    @Autowired
    private FaqDataRepo faqDataRepo;

    public void save(MultipartFile file) throws IOException {
        List<FaqData> faqData = Helper.convertExcelToListOfProduct(file.getInputStream());
        this.faqDataRepo.saveAll(faqData);
    }

    public List<FaqData> getAllFaqData() {
        return this.faqDataRepo.findAll();
    }
}
