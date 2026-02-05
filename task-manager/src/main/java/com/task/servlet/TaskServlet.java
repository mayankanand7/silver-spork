package com.task.servlet;

import java.io.IOException;
import java.util.Objects;

import com.google.gson.Gson;
import com.task.bean.TaskBean;
import com.task.dao.TaskDAO;
import com.task.dto.TaskDTO;
import com.task.service.TaskService;
import com.task.service.impl.TaskServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class TaskServlet extends HttpServlet {

    // private static final Logger LOGGER = LoggerFactory.getLogger(TaskServlet.class);

    private static final long serialVersionUID = 1L;

    private final TaskDAO taskDAO = new TaskDAO();
    private final TaskService taskService = new TaskServiceImpl(taskDAO);


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
        // Bean from Request
        final TaskBean orgBean = this.toTaskBean(req);

        // Create
        final int orgId = taskService.create(orgBean);

        // Response
        final String response = String.format("Successfully created task - %d", orgId);
        final Gson gson = new Gson();
        final String responseJson = gson.toJson(response);
        resp.getWriter().write(responseJson);
    }

    private void update(final int id, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // Request to Bean
        final TaskBean orgBean = this.toTaskBean(req);

        // Update
        taskService.update(id, orgBean);

        // Response
        final String response = String.format("Successfully udpated task - %d", id);
        final Gson gson = new Gson();
        final String responseJson = gson.toJson(response);
        resp.getWriter().write(responseJson);
    }

    private void purge(final int id, HttpServletResponse resp) throws IOException {
        // Delete
        taskService.purge(id);

        // Response
        final String response = String.format("Successfully purged task - %d", id);
        final Gson gson = new Gson();
        final String responseJson = gson.toJson(response);
        resp.getWriter().write(responseJson);
    }

    private void read(final int id, HttpServletResponse resp) throws IOException {
        // Read
        final TaskDTO user = taskService.read(id);

        // Response
        final Gson gson = new Gson();
        final String responseJson = gson.toJson(user);
        resp.getWriter().write(responseJson);
    }


    // Private Methods
    // ------------------------------------------------------------------------

    private TaskBean toTaskBean(HttpServletRequest req) {
        final TaskBean bean = new TaskBean();

        final String id = req.getParameter("id");
        if (Objects.nonNull(id)) {
            bean.setId(Integer.parseInt(id));
        }
        final String version = req.getParameter("version");
        if (Objects.nonNull(version)) {
            bean.setVersion(Long.parseLong(version));
        }

        final String userIdStr = req.getParameter("userId");
        final int userId = Integer.parseInt(userIdStr);
        bean.setUserId(userId);
        final String parentIdStr = req.getParameter("parentId");
        final int parentId = Integer.parseInt(parentIdStr);
        bean.setParentId(parentId);

        final String title = req.getParameter("title");
        bean.setTitle(title);
        final String description = req.getParameter("description");
        bean.setDescription(description);

        final String isCompletedStr = req.getParameter("isCompleted");
        final Boolean isCompleted = Boolean.parseBoolean(isCompletedStr);
        bean.setIsCompleted(isCompleted);

        final String isActiveStr = req.getParameter("isActive");
        final Boolean isActive = Boolean.parseBoolean(isActiveStr);
        bean.setIsActive(isActive);

        return bean;
    }


}
