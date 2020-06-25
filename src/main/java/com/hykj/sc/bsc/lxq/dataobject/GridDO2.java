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
     * 主数据key
     */
    @NotNull
    private String pkey;
    /**
     * 网格编码
     */
    @NotNull
    private String code;
    @NotNull
    private String name;
    private String pcode;
    private String pname;
    /**
     * 网格封面图
     */
    private String picUrl;
    private String type;
    private String typeName;
    /**
     * 地图网格范围
     */
    private Polygon shape;
    /**
     * 面积
     */
    private Double area;
    private String color;
    private String scope;
    private String supervise;
    private Boolean isActive;
    private String activeReason;
    private Date activeTime;
    /**
     * 是否删除
     */
    private Boolean isDeleted;

    @NotNull
    private Integer sortIdx;
    @NotNull
    private Date createTime;
    @NotNull
    private Date updateTime;
}
