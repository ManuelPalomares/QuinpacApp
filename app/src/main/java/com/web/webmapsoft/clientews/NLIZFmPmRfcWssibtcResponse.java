package com.web.webmapsoft.clientews;

//----------------------------------------------------
//
// Generated by www.easywsdl.com
// Version: 4.1.9.1
//
// Created by Quasar Development at 28-11-2015
//
//---------------------------------------------------


import java.util.Hashtable;
import org.ksoap2.serialization.*;

public class NLIZFmPmRfcWssibtcResponse extends AttributeContainer implements KvmSerializable
{

    
    public NLIZstPmDataSibtc CsDataSibtc;
    
    public String EvRespuesta;
    
    public String EvTipoRespu;

    public NLIZFmPmRfcWssibtcResponse ()
    {
    }

    public NLIZFmPmRfcWssibtcResponse (java.lang.Object paramObj,NLIExtendedSoapSerializationEnvelope __envelope)
    {
	    
	    if (paramObj == null)
            return;
        AttributeContainer inObj=(AttributeContainer)paramObj;


        if(inObj instanceof SoapObject)
        {
            SoapObject soapObject=(SoapObject)inObj;
            int size = soapObject.getPropertyCount();
            for (int i0=0;i0< size;i0++)
            {
                //if you have compilation error here, please use a ksoap2.jar and ExKsoap2.jar from libs folder (in the generated zip file)
                PropertyInfo info=soapObject.getPropertyInfo(i0);
                java.lang.Object obj = info.getValue(); 
                if (info.name.equals("CsDataSibtc"))
                {
                    java.lang.Object j = obj;
                    this.CsDataSibtc = (NLIZstPmDataSibtc)__envelope.get(j,NLIZstPmDataSibtc.class);
                    continue;
                }
                if (info.name.equals("EvRespuesta"))
                {
        
                    if (obj != null && obj.getClass().equals(SoapPrimitive.class))
                    {
                        SoapPrimitive j =(SoapPrimitive) obj;
                        if(j.toString()!=null)
                        {
                            this.EvRespuesta = j.toString();
                        }
                    }
                    else if (obj!= null && obj instanceof String){
                        this.EvRespuesta = (String)obj;
                    }
                    continue;
                }
                if (info.name.equals("EvTipoRespu"))
                {
        
                    if (obj != null && obj.getClass().equals(SoapPrimitive.class))
                    {
                        SoapPrimitive j =(SoapPrimitive) obj;
                        if(j.toString()!=null)
                        {
                            this.EvTipoRespu = j.toString();
                        }
                    }
                    else if (obj!= null && obj instanceof String){
                        this.EvTipoRespu = (String)obj;
                    }
                    continue;
                }

            }

        }



    }

    @Override
    public java.lang.Object getProperty(int propertyIndex) {
        //!!!!! If you have a compilation error here then you are using old version of ksoap2 library. Please upgrade to the latest version.
        //!!!!! You can find a correct version in Lib folder from generated zip file!!!!!
        if(propertyIndex==0)
        {
            return CsDataSibtc;
        }
        if(propertyIndex==1)
        {
            return EvRespuesta;
        }
        if(propertyIndex==2)
        {
            return EvTipoRespu;
        }
        return null;
    }


    @Override
    public int getPropertyCount() {
        return 3;
    }

    @Override
    public void getPropertyInfo(int propertyIndex, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info)
    {
        if(propertyIndex==0)
        {
            info.type = NLIZstPmDataSibtc.class;
            info.name = "CsDataSibtc";
            info.namespace= "";
        }
        if(propertyIndex==1)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "EvRespuesta";
            info.namespace= "";
        }
        if(propertyIndex==2)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "EvTipoRespu";
            info.namespace= "";
        }
    }
    
    @Override
    public void setProperty(int arg0, java.lang.Object arg1)
    {
    }

}
