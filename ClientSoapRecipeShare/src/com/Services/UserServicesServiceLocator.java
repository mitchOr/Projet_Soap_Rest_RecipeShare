/**
 * UserServicesServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.Services;

public class UserServicesServiceLocator extends org.apache.axis.client.Service implements com.Services.UserServicesService {

    public UserServicesServiceLocator() {
    }


    public UserServicesServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public UserServicesServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for UserServices
    private java.lang.String UserServices_address = "http://localhost:8080/RecipesShareSOAP/services/UserServices";

    public java.lang.String getUserServicesAddress() {
        return UserServices_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String UserServicesWSDDServiceName = "UserServices";

    public java.lang.String getUserServicesWSDDServiceName() {
        return UserServicesWSDDServiceName;
    }

    public void setUserServicesWSDDServiceName(java.lang.String name) {
        UserServicesWSDDServiceName = name;
    }

    public com.Services.UserServices getUserServices() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(UserServices_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getUserServices(endpoint);
    }

    public com.Services.UserServices getUserServices(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.Services.UserServicesSoapBindingStub _stub = new com.Services.UserServicesSoapBindingStub(portAddress, this);
            _stub.setPortName(getUserServicesWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setUserServicesEndpointAddress(java.lang.String address) {
        UserServices_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.Services.UserServices.class.isAssignableFrom(serviceEndpointInterface)) {
                com.Services.UserServicesSoapBindingStub _stub = new com.Services.UserServicesSoapBindingStub(new java.net.URL(UserServices_address), this);
                _stub.setPortName(getUserServicesWSDDServiceName());
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
        if ("UserServices".equals(inputPortName)) {
            return getUserServices();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://Services.com", "UserServicesService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://Services.com", "UserServices"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("UserServices".equals(portName)) {
            setUserServicesEndpointAddress(address);
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
