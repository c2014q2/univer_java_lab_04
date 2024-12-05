import java.util.ArrayList;

public class MyThread extends Thread{

    int index;
    int par;
    MyThread( int index){
        this.index = index;
    }

    public void run(){
        par = 0; //suma numerelor pare
        int total_pare = 0; //contorul numerelor pare


        System.out.println(Thread.currentThread().getName() + " nr.pare gasite: ");
        for (int i=0; i<Main.numb; i++)
            if(Main.list[index][i] %2 == 0) {
                System.out.print(Main.list[index][i]+" ");
                par+=Main.list[index][i];
                total_pare++;
                // System.out.println(total_pare);
            }

        if (total_pare != 0) {
            par =  par/total_pare; //media arimetica a numerelor pare
            System.out.print(" -> "+ par);

            synchronized (Main.media) {      //Aici am adaugat cuvantul-cheie synchronized pentru a permite unui singur fir sa modifice lista globala "media"!
                Main.media.add(par);
            }
        }

        System.out.print("\n");

    }

    public int getPar() {
        return par;
    }
}
