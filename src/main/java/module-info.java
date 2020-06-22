module es.jlarriba.jrmapi {
    requires org.apache.logging.log4j;
    requires java.net.http;
    requires com.google.gson;
    requires net.lingala.zip4j;

    exports es.jlarriba.jrmapi;
    exports es.jlarriba.jrmapi.model;
    opens es.jlarriba.jrmapi.http to es.jlarriba.jrmapi;
}