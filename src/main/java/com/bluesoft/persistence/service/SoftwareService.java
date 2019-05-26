package com.***REMOVED***.persistence.service;

import com.***REMOVED***.persistence.entity.Software;

import java.util.List;

/**
 * Created by Matt on 25.05.2019 at 11:49.
 */
public interface SoftwareService {

    List<Software> getAll();
    Software getDetailedSoftware(long id);
}
