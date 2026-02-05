package com.task.servlet;

import java.io.IOException;
import java.util.Objects;

import com.google.gson.Gson;
import com.task.bean.OrgBean;
import com.task.dao.OrgDAO;
import com.task.dto.OrgDTO;
import com.task.service.OrgService;
import com.task.service.impl.OrgServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class OrgServlet extends HttpServlet {

    // private static final Logger LOGGER = LoggerFactory.getLogger(OrgServlet.class);

    private static final long serialVersionUID = 1L;

    private final OrgDAO orgDAO = new OrgDAO();
    private final OrgService orgService = new OrgServiceImpl(orgDAO);


    // POST
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Request Path
        final String pathInfo = req.getPathInfo();

        if (Objects.isNull(pathInfo)) {
            throw new ServletException("Path info is missing");
        }

        // Create
        if (pathInfo.isBlank() || pathInfo.equals("/")) {
            this.create(req, resp);
            return;
        }

        // Default Response
        resp.setContentType("application/json");
        final String defaultResponse = "Invalid request";

        final Gson gson = new Gson();
        final String responseJson = gson.toJson(defaultResponse);
        resp.getWriter().write(responseJson);
    }


    // PUT
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Request Path
        final String pathInfo = req.getPathInfo();
        if (Objects.isNull(pathInfo)) {
            throw new ServletException("Path info is missing");
        }

        final String[] pathParts = pathInfo.split("/");
        if (pathParts.length > 1) {
            final String orgIdStr = pathParts[1];
            final int orgId = Integer.parseInt(orgIdStr);
            final String action = pathParts[2];

            // Update
            if (Objects.isNull(action) || action.isBlank() || "/".equals(action)) {
                this.update(orgId, req, resp);
                return;
            }
        }

        // Default Response
        resp.setContentType("application/json");
        final String defaultResponse = "Invalid request";

        final Gson gson = new Gson();
        final String responseJson = gson.toJson(defaultResponse);
        resp.getWriter().write(responseJson);
    }


    // DELETE
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Request Path
        final String pathInfo = req.getPathInfo();
        if (Objects.isNull(pathInfo)) {
            throw new ServletException("Path info is missing");
        }

        final String[] pathParts = pathInfo.split("/");
        if (pathParts.length > 1) {
            final String orgIdStr = pathParts[1];
            final int orgId = Integer.parseInt(orgIdStr);
            final String action = pathParts[2];

            // Update
            if (Objects.isNull(action) || action.isBlank() || "/".equals(action)) {
                this.purge(orgId, resp);
                return;
            }
        }

        // Default Response
        resp.setContentType("application/json");
        final String defaultResponse = "Invalid request";

        final Gson gson = new Gson();
        final String responseJson = gson.toJson(defaultResponse);
        resp.getWriter().write(responseJson);
    }


    // GET
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Request Path
        final String pathInfo = req.getPathInfo();

        if (Objects.isNull(pathInfo)) {
            throw new ServletException("Path info is missing");
        }

        final String[] pathParts = pathInfo.split("/");
        if (pathParts.length > 1) {
            final String orgIdStr = pathParts[1];
            final int orgId = Integer.parseInt(orgIdStr);
            final String action = pathParts[2];

            // Read
            if (Objects.isNull(action) || action.isBlank() || "/".equals(action)) {
                this.read(orgId, resp);
                return;
            }
        }

        // Default Response
        resp.setContentType("application/json");
        final String defaultResponse = "Invalid request";

        final Gson gson = new Gson();
        final String responseJson = gson.toJson(defaultResponse);
        resp.getWriter().write(responseJson);
    }


    // Service Methods

    private void create(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // OrgBean from Request
        final OrgBean orgBean = this.toOrgBean(req);

        // Create
        final int orgId = orgService.create(orgBean);

        // Response
        final String response = String.format("Successfully created org - %d", orgId);
        final Gson gson = new Gson();
        final String responseJson = gson.toJson(response);
        resp.getWriter().write(responseJson);
    }

    private void update(final int orgId, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // Request to OrgBean
        final OrgBean orgBean = this.toOrgBean(req);

        // Update
        orgService.update(orgId, orgBean);

        // Response
        final String response = String.format("Successfully udpated org - %d", orgId);
        final Gson gson = new Gson();
        final String responseJson = gson.toJson(response);
        resp.getWriter().write(responseJson);
    }

    private void purge(final int orgId, HttpServletResponse resp) throws IOException {
        // Delete
        orgService.purge(orgId);

        // Response
        final String response = String.format("Successfully purged org - %d", orgId);
        final Gson gson = new Gson();
        final String responseJson = gson.toJson(response);
        resp.getWriter().write(responseJson);
    }

    private void read(final int orgId, HttpServletResponse resp) throws IOException {
        // Read
        final OrgDTO org = orgService.read(orgId);

        // Response
        final Gson gson = new Gson();
        final String responseJson = gson.toJson(org);
        resp.getWriter().write(responseJson);
    }


    // Private Methods
    // ------------------------------------------------------------------------

    private OrgBean toOrgBean(HttpServletRequest req) {
        final OrgBean orgBean = new OrgBean();

        final String id = req.getParameter("id");
        if (Objects.nonNull(id)) {
            orgBean.setId(Integer.parseInt(id));
        }

        final String version = req.getParameter("version");
        if (Objects.nonNull(version)) {
            orgBean.setVersion(Long.parseLong(version));
        }

        final String name = req.getParameter("name");
        orgBean.setName(name);
        final String description = req.getParameter("description");
        orgBean.setDescription(description);

        final String addressLine1 = req.getParameter("addressLine1");
        orgBean.setAddressLine1(addressLine1);
        final String addressLine2 = req.getParameter("addressLine2");
        orgBean.setAddressLine2(addressLine2);
        final String city = req.getParameter("city");
        orgBean.setCity(city);
        final String state = req.getParameter("state");
        orgBean.setState(state);
        final String zipCode = req.getParameter("zipCode");
        orgBean.setZipCode(zipCode);
        final String country = req.getParameter("country");
        orgBean.setCountry(country);

        final String phoneNumber = req.getParameter("phoneNumber");
        orgBean.setPhoneNumber(phoneNumber);
        final String email = req.getParameter("email");
        orgBean.setEmail(email);

        return orgBean;
    }


}
