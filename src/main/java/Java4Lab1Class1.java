public class Java4Lab1Class1 {


    static Object mon = new Object();
    static volatile char currnetL = 'A';

    public static void main(String[] args) {

        new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 5; i++) {
                    synchronized (mon)
                    {
                        while (currnetL != 'A')
                        {
                            try {
                                mon.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.print(currnetL);
                        currnetL = 'B';
                        mon.notifyAll();
                    }

                }
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 5; i++) {
                    synchronized (mon)
                    {
                        while (currnetL != 'B')
                        {
                            try {
                                mon.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.print(currnetL);
                        currnetL = 'C';
                        mon.notifyAll();
                    }

                }
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 5; i++) {
                    synchronized (mon)
                    {
                        while (currnetL != 'C')
                        {
                            try {
                                mon.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.print(currnetL);
                        currnetL = 'A';
                        mon.notifyAll();
                    }

                }
            }
        }).start();


    }
}
