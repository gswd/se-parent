import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

public class ReflectionTest {
	public static void main(String[] args) {

		String name;
		if (args.length > 0) {
			name = args[0];
		}else {
			Scanner in = new Scanner(System.in);
			System.out.print("Enter class name (e.g. java.util.Date):");
			name = in.next();
		}

		try {
			Class cl = Class.forName(name);
			Class superCl = cl.getSuperclass();
			String modifiers = Modifier.toString(cl.getModifiers());

			if (modifiers.length() > 0) {
				System.out.print(modifiers + " ");
			}

			System.out.print("class " + name);

			if (superCl != null && superCl != Object.class) {
				System.out.print(" extends " + superCl.getName());
			}
			System.out.print("{\n");
			printConstructors(cl);
			System.out.println();
			printMethods(cl);
			System.out.println();
			printFields(cl);
			System.out.print("}");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		System.exit(0);

	}

	private static void printFields(Class cl) {

		Field[] fields = cl.getDeclaredFields();
		for (Field field : fields) {
			String modifier = Modifier.toString(field.getModifiers());
			Class type = field.getType();
			String name = field.getName();

			System.out.print("    ");
			if (modifier.length() > 0) {
				System.out.print(modifier + " ");
			}
			System.out.print(type.getName() + " " + name + ";");
			System.out.println();
		}

	}

	private static void printMethods(Class cl) {

		Method[] methods = cl.getDeclaredMethods();

		for (Method method : methods) {

			System.out.print("    ");

			String name = method.getName();
			String modifier = Modifier.toString(method.getModifiers());

			if (modifier.length() > 0) {
				System.out.print(modifier + " ");
			}

			Class returnType = method.getReturnType();

			System.out.print(returnType.getName() + " " + name + "(");

			Class[] paramTypes = method.getParameterTypes();
			
			for(int j = 0; j < paramTypes.length; j++) {
				if (j > 0) {
					System.out.print(", ");
				}
				System.out.print(paramTypes[j].getName());
			}

			System.out.print(")");

			//打印声明异常
			Class[] exceptionTypes = method.getExceptionTypes();

			if(exceptionTypes.length > 0) {
				System.out.print(" throws ");
			}

			for(int i = 0; i < exceptionTypes.length; i ++) {
				if (i > 0) {
					System.out.print(", ");
				}
				System.out.print(exceptionTypes[i].getName());
			}

			System.out.print(";");

			System.out.println();

		}

	}

	private static void printConstructors(Class cl) {

		Constructor[] constructors = cl.getDeclaredConstructors();

		for (Constructor constructor : constructors) {

			System.out.print("    ");

			String modifier = Modifier.toString(constructor.getModifiers());
			String name = constructor.getName();
			if (modifier.length() > 0) {
				System.out.print(modifier + " ");
			}
			System.out.print(name + "(");

			Class[] paramtypes = constructor.getParameterTypes();

			for(int j = 0; j < paramtypes.length; j++) {
				if (j > 0) {
					System.out.print(", ");
				}
				System.out.print(paramtypes[j].getName());
			}
			System.out.print(");");
			System.out.println();

		}

	}
}
