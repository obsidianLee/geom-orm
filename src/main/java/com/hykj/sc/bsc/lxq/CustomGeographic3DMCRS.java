package com.hykj.sc.bsc.lxq;

import org.geolatte.geom.G3DM;
import org.geolatte.geom.crs.CoordinateSystem;
import org.geolatte.geom.crs.CoordinateSystemAxis;
import org.geolatte.geom.crs.CrsId;
import org.geolatte.geom.crs.GeographicCoordinateReferenceSystem;

public class CustomGeographic3DMCRS extends GeographicCoordinateReferenceSystem<G3DM> {
    /**
     * Constructs a <code>HorizontalCoordinateReferenceSystem</code>.
     *
     * @param crsId            the {@link CrsId} that identifies this
     *                         <code>CoordinateReferenceSystem</code> uniquely
     * @param name             the commonly used name for this <code>CoordinateReferenceSystem</code>
     * @param coordinateSystem the coordinate system to use  @throws java.lang.IllegalArgumentException if less than
     *                         two {@link CoordinateSystemAxis CoordinateSystemAxes} are passed.
     */
    public CustomGeographic3DMCRS(CrsId crsId, String name, CoordinateSystem<G3DM> coordinateSystem) {
        super(crsId, name, coordinateSystem);
    }
}
