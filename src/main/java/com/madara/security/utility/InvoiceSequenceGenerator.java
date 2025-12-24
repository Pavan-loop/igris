package com.madara.security.utility;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class InvoiceSequenceGenerator {

    private static JdbcTemplate jdbcTemplate;

    public InvoiceSequenceGenerator(JdbcTemplate jdbcTemplate) {
        InvoiceSequenceGenerator.jdbcTemplate = jdbcTemplate;
    }

    public static Long nextVal() {
        return jdbcTemplate.queryForObject(
                "SELECT nextval('invoice_seq')",
                Long.class
        );
    }
}
