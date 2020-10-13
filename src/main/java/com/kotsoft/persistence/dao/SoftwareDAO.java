package com.kotsoft.persistence.dao;

import com.kotsoft.persistence.entity.Software;

import java.util.List;

/**
 * @author Created by Matt on 24.05.2019 at 19:19.
 * DAO interface for Software entity.
 */
public interface SoftwareDAO {

    List<Software> getSoftwareSystems();

    Software getSoftwareById(long id);
}
