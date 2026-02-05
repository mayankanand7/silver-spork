package com.task.servlet;

import java.io.IOException;
import java.util.Objects;

import com.google.gson.Gson;
import com.task.bean.UserBean;
import com.task.dao.UserDAO;
import com.task.dto.UserDTO;
import com.task.service.UserService;
import com.task.service.impl.UserServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class UserServlet extends HttpServlet {

    // private static final Logger LOGGER = LoggerFactory.getLogger(UserServlet.class);

    private static final long serialVersionUID = 1L;

    private final UserDAO userDAO = new UserDAO();
    private final UserService userService = new UserServiceImpl(userDAO);


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
            final String userIdStr = pathParts[1];
            final int userId = Integer.parseInt(userIdStr);
            final String action = pathParts[2];

            // Read
            if (Objects.isNull(action) || action.isBlank() || "/".equals(action)) {
                this.read(userId, resp);
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
        final UserBean orgBean = this.toUserBean(req);

        // Create
        final int orgId = userService.create(orgBean);

        // Response
        final String response = String.format("Successfully created org - %d", orgId);
        final Gson gson = new Gson();
        final String responseJson = gson.toJson(response);
        resp.getWriter().write(responseJson);
    }

    private void update(final int userId, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // Request to OrgBean
        final UserBean orgBean = this.toUserBean(req);

        // Update
        userService.update(userId, orgBean);

        // Response
        final String response = String.format("Successfully udpated org - %d", userId);
        final Gson gson = new Gson();
        final String responseJson = gson.toJson(response);
        resp.getWriter().write(responseJson);
    }

    private void purge(final int userId, HttpServletResponse resp) throws IOException {
        // Delete
        userService.purge(userId);

        // Response
        final String response = String.format("Successfully purged org - %d", userId);
        final Gson gson = new Gson();
        final String responseJson = gson.toJson(response);
        resp.getWriter().write(responseJson);
    }

    private void read(final int userId, HttpServletResponse resp) throws IOException {
        // Read
        final UserDTO user = userService.read(userId);

        // Response
        final Gson gson = new Gson();
        final String responseJson = gson.toJson(user);
        resp.getWriter().write(responseJson);
    }


    // Private Methods
    // ------------------------------------------------------------------------

    private UserBean toUserBean(HttpServletRequest req) {
        final UserBean bean = new UserBean();

        final String id = req.getParameter("id");
        if (Objects.nonNull(id)) {
            bean.setId(Integer.parseInt(id));
        }
        final String version = req.getParameter("version");
        if (Objects.nonNull(version)) {
            bean.setVersion(Long.parseLong(version));
        }

        final String username = req.getParameter("username");
        bean.setUsername(username);
        final String firstName = req.getParameter("firstName");
        bean.setFirstName(firstName);
        final String lastName = req.getParameter("lastName");
        bean.setLastName(lastName);

        final String email = req.getParameter("email");
        bean.setEmail(email);
        final String phoneNumber = req.getParameter("phoneNumber");
        bean.setPhoneNumber(phoneNumber);

        return bean;
    }


}
