package library.wslibrarycheckout.library.exceptionhandling;

import org.springframework.http.HttpStatus;

import java.util.*;


public class Response<T>   {

    private Date timeStamp;
    private boolean status;
    private HttpStatus httpStatus;
    private List<String> message;
    private Set result;


    public Response(String message, boolean status, Date timeStamp, HttpStatus httpStatus) {
        this(Collections.singletonList(message), status, timeStamp, httpStatus);
    }

    public Response(boolean status, Date timeStamp, HttpStatus httpStatus, String... message) {
        this(Arrays.asList(message), status, timeStamp, httpStatus);
    }

    public Response(String message, boolean status, Date timeStamp, HttpStatus httpStatus, Set result) {
        this(Collections.singletonList(message), status, timeStamp, httpStatus, result);
    }

    public Response() {

    }

    public Response(List<String> message, boolean status, Date timeStamp, HttpStatus httpStatus) {
        this.message = message;
        this.status = status;
        this.timeStamp = timeStamp;
        this.httpStatus = httpStatus;
    }

    public Response(List<String> message, boolean status, Date timeStamp, HttpStatus httpStatus, Set result) {
        this.message = message;
        this.status = status;
        this.timeStamp = timeStamp;
        this.httpStatus = httpStatus;
        this.result = result;
    }

    public List<String> getMessage() {
        return message;
    }

    public void setMessage(List<String> message) {
        this.message = message;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public Set getResult() {
        return result;
    }

    public void setResult(Set result) {
        this.result = result;
    }

}

