package com.nokia.example.Basics.Basic;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * Created by YLongYao on 2016/10/19.
 */
public class StringTest {

    /**
     * 方法可以和类同名，和构造器区别在于必须要有返回值类型
     */
    @Test
    public void StringTest(){
        double b = 5/2;
        System.out.println("b=="+b);    //2.0
        double c = 5.0/2;
        System.out.println("c=="+c);    //2.5
        int d = 5/2;                    //向下取整
        System.out.println("d=="+d);    //2
    }

    @Test
    public void StringTest01(){
        String s="hello";
        String t="hello";
        Character c[] ={'h','e','l','l','o'};

        System.err.println("s = t:"+s.equals(t));       //true
        System.err.println("s = t:" + (s==t));          //true
        System.err.println("s = c:"+s.equals(c));       //false
        System.err.println("s = c:"+t.equals(new String("hello"))); //true
    }

    @Test
    public void StringTest02(){
        String str = "Ask34第三课时l23kdjksJJl";
        char[] cArr = str.toCharArray();
        String reStr = "";
        for(char c : cArr){
            if(64<c && c<91){
                reStr += c;
            }else if(96<c && c<123){
                reStr += (char)(c - 32);
            }
        }
        System.out.println("return Str : "+reStr);

        String str1 = "sdfjsJKjsdkfksdf";
        System.out.println("return str1 : "+str1.toUpperCase());

    }

    @Test
    public void StringTest03(){
        /**
         * floor:求小于参数的最大整数，返回double类型
         * ceil:求大于参数的最小整数，返回double类型
         * round:对小数四色五入的结果，且对-0.5round后为0,对0.5round后为1
         *      对float取整返回int，double取整返回long
         */
        float d1=-1.5f;
        double k11 = Math.ceil(d1);
        double k12 = Math.floor(d1);
        int k13 = Math.round(d1);
        System.out.println("Ceil d1="+Math.ceil(d1));
        System.out.println("floor d1="+Math.floor(d1));
        System.out.println("round d1="+Math.round(d1));
        System.out.println("--------------------------------");

        double d2=1.5;
        double k21 = Math.ceil(d2);
        double k22 = Math.floor(d2);
        long k23 = Math.round(d2);
        System.out.println("Ceil d2="+Math.ceil(d2));
        System.out.println("floor d2="+Math.floor(d2));
        System.out.println("round d2="+Math.round(d2));
        System.out.println("--------------------------------");

        double d3=-1.6;
        double k31 = Math.ceil(d3);
        double k32 = Math.floor(d3);
        long k33 = Math.round(d3);
        System.out.println("Ceil d3="+Math.ceil(d3));
        System.out.println("floor d3="+Math.floor(d3));
        System.out.println("round d3="+Math.round(d3));
    }

    @Test
    public void StringTest04(){
        byte a1 = 2, a2 = 4, a3;
        short s = 16;
//        a2 = s;
//        a3 = a1 * a2;
    }

    @Test
    public void StringTest05(){
        boolean x = true;
        boolean y =false;
        System.out.println(10%3*2);
        if(x = y) //出错
            System.out.println("Not equal");
        else
            System.out.println("Equal");
    }

    @Test
    public void StringTest06(){
        double x= 3.0;
        int y=5;
        x/=--y;
        System.out.println("result: "+x);
    }

    @Test
    public void StringTest08(){
        byte x = 2;
//        x>>3;
//        +++x;
        x%=4;
    }

    @Test
    public void StringTest09(){
        int k = -8%3;
        int s = 8%-3;
        int h = -8%-3;
        System.out.println("k=="+k);    //-2
        System.out.println("s=="+s);    //2
        System.out.println("h=="+h);    //-2
    }

    /**
     * 交换两个变量的值不定义新的变量 通用方法位异或
     */
    @Test
    public void StringTest10(){
        char a = '中';
        char b = '国';
        System.out.println(String.valueOf(a) + String.valueOf(b));
        a ^= b;
        b ^= a;
        a ^= b;
        System.out.println(String.valueOf(a) + String.valueOf(b));

        int k = 18;
        int s = 10;
        System.out.println("k="+k+" s="+s);
        k ^= s;
        System.out.println("k="+k+" s="+s);
        s ^= k;
        System.out.println("k="+k+" s="+s);
        k ^= s;
        System.out.println("k="+k+" s="+s);
    }

    @Test
    public void StringTest11(){
        int i =0 , k = 0;
        ok:
        for(;i<10;i++){
            for(;k<10;k++){
                if(k == 3){
                    break  ok;
                }
            }
        }

        System.out.println("i =" +i);
        System.out.println("k==" + k);

        System.out.println("2 到 8 " + (2<<2));
    }

    @Test
    public void StringTest12(){
//        String k;
//        System.out.println("k=="+k);  必须初始化

//        int k;
//        System.out.println("k==="+k);  必须初始化
    }

    @Test
    public void IntTest(){
        int i = 1, j;
        j = i++ * 2 + 3 * ++i;

        System.out.println("i == " + i + "  j ==" + j);   //i = 3 j = 11
    }

    @Test
    public void IntegerTest(){
        int i = 0;
        Integer j = new Integer(0);

        System.out.println(i == j);
        System.out.println(j.equals(i));
    }

