import java.util.Arrays;
import java.util.Random;

public class Practice3 {
    //归并排序
//    public static void mergeSort(int[] array){
//        merge(array,0,array.length);
//    }
//
//    private static void merge(int[] array, int low, int high) {
//        int length = high - low;
//        if(length <= 1){
//            return;
//        }
//        int mid = (high + low) / 2;
//        merge(array,low,mid);
//        merge(array,mid,high);
//        sort(array,low,mid,high);
//    }
//
//    private static void sort(int[] array, int low, int mid, int high) {
//        int length = high - low;
//        int[] newArray = new int[length];
//        int ileft = low;
//        int iright = mid;
//        int inew = 0;
//        while(ileft < mid && iright < high){
//            if(array[ileft] <= array[iright]){
//                newArray[inew++] = array[ileft++];
//            }else{
//                newArray[inew++] = array[iright++];
//            }
//        }
//        while(ileft < mid){
//            newArray[inew++] = array[ileft++];
//        }
//        while(iright < high){
//            newArray[inew++] = array[iright++];
//        }
//        for(int i = 0;i < newArray.length;i ++){
//            array[low + i] = newArray[i];
//        }
//    }

    //第一种比较方法
//    public static void mergeSort(Person[] array){
//        merge(array,0,array.length);
//    }
//
//    private static void merge(Person[] array, int low, int high) {
//        int length = high - low;
//        if(length <= 1){
//            return;
//        }
//        int mid = (high + low) / 2;
//        merge(array,low,mid);
//        merge(array,mid,high);
//        sort(array,low,mid,high);
//    }
//
//    private static void sort(Person[] array, int low, int mid, int high) {
//        int length = high - low;
//        Person[] newArray = new Person[length];
//        int ileft = low;
//        int iright = mid;
//        int inew = 0;
//        while(ileft < mid && iright < high){
//            int r = array[ileft].compareTo(array[iright]);
//            if(r <= 0){
//                newArray[inew++] = array[ileft++];
//            }else{
//                newArray[inew++] = array[iright++];
//            }
//        }
//        while(ileft < mid){
//            newArray[inew++] = array[ileft++];
//        }
//        while(iright < high){
//            newArray[inew++] = array[iright++];
//        }
//        for(int i = 0;i < newArray.length;i ++){
//            array[low + i] = newArray[i];
//        }
//    }

    public static void mergeSort(Person[] array){
        merge(array,0,array.length);
    }

    private static void merge(Person[] array, int low, int high) {
        int length = high - low;
        if(length <= 1){
            return;
        }
        int mid = (high + low) / 2;
        merge(array,low,mid);
        merge(array,mid,high);
        sort(array,low,mid,high);
    }

    private static void sort(Person[] array, int low, int mid, int high) {
        int length = high - low;
        Person[] newArray = new Person[length];
        int ileft = low;
        int iright = mid;
        int inew = 0;
        while(ileft < mid && iright < high){
            int r = array[ileft].compareTo(array[iright]);
            if(r <= 0){
                newArray[inew++] = array[ileft++];
            }else{
                newArray[inew++] = array[iright++];
            }
        }
        while(ileft < mid){
            newArray[inew++] = array[ileft++];
        }
        while(iright < high){
            newArray[inew++] = array[iright++];
        }
        for(int i = 0;i < newArray.length;i ++){
            array[low + i] = newArray[i];
        }
    }
    public static void main(String[] args) {
        Person[] array = new Person[5];
        Random random = new Random(20190906);
        for(int i = 0;i < array.length;i ++){
            array[i] = new Person();
            array[i].age = random.nextInt(100);
        }
        System.out.println(Arrays.toString(array));
        mergeSort(array);
        System.out.println(Arrays.toString(array));
    }
}
