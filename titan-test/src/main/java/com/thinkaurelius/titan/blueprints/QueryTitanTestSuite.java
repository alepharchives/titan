package com.thinkaurelius.titan.blueprints;

import com.thinkaurelius.titan.core.TitanGraph;
import com.thinkaurelius.titan.core.TitanKey;
import com.tinkerpop.blueprints.Direction;
import com.tinkerpop.blueprints.QueryTestSuite;
import com.tinkerpop.blueprints.impls.GraphTest;

/**
 * (c) Matthias Broecheler (me@matthiasb.com)
 */

public class QueryTitanTestSuite extends QueryTestSuite {


    public QueryTitanTestSuite(final GraphTest graphTest) {
        super(graphTest);
    }

    @Override
    public void testGraphQueryForVertices() {
        TitanGraph g = (TitanGraph) graphTest.generateGraph();
        if (g.getType("age")==null) {
            TitanKey age = g.makeType().name("age").dataType(Integer.class).unique(Direction.OUT).makePropertyKey();
        }
        g.shutdown();
        super.testGraphQueryForVertices();
    }

    @Override
    public void testGraphQueryForEdges() {
        TitanGraph g = (TitanGraph) graphTest.generateGraph();
        if (g.getType("weight")==null) {
            TitanKey weight = g.makeType().name("weight").dataType(Double.class).unique(Direction.OUT).makePropertyKey();
        }
        g.shutdown();
        super.testGraphQueryForEdges();
    }
}
