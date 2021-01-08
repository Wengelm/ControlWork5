

import StudentApp.StudentApp;
import StudentApp.StudentAppHelper;
import org.omg.CosNaming.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;

    public class StudentServer {

// Сервер создает один или несколько объектов-серванов.
// Сервант наследует интерфейсу, сгенерированному компилятором idlj,
// и реально выполняет все операции этого интерфейса.

        public static void main(String args[]) {
            try{
                // Создаем и инициализируем экземпляр ORB
                ORB orb = ORB.init(args, null);

                // Получаем доступ к Root POA и активируем POAManager
                POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
                rootpoa.the_POAManager().activate();

                // Создаем объект сервант и регистрируем в нем объект ORB
                StudentImpl helloImpl = new StudentImpl();
                helloImpl.setORB(orb);

                // Получаем доступ к объекту серванта
                org.omg.CORBA.Object ref = rootpoa.servant_to_reference(helloImpl);
                StudentApp href = StudentAppHelper.narrow(ref);

                // Получаем корневой контекст именования
                org.omg.CORBA.Object objRef =
                        orb.resolve_initial_references("NameService");
                // NamingContextExt является частью спецификации Interoperable
                // Naming Service (INS)
                NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

                // Связывание идентификатора "Hello" и объекта серванта
                String name = "Hello";
                NameComponent path[] = ncRef.to_name( name );
                ncRef.rebind(path, href);

                System.out.println("HelloServer готов и ждет обращений ...");

                // Ожидание обращений клиентов
                orb.run();
            }
            catch (Exception e) {
                System.err.println("ОШИБКА: " + e);	// Выводим сообщение об ошибке
                e.printStackTrace(System.out);	// Выводим содержимое стека вызовов
            };

            System.out.println("HelloServer работу завершил ...");

        }

}
