package com.first.springboot.cruddemo.rest;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;


import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Path("/health/database")
public class DatabaseHealthResource {

    @Autowired
    private DataSource dataSource;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response checkDatabaseHealth() {
        Map<String, Object> response = new HashMap<>();

        try (Connection conn = dataSource.getConnection()) {
            boolean isValid = conn.isValid(5);
            response.put("status", isValid ? "OK" : "Failed");
            response.put("timestamp", new Date());

            if (isValid) {
                response.put("message", "Database connection successful");
                return Response.ok(response).build();
            } else {
                response.put("message", "Database connection failed");
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity(response)
                        .build();
            }

        } catch (SQLException e) {
           // log.error("Database connection error", e);
            response.put("status", "ERROR");
            response.put("message", e.getMessage());
            response.put("timestamp", new Date());
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(response)
                    .build();
        }
    }
}