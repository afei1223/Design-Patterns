package com.lb.designpatterns.singleton;

import android.util.Log;

import com.lb.designpatterns.StaticFun;

/**
 * -----单例模式-----
 *
 * 单例模式我遇到比较多，所以可能会说的比较少了。
 * 简而言之，当有一个类，你只希望他只能存在一个实例的时候，你可以用单例。
 * 比如我在做长链接项目的时候，就需要使用单例，因为需要保证只有一条长链接，不然会很难管理。
 * 实现单例的方式有很多中，可以视需求来选择自己需要的方法。
 * 下面实现的方式是懒汉式，在单线程的情况下是比较良好的。
 * 再往下是实现单例的其他方式，总结写在最底。
 * */
public class Singleton {
    private void Singleton(){
    }

    private static Singleton intence;

    public static Singleton getIntence(){
        if(intence != null){
            return intence;
        }
        return new Singleton();
    }

    public void print(){
        Log.i(StaticFun.TAG,"生成了一个单例");
    }
}

/**
 * 以下为java中其他构建单例的方式，有些中文名称可能翻译的不太合适，直接看类名就好了
 * 以下例子全部来自于https://www.journaldev.com/1377/java-singleton-design-pattern-best-practices-examples
 * */

/**
 *----饿汉式----
 *
 * 这个类的实例是在类加载的时候创建的，也是最简单的创建单例的方式。
 * 不过缺点就是，当不需要使用这个类的时候也会创建。
 *
 * 如果您的singleton类没有使用很多资源，那么这是使用的方法。
 * 但是在大多数情况下，单例类是为文件系统、数据库连接等资源创建的，除非客户端调用getInstance方法，否则我们应该避免实例化。
 * 此外，此方法不提供任何异常处理选项。
 * */
class EagerInitializedSingleton {

    private static final EagerInitializedSingleton instance = new EagerInitializedSingleton();

    //private constructor to avoid client applications to use constructor
    private EagerInitializedSingleton(){}

    public static EagerInitializedSingleton getInstance(){
        return instance;
    }
}

/**
 * ----静态块----
 *
 * 这种实在不知道该怎么翻译了，我看到有人说这种也属于饿汉式，代码结构上也很相似。
 * 不过这种方式的实例是在提供异常处理选项的静态中创建的。
 * 除了加了一个try catch，其他和上一种饿汉式是一样的。优缺点类似
 * */
class StaticBlockSingleton {

    private static StaticBlockSingleton instance;

    private StaticBlockSingleton(){}

    //static block initialization for exception handling
    static{
        try{
            instance = new StaticBlockSingleton();
        }catch(Exception e){
            throw new RuntimeException("Exception occured in creating singleton instance");
        }
    }

    public static StaticBlockSingleton getInstance(){
        return instance;
    }
}

/**
 * ----懒汉式----
 *
 * 和饿汉式不同，该方法在全局方法中创建实例。
 * 这种方式适用于单线程环境下，当线程过多时，会导致线程不安全，即实例化两个实例。
 * （两个线程同时判断instance == null，然后都new了一个singleton）
 * 最上面的例子采用的就是这种方式。
 * */
class LazyInitializedSingleton {

    private static LazyInitializedSingleton instance;

    private LazyInitializedSingleton(){}

    public static LazyInitializedSingleton getInstance(){
        if(instance == null){
            instance = new LazyInitializedSingleton();
        }
        return instance;
    }
}

/**
 * ----线程安全的方式----
 *
 * 基于懒汉式加了一个synchronized，加了一个同步锁。这样一次只有一个线程可以访问这个方法。
 * 这种方式优化了下懒汉式的缺点，但是由于加了synchronized这个东西,性能有所降低。
 * */
class ThreadSafeSingleton {

    private static ThreadSafeSingleton instance;

    private ThreadSafeSingleton(){}

    public static synchronized ThreadSafeSingleton getInstance(){
        if(instance == null){
            instance = new ThreadSafeSingleton();
        }
        return instance;
    }

}

/**
 * ----线程安全的方式升级版----
 *
 * 可以和上面的代码比较以下，会发现，把synchronized加到了里面。
 * 这种方法在不需要实例化的时候，效率和懒汉式是一样的，比懒汉式还多了线程安全。
 * 不过可能有人会问，为什么需要两次判断是否为null
 * 他在第一次判断instance是不是null的时候，两个线程是可以一起进来的，
 * 那么会创建两个单例，所以在加锁之后再进行判断，
 * */
class ThreadSafeSingletonPlus1 {

    private static ThreadSafeSingletonPlus1 instance;

    private ThreadSafeSingletonPlus1(){}


    public static ThreadSafeSingletonPlus1 getInstanceUsingDoubleLocking(){
        if(instance == null){
            synchronized (ThreadSafeSingletonPlus1.class) {
                if(instance == null){
                    instance = new ThreadSafeSingletonPlus1();
                }
            }
        }
        return instance;
    }

}

/**
 * ----比尔方式----
 *
 * 在java5之前，Java内存模型有很多问题，在太多线程试图同时获取Singleton类的实例的情况下，上述方法常常失败。
 * 因此，Bill Pugh提出了一种不同的方法来使用内部静态helper类来创建Singleton类。
 *
 * 请注意包含singleton类实例的私有内部静态类。
 * 当singleton类被加载时，SingletonHelper类不会被加载到内存中，
 * 只有当有人调用getInstance方法时，这个类才会被加载并创建singleton类实例。
 * 这是单例类最常用的方法，因为它不需要同步。
 * */
class BillPughSingleton {

    private BillPughSingleton(){}

    private static class SingletonHelper{
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    public static BillPughSingleton getInstance(){
        return SingletonHelper.INSTANCE;
    }
}

/**
 * ----枚举----
 *
 * 为了用反射来克服这种情况，（详见https://www.journaldev.com/1377/java-singleton-design-pattern-best-practices-examples中的第六）
 * joshuabloch建议使用Enum来实现Singleton设计模式，因为Java确保任何Enum值在Java程序中只实例化一次。
 * 由于Java枚举值是全局可访问的，因此单例也是如此。
 *
 * 缺点是枚举类型有些不灵活；例如，它不允许延迟初始化。
 * */
enum EnumSingleton {

    INSTANCE;

    public static void doSomething(){
        //do something
    }
}

/**
 * 以上都是单例的创建方式，主要代码都是来自https://www.journaldev.com/1377/java-singleton-design-pattern-best-practices-examples
 * 还有一些反射破坏单例模式和单例序列化，我没有加进来，有需要可以自己看上面👆的网站。
 * 也没什么好总结的了，无非就是根据自己的情况，根据需求来创建想要的单例。
 * */