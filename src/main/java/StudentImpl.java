import StudentApp.StudentAppPOA;
import org.omg.CORBA.ORB;

class StudentImpl extends StudentAppPOA {
private ORB orb;	// Необходима для хранения текущего ORB (используется в методе shutdown)

public void setORB(ORB orb_val) {
        orb = orb_val;
        }

public String add() {
        return "\nHello, world !!\n";
        }


    public String udate() {
        return "\nHello, world !!\n";
    }
    public String delete() {
        return "\nHello, world !!\n";
    }

public void shutdown() {
        // Использует метод org.omg.CORBA.ORB.shutdown(boolean) для завершения ORB,
        //false означает, что завершение должно быть немедленным
        orb.shutdown(false);
        }
        }
