package sop_corba;

/**
* sop_corba/ControladorCompraIntHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from interface.idl
* Sunday, August 7, 2022 2:03:00 PM COT
*/

public final class ControladorCompraIntHolder implements org.omg.CORBA.portable.Streamable
{
  public sop_corba.ControladorCompraInt value = null;

  public ControladorCompraIntHolder ()
  {
  }

  public ControladorCompraIntHolder (sop_corba.ControladorCompraInt initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = sop_corba.ControladorCompraIntHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    sop_corba.ControladorCompraIntHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return sop_corba.ControladorCompraIntHelper.type ();
  }

}
