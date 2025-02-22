package simple.web.app.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet(urlPatterns = {"/hello"})
public class HelloWorldServlet extends HttpServlet {

    private static final long serialVersionUID = -4646757802549911204L;

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloWorldServlet.class);


    // Servlet Methods
    // ------------------------------------------------------------------------

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            resp.getWriter().write("Hello World");
        } catch (IOException e) {
            LOGGER.error("Failed to process request :: {}", req);
        }
    }


}
