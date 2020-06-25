package com.hykj.sc.bsc.lxq.repository;

import com.hykj.sc.bsc.lxq.dataobject.GridDO2;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GridDO2Repository extends JpaRepository<GridDO2,Long> {
    GridDO2 findByCode(String key);
}
