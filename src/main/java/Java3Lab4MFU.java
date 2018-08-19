public class Java3Lab4MFU {

    static volatile int pechatStr = 0;
    static volatile int scanStr = 0;
    static final Object scanM = new Object();
    static final Object pechM = new Object();

    public void pechat()
    {
        pechatStr++;
        System.out.println("отпечатано " + pechatStr + " страниц");
    }

    public void scan()
    {
        scanStr++;
        System.out.println("отсканировано " + scanStr + " страниц");
    }

    public static void main(String[] args) {
        final Java3Lab4MFU per = new Java3Lab4MFU();
        new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 100; i++) {
                    synchronized (pechM)
                    {
                        per.pechat();
                        try {
                            Thread.sleep(20);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 100; i++) {
                    synchronized (pechM)
                    {
                        per.pechat();
                        try {
                            Thread.sleep(20);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 100; i++) {
                    synchronized (scanM)
                    {
                        per.scan();
                        try {
                            Thread.sleep(20);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        }).start();
    }
}
