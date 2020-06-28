package com.hykj.sc.bsc.lxq.dataobject;

import lombok.Data;
import org.geolatte.geom.Polygon;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Entity
@Table(name = "biz_grid")
public class GridDO {
    /**
     * 主键ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 业务键，UUID
     */
    @NotNull
    @Column(name = "`key`")
    private String key;
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
