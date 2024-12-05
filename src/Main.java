import java.util.ArrayList;
import java.util.Random;

public class Main {

    static int[][] list;
    static int numb;
    static ArrayList<Integer> media = new ArrayList<>();

    static{
        numb = new Random().nextInt(9)+2;
        list = new int[numb][numb];
    }



    public static void main(String[] args) {

        Random rand = new Random();

        System.out.println("    ");
        System.out.println("    ");


        for (int i = 0; i < list.length; i++) {         // Se seteaza vcalori random si totodata se printeaza matricea!
            for (int j = 0; j < list[i].length; j++) {
                list[i][j] = rand.nextInt(90)+10; //valori rand
                System.out.print(list[i][j]+" ");   //printarea
                if (j == list[i].length-1) {
                    System.out.print("\n");
                }
            }
        }

        System.out.println("    ");
        System.out.println("    ");
        System.out.println("    ");



        ArrayList <MyThread> threads = new ArrayList<MyThread>(); //cream lista de fire pentru fiecare coloana in matrice
        for (int i = 0; i < list.length; i++) {        //cream si adaugam in lista cate un fir pentru fiecare rand
            threads.add(new MyThread(i));
        }

        for (MyThread mt : threads) {//pornim fiecare fir de executie

            mt.start();

            try {                       //impunem firul Main sa astepte fiecare fir din threads
                mt.join();
            }
            catch (InterruptedException e) {};
            //System.out.println(Thread.currentThread().getName() + mt.getPar());
        }

        int temp=0;
        for (int y : media) {
            temp+=y;
        }
        System.out.println("Media de pe fiecare rand: "+media);
        System.out.println("Media mediilor a fiecarui rand :D -> "+ temp/media.size());


       /* try{
            Thread.sleep(1000);
        }catch (InterruptedException e){}; */







    }
}