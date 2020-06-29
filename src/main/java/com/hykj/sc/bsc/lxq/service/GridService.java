package com.hykj.sc.bsc.lxq.service;

import com.hykj.sc.bsc.lxq.CustomGeographic3DMCRS;
import com.hykj.sc.bsc.lxq.dataobject.GridDO;
import com.hykj.sc.bsc.lxq.dataobject.GridDO2;
import com.hykj.sc.bsc.lxq.ipo.GridIPO;
import com.hykj.sc.bsc.lxq.ipo.GridIPO2;
import com.hykj.sc.bsc.lxq.ipo.GridIPO3;
import com.hykj.sc.bsc.lxq.repository.GridDO2Repository;
import com.hykj.sc.bsc.lxq.repository.GridDORepository;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.LinearRing;
import com.vividsolutions.jts.geom.Polygon;
import lombok.extern.slf4j.Slf4j;
import org.geolatte.geom.*;
import org.geolatte.geom.crs.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;

@Slf4j
@Service
public class GridService {
    @Autowired
    GridDORepository gridDao;
    @Autowired
    GridDO2Repository gridDao2;


    /**
     * 方案一
     * 采用geotools的org.locationtech.jts.geom包下geometry类型接收参数，并通过WKT方式转换为hibernate支持的geometry
     * @param gridIPO
     */
    public void insertGridSolution1(GridIPO gridIPO) {
//        org.locationtech.jts.geom.GeometryFactory geometryFactory = JTSFactoryFinder.getGeometryFactory();

        /**如果接收的是4维的坐标点集合，可以参考如下代码，CoordinateXYZM类接收4维参数并可生成对应几何体，应当注意，CoordinateXYZM
         * 类属于geotools，非hibernate支持Geometry实体类，需通过WKT或WKB方式转换；Geotools自带WKT解析器，可以写出几何体4维文本形
         * 式，但是不能反过来读取，直接使用toString()方法写出的文本，z轴m轴数据会丢弃，然后通过geolatte.geom包即hibernate支持的空
         * 间实体方言包，转换为hibernate支持的Geometry或子类实体类，当然，MYSQL数据库也只支持二维空间几何类型。所以，如果使用MYSQL
         * 存储4维坐标的空间几何体，对应字段不能设置为geometry或其子类型，直接用varchar保存*/
//        List<CoordinateXYZM> cooList = gridIPO.getShape();
//        org.locationtech.jts.geom.LinearRing linearRing = geometryFactory.createLinearRing(cooList.toArray(new CoordinateXYZM[cooList.size()]));
//        org.locationtech.jts.geom.Polygon polygon = geometryFactory.createPolygon(linearRing, null);
//        System.out.println(polygon);
//        WKTWriter wktWriter = new WKTWriter(4);
//        String polygonText = wktWriter.write(polygon);
//        System.out.println(polygonText);
//        String text = polygonText.replace("ZM", "");
//        System.out.println(text);
//
//        try {
//            org.locationtech.jts.geom.Geometry decodePolygon = new WKTReader(geometryFactory).read(polygonText);
//            org.locationtech.jts.geom.Coordinate[] coordinates = ( org.locationtech.jts.geom.Coordinate[])decodePolygon.getCoordinates();
//            System.out.println(m);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }

        /**如果接收的是2维的坐标点，可选方案颇多，可以参考如下代码，Coordinate类接收2维参数并可生成对应几何体，并通过WKT方式转换为
         * hibernate支持的实体类，该方案优点是可以使用geotools的能力，对几何类做运算，缺点是通过WKT形式转换为hibernate支持类时耗
         * 时较长，数秒以上的时间，对于仅存取的需求来讲不合适*/
//        List<org.locationtech.jts.geom.Coordinate> cooList = gridIPO.getShape();
//        org.locationtech.jts.geom.LinearRing linearRing = geometryFactory.createLinearRing(cooList.toArray(new org.locationtech.jts.geom.Coordinate[cooList.size()]));
//        org.locationtech.jts.geom.Polygon polygon = geometryFactory.createPolygon(linearRing, null);
//
//        org.geolatte.geom.Polygon decodePg = (org.geolatte.geom.Polygon) Wkt.newDecoder(Wkt.Dialect.MYSQL_WKT).decode(polygon.toString());
//        GridDO gridDO = new GridDO();
//        gridDO.setName(gridIPO.getName());
//        gridDO.setCode(gridIPO.getCode());
//        gridDO.setShape(decodePg);
//        gridDO.setKey(UUID.randomUUID().toString().replace("-", ""));
//        gridDO.setCreateTime(new Date());
//        gridDO.setUpdateTime(new Date());
//        gridDao.save(gridDO);
    }

    public GridIPO getGridDataSolution1(String code) {
//        GridDO gridDO = gridDao.findByCode(code);
//        org.geolatte.geom.Polygon shape = gridDO.getShape();
//        String encodeShape = Wkt.newEncoder(Wkt.Dialect.MYSQL_WKT).encode(shape);

//        org.locationtech.jts.geom.GeometryFactory gf = JTSFactoryFinder.getGeometryFactory(null);
//        WKTReader wktReader = new WKTReader(gf);
//        org.locationtech.jts.geom.Polygon polygon;
//        try {
//            polygon = (org.locationtech.jts.geom.Polygon) wktReader.read(shape.toString());
//        } catch (ParseException e) {
//            e.printStackTrace();
//            return null;
//        }
//        org.locationtech.jts.geom.Coordinate[] coordinates = polygon.getExteriorRing().getCoordinates();
//        List<org.locationtech.jts.geom.CoordinateXYZM> cooList = Arrays.asList(coordinates);
//        List<org.locationtech.jts.geom.Coordinate> cooList = Arrays.asList(coordinates);
//        GridIPO ipo = new GridIPO();
//        ipo.setName(gridDO.getName());
//        ipo.setCode(gridDO.getCode());
//        ipo.setShape(cooList);
//        return ipo;
        return null;
    }

