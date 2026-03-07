package edu.eci.MicroSpringBoot.framework;

public interface WebMethod {
    String execute(HttpRequest req, HttpResponse res);
}
