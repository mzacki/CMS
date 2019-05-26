package com.***REMOVED***.persistence.dao;

import com.***REMOVED***.persistence.entity.Software;

import java.util.List;

/**
 * Created by Matt on 24.05.2019 at 19:19.
 */
public interface SoftwareDAO {

    List<Software> getSoftwareSystems();
    Software getSoftwareById(long id);
}
