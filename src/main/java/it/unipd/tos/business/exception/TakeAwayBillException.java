////////////////////////////////////////////////////////////////////
// [EMANUELE] [PASE] [1201250]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.business.exception;

public class TakeAwayBillException extends RuntimeException {

private String mess;

    public TakeAwayBillException(String error) {
        this.mess = error;
    }

    public String getMessaggio() {
        return this.mess;
    }
}