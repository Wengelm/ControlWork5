package StudentApp;

/**
* StudentApp/StudentAppHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from C:/GitHub/ControlWork5/src/main/java/StudentApp.idl
* 5 ?????? 2021 ?. 18:58:09 MSK
*/

public final class StudentAppHolder implements org.omg.CORBA.portable.Streamable
{
  public StudentApp value = null;

  public StudentAppHolder ()
  {
  }

  public StudentAppHolder (StudentApp initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = StudentAppHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    StudentAppHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return StudentAppHelper.type ();
  }

}
