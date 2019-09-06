import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Practice4 {
    public static void mergeSort(Person[] array, Comparator<Person> comparator){
        merge(array,0,array.length,comparator);
    }

    private static void merge(Person[] array, int low, int high,Comparator<Person> comparator) {
        int length = high - low;
        if(length <= 1){
            return;
        }
        int mid = (high + low) / 2;
        merge(array,low,mid,comparator);
        merge(array,mid,high,comparator);
        sort(array,low,mid,high,comparator);
    }

    private static void sort(Person[] array, int low, int mid, int high,Comparator<Person> comparator) {
        int length = high - low;
        Person[] newPerson = new Person[length];
        int ileft = low;
        int iright = mid;
        int inew = 0;
        while(ileft < mid && iright < high){
            int r = comparator.compare(array[ileft],array[iright]);
            if(r <= 0){
                newPerson[inew++]  = array[ileft++];
            }else{
                newPerson[inew++]  = array[iright++];
            }
        }
        while(ileft < mid){
            newPerson[inew++]  = array[ileft++];
        }
        while(iright < high){
            newPerson[inew++]  = array[iright++];
        }
        for(int i = 0;i < newPerson.length;i ++){
            array[i + low] = newPerson[i];
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
        mergeSort(array,new PersonImp());
        System.out.println(Arrays.toString(array));
    }
}
