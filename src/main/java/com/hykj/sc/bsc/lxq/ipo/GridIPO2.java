package com.hykj.sc.bsc.lxq.ipo;

import com.vividsolutions.jts.geom.Coordinate;
import lombok.Data;

import java.util.List;

@Data
public class GridIPO2 {
    private String name;
    private String code;
    private List<Coordinate> shape;
}
