package com.hykj.sc.bsc.lxq.dataobject;

import com.vividsolutions.jts.geom.Polygon;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Entity
@Table(name = "biz_grid")
public class GridDO2 {
    /**
     * 主键ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 业务键，UUID5
     */
    @NotNull
    @Column(name = "`key`")
    private String key;
    /**
     * 网格编码
     */
    @NotNull
    private String code;
    @NotNull
    private String name;
    /**
     * 地图网格范围
     */
    private Polygon shape;
    @NotNull
    private Date createTime;
    @NotNull
    private Date updateTime;
}
