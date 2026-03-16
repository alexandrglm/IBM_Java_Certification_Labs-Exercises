// A) First change for this abstrac class as mentioned
public abstract class ClassWithAbstractMeth {

    // inits
	public abstract int absMeth1(String s);
	protected abstract String absMeth2();
	public abstract  String absMeth3(int num);
	protected abstract boolean absMeth4(String str);
	abstract float absMeth5(int num, String str);


    public static void main(String[] args) {

        System.out.println("This is a class with Abstract methods");

    }
}
// // A) Initial code
// public abstract class ClassWithAbstractMeth {

//     // inits
//     public abstract String absMeht1(int num);
//     protected abstract boolean absMeht2(String str);
//     abstract float absMeht3(int num, String str);

//     public static void main(String[] args) {

//         System.out.println("This is a class with Abstract methods");

//     }
// }