    @Test
    public void replaceTest(){
        String classFile = "com. jd. ".replaceAll(".", "/") + "MyClass.class";
        System.out.println(classFile);

        String classFile1 = "com. jd. ".replaceAll("\\.", "/") + "MyClass.class";
        System.out.println(classFile1);
    }

    @Test
    public void ClassOrMethodNameTest(){
        String sName = super.getClass().getName();
        String sCanonicalName = super.getClass().getCanonicalName();
        String sSimpleName = super.getClass().getSimpleName();
        String sTypeName = super.getClass().getTypeName();

        System.out.println("super name:"+sName);
        System.out.println("super canonicalName:"+sCanonicalName);
        System.out.println("super simpleName:"+sSimpleName);
        System.out.println("super typeName:"+sTypeName);
        System.out.println("------------------------------------------");

        String tName = this.getClass().getName();
        String tCanonicalName = this.getClass().getCanonicalName();
        String tSimpleName = this.getClass().getSimpleName();
        String tTypeName = this.getClass().getTypeName();

        System.out.println("this name:"+tName);
        System.out.println("this canonicalName:"+tCanonicalName);
        System.out.println("this simpleName:"+tSimpleName);
        System.out.println("this typeName:"+tTypeName);
        System.out.println("------------------------------------------");

        String mName = Thread.currentThread().getStackTrace()[1].getMethodName();
        System.out.println("method name:" + mName);
    }

    @Test
    public void ArrayTest(){
        float f1 = 2;
        float f2 = 2f;
        float f3 = 2.0f;
        float f4 = 2e3f;
        float f5 = 33F;
        float f6 = 44L;
        //float f = 2.0;

        int[][] int1 = new int[2][];
        int[][] int2 = new int[2][2];
//        int[][] int3 = new int[][2];
        int []int4[] = new int[2][];
        int int5[][] = new int[2][];
//        int int6[3][] = new int[3][3];
//        int int7[][3] = new int[][];
        int[] int8[] = new int[2][];

        int[][] int9 = new int[8][9];
        System.out.println("array length1: " + int9.length);
        System.out.println("array length2: " + int9[1].length);
        System.out.println("array length3: " + int9[3].length);
        System.out.println("array length4: " + int9[3][2]);

        double d1 = 2;
        double d2 = 2.1;
        double d3 = 2.1f;
        double d4 = 2.1d;
//        double d5 = 08;
        double d6 = 2F;
        double d7 = 2.1F;
        double d8 = 2.1D;
        double d9 = 7L;


        int i1 = 1;
//        int i2 = 09;


        long l1 = 2;
        long l2 = 2L;
        long l3 = 2l;
    }

    @Test
    public void SwitchTest(){
        int k = 5;
        switch (k){
            case 0 :
                System.out.println("this is a 0");
            case 1 :
                System.out.println("this is a 1");
            case 2 :
                System.out.println("this is a 2");
            case 3 :
                System.out.println("this is a 3");
                break;
            case 4 :
                System.out.println("this is a 4");
            default:
                System.out.println("this is a default");
        }
    }

    @Test
    public void StringEqualsTest(){
        String a = "taobao";
        String b = "tao" + "bao";
        String c = "tao";
        String d = "bao";
        String e = "taobao";

        System.out.println("a == b is " + (a==b));              //true
        System.out.println("a == c + d is " + (a==(c + d)));    //false
        System.out.println("b == c + d is " + (b==(c + d)));    //false
        System.out.println("a == e is " + (a==e));              //true

        Integer i01 = 59;
        int i02 = 59;
        Integer i03 = Integer.valueOf(59);
        Integer i04 = new Integer(59);
        System.out.println("i01 == i02  " + (i01 == i02));      //true
        System.out.println("i02 == i03  " + (i02 == i03));      //true
        System.out.println("i03 == i04  " + (i03 == i04));      //false
    }

    @Test
    public void TypeTransanc(){
        byte x = 1;
        double y =99;
        double d = (long)x/y+1;
    }


    @Test
    public void test() throws IOException {

        File file = new File("/java/StringTest");
        assertEquals("StringTest" , file.getName());
        assertEquals("E:\\java\\StringTest" , file.getAbsolutePath());
    }

    @Test
    public void InstanceOfTest(){
        boolean flag1 = "abc" instanceof Object;
        boolean flag2 = "abc" instanceof String;

        System.out.println("flag1 : " + flag1);     //true
        System.out.println("flag2 : " + flag2);     //true
    }

    @Test
    public void arrTest(){
        int[] a = new int[1];
        System.out.println(a[1]);  //抛异常ArrayIndexOutOfBoundsException
    }

    @Test
    public void ArrayInitTest(){
        int[] a1 = new int[]{1,2,3,4,5};
        int[] a2;   a2 = new int[]{1,2,3,4,5};
//        int[] a3;   a3 = {1,2,3,4,5};  //不合法的初始化
        int[] a4 = {1,2,3,4,5,6};


        int[] a5 = {1,2,3,4,5,6,};

        System.out.println("a5 length = " + a5.length); //6

    }

    @Test
    public void intTest(){
        int i=5;
//        int s=(i++)+(++i)+(i--)+(--i);
//        int s1 = (i++);
//        System.out.println("s1:" + s1);
//        int s2 = (i++)+(++i);
//        System.out.println("s2:" + s2);
        int s3 = (i++)+(++i)+(i--);
        System.out.println("s3:" + s3);

//        System.out.println("s:" + s);
    }
}
