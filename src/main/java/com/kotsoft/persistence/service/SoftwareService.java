package com.kotsoft.persistence.service;

import com.kotsoft.persistence.entity.Software;

import java.util.List;

/**
 * @author Created by Matt on 25.05.2019 at 11:49.
 * Service interface for Software entity. Service layer separates DAO from business logic operations.
 */
public interface SoftwareService {

    List<Software> getAll();

    Software getDetailedSoftware(long id);
}
