
package th.go.nhso.ucws.tokenws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "UCWSTokenP1", targetNamespace = "http://tokenws.ucws.nhso.go.th/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface UCWSTokenP1 {


    /**
     * 
     * @param smctoken
     * @param personId
     * @param userPersonId
     * @return
     *     returns th.go.nhso.ucws.tokenws.NhsoDataSetC1
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "searchCurrentByPID", targetNamespace = "http://tokenws.ucws.nhso.go.th/", className = "th.go.nhso.ucws.tokenws.SearchCurrentByPID")
    @ResponseWrapper(localName = "searchCurrentByPIDResponse", targetNamespace = "http://tokenws.ucws.nhso.go.th/", className = "th.go.nhso.ucws.tokenws.SearchCurrentByPIDResponse")
    @Action(input = "http://tokenws.ucws.nhso.go.th/UCWSTokenP1/searchCurrentByPIDRequest", output = "http://tokenws.ucws.nhso.go.th/UCWSTokenP1/searchCurrentByPIDResponse")
    public NhsoDataSetC1 searchCurrentByPID(
        @WebParam(name = "user_person_id", targetNamespace = "")
        String userPersonId,
        @WebParam(name = "smctoken", targetNamespace = "")
        String smctoken,
        @WebParam(name = "person_id", targetNamespace = "")
        String personId);

}
