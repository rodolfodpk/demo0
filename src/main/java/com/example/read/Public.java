/*
 * This file is generated by jOOQ.
 */
package com.example.read;


import com.example.read.tables.CustomerSummary;
import com.example.read.tables.Projections;
import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;

import java.util.Arrays;
import java.util.List;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Public extends SchemaImpl {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public</code>
     */
    public static final Public PUBLIC = new Public();

    /**
     * The table <code>public.customer_summary</code>.
     */
    public final CustomerSummary CUSTOMER_SUMMARY = CustomerSummary.CUSTOMER_SUMMARY;

    /**
     * The table <code>public.projections</code>.
     */
    public final Projections PROJECTIONS = Projections.PROJECTIONS;

    /**
     * No further instances allowed
     */
    private Public() {
        super("public", null);
    }


    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        return Arrays.<Table<?>>asList(
            CustomerSummary.CUSTOMER_SUMMARY,
            Projections.PROJECTIONS);
    }
}
