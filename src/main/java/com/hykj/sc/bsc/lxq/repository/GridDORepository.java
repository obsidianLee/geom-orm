package com.hykj.sc.bsc.lxq.repository;

import com.hykj.sc.bsc.lxq.dataobject.GridDO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GridDORepository extends JpaRepository<GridDO,Long> {
    GridDO findByCode(String key);
}
