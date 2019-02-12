package me.nithind.algo;

/**
 * Created by devangn on 21-12-2016.
 */
public class Kaedance {

    public int maxSubArray(int[] A) {
        int global_max = A[0];
        int cur_max = A[0];
        for (int i = 1; i < A.length; i++) {
            cur_max = this.max(cur_max + A[i], A[i]);
            global_max = this.max(cur_max, global_max);
        }
        return global_max;
    }

    private int max(int a, int b) {
        //System.out.print("for " + a + ">" + b+" ");
        if (a > b) {
            System.out.println(a);
            return a;
        }
        System.out.println(b);
        return b;
    }
}


/*

int main()
{
   int a[]={-2, 1, -3, 4, -1, 2, 1, -5, 4};
   int size=sizeof(a)/sizeof(a[0]);
   int startIndex=0,endIndex=0,i,j;
   int max_so_far=0,max_sum=-999;
   for(i=0;i<size;i++)
   {
   max_so_far=max_so_far+a[i];//kadane's algorithm step 1
   if(max_so_far>max_sum) //computing max
   {
      max_sum=max_so_far;
      endIndex=i;
   }

   if(max_so_far<0)
   {
   max_so_far=0;
   startIndex=i+1;
   }
}
   cout<<max_so_far<<" "<<startIndex<<" "<<endIndex;
   getchar();
   return 0;
}

*/
