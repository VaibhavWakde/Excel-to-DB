package readexceltomysql.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import readexceltomysql.entity.ServiceGuide;
import readexceltomysql.repository.ServiceGuideRepo;

@Service
public class ServiceGuideService {

    @Autowired
    private ServiceGuideRepo serviceGuideRepo;

    public void saveHtmlData(Long categoryId, Long vehicleType, String htmlData) {
        ServiceGuide entity = new ServiceGuide();
        entity.setCategoryId(categoryId);
        entity.setVehicleType(vehicleType);
        entity.setHtmlContent(htmlData);
        serviceGuideRepo.save(entity);
    }
    public ServiceGuide saveServiceGuide(ServiceGuide serviceGuide){

        return this.serviceGuideRepo.save(serviceGuide);
    }
}
