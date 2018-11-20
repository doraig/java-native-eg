package com.pigopoyo.jni;

import java.util.Arrays;

public class Main
{
    //Load dynamic library.
    static {
        System.loadLibrary("libpoyo");
    }

    private int number = 88;

    private static double number2 = 78.87;

    private void callBack() {
      System.out.println("Call from C++");
    }

    //Native method.
    private native String message(String msg);

    private native double avg(int n1, int n2);

    private native double[] sumAvg(int... n1);

    private native void modifyValues();

    private native void nativeCall();

    public static void main(String[] args) {
        //Call to the C++ code.
      Main main = new Main();
      String msg = main.message("JNI program call");
      System.out.println("In java mode : "+ msg);
      System.out.println(main.avg(10, 15));

      System.out.println("Sum and avg : " + Arrays.toString(main.sumAvg(1, 2, 3, 4, 5)));
      System.out.println("Before Class values: " + main.number + ", " + Main.number2  );
      main.modifyValues();
      System.out.println("After Class values: " + main.number + ", " + Main.number2  );
      main.nativeCall();


    }
}
