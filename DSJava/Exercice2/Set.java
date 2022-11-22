package Exercice2;
//Creation de la classe set pour faciliter leur affichage
public class Set {
    int[] T = new int[16];
    Set(int a,int b,int c,int d,int e,int f,int g,int h,
        int i,int j,int k,int l,int m,int n,int o,int p)
    {
        T[0] = a;
        T[1] = b;
        T[2] = c;
        T[3] = d;
        T[4] = e;
        T[5] = f;
        T[6] = g;
        T[7] = h;
        T[8] = i;
        T[9] = j;
        T[10] = k;
        T[11] = l;
        T[12] = m;
        T[13] = n;
        T[14] = o;
        T[15] = p;
    }
    void afficheSet()
    {
        //Creation de la fonction affichage, pour reduire le code dans main
        int k=0;
        for(int j=0;j<4;j++)
        {
            for(int i=k;i<k+4;i++)
            {
            System.out.print(T[i] + "\t");
            }
            System.out.println(" ");
            k+= 4;
        }
        
    }
}
