package com.***REMOVED***.persistence.service;

import com.***REMOVED***.persistence.dao.SoftwareDAO;
import com.***REMOVED***.persistence.entity.Software;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Matt on 25.05.2019 at 11:49.
 */

@Service
public class SoftwareServiceImplementation implements SoftwareService {

    SoftwareDAO softwareDAO;

    @Autowired
    public SoftwareServiceImplementation(SoftwareDAO softwareDAO) {
        this.softwareDAO = softwareDAO;
    }

    @Override
    public List<Software> getAll() {
        return softwareDAO.getSoftwareSystems();
    }

    @Override
    public Software getDetailedSoftware(long id) {
        return softwareDAO.getSoftwareById(id);
    }
}