    /**
     * 方案二
     * 直接使用hibernate支持的com.vividsolutions.jts.geom包下Geometry做存取介质，支持维坐标点，但需考虑数据库是否支持(MYSQL
     * 不支持)，该方法实现二维坐标点
     * 坐标点集需闭合，即首尾点要相同
     * @param gridIPO
     */
    public void insertGridSolution2(GridIPO2 gridIPO) {
        GeometryFactory geometryFactory = new GeometryFactory();
        List<Coordinate> codList = gridIPO.getShape();
        LinearRing ring = geometryFactory.createLinearRing(codList.toArray(new Coordinate[codList.size()]));
        Polygon polygon = geometryFactory.createPolygon(ring, null);
        GridDO2 gridDO = new GridDO2();
        gridDO.setName(gridIPO.getName());
        gridDO.setCode(gridIPO.getCode());
        gridDO.setShape(polygon);
        gridDO.setCreateTime(new Date());
        gridDO.setUpdateTime(new Date());
        gridDO.setKey(UUID.randomUUID().toString().replace("-", ""));
        gridDao2.save(gridDO);
    }

    public GridIPO2 getGridDataSolution2(String code) {
        GridDO2 gridDO = gridDao2.findByCode(code);
        Polygon shape = gridDO.getShape();
        Coordinate[] coo = shape.getCoordinates();
        GridIPO2 ipo = new GridIPO2();
        ipo.setName(gridDO.getName());
        ipo.setCode(gridDO.getCode());
        ipo.setShape(Arrays.asList(coo));
        return ipo;
    }

    /**
     * 方案三
     * 采用hibernate5.x开始支持的geolatte包中的实体，通过定制参考坐标系统（本项目采用）或采用国际通用参考坐标系统
     * （WGS84,geolatte自带实现）,构建空间地理多边形Polygon。
     * 注：该方法无法从jackson直接转换为G3DM实体类,IPO类中需自建数组集合接收前端数据
     * @param ipo
     */
    public void insertGridSolution3(GridIPO3 ipo) {
        GeodeticLongitudeCSAxis x = new GeodeticLongitudeCSAxis("x", Unit.DEGREE);
        GeodeticLatitudeCSAxis y = new GeodeticLatitudeCSAxis("y", Unit.DEGREE);
        StraightLineAxis z = new StraightLineAxis("z", CoordinateSystemAxisDirection.UP, Unit.METER);
        MeasureStraightLineAxis m = new MeasureStraightLineAxis("m", Unit.METER);
        EllipsoidalCoordinateSystem3DM cs = new EllipsoidalCoordinateSystem3DM(x, y, z, m);
        CustomGeographic3DMCRS crs = new CustomGeographic3DMCRS(CrsId.UNDEFINED, "custom", cs);
        PositionSequenceBuilder<G3DM> builder = PositionSequenceBuilders.variableSized(G3DM.class);
        List<double[]> positions = ipo.getShape();
        if (!StringUtils.isEmpty(positions)) {
            for (int i = 0; i < positions.size(); i++) {
                double[] crd = positions.get(i);
                G3DM g = new G3DM(crd[0], crd[1], crd[2], crd[3]);
                builder.add(g);
            }
        }
        PositionSequence<G3DM> g3DMS = builder.toPositionSequence();
        org.geolatte.geom.LinearRing<G3DM> linearRing = Geometries.mkLinearRing(g3DMS, crs);
        org.geolatte.geom.Polygon<G3DM> polygon = Geometries.mkPolygon(linearRing);
        GridDO gd = new GridDO();
        gd.setName(ipo.getName());
        gd.setShape(polygon);
        gd.setCode(ipo.getCode());
        gd.setCreateTime(new Date());
        gd.setUpdateTime(new Date());
        gd.setKey(UUID.randomUUID().toString().replace("-", ""));
        gridDao.save(gd);
    }

    public GridIPO3 getGridDataSolution3(String code) {
        GridDO gridDO = gridDao.findByCode(code);
        org.geolatte.geom.Polygon<G3DM> shape = gridDO.getShape();
        org.geolatte.geom.LinearRing<G3DM> exteriorRing = shape.getExteriorRing();
        PositionSequence<G3DM> positions = exteriorRing.getPositions();
        List<double[]> shapes = new ArrayList<>(positions.size());
        for (int i = 0; i < positions.size(); i++) {
            G3DM po = positions.getPositionN(i);
            shapes.add(new double[]{po.getLat(),po.getLon(),po.getHeight(),po.getM()});
        }
        GridIPO3 ipo = new GridIPO3();
        ipo.setName(gridDO.getName());
        ipo.setCode(gridDO.getCode());
        ipo.setShape(shapes);
        return ipo;
    }


}
