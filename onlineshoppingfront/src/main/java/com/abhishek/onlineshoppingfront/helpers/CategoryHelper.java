package com.abhishek.onlineshoppingfront.helpers;

import com.abhishek.onlineshoppingfront.dto.Category;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class CategoryHelper {

    @Autowired
    private RestTemplate restTemplate;

//    @Value("backend.service.url")
//    private String backendServiceUrl;
    private String backendServiceUrl = "http://localhost:8088/onlineshoppingbackend";

    public List<Category> getActiveCategoryList() {
        List<Category> categoryList = new ArrayList<>();
        String url = backendServiceUrl + "/category/getAll/active";
        HttpEntity entity = new HttpEntity(CommonHelper.getHttpHeaders());
        log.info("Calling backend service to get active category list url - {}", url);
        try {
            ResponseEntity<List<Category>> responseEntity = restTemplate.exchange(
                    url, HttpMethod.GET, entity, new ParameterizedTypeReference<List<Category>>() {});
            if (responseEntity.getStatusCode() == HttpStatus.OK) {
                categoryList = responseEntity.getBody();
            }
        } catch (Exception ex) {
            log.error("Exception in getting active categoryList, url - {}", url, ex);
        }
//        log.info("Categories - ", categoryList);
        return categoryList;
    }

    public Category getCategoryById(Long categoryId) {
        Category category = null;
        String url = backendServiceUrl + "/category/get/id/" + categoryId;
        HttpEntity entity = new HttpEntity(CommonHelper.getHttpHeaders());
        log.info("Calling backend service to get category By Id - {} - {}",categoryId, url);
        try {
            ResponseEntity<Category> responseEntity = restTemplate.exchange(
                    url, HttpMethod.GET, entity, Category.class);
            if (responseEntity.getStatusCode() == HttpStatus.OK) {
                category = responseEntity.getBody();
            }
        } catch (Exception ex) {
            log.error("Exception in getting category id - {}, url - {}",categoryId, url, ex);
        }
        log.info("Category id - {}, category - {}",categoryId, category);
        return category;
    }
}
