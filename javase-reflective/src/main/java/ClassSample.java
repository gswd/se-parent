import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by LH on 2017/7/28.
 */
public class ClassSample {

	public static void main(String[] args) throws IllegalAccessException, InstantiationException {

		Constructor[] constructors = MyClass.class.getConstructors();

		for (Constructor constructor : constructors) {
			Class clazz = constructor.getDeclaringClass();
			System.out.println(Arrays.toString(clazz.getDeclaredMethods()));
			System.out.println(constructor.getName());

		}
	}
}
