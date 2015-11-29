package com.web.webmapsoft.clientews;




//----------------------------------------------------
//
// Generated by www.easywsdl.com
// Version: 4.1.9.1
//
// Created by Quasar Development at 28-11-2015
//
//---------------------------------------------------




import org.ksoap2.HeaderProperty;
import org.ksoap2.serialization.*;
import org.ksoap2.transport.*;
import org.kxml2.kdom.Element;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class NLIBINDING_SIBTC
{
    interface NLIIWcfMethod
    {
        NLIExtendedSoapSerializationEnvelope CreateSoapEnvelope() throws java.lang.Exception;

        java.lang.Object ProcessResult(NLIExtendedSoapSerializationEnvelope __envelope,java.lang.Object result) throws java.lang.Exception;
    }

    //String url="http://desqpsap.quimpac.corp:1080/sap/bc/srt/rfc/sap/zpmws_sibtc/400/zpmws_sibtc/binding_sibtc";
    String url="http://10.1.1.250:1080/sap/bc/srt/rfc/sap/zpmws_sibtc/400/zpmws_sibtc/binding_sibtc";

    int timeOut=60000;
    public List< HeaderProperty> httpHeaders;
    public boolean enableLogging;

    NLIIServiceEvents callback;
    public NLIBINDING_SIBTC(){}

    public NLIBINDING_SIBTC (NLIIServiceEvents callback)
    {
        this.callback = callback;
    }
    public NLIBINDING_SIBTC(NLIIServiceEvents callback,String url)
    {
        this.callback = callback;
        this.url = url;
    }

    public NLIBINDING_SIBTC(NLIIServiceEvents callback,String url,int timeOut)
    {
        this.callback = callback;
        this.url = url;
        this.timeOut=timeOut;
    }

    protected org.ksoap2.transport.Transport createTransport()
    {
        try
        {
            java.net.URI uri = new java.net.URI(url);
            if(uri.getScheme().equalsIgnoreCase("https"))
            {
                int port=uri.getPort()>0?uri.getPort():443;
                return new HttpsTransportSE(uri.getHost(), port, uri.getPath(), timeOut);
            }
            else
            {
                return new HttpTransportSE(url,timeOut);
            }

        }
        catch (java.net.URISyntaxException e)
        {
        }
        return null;
    }
    
    protected NLIExtendedSoapSerializationEnvelope createEnvelope()
    {
        NLIExtendedSoapSerializationEnvelope envelope= new NLIExtendedSoapSerializationEnvelope(NLIExtendedSoapSerializationEnvelope.VER11);
        return envelope;
    }
    
    protected java.util.List sendRequest(String methodName,NLIExtendedSoapSerializationEnvelope envelope,org.ksoap2.transport.Transport transport  )throws java.lang.Exception
    {
        return transport.call(methodName, envelope, httpHeaders);
    }

    java.lang.Object getResult(java.lang.Class destObj,java.lang.Object source,String resultName,NLIExtendedSoapSerializationEnvelope __envelope) throws java.lang.Exception
    {
        if(source==null)
        {
            return null;
        }
        if(source instanceof SoapPrimitive)
        {
            SoapPrimitive soap =(SoapPrimitive)source;
            if(soap.getName().equals(resultName))
            {
                java.lang.Object instance=__envelope.get(source,destObj);
                return instance;
            }
        }
        else
        {
            SoapObject soap = (SoapObject)source;
            if (soap.hasProperty(resultName))
            {
                java.lang.Object j=soap.getProperty(resultName);
                if(j==null)
                {
                    return null;
                }
                java.lang.Object instance=__envelope.get(j,destObj);
                return instance;
            }
            else if( soap.getName().equals(resultName)) {
                java.lang.Object instance=__envelope.get(source,destObj);
                return instance;
            }
       }

       return null;
    }

        
    public NLIZFmPmRfcWssibtcResponse ZFmPmRfcWssibtc(final NLIZstPmDataSibtc CsDataSibtc,final String IvCase,final String IvClave,final String IvUsuario ) throws java.lang.Exception
    {
        return (NLIZFmPmRfcWssibtcResponse)execute(new NLIIWcfMethod()
        {
            @Override
            public NLIExtendedSoapSerializationEnvelope CreateSoapEnvelope(){
              NLIExtendedSoapSerializationEnvelope __envelope = createEnvelope();
                __envelope.addMapping("","CsDataSibtc",new NLIZstPmDataSibtc().getClass());
                SoapObject __soapReq = new SoapObject("urn:sap-com:document:sap:soap:functions:mc-style", "ZFmPmRfcWssibtc");
                __envelope.setOutputSoapObject(__soapReq);
                
                PropertyInfo __info=null;
                __info = new PropertyInfo();
                __info.namespace="";
                __info.name="CsDataSibtc";
                __info.type=NLIZstPmDataSibtc.class;
                __info.setValue(CsDataSibtc);
                __soapReq.addProperty(__info);
                __info = new PropertyInfo();
                __info.namespace="";
                __info.name="IvCase";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(IvCase);
                __soapReq.addProperty(__info);
                __info = new PropertyInfo();
                __info.namespace="";
                __info.name="IvClave";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(IvClave);
                __soapReq.addProperty(__info);
                __info = new PropertyInfo();
                __info.namespace="";
                __info.name="IvUsuario";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(IvUsuario);
                __soapReq.addProperty(__info);
                return __envelope;
            }
            
            @Override
            public java.lang.Object ProcessResult(NLIExtendedSoapSerializationEnvelope __envelope,java.lang.Object __result)throws java.lang.Exception {
                return (NLIZFmPmRfcWssibtcResponse)getResult(NLIZFmPmRfcWssibtcResponse.class,__result,"ZFmPmRfcWssibtcResponse",__envelope);
            }
        },"");
    }
    
    public android.os.AsyncTask< Void, Void, NLIOperationResult< NLIZFmPmRfcWssibtcResponse>> ZFmPmRfcWssibtcAsync(final NLIZstPmDataSibtc CsDataSibtc,final String IvCase,final String IvClave,final String IvUsuario)
    {
        return executeAsync(new NLIFunctions.IFunc< NLIZFmPmRfcWssibtcResponse>() {
            public NLIZFmPmRfcWssibtcResponse Func() throws java.lang.Exception {
                return ZFmPmRfcWssibtc( CsDataSibtc,IvCase,IvClave,IvUsuario);
            }
        });
    }

    
    protected java.lang.Object execute(NLIIWcfMethod wcfMethod,String methodName) throws java.lang.Exception
    {
        org.ksoap2.transport.Transport __httpTransport=createTransport();
        __httpTransport.debug=enableLogging;
        NLIExtendedSoapSerializationEnvelope __envelope=wcfMethod.CreateSoapEnvelope();
        try
        {
            sendRequest(methodName, __envelope, __httpTransport);
            
        }
        finally {
            if (__httpTransport.debug) {
                if (__httpTransport.requestDump != null) {
                    android.util.Log.i("requestDump",__httpTransport.requestDump);
                }
                if (__httpTransport.responseDump != null) {
                    android.util.Log.i("responseDump",__httpTransport.responseDump);
                }
            }
        }
        java.lang.Object __retObj = __envelope.bodyIn;
        if (__retObj instanceof org.ksoap2.SoapFault){
            org.ksoap2.SoapFault __fault = (org.ksoap2.SoapFault)__retObj;
            throw convertToException(__fault,__envelope);
        }else{
            return wcfMethod.ProcessResult(__envelope,__retObj);
        }
    }
    
    protected < T> android.os.AsyncTask< Void, Void, NLIOperationResult< T>>  executeAsync(final NLIFunctions.IFunc< T> func)
    {
        return new android.os.AsyncTask< Void, Void, NLIOperationResult< T>>()
        {
            @Override
            protected void onPreExecute() {
                callback.Starting();
            };
            @Override
            protected NLIOperationResult< T> doInBackground(Void... params) {
                NLIOperationResult< T> result = new NLIOperationResult< T>();
                try
                {
                    result.Result= func.Func();
                }
                catch(java.lang.Exception ex)
                {
                    ex.printStackTrace();
                    result.Exception=ex;
                }
                return result;
            }
            
            @Override
            protected void onPostExecute(NLIOperationResult< T> result)
            {
                callback.Completed(result);
            }
        }.execute();
    }
        
    java.lang.Exception convertToException(org.ksoap2.SoapFault fault,NLIExtendedSoapSerializationEnvelope envelope)
    {

        return new java.lang.Exception(fault.faultstring);
    }
}


