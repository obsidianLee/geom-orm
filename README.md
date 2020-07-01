# geometry-orm-hibernate
## 项目目的
该工程展示了如何通过java实体类映射到数据库geometry类型字段。工程中提供了简单的插入数据和读取数据两个功能，有三个实现方案。其中
方案一和方案三由于MYSQL支持的geometry类型仅支持二维坐标，所以在本工程实际调用时会报错。当然如果方案一调整坐标类CoordinateXYZM为
同一包下的Coordinate类，则可以正确执行插入查询操作；同样，方案三如果调整坐标类G3DM为G2D，则同样可以正常执行。原因就是前者是四维
坐标类，有四个参数，后者是2维坐标类，有两个参数。
## 项目环境
springMVC5.x    Hibernate5.x    geotools工具包