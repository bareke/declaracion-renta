package sop_corba.ControladorCompraIntPackage;


/**
* sop_corba/ControladorCompraIntPackage/CompraDTOHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from interface.idl
* Sunday, August 7, 2022 2:03:00 PM COT
*/

abstract public class CompraDTOHelper
{
  private static String  _id = "IDL:sop_corba/ControladorCompraInt/CompraDTO:1.0";

  public static void insert (org.omg.CORBA.Any a, sop_corba.ControladorCompraIntPackage.CompraDTO that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static sop_corba.ControladorCompraIntPackage.CompraDTO extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  private static boolean __active = false;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      synchronized (org.omg.CORBA.TypeCode.class)
      {
        if (__typeCode == null)
        {
          if (__active)
          {
            return org.omg.CORBA.ORB.init().create_recursive_tc ( _id );
          }
          __active = true;
          org.omg.CORBA.StructMember[] _members0 = new org.omg.CORBA.StructMember [7];
          org.omg.CORBA.TypeCode _tcOf_members0 = null;
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_long);
          _members0[0] = new org.omg.CORBA.StructMember (
            "id",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[1] = new org.omg.CORBA.StructMember (
            "tipo",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_long);
          _members0[2] = new org.omg.CORBA.StructMember (
            "valor",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[3] = new org.omg.CORBA.StructMember (
            "lugar",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[4] = new org.omg.CORBA.StructMember (
            "fecha",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[5] = new org.omg.CORBA.StructMember (
            "medioPago",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[6] = new org.omg.CORBA.StructMember (
            "nit",
            _tcOf_members0,
            null);
          __typeCode = org.omg.CORBA.ORB.init ().create_struct_tc (sop_corba.ControladorCompraIntPackage.CompraDTOHelper.id (), "CompraDTO", _members0);
          __active = false;
        }
      }
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static sop_corba.ControladorCompraIntPackage.CompraDTO read (org.omg.CORBA.portable.InputStream istream)
  {
    sop_corba.ControladorCompraIntPackage.CompraDTO value = new sop_corba.ControladorCompraIntPackage.CompraDTO ();
    value.id = istream.read_long ();
    value.tipo = istream.read_string ();
    value.valor = istream.read_long ();
    value.lugar = istream.read_string ();
    value.fecha = istream.read_string ();
    value.medioPago = istream.read_string ();
    value.nit = istream.read_string ();
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, sop_corba.ControladorCompraIntPackage.CompraDTO value)
  {
    ostream.write_long (value.id);
    ostream.write_string (value.tipo);
    ostream.write_long (value.valor);
    ostream.write_string (value.lugar);
    ostream.write_string (value.fecha);
    ostream.write_string (value.medioPago);
    ostream.write_string (value.nit);
  }

}