import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Java4Lab1Fail {
    public static void main(String[] args) throws FileNotFoundException {
        zapis("1.txt");
    }

    public static void zapis(String nameFile) throws FileNotFoundException {
        final FileOutputStream n;
        final String[] str = new String[100];
        for (int i = 0; i < 100; i++) {
            str[i] = "stroka + " + i;
        }

        n = new FileOutputStream(new File(nameFile));


        new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 100; i++) {
                    try {
                        n.write(str[i].getBytes(), 0, str[i].length());
                        n.write('\n');
                        Thread.sleep(30);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 100; i++) {
                    try {
                        n.write(str[i].getBytes(), 0, str[i].length());
                        n.write('\n');
                        Thread.sleep(30);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 100; i++) {
                    try {
                        n.write(str[i].getBytes(), 0, str[i].length());
                        n.write('\n');
                        Thread.sleep(30);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }).start();
    }
}
