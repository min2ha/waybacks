/**
 * 
 */
package uk.bl.bspa.webarchive.prototype.lockingFilter;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

/**
 * @author Andrew Jackson <Andrew.Jackson@bl.uk>
 *
 */
public class StatusExposingServletResponse extends HttpServletResponseWrapper {

    private int httpStatus;

    public StatusExposingServletResponse(HttpServletResponse response) {
        super(response);
    }

    @Override
    public void sendError(int sc) throws IOException {
        httpStatus = sc;
        super.sendError(sc);
    }

    @Override
    public void sendError(int sc, String msg) throws IOException {
        httpStatus = sc;
        super.sendError(sc, msg);
    }


    @Override
    public void setStatus(int sc) {
        httpStatus = sc;
        super.setStatus(sc);
    }

    public int getStatus() {
        return httpStatus;
    }

}
