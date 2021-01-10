package homework_1;

public class BinarySearch {
    public static int search(int[] ar, int val, int... par){
        int beg;
        int end;
        if(par.length==2)
        {
            beg = par[0];
            end = par[1];
        }else{
            beg = 0;
            end = ar.length-1;
        }
        int indMid = beg + (end-beg)/2;
        if(end-beg==1){
            if(ar[beg]==val)
            {
                return beg;
            }else if(ar[end]==val){
                return end;
            }
        }else if(val>ar[indMid]){
            return search(ar, val, indMid, end);
        }else if(val<ar[indMid]){
            return search(ar, val, beg, indMid);
        }else{
            return indMid;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {0,10,20,30,40,50,60,70,80,90,100,110};
        int ind = BinarySearch.search(arr, 77);
        if(ind>=0)
        {
            System.out.println("индекс равен " + ind);
        }
        else
        {
            System.out.println("элемент не найден");
        }

    }
}
