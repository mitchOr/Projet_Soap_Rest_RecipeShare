/**
 * AuthenticationServiceServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.Services;

public class AuthenticationServiceServiceLocator extends org.apache.axis.client.Service implements com.Services.AuthenticationServiceService {

    public AuthenticationServiceServiceLocator() {
    }


    public AuthenticationServiceServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public AuthenticationServiceServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for AuthenticationService
    private java.lang.String AuthenticationService_address = "http://localhost:8080/RecipesShareSOAP/services/AuthenticationService";

    public java.lang.String getAuthenticationServiceAddress() {
        return AuthenticationService_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String AuthenticationServiceWSDDServiceName = "AuthenticationService";

    public java.lang.String getAuthenticationServiceWSDDServiceName() {
        return AuthenticationServiceWSDDServiceName;
    }

    public void setAuthenticationServiceWSDDServiceName(java.lang.String name) {
        AuthenticationServiceWSDDServiceName = name;
    }

    public com.Services.AuthenticationService getAuthenticationService() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(AuthenticationService_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getAuthenticationService(endpoint);
    }

    public com.Services.AuthenticationService getAuthenticationService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.Services.AuthenticationServiceSoapBindingStub _stub = new com.Services.AuthenticationServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getAuthenticationServiceWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setAuthenticationServiceEndpointAddress(java.lang.String address) {
        AuthenticationService_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.Services.AuthenticationService.class.isAssignableFrom(serviceEndpointInterface)) {
                com.Services.AuthenticationServiceSoapBindingStub _stub = new com.Services.AuthenticationServiceSoapBindingStub(new java.net.URL(AuthenticationService_address), this);
                _stub.setPortName(getAuthenticationServiceWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("AuthenticationService".equals(inputPortName)) {
            return getAuthenticationService();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://Services.com", "AuthenticationServiceService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://Services.com", "AuthenticationService"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("AuthenticationService".equals(portName)) {
            setAuthenticationServiceEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
