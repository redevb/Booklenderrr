package kg.java.lesson44;

import com.sun.net.httpserver.HttpExchange;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import kg.java.server.ContentType;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import kg.java.lesson44.models.Book;
import kg.java.lesson44.models.BookDataModel;
import kg.java.lesson44.models.EmployeesDataModel;
import kg.java.server.BasicServer;
import kg.java.server.ResponseCodes;
import kg.java.server.Utils;
import java.util.HashMap;
import java.util.Map;

public class Lesson44Server extends BasicServer {
    private final static Configuration freemarker = initFreeMarker();

    public Lesson44Server(String host, int port) throws IOException {
        super(host, port);
        registerGet("/", this::homeGetHandler);
        registerGet("/sample", this::freemarkerSampleHandler);
        registerGet("/books",this::BooksHandler);
        registerGet("/employees",this::employeesHandler);
    }


    private static Configuration initFreeMarker() {
        try {
            Configuration cfg = new Configuration(Configuration.VERSION_2_3_29);
            cfg.setDirectoryForTemplateLoading(new File("data"));
            cfg.setDefaultEncoding("UTF-8");
            cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
            cfg.setLogTemplateExceptions(false);
            cfg.setWrapUncheckedExceptions(true);
            cfg.setFallbackOnNullLoopVariable(false);
            return cfg;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void freemarkerSampleHandler(HttpExchange exchange) {
        renderTemplate(exchange, "sample.html", getSampleDataModel());
    }

    protected void renderTemplate(HttpExchange exchange, String templateFile, Object dataModel) {
        try {
            Template temp = freemarker.getTemplate(templateFile);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            try (OutputStreamWriter writer = new OutputStreamWriter(stream)) {
                temp.process(dataModel, writer);
                writer.flush();
                var data = stream.toByteArray();
                sendByteData(exchange, ResponseCodes.OK, ContentType.TEXT_HTML, data);
            }
        } catch (IOException | TemplateException e) {
            e.printStackTrace();
        }
    }

    private SampleDataModel getSampleDataModel() {
        return new SampleDataModel();
    }
    private void homeGetHandler (HttpExchange exchange){
        Map<String, Object> data = new HashMap<>();
        renderTemplate(exchange, "index.html", data);
    }

    private void BooksHandler (HttpExchange exchange){
        Map<String, Object> data = new HashMap<>();
        String queryParams = getQueryParams(exchange);
        Map<String, String> params = Utils.parseUrlEncoded(queryParams, "&");
        if (params.get("id") != null) {
            var books = new BookDataModel().getBooks();
            for (Book book : books) {
                if (book.getId().equalsIgnoreCase(params.get("id"))) {
                    data.put("book", book);
                    break;
                }
            }
            if (data.get("book") != null) {
                renderTemplate(exchange, "book.ftlh", data);
            } else {
                respond404(exchange);
            }

        } else {
            renderTemplate(exchange, "books.ftlh", getBooksModel());
        }
    }
    private BookDataModel getBooksModel () {
        return new BookDataModel();
    }

    private void employeesHandler(HttpExchange exchange){
        renderTemplate(exchange, "employees.ftlh", getEmployeesDataModel());
    }

    private Object getEmployeesDataModel() {
        return new EmployeesDataModel();
    }
}
